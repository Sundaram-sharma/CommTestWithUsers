package usercomms.joemarini.example.com.usercommunications.Dialogs

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.DialogFragment
import androidx.appcompat.app.AlertDialog

class SimpleDialogFragment : DialogFragment() {
    private val TAG = "AUC_SIMPLE"
    private var mHost: SimpleDialogListener? = null

    interface SimpleDialogListener {
        fun onPositiveResult(dlg: DialogFragment)
        fun onNegativeResult(dlg: DialogFragment)
        fun onNeutralResult(dlg: DialogFragment)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)

        builder.setTitle("Peas Preference")
        builder.setMessage("Do you like sugar snap peas?")
        builder.setPositiveButton("Sure!") { dialog, which ->
            Log.i(TAG, "Positive button clicked")
            mHost!!.onPositiveResult(this@SimpleDialogFragment)
        }
        builder.setNegativeButton("No way!") { dialog, which ->
            Log.i(TAG, "Negative button clicked")
            mHost!!.onNegativeResult(this@SimpleDialogFragment)
        }
        builder.setNeutralButton("Not Sure") { dialog, which ->
            Log.i(TAG, "Neutral button clicked")
            mHost!!.onNeutralResult(this@SimpleDialogFragment)
        }
        return builder.create()
    }

    override fun onCancel(dlg: DialogInterface) {
        super.onCancel(dlg)
        Log.i(TAG, "Dialog cancelled")
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mHost = activity as SimpleDialogListener
    }

}
