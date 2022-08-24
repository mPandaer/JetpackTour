package space.pandaer.lifecycledemo.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import space.pandaer.lifecycledemo.R

class MainActivity : AppCompatActivity() {
    private  val dialog by lazy { MyDialog(this@MainActivity) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(dialog)
        Handler(Looper.getMainLooper()).postDelayed({
              finish()
        },2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("xixi", "onDestroy: Activity销毁了")
    }
}