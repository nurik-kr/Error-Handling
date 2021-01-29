package kg.nurik.errorhandling.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token =
            "2a39e44a972aa93f42688153a8807871a3dc51fe59609a523da61fadcc0bcf323a68ca4465f1627ea58784b4438174021b70665473365797bcd841fb1adda995"
        val request = chain.request().newBuilder()
            .addHeader("token", token)
            .build()
        return chain.proceed(request)
    }
}