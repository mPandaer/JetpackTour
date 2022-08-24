package space.pandaer.databindingdemo

import android.util.Log
import android.view.View
import space.pandaer.databindingdemo.model.User

class ClickHandler {

    fun save(view : View,user:User) {
        Log.d("xixi", "save: ${view::class.java} ${user.name} ${user.hobby}")
    }
}