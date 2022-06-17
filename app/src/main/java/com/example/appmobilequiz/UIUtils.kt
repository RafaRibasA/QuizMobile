package com.example.appmobilequiz

import android.content.Context
import androidx.appcompat.app.AlertDialog
fun alert(title: String, msg: String, context: Context) {
    val builder = AlertDialog.Builder(context)
    builder
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()
}