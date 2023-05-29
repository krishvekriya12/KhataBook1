package com.example.khatabook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.khatabook.Fragments.AddFragment
import com.example.khatabook.Fragments.HomeFragment
import com.example.khatabook.Fragments.TransactionFragment
import com.example.khatabook.databinding.ActivityMainBinding
import me.ibrahimsn.lib.OnItemSelectedListener
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadFragment(HomeFragment())
        binding.bottomBar.onItemSelectedListener = object : OnItemSelectedListener{

            override fun onItemSelect(pos: Int): Boolean {

                when(pos) {
                    0->{

                        loadFragment(HomeFragment())
                    }
                    1->{
                        loadFragment(AddFragment())
                    }
                    2->{

                        loadFragment(TransactionFragment())
                    }

                }

                return false
            }


        }


    }

    private fun loadFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameFragment, fragment)
            .commit()
    }
}