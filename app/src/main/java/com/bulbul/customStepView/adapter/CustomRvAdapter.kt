package com.bulbul.customStepView.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bulbul.customStepView.R
import com.bulbul.customStepView.databinding.LayoutStepperviewBinding
import com.bulbul.customStepView.model.StepViewModel
import com.bulbul.customStepView.util.Constants

/**
 * Created by Emirhan Bülbül on 4.03.2023
 */


class CustomRvAdapter(private var stepList: ArrayList<StepViewModel>) :
    RecyclerView.Adapter<CustomRvAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: LayoutStepperviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val binding =
            LayoutStepperviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (stepList[position].status) {
            Constants.CONTINUES ->{
                holder.binding.ivStepIcon.setImageResource(R.drawable.baseline_lens_24)
                holder.binding.tvStepText.setTextColor(Color.BLACK)
            }
            Constants.COMPLETED -> {
                holder.binding.ivStepIcon.setImageResource(R.drawable.baseline_check_24)
                holder.binding.ivStepIcon.setBackgroundResource(R.drawable.circle_black)
            }
            Constants.SPACE -> holder.binding.ivStepIcon.setImageResource(0)
        }

        //Gone start and end line.
        if (position == 0)
            holder.binding.viewLineStart.visibility = View.GONE
        if (position == itemCount - 1)
            holder.binding.viewLineEnd.visibility = View.GONE

        holder.binding.tvStepText.text = stepList[position].title
    }

    override fun getItemCount(): Int {
        return stepList.size
    }

}