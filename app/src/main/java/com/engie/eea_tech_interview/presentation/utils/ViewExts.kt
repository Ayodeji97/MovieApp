package com.engie.eea_tech_interview.presentation.utils

import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.engie.eea_tech_interview.R
import com.google.android.material.snackbar.Snackbar

fun ImageView.loadImage(url: String, placeHolder: Int = R.drawable.vikings) {
    Glide.with(this.context)
        .load(url)
        .placeholder(placeHolder)
        .error(placeHolder)
        .into(this)
}

inline fun SearchView.onQueryTextChanged(crossinline listener: (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        var timer: CountDownTimer? = null
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            timer?.cancel()
            timer = object : CountDownTimer(1000, 200) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    if (!newText.isNullOrEmpty()) {
                        listener(newText.orEmpty())
                    }
                }
            }.start()
            return true
        }
    })
}

fun Fragment.showSnackBar(view: View, message: String) {
    Snackbar.make(
        view,
        message,
        Snackbar.LENGTH_LONG
    ).setAction("ok") {
    }.show()
}
