package com.example.a20220108_danielzorrilla_nycschools.Network

import com.example.a20220108_danielzorrilla_nycschools.Model.School
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SchoolRetrofit {

    private var schoolAPI: SchoolAPI = createSchoolAPI(createRetrofitInstance())

    private fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://data.cityofnewyork.us/resource/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createSchoolAPI(retrofit: Retrofit): SchoolAPI{
        return retrofit.create(SchoolAPI::class.java)
    }

    fun getSchoolList(): Call<List<School>>{
        return schoolAPI.getSchoolList()
    }

    fun getSchoolScore(dbn: String): Call<List<School>>{
        return schoolAPI.getSchoolScore(dbn)
    }
}