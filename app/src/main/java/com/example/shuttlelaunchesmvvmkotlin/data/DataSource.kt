package com.example.shuttlelaunchesmvvmkotlin.data

import io.reactivex.Observable

interface DataSource {

    fun getListOfBreaches(domainName: String):Observable<List<Breach>>
}