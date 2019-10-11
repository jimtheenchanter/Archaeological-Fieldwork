package ie.jim.hillfort.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ie.jim.hillfort.R
import ie.jim.hillfort.main.MainApp

class HillfortListActivity : AppCompatActivity() {

    lateinit var app: MainApp // Retrieve and store a reference to the MainApp object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort_list)
        app = application as MainApp
    }
}