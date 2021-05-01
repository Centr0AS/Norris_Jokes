package com.example.Norris_Jokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.Norris_Jokes.fragments.BrowserFragment
import com.example.Norris_Jokes.fragments.JokesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jokesFragment = JokesFragment()
        val browserFragment = BrowserFragment()
        makeCurrentFragment(jokesFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val loadBtn = findViewById<Button>(R.id.load_btn)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.jokes -> makeCurrentFragment(jokesFragment)
                R.id.web -> makeCurrentFragment(browserFragment)

            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fl_wrapper, fragment)
            addToBackStack(null)
            //TODO: Fix backButton behavior
            commit()
        }
}