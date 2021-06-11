package pt.ulusofona.deisi.a2020.cm.g2.ui.fragments

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment

abstract class PermissionedFragment(private val requestCode: Int) : Fragment() {

    fun onRequestPermissions(context: Context, permissions: Array<String>){
        var permissionsGiven = 0
        permissions.forEach {
            if (checkSelfPermission(context, it) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(permissions, requestCode)
            } else {
                permissionsGiven++
            }
        }
        if (permissionsGiven == permissions.size)
            onRequestPermissionsSuccess()
    }

    abstract fun onRequestPermissionsSuccess()

    abstract fun onRequestPermissionsFailure()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (this.requestCode == requestCode){
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                onRequestPermissionsSuccess()
            } else {
                onRequestPermissionsFailure()
            }
        }
    }
}