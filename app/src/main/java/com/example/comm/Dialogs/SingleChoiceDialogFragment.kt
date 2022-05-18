package usercomms.joemarini.example.com.usercommunications.Dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.DialogFragment

class SingleChoiceDialogFragment : DialogFragment() {
    private val TAG = "AUC_COMPLEX"
    private val colors = arrayOf("Red", "Blue", "Green", "Yellow")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        // NOTE: setMessage doesn't work here because the list takes up the content
        // area. Use the setTitle method to set a descriptive prompt
        builder.setTitle("What Is Your Favorite Color?")

        // The setItems function is used to create a list of content
        builder.setItems(colors) { dialog, which -> Log.i(TAG, String.format("Color chosen: %s", colors[which])) }

        // Single-choice dialogs don't need buttons because they
        // auto-dismiss when the user makes a choice

        return builder.create()
    }
}
