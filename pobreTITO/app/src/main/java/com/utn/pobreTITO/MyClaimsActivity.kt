package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.utn.pobreTITO.databinding.ActivityMyClaimsBinding
import com.utn.pobreTITO.models.Claim
import com.utn.pobreTITO.viewmodels.MyClaimsAdapter
import com.utn.pobreTITO.viewmodels.MyClaimsViewModel

class MyClaimsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyClaimsBinding
    private var viewModel : MyClaimsViewModel? = null
    private lateinit var claimList: List<Claim>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyClaimsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundel : Bundle?=intent.extras

        viewModel = MyClaimsViewModel(this)

        viewModel!!.listClaim.observe(this, Observer { list ->
            claimList = list as List<Claim>
            setupList()
        })
        val email = bundel?.getString("email").toString()
        viewModel!!.getClaims(email)
    }

    private fun setupList(){
        binding.rvMyClaims.layoutManager = LinearLayoutManager(this)
        val adapter = MyClaimsAdapter(claimList)
        binding.rvMyClaims.adapter = adapter
    }
}