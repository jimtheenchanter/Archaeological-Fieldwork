package ie.jim.hillfort.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import ie.jim.hillfort.R
import ie.jim.hillfort.helpers.readImage
import ie.jim.hillfort.helpers.readImageFromPath
import ie.jim.hillfort.helpers.showImagePicker
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
     // generate id for the image request function so activity can confirm when complete to avoid confusion
     val IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hillfort)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        app = application as MainApp // initialize the app
        info("Hillfort Activity initialized")

        var edit = false
        //read back the placemark, and place its field into the view controls.
        if (intent.hasExtra("hillfort_edit")) {
            edit = true
            hillfort = intent.extras?.getParcelable<HillfortModel>("hillfort_edit")!!

            hillfortName.setText(hillfort.title)
            description.setText(hillfort.description)
            hillfortImage.setImageBitmap(readImageFromPath(this, hillfort.image)) //image to appear in edit mode
           // if (hillfort.image != null) {
                chooseImage.setText(R.string.change_image)
            //}

            btnAdd.setText(R.string.save_hillfort)  // change button text if editing an existing hillfort
//            chooseImage.setText(R.string.change_image) // change button text if editing an existing hillfort

        }

        btnAdd.setOnClickListener() {
            hillfort.title = hillfortName.text.toString()
            hillfort.description = description.text.toString()
            if (hillfort.title.isEmpty()) { //checks that somethings has been entered for hillfortName
                toast(R.string.hint_hillfortName)
            } else {
                if(edit) {
                    app.hillforts.update(hillfort.copy()) //makes a copy of the hillfort
                } else {
                    app.hillforts.create(hillfort.copy())
                }
               }
                info("add Button Pressed: $hillfortName")
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            chooseImage.setOnClickListener {
                showImagePicker(this, IMAGE_REQUEST)
                info("Select image")
            }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hillfort, menu)
        return super.onCreateOptionsMenu(menu)
    }


    // activity that checks that a button is pressed and reports back boolean
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            // recover the name only when IMAGE_REQUEST is seen
            IMAGE_REQUEST -> {
                if (data != null) {
                    hillfort.image = data.getData().toString()
                    hillfortImage.setImageBitmap(readImage(this, resultCode, data))
                    chooseImage.setText(R.string.change_image)
                }
            }
        }
    }
}

