package com.cst.cstacademy2024

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.cst.cstacademy2024.helpers.extensions.logErrorMessage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.view?.post {
            val navController = navHostFragment.navController
            setupActionBarWithNavController(navController)
        }
    }

    override fun onStart() {
        super.onStart()

        "onStart".logErrorMessage()
    }

    override fun onResume() {
        super.onResume()

        "onResume".logErrorMessage()
    }

    override fun onPause() {
        super.onPause()

        "onPause".logErrorMessage()
    }

    override fun onStop() {
        super.onStop()

        "onStop".logErrorMessage()
    }

    override fun onDestroy() {
        super.onDestroy()

        "onDestroy".logErrorMessage()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
    }

}