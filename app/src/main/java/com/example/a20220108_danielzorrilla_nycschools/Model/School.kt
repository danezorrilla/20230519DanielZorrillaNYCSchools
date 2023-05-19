package com.example.a20220108_danielzorrilla_nycschools.Model

import com.google.gson.annotations.SerializedName

data class School(
    @SerializedName("dbn")
    var dbn: String? = null,
    @SerializedName("school_name")
    var name: String? = null,
    @SerializedName("location")
    var location: String? = null,
    @SerializedName("phone_number")
    var phoneNumber: String? = null,
    @SerializedName("school_email")
    var email: String? = null,
    @SerializedName("sat_critical_reading_avg_score")
    var sat_critical_reading_score: String? = null,
    @SerializedName("sat_math_avg_score")
    var sat_math_score: String? = null,
    @SerializedName("sat_writing_avg_score")
    var sat_writing_score: String? = null
)
