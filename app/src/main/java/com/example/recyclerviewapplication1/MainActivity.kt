package com.example.recyclerviewapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapplication1.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var homeRVAdapter : HomeRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            homeRVAdapter = HomeRecyclerViewAdapter(getData())
            homeRV.adapter = homeRVAdapter
            homeRV.layoutManager = LinearLayoutManager(this@MainActivity)

        }


    }



    private fun getData(): MutableList<Email> {
        var dataList = ArrayList<Email>()
        dataList.add(Email("author 1", "subject 1", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 2", "subject 2", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 3", "subject 3", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 4", "subject 4", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 5", "subject 5", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 6", "subject 6", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 7", "subject 7", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 8", "subject 8", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 9", "subject 9", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 10", "subject 10", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 11", "subject 11", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 12", "subject 12", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 13", "subject 13", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 14", "subject 14", "content 1 content 1 content 1 content 1 content 1"))
        dataList.add(Email("author 15", "subject 15", "content 1 content 1 content 1 content 1 content 1"))
        return dataList

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)



        FirebaseApp.initializeApp(this)




    }

    private fun fetchDataFromFirestore() {
        itemsCollection.get()
            .addOnSuccessListener { querySnapshot ->
                val items = ArrayList<Item>()
                for (documentSnapshot in querySnapshot) {
                    val item = documentSnapshot.toObject(Item::class.java)
                    items.add(item)
                }

                val adapter = YourRecyclerViewAdapter(items)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener { e ->
            }
    }


    private lateinit var db: FirebaseFirestore
    private lateinit var itemsCollection: CollectionReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.firestore
        itemsCollection = db.collection("items")
    }



}
