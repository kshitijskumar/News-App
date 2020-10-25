package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.newsapp.models.Articles
import kotlinx.android.synthetic.main.activity_full_article.*

class FullArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_article)

        val currentArticle= intent.getParcelableExtra<Articles>("CurrentArticle")
        tvFullTitle.text= currentArticle?.title

        if(currentArticle?.imageUrl!="" || currentArticle.imageUrl== null){
            Glide.with(this).load(currentArticle?.imageUrl).into(ivFullImage)
        }else{
            ivFullImage.setImageResource(R.drawable.ic_news_image)
        }

        tvFullAuthor.text= currentArticle?.author
        tvFullPublishedAt.text= currentArticle?.publishedAt
        tvFullDescription.text= currentArticle?.description
        tvFullArticleLink.append(currentArticle?.url)

    }

    override fun onBackPressed() {
        finish()
    }
}