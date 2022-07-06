package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.utn.pobreTITO.databinding.ActivityRegisterClaimBinding
import com.utn.pobreTITO.viewmodels.RegisterClaimViewModel

class RegisterClaimActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterClaimBinding

    private var viewModel : RegisterClaimViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterClaimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = RegisterClaimViewModel(this)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        val bundle : Bundle? = intent.extras
        setupAdapter()

        binding.btRegisterClaim.setOnClickListener {
            viewModel!!.ValidationRegisterClaim(
                binding.etTitle.text.toString(),
                binding.tfCategory.editText?.text.toString(),
                binding.etDescription.text.toString(),
                binding.etDirection.text.toString(),
                bundle?.getString("email").toString()
            )
        }

        setupViewModelObserver()
        setupEditText()
    }

    private fun setupViewModelObserver(){
        viewModel!!.validatornCalimMutable.observe(this, Observer { validatorClaim -> validatorClaim?.let{
            if (!validatorClaim.titleError.isNullOrEmpty()){
                binding.tfTitle.error = validatorClaim.titleError
            }
            if (!validatorClaim.descriptionError.isNullOrEmpty()){
                binding.tfDescrption.error = validatorClaim.descriptionError
            }
            if (!validatorClaim.categoryError.isNullOrEmpty()){
                binding.tfCategory.error = validatorClaim.categoryError
            }
            if (!validatorClaim.directionError.isNullOrEmpty()){
                binding.tfDirection.error = validatorClaim.directionError
            }
        } })
    }

    private fun setupAdapter(){
        val categories = resources.getStringArray(R.array.categories)
        val adapter = ArrayAdapter(this, R.layout.list_category, categories)
        binding.atvCategory.setAdapter(adapter)
    }

    private fun setupEditText() {
        binding.etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfTitle.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfDescrption.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.atvCategory.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfCategory.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })
        binding.etDirection.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tfDirection.error = null
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // Nothing use
            }
            override fun afterTextChanged(p0: Editable?) {
                // Nothing use
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) { onBackPressed() }
        return super.onOptionsItemSelected(item)
    }
}