package com.example.a20220108_danielzorrilla_nycschools.Network

import com.example.a20220108_danielzorrilla_nycschools.Model.School
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolAPI {

    @GET("s3k6-pzi2.json")
    fun getSchoolList(): Call<List<School>>

    @GET("f9bf-2cp4.json")
    fun getSchoolScore(@Query("dbn") searchQuery: String): Call<List<School>>
}