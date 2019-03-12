package com.example.shuttlelaunchesmvvmkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shuttlelaunchesmvvmkotlin.data.DataSource
import com.example.shuttlelaunchesmvvmkotlin.data.RemoteDataSource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource: DataSource = RemoteDataSource()
        dataSource.getListOfBreaches("Adobe")
    }
}
