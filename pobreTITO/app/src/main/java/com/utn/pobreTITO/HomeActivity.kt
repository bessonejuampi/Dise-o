package com.utn.pobreTITO

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import com.utn.pobreTITO.databinding.ActivityHomeBinding
import com.utn.pobreTITO.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var viewModel : HomeViewModel?=null
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = HomeViewModel(this)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val bundle : Bundle? = intent.extras

        viewModel!!.saveSession(bundle?.getString("email").toString(), bundle?.getString("pass").toString())

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            binding.drawerLayout.close()
            true
        }

        binding.navigationDrawer.setNavigationItemSelectedListener(this)


//        binding. btSignOut.setOnClickListener {
//            viewModel!!.signOutUser()
//            onBackPressed()
//        }

        binding.btRegisterClaim.setOnClickListener {
            viewModel!!.goToRegisterClaim()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) { onBackPressed() }
        return super.onOptionsItemSelected(item)
    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        when (item.itemId){
//
//        }
//    }


}