package com.chao.algorithmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Algorithm2().test()
        findViewById<TextView>(R.id.tv_start).setOnClickListener {
            DataSort().quickSort()
        }
    }
}