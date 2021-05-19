package com.dino.validator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dino.validator.databinding.ActivityValidateBinding
import java.util.*

class ValidateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValidateBinding
    private val viewModel: ValidateViewModel by lazy {
        ViewModelProvider(this).get(ValidateViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_validate)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setObservers()
    }

    private fun setObservers() {
        viewModel.eventNext.observe(this, { isNext ->
            if (isNext){
                Toast.makeText(this,"Details submitted successfully",Toast.LENGTH_SHORT).show()
                viewModel.onNextCompleted()
                finish()
            }
        })
        viewModel.eventNoPan.observe(this, { isNoPan ->
            if (isNoPan){
                Toast.makeText(this,"Yoo",Toast.LENGTH_SHORT).show()
                viewModel.onNoPanCompleted()
            }
        })
        viewModel.eventDatePicker.observe(this, { clicked ->
            if (clicked) {
                // Get Current Date
                val c: Calendar = Calendar.getInstance()
                val mYear = c.get(Calendar.YEAR)
                val mMonth = c.get(Calendar.MONTH)
                val mDay = c.get(Calendar.DAY_OF_MONTH)
                DatePickerDialog(this,R.style.DialogTheme,
                        { view, year, monthOfYear, dayOfMonth ->
                           viewModel.day.value = dayOfMonth.toString()
                           viewModel.month.value = (monthOfYear+1).toString()
                           viewModel.year.value = year.toString()
                        }, mYear, mMonth, mDay).show()
                viewModel.onDateCompleted()
            }
        })
    }
}