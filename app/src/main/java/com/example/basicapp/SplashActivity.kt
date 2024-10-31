package com.example.basicapp



import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.basicapp.activities.MainActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY = 2000L // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Animate the text
        val splashText = findViewById<TextView>(R.id.splash_text)
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 1500
        splashText.startAnimation(fadeIn)

        // Navigate to MainActivity after delay
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            // Add transition animation
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, SPLASH_DELAY)
    }
}
