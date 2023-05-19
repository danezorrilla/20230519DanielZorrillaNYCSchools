package com.example.a20220108_danielzorrilla_nycschools.Network

import org.junit.Assert.*

import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SchoolRetrofitTest {

    // create Retofit Intance
    private val instance: SchoolAPI = Retrofit.Builder()
        .baseUrl("https://data.cityofnewyork.us/resource/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SchoolAPI::class.java)

    // Test to get school list api
    @Test
    fun getSchoolList() {
        val service = instance.getSchoolList()
        assertNotNull(service)
    }

    // Test to get school score api based on dbn
    @Test
    fun getSchoolScore() {
        val dbn = "01M292"
        val service = instance.getSchoolScore(dbn)
        assertNotNull(service)
    }
}