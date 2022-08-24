package space.pandaer.myjetpacktour

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import space.pandaer.myjetpacktour.databinding.ActivityMainBinding
import space.pandaer.myjetpacktour.vm.MyViewModel

const val TAG = "xixi"
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private val viewModel by lazy { ViewModelProvider(this)[MyViewModel::class.java] }
    private val viewModel by lazy { ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory(application))[MyViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: ")

        viewModel.liveText.observeForever {
            Log.d(TAG, "xixi")
            binding.textView.text = it
        }
        Log.d(TAG, "onCreate: ${viewModel.liveText.hasActiveObservers()}")
        binding.editText.setOnClickListener {
            viewModel.liveText.value = binding.editText.text.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        Log.d(TAG, "onStart: ${viewModel.liveText.hasActiveObservers()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        Log.d(TAG, "onResume: ${viewModel.liveText.hasActiveObservers()}")
    }

}