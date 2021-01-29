package kg.nurik.errorhandling.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

abstract class BaseActivity : AppCompatActivity() {

    protected fun setupViewModel(vm: BaseViewModel) {
        vm.errorData.observe(this, Observer {
            when (it) {
                ErrorTypes.IO_ERROR -> ioException()
                ErrorTypes.NETWORK_FAILED -> networkException()
                ErrorTypes.AUTH_ERROR -> authException()
                else -> {   }
            }
        })
    }


    private fun ioException() {
        Toast.makeText(this, "IO error", Toast.LENGTH_LONG).show()
    }
    private fun networkException() {
        Toast.makeText(this, "network error", Toast.LENGTH_LONG).show()
    }
    private fun authException() {
        Toast.makeText(this, "Auth error", Toast.LENGTH_LONG).show()
    }
}