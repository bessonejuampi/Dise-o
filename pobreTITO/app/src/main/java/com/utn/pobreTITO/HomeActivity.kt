package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utn.pobreTITO.databinding.ActivityHomeBinding
import com.utn.pobreTITO.viewmodels.HomeViewModel

class HomeActivity : AppCompatActivity(){

    private var viewModel : HomeViewModel?=null
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = HomeViewModel(this)

        val bundle : Bundle? = intent.extras

        viewModel!!.saveSession(bundle?.getString(getString(R.string.title_email)).toString(),
            bundle?.getString("pass").toString())

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            binding.drawerLayout.close()
            when(menuItem.itemId){
                R.id.btSignOut -> {
                    viewModel!!.signOutUser()
                    onBackPressed()
                }
                R.id.profile -> viewModel!!.goToProfile()
                R.id.myClaims -> viewModel!!.goToMyClaims()

            }
            true
        }


        binding.btRegisterClaim.setOnClickListener {
            viewModel!!.goToRegisterClaim()
        }

    }

}