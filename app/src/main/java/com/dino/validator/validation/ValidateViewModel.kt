package com.dino.validator.validation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dino.validator.utility.Utilities.Companion.isPanNumberValid

class ValidateViewModel: ViewModel() {

    val panNumber = MutableLiveData<String>()
    var day = MutableLiveData<String>()
    var month = MutableLiveData<String>()
    var year = MutableLiveData<String>()

    // Event which triggers
    private val _eventNext = MutableLiveData<Boolean>()
    val eventNext: LiveData<Boolean>
        get() = _eventNext

    private val _eventPan = MutableLiveData<Boolean>()
    val eventNoPan: LiveData<Boolean>
        get() = _eventPan

    private val _eventDate = MutableLiveData<Boolean>()
    val eventDatePicker: LiveData<Boolean>
        get() = _eventDate


    val isPanValid = MediatorLiveData<Boolean>().apply {
        addSource(panNumber) {
            value = isPanNumberValid(it)
        }
    }

    val isDateValid = MediatorLiveData<Boolean>().apply {
        addSource(day) {
            value = it.isNotEmpty()
        }
    }

    fun onNextClick(){
        _eventNext.value = true
    }

    fun onNextCompleted() {
        _eventNext.value = false
    }

    fun onNoPanClick(){
        _eventPan.value = true
    }

    fun onNoPanCompleted() {
        _eventPan.value = false
    }
    fun onDateClick(){
        _eventDate.value = true
    }

    fun onDateCompleted() {
        _eventDate.value = false
    }
}