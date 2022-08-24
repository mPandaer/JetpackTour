package space.pandaer.databindingdemo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import space.pandaer.databindingdemo.BR

class User(name:String,hobby:String) {


    var name : ObservableField<String> = ObservableField(name)
    var hobby : ObservableField<String> = ObservableField(hobby)
}

class User1(name:String,hobby:String):BaseObservable() {
    @get:Bindable
    var name:String = name
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }
    @get:Bindable
    var hobby:String = hobby
    set(value) {
        field = value
        notifyPropertyChanged(BR.hobby)
    }
}