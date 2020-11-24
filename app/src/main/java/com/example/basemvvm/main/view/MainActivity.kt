package com.example.basemvvm.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.basemvvm.R
import com.example.basemvvm.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding : MainActivityBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = MainActivityBinding.inflate(layoutInflater).apply {
            setContentView(root)
            setSupportActionBar(toolbar)

            val navController: NavController = findNavController(R.id.navHostFragment)
            appBarConfiguration = AppBarConfiguration.Builder(R.id.main_frag_dest, R.id.security_frag_dest, R.id.setting_frag_dest)
                    .setOpenableLayout(drawerLayout)
                    .build()
            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)

            //toolbar customize
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            navController.addOnDestinationChangedListener { _, destination, _ ->
                textTitle.text = destination.label
            }
        }
        setupNavigationDrawer()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setupNavigationDrawer() {
        viewBinding.drawerLayout.apply { setStatusBarBackground(R.color.colorPrimary) }
    }
}