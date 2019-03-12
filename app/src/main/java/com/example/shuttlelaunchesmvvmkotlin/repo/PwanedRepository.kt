package com.example.shuttlelaunchesmvvmkotlin.repo

import com.example.shuttlelaunchesmvvmkotlin.data.Breach
import com.example.shuttlelaunchesmvvmkotlin.data.DataSource
import com.example.shuttlelaunchesmvvmkotlin.data.RemoteDataSource
import io.reactivex.Observable

class PwanedRepository(private val  remoteDataSource: DataSource): DataSource{


    override fun getListOfBreaches(domainName: String)
            = remoteDataSource.getListOfBreaches(domainName)
    }
