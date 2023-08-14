package com.example.roadmapproject.utils

import okhttp3.Interceptor

class HeaderAuth (private val tokenType: String, private val acceesToken: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", "$tokenType $acceesToken").build()
        return chain.proceed(request)
    }
}
