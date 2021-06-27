package com.example.navigationcomponemtexample

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private lateinit var senario: ActivityScenario<MainActivity>


    @Before
    fun setup(){
        senario= ActivityScenario.launch(MainActivity::class.java)
        senario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testSendMoney(){
        onView(withId(R.id.send_money_btn)).perform(click())
        val name = "Arindam"
        val amount=1000

        onView(withId(R.id.input_recipient)).perform(ViewActions.typeText(name))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.next_btn)).perform(click())

        onView(withId(R.id.input_amount)).perform(ViewActions.typeText(amount.toString()))
        Espresso.closeSoftKeyboard()

        onView(withId(R.id.send_btn)).perform(click())
        var display= "You have sent ${amount.toString()} to $name"


        onView(withId(R.id.Home_btn)).perform(click())

        // VERIFY
        onView(withId(R.id.mainFragment))
            .check(matches(isDisplayed()))



//        onView(withId(R.id.confirmation_message)).check(matches(withText(display)))



    }
}