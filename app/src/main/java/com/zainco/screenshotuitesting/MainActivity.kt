package com.zainco.screenshotuitesting

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Attach the MainFragment to the MainActivity
        /*if (savedInstanceState == null) {
            val mainFragment = WelcomeFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, mainFragment)
                .commit()
        }*/
        findViewById<Button>(R.id.btnArabic).setOnClickListener {
            switchToArabic()
        }

        findViewById<Button>(R.id.btnEnglish).setOnClickListener {
            switchToEnglish()
        }
        findViewById<Button>(R.id.button_next_activity).setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setAppLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration(resources.configuration)
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    // Function to restart the activity
    private fun restartActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    // Function to switch to English
    private fun switchToEnglish() {
        setAppLocale("en")
        restartActivity()
    }

    // Function to switch to Arabic
    private fun switchToArabic() {
        setAppLocale("ar")
        restartActivity()
    }
}