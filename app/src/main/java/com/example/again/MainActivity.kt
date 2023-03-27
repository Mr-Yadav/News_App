package com.example.again

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.again.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var sport: Button
    lateinit var technology: Button

    lateinit var adapter: layoutAdapter
    lateinit var binding: ActivityMainBinding

    var pageNum = 1
    var totalResult  = -1
    var country = "in"
    var category = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.rec)
//        sport = findViewById(R.id.sports)
//        technology = findViewById(R.id.Technology)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


        getnew()

//        binding.Science.setOnClickListener {
//            category = "science"
//
//            Toast.makeText(this@MainActivity, "Showing News on science", Toast.LENGTH_SHORT).show()
//            getnew()
//
//        }
//
//
//
//       binding.Entertainment.setOnClickListener {
//           category = "entertainment"
//
//           Toast.makeText(this@MainActivity, "Showing News on entertainment", Toast.LENGTH_SHORT).show()
//           getnew()
//
//       }
//
//
//        binding.business.setOnClickListener {
//
//            category = "business"
//
//            Toast.makeText(this@MainActivity, "Showing News on business", Toast.LENGTH_SHORT).show()
//            getnew()
//        }

//       binding.sports.setOnClickListener {
//
//            category = "sports"
//
//            Toast.makeText(this@MainActivity, "Showing News on Sports", Toast.LENGTH_SHORT).show()
//          getnew()
//
//        }

//        binding.Technology.setOnClickListener {
//
//            category = "technology"
//            Toast.makeText(this@MainActivity, "Showing News on Technology", Toast.LENGTH_SHORT).show()
//
//            getnew()
//        }

        binding.home.setOnClickListener {

            val intent = Intent(this,homee::class.java)
//
//            intent.putExtra("URL" , curr.url)
//
            this.startActivity(intent)

        }


        binding.user.setOnClickListener {

            val intent = Intent(this,homee::class.java)
//
//            intent.putExtra("URL" , curr.url)
//
            this.startActivity(intent)

        }


    }






    private fun getnew() {

        val retrofit = NewsService.newsInstance.getHeadline(country ,category, pageNum)

        retrofit.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {

                val news = response.body()
                totalResult = news!!.totalResults

                if (news!=null) {

                    adapter = layoutAdapter(news.articles,this@MainActivity)


                }

                recyclerView.adapter = adapter

                adapter.notifyDataSetChanged()



            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("vikash" , "Eroor In fETCHING news"+t.localizedMessage)

                Toast.makeText(this@MainActivity, "Error bc", Toast.LENGTH_SHORT).show()
                
            }

        })



    }
}