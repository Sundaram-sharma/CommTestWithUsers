package com.example.comm

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btnLaunchToast).setOnClickListener(this)
        findViewById<View>(R.id.btnLaunchSnackbar).setOnClickListener(this)
        findViewById<View>(R.id.btnLaunchDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnLaunchNotification).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnLaunchToast -> startActivity(Intent(this, ToastActivity::class.java))
            R.id.btnLaunchSnackbar -> startActivity(Intent(this, SnackbarActivity::class.java))
            R.id.btnLaunchDialog -> startActivity(Intent(this, DialogActivity::class.java))
            R.id.btnLaunchNotification -> startActivity(Intent(this, NotificationActivity::class.java))
        }
    }
}
