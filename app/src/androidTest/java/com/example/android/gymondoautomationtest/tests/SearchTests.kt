package com.example.android.gymondoautomationtest.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.gymondoautomationtest.ListActivity
import com.example.android.gymondoautomationtest.helpers.SearchScreenExercises
import com.example.android.gymondoautomationtest.screenObjects.SearchScreen
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchTest {

    @get:Rule
    val lActivityTestRule = IntentsTestRule(ListActivity::class.java)

    private val searchScreen = SearchScreen()
    private val searchScreenExercises: SearchScreenExercises by lazy {
        SearchScreenExercises(activity = lActivityTestRule.activity)
    }

    @Test
    fun checkAllFieldsAreDisplayed() {
        onView(searchScreen.searchField).check(matches(isDisplayed()))
        onView(searchScreen.searchButton).check(matches(isDisplayed()))
        onView(searchScreen.clearButton).check(matches(isDisplayed()))
    }

    @Test
    fun checkSearchExercise() {
        val exercise = searchScreenExercises.getRandomExercise()

        searchScreen
            .fillSearch(exercise)
            .closeSoftKeyboard()
            .clickSearchButton()

        onView(searchScreen.cell).check(matches(withText(exercise)))
    }

}
