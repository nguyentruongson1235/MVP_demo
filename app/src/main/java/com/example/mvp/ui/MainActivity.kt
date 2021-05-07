package com.example.mvp.ui

import android.util.Log
import com.example.mvp.R
import com.example.mvp.base.BaseActivity
import com.example.mvp.models.Products
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var mainAdapter: RecyclerViewAdapter
    private lateinit var mainPresenter: MainPresenter

    private var data: MutableList<Products?> = mutableListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onInit() {
        mainAdapter = RecyclerViewAdapter(data)
        recyclerviewWrapper.adapter = mainAdapter
        initData()
    }

    override fun onSuccess(products: MutableList<Products>) {
        data.addAll(products)
        mainAdapter.notifyDataSetChanged()
    }

    override fun onError(error: String) {
        Log.d("nnn", "onError: $error")
    }

    override fun onLoading() {
    }

    private fun initData() {
        mainPresenter = MainPresenter().apply {
            setView(this@MainActivity)
            onStart()
        }
    }
}
