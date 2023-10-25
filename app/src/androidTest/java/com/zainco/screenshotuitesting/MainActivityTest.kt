package com.zainco.screenshotuitesting

import android.graphics.Bitmap
import android.os.Environment
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.screenshot.Screenshot
import androidx.test.uiautomator.UiDevice
import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.io.File
import java.io.FileOutputStream

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    /* @Test
     fun a_testActivity_inView() {
         val activityScenario = ActivityScenario.launch(MainActivity::class.java)
         Espresso.onView(withId(R.id.tvWelcomeMessage)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
     }*/

    @Test
    fun testActivity_inView2() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_arabic_and_english_Buttons() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.btnArabic))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // method 1

        Espresso.onView(withId(R.id.btnArabic))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2

        Espresso.onView(withId(R.id.btnEnglish))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Text
    @Test
    fun testNextTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.button_next_activity))
            .check(ViewAssertions.matches(withText(R.string.text_next)))
    }

    @Test
    fun test_arabic_clicked_verifySecondaryTitleText() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.btnArabic)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_back))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        /*   Espresso.onView(withId(R.id.activity_secondary_title))
               .check(ViewAssertions.matches(withText("SecondaryActivity")))*/

        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(withText("SecondaryActivity عربي")))

    }

    @Test
    fun test_english_clicked_verifySecondaryTitleText() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.btnEnglish)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_back))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        /*   Espresso.onView(withId(R.id.activity_secondary_title))
               .check(ViewAssertions.matches(withText("SecondaryActivity")))*/

        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(withText(R.string.text_secondaryactivity)))

    }

    @Test
    fun test_english_clicked_takeScreenShotForMain() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.btnEnglish)).perform(ViewActions.click())
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val screenshot = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath,
            "Screen1-English.png"
        )
        device.takeScreenshot(screenshot)
    }

    @Test
    fun test_english_clicked_takeScreenShotForSecondary() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.btnEnglish)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val screenshot = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath,
            "Screen2-English.png"
        )
        device.takeScreenshot(screenshot)
    }

    @Test
    fun test_arabic_clicked_takeScreenShotForMain() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.btnArabic)).perform(ViewActions.click())
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val screenshot = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath,
            "Screen1-Arabic.png"
        )
        device.takeScreenshot(screenshot)
    }

    @Test
    fun test_arabic_clicked_takeScreenShotForSecondary() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(withId(R.id.btnArabic)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_next_activity)).perform(ViewActions.click())
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val screenshot = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath,
            "Screen2-Arabic.png"
        )
        device.takeScreenshot(screenshot)
    }

}