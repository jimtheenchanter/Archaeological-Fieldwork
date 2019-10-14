package ie.jim.hillfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        app = application as MainApp // initialize the app
        info("Hillfort Activity initialized")

        var edit = false

        if (intent.hasExtra("hillfort_edit")) {
            hillfort = intent.extras?.getParcelable<HillfortModel>("hillfort_edit")!!
            edit = true
            hillfortName.setText(hillfort.title)
            description.setText(hillfort.description)
            btnAdd.setText(R.string.save_hillfort)
        }

        btnAdd.setOnClickListener() {
            hillfort.title = hillfortName.text.toString()
            hillfort.description = description.text.toString()
            if (hillfort.title.isEmpty()) { //checks that somethings has been entered for hillfortName
                toast(R.string.hint_hillfortName)
            } else {
                if(edit) {
                    app.hillforts.update(hillfort.copy())
                } else {
                    app.hillforts.create(hillfort.copy())
                }
                }
                info("add Button Pressed: $hillfortName")
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            chooseImage.setOnClickListener {
                info("Select image")
            }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hillfort, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

