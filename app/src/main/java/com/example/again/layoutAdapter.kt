package com.example.again

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class layoutAdapter(val articles: List<Article> , val context: Context) : RecyclerView.Adapter<layoutAdapter.ViewHolder>() {
    class ViewHolder (var ItemView: View) : RecyclerView.ViewHolder(ItemView){


        val pics : ImageView = itemView.findViewById(R.id.pic)

    //    val title :  TextView = itemView.findViewById(R.id.title)

        val b : TextView = itemView.findViewById(R.id.textid)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_resouce,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val curr = articles[position]


        holder.b.text = curr.title
        //holder.title.text = curr.author



        if(curr.urlToImage!=null){

            Glide.with(context).load(curr.urlToImage).into(holder.pics)

        }

        else{

            Glide.with(context).load(R.drawable.no).into(holder.pics)
        }




        holder.itemView.setOnClickListener {

        //    Toast.makeText(context,curr.description,Toast.LENGTH_SHORT).show()

            val builder = CustomTabsIntent.Builder()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(context, Uri.parse(curr.url))







//            val intent = Intent(context,detail_activity::class.java)
//
//            intent.putExtra("URL" , curr.url)
//
//            context.startActivity(intent)


        }


    }

    override fun getItemCount(): Int {

        return  articles.size

    }
}