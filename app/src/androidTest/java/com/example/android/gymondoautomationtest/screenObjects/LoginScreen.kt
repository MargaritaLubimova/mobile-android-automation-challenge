package com.example.android.gymondoautomationtest.screenObjects

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
import com.example.android.gymondoautomationtest.R

class LoginScreen {

    val loginField = ViewMatchers.withId(R.id.editText)
    val passwordField = ViewMatchers.withId(R.id.editText2)
    val loginButton = ViewMatchers.withId(R.id.button)
    val allert = ViewMatchers.withText("Username and/or password incorrect")

    fun fillLogin(login: String): LoginScreen {
        onView(loginField).perform(typeText(login))
        return this
    }

    fun fillPassword(password: String): LoginScreen {
        onView(passwordField).perform(typeText(password))
        return this
    }

    fun clickLoginButton(): LoginScreen {
        onView(loginButton).perform(click())
        return this
    }

    fun closeSoftKeyboard(): LoginScreen {
        Espresso.closeSoftKeyboard()
        return this
    }

}