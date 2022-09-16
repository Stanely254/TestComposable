package com.stanley.testcomposable

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.stanley.testcomposable.ui.theme.TestComposableTheme
import org.junit.Before
import org.junit.Rule

import org.junit.Test

class MainActivityKtTest {

    @get: Rule
    val composableTestRule = createComposeRule()

    @Before
    fun setUp(){
        composableTestRule.setContent {
            TestComposableTheme{
                CounterDisplay()
            }
        }
    }

    @Test
    fun verify_if_all_views_exists() {
        composableTestRule.onNodeWithTag("Counter Display").assertExists()
        composableTestRule.onNodeWithTag("Input").assertExists()
        composableTestRule.onNodeWithText("Copy").assertExists()
    }

    @Test
    fun counterValue_with_emptyInput_displays_InvalidEntry(){
        composableTestRule.onNodeWithText("Copy").performClick()
        composableTestRule.onNodeWithTag("Counter Display").assertTextEquals("Invalid Entry")
    }

    @Test
    fun withInput_as_1_onButtonClick_displayOnTop(){
        // Mimic the user inputting the text
        composableTestRule.onNodeWithTag("Input").performTextInput("1")

        //mimic if the user clicked on the button
        composableTestRule.onNodeWithText("Copy").performClick()

        //mimic if the user is shown the desired text on UI
        composableTestRule.onNodeWithTag("Counter Display").assertTextContains("Counter = 1")
    }
}