package com.example.biography

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.biography.databinding.ActivityBiographyOutputBinding

class BiographyOutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBiographyOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiographyOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val school = intent.getStringExtra("SCHOOL")
        val graduationYear = intent.getStringExtra("GRADUATION_YEAR")
        val favoriteActivities = intent.getStringExtra("FAVORITE_ACTIVITIES")
        val selectedMajor = intent.getStringExtra("SELECTED_MAJOR")
        val selectedDegree = intent.getStringExtra("SELECTED_DEGREE")

        val output = "$firstName $lastName graduated in $graduationYear with a $selectedDegree with a concentration in $selectedMajor from $school. Their favorite activities are $favoriteActivities."
        binding.displayText.text = output
    }
}