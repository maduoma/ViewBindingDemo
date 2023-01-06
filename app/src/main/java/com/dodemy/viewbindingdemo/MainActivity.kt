package com.dodemy.viewbindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dodemy.viewbindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // create binding instance for the activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // when app is initially opened the Fragment 1 should be visible
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentHolder.id, Fragment1())
            addToBackStack(null)
            commit()
        }

        // handle the fragment 2 button to toggle the fragment 2
        binding.fragment1B.setOnClickListener {
            changeFragment(Fragment1())
        }

        // handle the fragment 2 button to toggle the fragment 2
        binding.fragment2B.setOnClickListener {
            changeFragment(Fragment2())
        }
    }

    // function to change the fragment which is used to reduce the lines of code
    private fun changeFragment(fragmentToChange: Fragment): Unit {
        supportFragmentManager.beginTransaction().apply {
            replace(binding.fragmentHolder.id, fragmentToChange)
            addToBackStack(null)
            commit()
        }
    }
}