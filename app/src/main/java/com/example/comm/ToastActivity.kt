package com.example.comm

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

class ToastActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        findViewById<View>(R.id.btnShowToast).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomToast).setOnClickListener(this)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnShowToast -> showToast()
            R.id.btnShowCustomToast -> showCustomToast()
        }
    }

    private fun showToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        // Create and show the toast message
        val toast = Toast.makeText(this, "This is a toast", toastDuration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    private fun showCustomToast() {
        val toastDuration: Int
        val rbShort = findViewById<View>(R.id.rbShort) as RadioButton
        if (rbShort.isChecked)
            toastDuration = Toast.LENGTH_SHORT
        else
            toastDuration = Toast.LENGTH_LONG

        // Get the custom layout and inflate it
        val inflater = LayoutInflater.from(this)
        val layout = inflater.inflate(R.layout.custom_toast_layout, findViewById(R.id.customToastLayout))

        // Build a toast message that uses the custom layout
        val tv = layout.findViewById<View>(R.id.textContent) as TextView
        tv.text = "This is a custom toast"
        val toast = Toast(applicationContext)
        toast.duration = toastDuration
        toast.setGravity(Gravity.BOTTOM or Gravity.START, 100, 100)
        toast.view = layout
        toast.show()
    }
}
