package com.example.shuttlelaunchesmvvmkotlin.home

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.shuttlelaunchesmvvmkotlin.data.Breach
import com.example.shuttlelaunchesmvvmkotlin.data.RemoteDataSource
import com.example.shuttlelaunchesmvvmkotlin.repo.PwanedRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.IllegalStateException

class HomeViewModel : ViewModel(){

    private val repository = PwanedRepository(RemoteDataSource())

    private val breachesObservable = MutableLiveData<List<Breach>>()

    private val compositeDisposable = CompositeDisposable()

    fun getBreachesObservable() = breachesObservable

    fun getData (domainName: String){
        if (domainName.isEmpty())throw IllegalStateException("Please specify a valid domain")

       compositeDisposable.add( repository.getListOfBreaches(domainName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //.subscribe({result -> })
            .subscribe({breachesObservable.value = it}, {throwable -> throwable.printStackTrace()}))



    }
}