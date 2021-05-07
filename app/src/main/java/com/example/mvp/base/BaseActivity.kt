package com.example.mvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        onInit()
    }

    abstract fun getLayoutId(): Int
    abstract fun onInit()
}
