package com.determinasian.outandaboutevents.ui.components.event

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.determinasian.outandaboutevents.ui.CharConstants
import org.junit.Rule
import org.junit.Test

class EventCardTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun vendorTextAll() {
        composeRule.setContent {
            VendorText(host = "test host", sponsor = "test sponsor")
        }

        composeRule.onNodeWithText("TEST HOST ${CharConstants.BULLET} TEST SPONSOR")
            .assertIsDisplayed()
    }

    @Test
    fun vendorTextHost() {
        composeRule.setContent {
            VendorText(host = "test host")
        }

        composeRule.onNodeWithText("TEST HOST").assertIsDisplayed()
    }

    @Test
    fun vendorTextSponsor() {
        composeRule.setContent {
            VendorText(sponsor = "test sponsor")
        }

        composeRule.onNodeWithText("TEST SPONSOR").assertIsDisplayed()
    }

    @Test
    fun vendorTextEmpty() {
        composeRule.setContent {
            VendorText()
        }

        composeRule.onNodeWithTag("VendorText").assertDoesNotExist()
    }
}