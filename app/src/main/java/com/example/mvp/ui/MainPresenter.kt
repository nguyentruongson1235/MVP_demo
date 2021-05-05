package com.example.mvp.ui

import android.os.Handler
import android.os.Looper
import com.example.mvp.service.ApiService
import com.example.mvp.service.ParseJson
import com.example.mvp.utils.Constants
import com.example.mvp.utils.Constants.OK
import org.json.JSONObject

class MainPresenter : MainContract.Presenter {

    private var viewMain: MainContract.View? = null

    override fun getProduct() {
        val thread = Thread {
            with(ApiService().httpGet(Constants.BASE_URL + "food/all")) {
                val handler = Handler(Looper.getMainLooper())
                handler.post {
                    val jsonObject = JSONObject(this)
                    if (jsonObject.getInt(Constants.GET_STATUS) == OK) {
                        viewMain?.onSuccess(ParseJson().parseJsonArray(jsonObject))
                    } else {
                        viewMain?.onError(jsonObject.getString(Constants.GET_MESSAGE))
                    }
                }
            }
        }
        thread.start()
    }

    override fun onStart() = getProduct()

    override fun setView(view: MainContract.View?) {
        viewMain = view
    }
}
