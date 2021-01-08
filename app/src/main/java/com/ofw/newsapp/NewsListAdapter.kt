package com.ofw.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items:ArrayList<String>,private val listener:NewsItemClicked):RecyclerView.Adapter<NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.news_view,parent,false)

        return NewsViewHolder(view)

         }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val currentItem=items[position]

        holder.titleView.text=currentItem
        holder.itemView.setOnClickListener {

         listener.onItemClicked(currentItem)


        }

        }

    override fun getItemCount(): Int {
        return items.size
         }
}
class NewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

    val titleView:TextView=itemView.findViewById(R.id.title)
}

interface NewsItemClicked{
    fun onItemClicked(item:String)
}