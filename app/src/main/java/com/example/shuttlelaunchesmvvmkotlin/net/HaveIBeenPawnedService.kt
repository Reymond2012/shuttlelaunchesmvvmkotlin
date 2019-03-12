package com.example.shuttlelaunchesmvvmkotlin.net

import com.example.shuttlelaunchesmvvmkotlin.data.Breach
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface HaveIBeenPawnedService {
    @GET(ENDPOINT)
    fun getListOfBreaches(@Path("sitename")domainName: String): Observable<List<Breach>>
}