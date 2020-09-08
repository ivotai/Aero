package com.sanre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dagger.hilt.components.SingletonComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}