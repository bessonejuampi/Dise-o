package com.utn.pobreTITO.viewmodels

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utn.pobreTITO.R
import com.utn.pobreTITO.databinding.CradMyClaimsBinding
import com.utn.pobreTITO.models.Claim

class MyClaimsAdapter(
    private val listClaims:List<Claim>
) : RecyclerView.Adapter<MyClaimsAdapter.MyClaimsViewHolder>() {

    override fun getItemCount(): Int = listClaims.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClaimsViewHolder {
        val binding =
            CradMyClaimsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyClaimsViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: MyClaimsViewHolder, position: Int) {
        holder.bind(listClaims[position])
    }

    inner class MyClaimsViewHolder(
        private val itemView: CradMyClaimsBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(itemView.root) {

        fun bind(claim: Claim) {
            itemView.findViewById<LinearLayout>(R.id.llTitle).apply {
                this.findViewById<TextView>(R.id.tvCardTitle).text = claim.title
            }

            itemView.findViewById<LinearLayout>(R.id.llCardMyClaims).apply {
                this.findViewById<TextView>(R.id.tvCategory).text = claim.category
                this.findViewById<TextView>(R.id.tvDescription).text = claim.description
                this.findViewById<TextView>(R.id.tvDirection).text = claim.direction
                this.findViewById<TextView>(R.id.tvCondition).text = claim.condition
            }

            val llViewMore = itemView.findViewById<LinearLayout>(R.id.llViewMore)
            val llHide = itemView.findViewById<LinearLayout>(R.id.llHide)
            val llCardClaim = itemView.findViewById<LinearLayout>(R.id.llCardMyClaims)

            llViewMore.setOnClickListener {
                llHide.visibility = View.VISIBLE
                llViewMore.visibility = View.GONE
                llCardClaim.visibility = View.VISIBLE
            }

            llHide.setOnClickListener {
                llViewMore.visibility = View.VISIBLE
                llHide.visibility = View.GONE
                llCardClaim.visibility = View.GONE
            }
        }
    }
}