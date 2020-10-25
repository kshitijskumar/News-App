package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.models.Articles

class NewsAdapter(var newsList: List<Articles>, private val clickListener: ClickHandle) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val title: TextView= view.findViewById(R.id.tvArticleTitle)
        val author: TextView= view.findViewById(R.id.tvArticleAuthor)
        val publishedAt: TextView= view.findViewById(R.id.tvArticlePublishedDate)
        val description: TextView= view.findViewById(R.id.tvArticleDescription)
        val image: ImageView= view.findViewById(R.id.ivArticleImage)

        val readMore: Button= view.findViewById(R.id.btnReadMore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.news_articles,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentArticle= newsList[position]
        holder.title.text= currentArticle.title
        holder.author.text= currentArticle.author
        holder.publishedAt.text= currentArticle.publishedAt
        holder.description.text= currentArticle.description
        if(currentArticle.imageUrl!= "" || currentArticle.imageUrl== null){
            Glide.with(holder.itemView).load(currentArticle.imageUrl).into(holder.image)
        }else{
            holder.image.setImageResource(R.drawable.ic_news_image)
        }

        holder.readMore.setOnClickListener {
            clickListener.onReadMoreClick(currentArticle)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    interface ClickHandle{
        fun onReadMoreClick(currentArticle: Articles)
    }
}