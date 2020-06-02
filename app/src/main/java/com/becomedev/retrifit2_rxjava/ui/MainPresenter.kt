package com.becomedev.retrifit2_rxjava.ui

import com.becomedev.retrifit2_rxjava.models.UserResponse
import com.becomedev.retrifit2_rxjava.services.ApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainPresenter(private val mainView: MainView) {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    fun searchUser(q: String) {
        retrofit.create<ApiService>(ApiService::class.java)
            .searchUser(q)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<UserResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: UserResponse) {
                    mainView.setAdapterData(t.users)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })
    }
}