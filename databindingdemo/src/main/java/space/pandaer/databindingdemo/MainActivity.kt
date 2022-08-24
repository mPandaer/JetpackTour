package space.pandaer.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import space.pandaer.databindingdemo.databinding.ActivityMainBinding
import space.pandaer.databindingdemo.model.User

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.user = User(getName(),getHobby())
//        binding.handler = ClickHandler()
        binding.button.setOnClickListener {
            val user  = binding.user as User
            user.name.set(getName())
            user.hobby.set(getHobby())
        }
    }

    private fun getName() = binding.name.text.toString()
    private fun getHobby() = binding.hobby.text.toString()
}