package com.example.rahal.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rahal.databinding.ActivityMainUserBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}