package com.mbucic.starwarspeople.network

import com.mbucic.starwarspeople.model.ResponseData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://swapi.dev/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StarWarsApiService {
    @GET("people/")
    suspend fun getPeople(@Query("page") page: String): ResponseData
}

object StarWarsApi {
    val retrofitService: StarWarsApiService by lazy {
        retrofit.create(StarWarsApiService::class.java)
    }
}