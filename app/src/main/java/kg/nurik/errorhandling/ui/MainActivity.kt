package kg.nurik.errorhandling.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import kg.nurik.errorhandling.R
import kg.nurik.errorhandling.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.loadUser()
        setupViewModel()
    }

    private fun setupViewModel() {
        super.setupViewModel(vm)
        vm.user.observe(this, Observer {
            tvText.text = it.getFullUserName()
            Toast.makeText(this, it.getFullUserName(), Toast.LENGTH_LONG).show()
        })
    }
}