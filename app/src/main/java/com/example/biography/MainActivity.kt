package com.example.biography

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.biography.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedRadioButtonsList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val majors = resources.getStringArray(R.array.majors)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, majors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val spinner = findViewById<Spinner>(binding.spinnerMajor.id)
        spinner.adapter = adapter

        binding.createButton.setOnClickListener {
            val intent = Intent(this, BiographyOutputActivity::class.java)
            intent.putExtra("FIRST_NAME", binding.fName.text.toString())
            intent.putExtra("LAST_NAME", binding.lName.text.toString())
            intent.putExtra("SCHOOL", binding.editTextSchool.text.toString())
            intent.putExtra("GRADUATION_YEAR", binding.editTextGraduationYear.text.toString())
            intent.putExtra("SELECTED_DEGREE", binding.editTextDegree.text.toString())
            intent.putExtra("FAVORITE_ACTIVITIES", binding.editTextFavoriteActivities.text.toString())
            intent.putExtra("SELECTED_MAJOR", binding.spinnerMajor.selectedItem.toString())
            startActivity(intent)
        }
    }
}