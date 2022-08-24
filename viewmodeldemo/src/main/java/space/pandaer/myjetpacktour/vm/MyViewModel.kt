package space.pandaer.myjetpacktour.vm

import android.app.Application
import androidx.lifecycle.*

class MyViewModel(application: Application) : AndroidViewModel(application) {
    val liveText = MutableLiveData("")

}