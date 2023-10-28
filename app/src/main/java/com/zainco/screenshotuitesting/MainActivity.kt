package com.zainco.screenshotuitesting

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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


/**
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 */


fun main(args: Array<String>) {
    println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3)))
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    // there is a work to n loop, "GO wherever you go, I am here with index i will get the first different value"
    for (n in nums){
        if (i < 2){
            i++
            continue
        }
        if(nums[i-2] != n){
            nums[i] = n//this line and the next spread the desired array and no need for the duplications
            i++
        }
    }
    return i
}

fun removeDuplicates2(nums: IntArray): Int {
    var i = 0
    for (n in nums) {
        if (i < 2 || n != nums[i - 2]) {
            nums[i++] = n
            print("${n},")
            println()
        }
    }
    return i
}