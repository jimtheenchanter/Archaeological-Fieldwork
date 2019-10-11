package ie.jim.hillfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.jim.hillfort.R
import ie.jim.hillfort.main.MainApp
import ie.jim.hillfort.models.HillfortModel
import kotlinx.android.synthetic.main.activity_hillfort.*
import org.jetbrains.anko.AnkoLogger // allow console logging
import org.jetbrains.anko.info  // allow info windows
import org.jetbrains.anko.toast

class HillfortActivity : AppCompatActivity(), AnkoLogger {

    // creating a hillfort as a class member:
    var hillfort = HillfortModel()
    //reference the MainApp object.
   lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort)
        app = application as MainApp // initialize the app
        info("Hillfort Activity initialized")

        btnAdd.setOnClickListener() {
           hillfort.title = hillfortName.text.toString()
           hillfort.title = description.text.toString()
            if (hillfort.title.isNotEmpty()) { //checks that somethings has been entered for hillfortName
                app.hillforts.add(hillfort.copy())
                info("add Button Pressed: ${hillfort}")
                for (i in app.hillforts.indices) {
                    info("Hillfort[$i]:${app.hillforts[i]}")
                }
            }
            else {
                toast ("Please enter a name")
            }
        }
    }
}

