package com.example.a20220108_danielzorrilla_nycschools.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a20220108_danielzorrilla_nycschools.Model.School
import com.example.a20220108_danielzorrilla_nycschools.R
import com.example.a20220108_danielzorrilla_nycschools.ViewModel.SATViewModel
import com.example.a20220108_danielzorrilla_nycschools.ViewModel.SchoolViewModel

class SchoolSAT : AppCompatActivity() {

    private lateinit var schoolName: TextView
    private lateinit var schoolRead: TextView
    private lateinit var schoolMath: TextView
    private lateinit var schoolWrite: TextView
    private lateinit var name: String

    private lateinit var satViewModel: SATViewModel
    private lateinit var satObserver: Observer<List<School>>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_sat)

        val bundle = intent.extras

        schoolName = findViewById(R.id.school_sat_name)
        schoolRead = findViewById(R.id.school_sat_read_avg)
        schoolMath = findViewById(R.id.school_sat_math_avg)
        schoolWrite = findViewById(R.id.school_sat_write_avg)

        val dbn = bundle?.getString("dbn")
        name = bundle?.getString("name").toString()


        satViewModel = ViewModelProvider(this)[SATViewModel::class.java]
        satObserver = Observer { schoolsScores -> displaySchoolScores(schoolsScores) }
        satObserver.let {
            if (dbn != null) {
                satViewModel.getSchoolScoreResponse(dbn).observe(this, it)
            }
        }
    }

    private fun displaySchoolScores(schoolsScores: List<School>?) {
        if(schoolsScores.isNullOrEmpty()){
            schoolName.text = name
            schoolRead.text = "SAT Reading Score: " + "N/A"
            schoolMath.text = "SAT Math Score: " + "N/A"
            schoolWrite.text = "SAT Writing Score: " + "N/A"
        }
            for (i in schoolsScores?.indices!!){
                schoolName.text = schoolsScores[i].name
                schoolRead.text = "SAT Reading Score: " +
                        schoolsScores[i].sat_critical_reading_score
                schoolMath.text = "SAT Math Score: " + schoolsScores[i].sat_math_score
                schoolWrite.text = "SAT Writing Score: " + schoolsScores[i].sat_writing_score
            }

    }
}