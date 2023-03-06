package com.bulbul.customStepView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bulbul.customStepView.databinding.ActivityMainBinding
import com.bulbul.customStepView.model.StepViewModel

class MainActivity : AppCompatActivity() {
    var arrayList: ArrayList<StepViewModel> = arrayListOf()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var step = 0
        binding = ActivityMainBinding.inflate(layoutInflater)
        arrayList.add(StepViewModel("Step 1", ""))
        arrayList.add(StepViewModel("Step 2", ""))
        arrayList.add(StepViewModel("Step 3", ""))
        binding.stepView.listUpdate(arrayList, step)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            step--
            binding.stepView.listUpdate(arrayList, step)
        }

        binding.next.setOnClickListener {
            step++
            binding.stepView.listUpdate(arrayList, step)
        }

    }
}