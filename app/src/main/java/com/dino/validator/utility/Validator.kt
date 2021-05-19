package com.dino.validator.utility

import java.util.regex.Matcher
import java.util.regex.Pattern

class Validator {

    companion object {
        //Validate PAN number is valid or not
        fun isPanNumberValid(panCardNo: String): Boolean {
            val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
            val p: Pattern = Pattern.compile(regex)
            val m: Matcher = p.matcher(panCardNo)
            return m.matches()
        }
    }

}