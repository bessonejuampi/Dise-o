package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.utn.pobreTITO.database.AppDatabase
import com.utn.pobreTITO.databinding.ActivityProfileBinding
import com.utn.pobreTITO.models.User

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle? = intent.extras
        val database = AppDatabase.getInstance(this)
        val user : User = database?.userDAO()?.getUser(bundle?.getString("email").toString())!!

        binding.tvName.text = "Nombre: ${user.name}"
        binding.tvEmail.text = "Email: ${user.email}"
        binding.tvSurname.text = "Apellido: ${user.surname}"
        binding.tvDni.text = "DNI: ${user.dni}"
    }
}