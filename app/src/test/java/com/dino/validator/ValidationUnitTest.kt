package com.dino.validator

import com.dino.validator.utility.Validator
import org.junit.Test

import org.junit.Assert.*
import javax.security.auth.Subject

class ValidationUnitTest {

    @Test
    fun is_pan_valid() {
        assertTrue(PAN, Validator.isPanNumberValid("BNZAA2318J"))
        assertFalse(PAN, Validator.isPanNumberValid("23ZAABN18J"))
        assertFalse(PAN, Validator.isPanNumberValid("BNZAA2318JM"))
        assertFalse(PAN, Validator.isPanNumberValid("BNZAA 23184"))
        assertFalse(PAN, Validator.isPanNumberValid(""))
        assertFalse(PAN, Validator.isPanNumberValid("1234"))
        assertFalse(PAN, Validator.isPanNumberValid("pan"))
    }

    companion object {
        const val PAN = "pan_test"
    }
}