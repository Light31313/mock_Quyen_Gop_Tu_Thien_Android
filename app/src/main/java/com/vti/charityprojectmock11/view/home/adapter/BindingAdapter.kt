package com.vti.charityprojectmock11.view.home.adapter

import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.vti.charityprojectmock11.R
import java.text.DecimalFormat
import java.util.*


@BindingAdapter("imageUrl")
fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}

@BindingAdapter("currentMoney", "targetMoney", requireAll = true)
fun TextView.showTextPercent(currentMoney: Float, totalMoney: Float) {
    val percent = (currentMoney / totalMoney) * 100
    text = resources.getString(R.string.percent, percent)
}

@BindingAdapter("currentMoney", "targetMoney", requireAll = true)
fun ProgressBar.showProgress(currentMoney: Float, totalMoney: Float) {
    val progress = ((currentMoney / totalMoney) * 100).toInt()
    this.progress = progress
}

@BindingAdapter("currentMoneyText")
fun TextView.convertToCurrentMoneyFormat(money: Float) {
    val formatter = DecimalFormat("###,###,###")
    val text = "${formatter.format(money)}đ"
    this.text = text
}

@BindingAdapter("targetMoneyText")
fun TextView.convertToTargetMoneyFormat(money: Float) {
    val formatter = DecimalFormat("###,###,###")
    val text = "/ ${formatter.format(money)}đ"
    this.text = text
}

@BindingAdapter("endDate")
fun TextView.getRemainDays(endDate: Date) {
    val remainDays = ((endDate.time - Calendar.getInstance().time.time)/(1000*60*60*24)).toInt()
    if (remainDays >= 0)
        this.text = resources.getString(R.string.time_remain, remainDays)
    else
        this.text = resources.getString(R.string.stop)
}