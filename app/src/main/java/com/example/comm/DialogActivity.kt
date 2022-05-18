package com.example.comm

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.DatePicker

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

import java.util.Calendar

import usercomms.joemarini.example.com.usercommunications.Dialogs.CustomDialogFragment
import usercomms.joemarini.example.com.usercommunications.Dialogs.SingleChoiceDialogFragment
import usercomms.joemarini.example.com.usercommunications.Dialogs.SimpleDialogFragment

class DialogActivity : AppCompatActivity(), View.OnClickListener, SimpleDialogFragment.SimpleDialogListener {

    private val TAG = "AUC_DLG_ACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        // set up button click handlers
        findViewById<View>(R.id.btnSimpleDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnShowDatePicker).setOnClickListener(this)
        findViewById<View>(R.id.btnShowChoiceDialog).setOnClickListener(this)
        findViewById<View>(R.id.btnShowCustomDialog).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSimpleDialog -> showSimpleDialog()
            R.id.btnShowDatePicker -> {
                // Get a calendar instance
                val cal = Calendar.getInstance()

                // Create a DatePickerDialog
                val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth -> Log.i(TAG, String.format("Date Chosen -- day: %d, month: %d, year: %d", dayOfMonth, monthOfYear, year)) }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

                // Set the title and show the dialog
                datePicker.setTitle("Choose a Date")
                datePicker.show()
            }
            R.id.btnShowChoiceDialog -> showChoiceDialog()
            R.id.btnShowCustomDialog -> showCustomDialog()
        }
    }

    private fun showSimpleDialog() {
        val simpleDialog = SimpleDialogFragment()
        // Use setCancelable() to make the dialog non-cancelable
        //simpleDialog.setCancelable(false);
        simpleDialog.show(supportFragmentManager, "SimpleDialogFragment")
    }

    private fun showCustomDialog() {
        val customDialog = CustomDialogFragment()
        customDialog.show(supportFragmentManager, "CustomDialogFragment")
    }

    private fun showChoiceDialog() {
        val complexDialog = SingleChoiceDialogFragment()
        complexDialog.show(supportFragmentManager, "SingleChoiceDialogFragment")
    }

    override fun onPositiveResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Positive Result")
    }

    override fun onNegativeResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Negative Result")
    }

    override fun onNeutralResult(dlg: DialogFragment) {
        Log.i(TAG, "Dialog Neutral Result")
    }
}
