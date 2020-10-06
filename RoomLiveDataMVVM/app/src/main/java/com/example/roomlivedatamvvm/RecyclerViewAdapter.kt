package com.example.roomlivedatamvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomlivedatamvvm.db.UserEntity
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class RecyclerViewAdapter(val listener: RowClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var items = ArrayList<UserEntity>()

    fun setListData(data: ArrayList<UserEntity>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return  MyViewHolder(inflater, listener)
    }

    override fun getItemCount(): Int {
        return  items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            listener.onItemClickListener(items[position])
        }
        holder.bing(items[position])
    }

    class MyViewHolder(view: View, val listener: RowClickListener):RecyclerView.ViewHolder(view){

        val tvName = view.tvName
        val tvEmail = view.tvEmail
        val deleteUserId = view.deleteUserID

        fun bing(data: UserEntity){
            tvName.text = data.name
            tvEmail.text = data.email

            deleteUserId.setOnClickListener {
                listener.onDeleteClickListener(data)
            }
        }
    }

    interface RowClickListener {
        fun onDeleteClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)
    }

}