package com.example.lrapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lrapp.models.User
import com.example.lrapp.models.UserX

class UserAdapter(private val user:List<UserX>): RecyclerView.Adapter<UserViewHolder>() {
    var users = mutableListOf<UserX>()
    fun setUserList(user: List<UserX>){
        this.users=users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return UserViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user =user[position]
        holder.username.text=user.username
        holder.email.text=user.email

    }

    override fun getItemCount(): Int {

        return user.size
    }

}
class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var username = itemView.findViewById<TextView>(R.id.username_tv)
    var email = itemView.findViewById<TextView>(R.id.email_tv)
}