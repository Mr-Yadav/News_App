package com.example.again

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.again.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var adapter: layoutAdapter
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var category = ""



        binding.idbuis.setOnClickListener {

              val intent = Intent(this,MainActivity2::class.java).putExtra("category","business")
              startActivity(intent)

            Log.d("bhang","clicked on buisness")

        }

        binding.idsports.setOnClickListener {

            val intent = Intent(this,MainActivity2::class.java).putExtra("category","sports")
            startActivity(intent)

            Log.d("bhang","clicked on buisness")

        }

        binding.identer.setOnClickListener {

            val intent = Intent(this,MainActivity2::class.java).putExtra("category","entertainment")
            startActivity(intent)

            Log.d("bhang","clicked on buisness")

        }

        binding.idtech.setOnClickListener {

            val intent = Intent(this,MainActivity2::class.java).putExtra("category","technology")
            startActivity(intent)

            Log.d("bhang","clicked on buisness")

        }


        binding.idtop.setOnClickListener {

            val intent = Intent(this,MainActivity2::class.java).putExtra("category","")
            startActivity(intent)

            Log.d("bhang","clicked on buisness")

        }



    }

}