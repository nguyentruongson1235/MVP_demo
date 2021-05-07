package com.example.mvp.base

interface BasePresenter<T> {
    fun onStart()
    fun setView(view : T?)
}
