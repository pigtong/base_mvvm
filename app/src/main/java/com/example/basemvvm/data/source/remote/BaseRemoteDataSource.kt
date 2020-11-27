package com.example.basemvvm.data.source.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

open class BaseRemoteDataSource<T> {
    protected fun makeCall(requestCall: Call<T>, successHandler: (T) -> Unit, errorHandler: (String) -> Unit): Call<T> {
        requestCall.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>?, response: Response<T>?) {
                response?.let { callResponse ->
                    when (callResponse.isSuccessful) {
                        true -> {
                            if (callResponse.body() != null) {
                                successHandler(callResponse.body()!!)
                            } else {
                                errorHandler("Response body is null")
                            }
                        }
                        false -> {
                            Timber.d("Call Not Success : ErrorResponse >> $callResponse")
                            errorHandler(callResponse.message())
                        }
                    }
                }
            }

            override fun onFailure(call: Call<T>?, t: Throwable?) {
                t?.let {
                    if (t is Exception) {
                        if (call != null && !call.isCanceled) {
                            Timber.d("Call Not Success : MakeRequest-http failed ${t.message}")
                            errorHandler("On failure : ${ t.message}")
                        }
                    }
                }
            }
        })
        return requestCall
    }
}