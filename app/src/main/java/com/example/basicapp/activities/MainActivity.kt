package com.example.basicapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.AlphaAnimation
import android.widget.TextView
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.basicapp.R
import com.example.basicapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition { false }

        super.onCreate(savedInstanceState)

        // Immediately set the custom splash layout
        setContentView(R.layout.activity_splash)

        // Animate the text
        val splashText = findViewById<TextView>(R.id.splash_text)
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 1500
        splashText.startAnimation(fadeIn)

        // After animation, switch to main content
        Handler(Looper.getMainLooper()).postDelayed({
            // Use view binding for main activity
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Setup Navigation
            val navView: BottomNavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment)
            navView.setupWithNavController(navController)

            // Handle window insets for edge-to-edge display
            enableEdgeToEdge()
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }, 3000)
    }
}