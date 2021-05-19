package com.dino.validator.validation

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dino.validator.R
import com.dino.validator.databinding.ActivityValidateBinding
import java.util.*

class ValidateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValidateBinding
    private val viewModel: ValidateViewModel by lazy {
        ViewModelProvider(this).get(ValidateViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_validate)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setObservers()
    }

    private fun setObservers() {
        viewModel.eventNext.observe(this, { isNext ->
            if (isNext){
                Toast.makeText(this,getString(R.string.success_message),Toast.LENGTH_SHORT).show()
                viewModel.onNextCompleted()
                finish()
            }
        })
        viewModel.eventNoPan.observe(this, { isNoPan ->
            if (isNoPan){
                viewModel.onNoPanCompleted()
                finish()
            }
        })
        viewModel.eventDatePicker.observe(this, { clicked ->
            if (clicked) {
                pickDate()
                viewModel.onDateCompleted()
            }
        })
    }

    private fun pickDate() {
        val calendar: Calendar = Calendar.getInstance()
        val mYear = calendar.get(Calendar.YEAR)
        val mMonth = calendar.get(Calendar.MONTH)
        val mDay = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, R.style.DialogTheme,
                { view, year, monthOfYear, dayOfMonth ->
                    viewModel.day.value = (dayOfMonth<10).let { "0$dayOfMonth" }
                    viewModel.month.value = (monthOfYear+1<10).let { "0$monthOfYear" }
                    viewModel.year.value = year.toString()
                }, mYear, mMonth, mDay).show()
    }
}