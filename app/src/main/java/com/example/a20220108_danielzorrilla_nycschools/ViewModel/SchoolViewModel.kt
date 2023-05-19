package com.example.a20220108_danielzorrilla_nycschools.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a20220108_danielzorrilla_nycschools.Model.School
import com.example.a20220108_danielzorrilla_nycschools.Network.SchoolRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolViewModel : ViewModel() {

    private var schoolRetrofit: SchoolRetrofit = SchoolRetrofit();
    private var schoolListResponseMutableLiveData = MutableLiveData<List<School>>()


    fun getSchoolListResponse(): MutableLiveData<List<School>>{
        schoolRetrofit.getSchoolList().enqueue(object : Callback<List<School>>{
            override fun onResponse(call: Call<List<School>>, response: Response<List<School>>) {
                if (response.isSuccessful && response.body() != null){
                    schoolListResponseMutableLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                Log.d("TAG_Z", "Error: " + t.localizedMessage)
            }
        })
        return schoolListResponseMutableLiveData
    }
}