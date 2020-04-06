package com.example.android.gymondoautomationtest.tests

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.gymondoautomationtest.*
import com.example.android.gymondoautomationtest.screenObjects.LoginScreen
import org.hamcrest.CoreMatchers.*
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val mActivityTestRule = IntentsTestRule(MainActivity::class.java)

    private val loginScreen = LoginScreen()
    private val validLogin = "automation@gymondo.de"
    private val validPassword = "automation"
    private val invalidLogin = "login"
    private val invalidPassword = "password"

    @Test
    fun checkAllFieldsAreDisplayed() {
        onView(loginScreen.loginField).check(matches(isDisplayed()))
        onView(loginScreen.passwordField).check(matches(isDisplayed()))
        onView(loginScreen.loginButton).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginWithValidParameters() {
        loginScreen
            .fillLogin(validLogin)
            .fillPassword(validPassword)
            .closeSoftKeyboard()
            .clickLoginButton()

        intended(hasComponent(ListActivity::class.java.name))
    }

    @Test
    fun checkLoginWithInvalidLogin() {
        loginScreen
            .fillLogin(invalidLogin)
            .fillPassword(validPassword)
            .closeSoftKeyboard()
            .clickLoginButton()

        onView(loginScreen.allert)
            .inRoot(withDecorView(not(`is`(mActivityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginWithInvalidPassword() {
        loginScreen
            .fillLogin(validLogin)
            .fillPassword(invalidPassword)
            .closeSoftKeyboard()
            .clickLoginButton()

        onView(loginScreen.allert)
            .inRoot(withDecorView(not(`is`(mActivityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

}
