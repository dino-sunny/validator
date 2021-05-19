package com.dino.validator

import com.dino.validator.utility.Utilities
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidationUnitTest {

    @Test
    fun is_pan_valid() {
        assertTrue(PAN, Utilities.isPanNumberValid("BNZAA2318J"))
        assertFalse(PAN, Utilities.isPanNumberValid("23ZAABN18J"))
        assertFalse(PAN, Utilities.isPanNumberValid("BNZAA2318JM"))
        assertFalse(PAN, Utilities.isPanNumberValid("BNZAA 23184"))
        assertFalse(PAN, Utilities.isPanNumberValid(""))
        assertFalse(PAN, Utilities.isPanNumberValid("1234"))
        assertFalse(PAN, Utilities.isPanNumberValid("pan"))
    }

    companion object {
        const val PAN = "pan_test"
    }
}