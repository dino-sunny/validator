package com.dino.validator.utility

import java.util.regex.Matcher
import java.util.regex.Pattern

class Utilities {

    companion object {
        //Validate PAN number is valid or not
        fun isPanNumberValid(panCardNo: String): Boolean {
            val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
            val p: Pattern = Pattern.compile(regex)
            val m: Matcher = p.matcher(panCardNo)
            return m.matches()
        }
        fun maxEligibleDate(): Long {
            return (System.currentTimeMillis()- (1000 * 60 * 60 * 24 * 365.25 * 18)).toLong()
        }
    }

}