package com.becomedev.retrifit2_rxjava.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.becomedev.retrifit2_rxjava.R
import com.becomedev.retrifit2_rxjava.models.User
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*
import org.w3c.dom.Text

class UsersAdapter(private val context:Context,private val users:List<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtId : TextView = itemView.txt_id
        val txtUsername : TextView = itemView.txt_username
        val avatar : ImageView = itemView.img_view
        val btnViewProfile : Button = itemView.btn_view_profile
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtId.text = users[position].id.toString()
        holder.txtUsername.text = users[position].login
        holder.btnViewProfile.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW,Uri.parse(users[position].url))
            context.startActivity(browserIntent)
        }
        Glide.with(context).load(users[position].avatar_url).into(holder.avatar)
    }
}