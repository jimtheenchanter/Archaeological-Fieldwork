// A single instance of this class will be created when our application will be launched.
// A reference to this application can be acquired in other activities as needed.
package ie.jim.hillfort.main

import android.app.Application
import ie.jim.hillfort.models.HillfortMemStore
import ie.jim.hillfort.models.HillfortModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp : Application(), AnkoLogger {

//    val hillforts = ArrayList<HillfortModel>()
    val hillforts = HillfortMemStore()

    override fun onCreate() {
        super.onCreate()
        info("Hillfort Here! started")
//        hillforts.add(HillfortModel("One", "About one..."))
//        hillforts.add(HillfortModel("Two", "About two..."))
//        hillforts.add(HillfortModel("Three", "About three..."))
    }
}