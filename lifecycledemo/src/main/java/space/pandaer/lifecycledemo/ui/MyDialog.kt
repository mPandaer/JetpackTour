package space.pandaer.lifecycledemo.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import space.pandaer.lifecycledemo.R

class MyDialog(val myContext: Context) : Dialog(myContext),LifecycleObserver{
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super<Dialog>.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dialog)
    }
    
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onShow() {
        Log.d("xixi", "onShow: dialog显示")
        if(!isShowing) show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        Log.d("xixi", "onShow: dialog销毁")
        if(isShowing) dismiss()
    }

}