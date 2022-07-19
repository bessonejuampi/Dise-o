package com.utn.pobreTITO

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.utn.pobreTITO.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : Bundle? = intent.extras
        val db = FirebaseFirestore.getInstance()
        db.collection("user").document(bundle?.getString("email").toString()).get()
            .addOnSuccessListener {
                binding.tvName.text = "Nombre: ${it.get("name") as String?}"
                binding.tvDni.text = "Dni: ${it.get("dni") as String?}"
                binding.tvSurname.text = "Apellido: ${it.get("surname") as String?}"
                binding.tvEmail.text = "Email: ${bundle?.getString("email")}"
            }
    }
}