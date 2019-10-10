package ie.jim.hillfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ie.jim.hillfort.R
import ie.jim.hillfort.models.HillfortModel
import kotlinx.android.synthetic.main.activity_hillfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class HillfortActivity : AppCompatActivity(), AnkoLogger {

    // creating a hillfort as a class member:
    var hillfort = HillfortModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort)
        info("Hillfort Activity initialized")


        btnAdd.setOnClickListener() {
            val hillfortName = hillfortName.text.toString()
            if (hillfortName.isNotEmpty()) {
                info("add Button Pressed: $hillfortName")
            }
            else {
                toast ("You must name it.")
            }
        }


    }
}
