package com.example.mvp.ui

import com.example.mvp.base.BasePresenter
import com.example.mvp.models.Products

interface MainContract {

    interface View {
        fun onSuccess(products: MutableList<Products>)
        fun onError(error: String)
        fun onLoading()
    }

    interface Presenter : BasePresenter<View> {
        fun getProduct()
    }
}
