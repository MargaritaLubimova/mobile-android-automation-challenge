package com.example.android.gymondoautomationtest.screenObjects

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.gymondoautomationtest.R

class SearchScreen {

    val searchField = ViewMatchers.withId(R.id.editTxtSearch)
    val searchButton = ViewMatchers.withId(R.id.btnSearch)
    val clearButton = ViewMatchers.withId(R.id.btnClear)
    val cell = ViewMatchers.withId(R.id.item_text)

    fun fillSearch(exercise: String): SearchScreen {
        onView(searchField).perform(typeText(exercise))
        return this
    }

    fun clickSearchButton(): SearchScreen {
        onView(searchButton).perform(click())
        return this
    }

    fun clickClearButton(): SearchScreen {
        onView(clearButton).perform(click())
        return this
    }

    fun closeSoftKeyboard(): SearchScreen {
        Espresso.closeSoftKeyboard()
        return this
    }

}
