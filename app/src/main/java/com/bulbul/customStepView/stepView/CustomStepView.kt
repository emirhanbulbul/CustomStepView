package com.bulbul.customStepView.stepView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.bulbul.customStepView.adapter.CustomRvAdapter
import com.bulbul.customStepView.databinding.CustomStepViewBinding
import com.bulbul.customStepView.model.StepViewModel
import com.bulbul.customStepView.util.Constants

/**
 * Created by Emirhan Bülbül on 2.03.2023
 */

class CustomStepView @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0, defStyleRes: Int = 0
) : FrameLayout(context, attributeSet, defStyle, defStyleRes) {
    private val binding: CustomStepViewBinding
    private var continuesPosition = 0
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = CustomStepViewBinding.inflate(inflater)
        addView(binding.root)
    }

    fun listUpdate(list: ArrayList<StepViewModel>, currentStep:Int) {
        continuesPosition = currentStep
        if(currentStep < list.size && currentStep >= 0)
            listSetStatus(list)
    }

    private fun listSetStatus(list: ArrayList<StepViewModel>){
        list[continuesPosition].status = Constants.CONTINUES

        for(i in 0 until continuesPosition){
            list[i].status = Constants.COMPLETED
        }
        for(i in continuesPosition+1 until list.size){
            list[i].status = Constants.SPACE
        }
        binding.rvStep.adapter = CustomRvAdapter(list)
    }


}