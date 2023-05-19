package com.example.again

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class layoutAdapter(val articles: List<Article> , val context: Context) : RecyclerView.Adapter<layoutAdapter.ViewHolder>() {
    class ViewHolder (var ItemView: View) : RecyclerView.ViewHolder(ItemView){


        val pics : ImageView = itemView.findViewById(R.id.pic)

        val shaare : ImageView = itemView.findViewById(R.id.share)
        val likee : ImageView = itemView.findViewById(R.id.like)
        val reaad : ImageView = itemView.findViewById(R.id.addlist)


        //    val title :  TextView = itemView.findViewById(R.id.title)

        val bik : TextView = itemView.findViewById(R.id.textid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.bkc,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val curr = articles[position]


        holder.bik.text = curr.title

        //holder.title.text = curr.author


        if(curr.urlToImage!=null){

            Glide.with(context).load(curr.urlToImage).into(holder.pics)

        }

        else{

            Glide.with(context).load(R.drawable.no).into(holder.pics)
        }



        holder.pics.setOnClickListener {
            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(curr.url))
        }

        holder.likee.setOnClickListener {

            holder.likee.setImageResource(R.drawable.heart_24)

        }

        holder.shaare.setOnClickListener{


            shareText(curr.url,context)

        }

        holder.reaad.setOnClickListener{

            Toast.makeText(context, "Added To Reading Later", Toast.LENGTH_SHORT).show()


        }




    }

    private fun shareText(text: String, context: Context) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        context.startActivity(Intent.createChooser(intent, "Share via"))
    }

    override fun getItemCount(): Int {

        return  articles.size

    }
}