// A single instance of this class will be created when our application will be launched.
// A reference to this application can be acquired in other activities as needed.
package ie.jim.hillfort.main

import android.app.Application
import ie.jim.hillfort.HillfortStore
import ie.jim.hillfort.models.HillfortJSONStore
import ie.jim.hillfort.models.HillfortMemStore
import ie.jim.hillfort.models.HillfortModel
import ie.jim.hillfort.models.UserJSONStore
import ie.jim.hillfort.models.UserModel
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MainApp : Application(), AnkoLogger {

//    val hillforts = ArrayList<HillfortModel>()
      lateinit var hillforts : HillfortStore
    var users = ArrayList<UserModel>()

    override fun onCreate() {
        super.onCreate()
        hillforts = HillfortJSONStore(applicationContext)
//        users = UserJSONStore(applicationContext)
        info("Hillfort Here! started")
       users.add(UserModel(1, "homer@simpson.com", "secret", 1))
        users.add(UserModel(2, "homer@simpson.com", "secret", 4))
        users.add(UserModel(3, "homer@simpson.com", "secret", 5))
        hillforts.create(HillfortModel(1, "Jim's Hillfort", "Like a castle" , "", 0.0, 0.0 ))
        hillforts.create(HillfortModel(2, "Shay' Hillfort", "Like a swamp" , "", 0.0, 0.0 ))
        hillforts.create(HillfortModel(3, "Paula's Hillfort", "Like a supermarket" , "", 0.0, 0.0 ))
        hillforts.create(HillfortModel(4, "Lucy's Hillfort", "Like a dump" , "", 0.0, 0.0 ))
        hillforts.create(HillfortModel(5, "Flash's Hillfort", "Like a giant tin of ancient tuna" , "", 0.0, 0.0 ))

    }
}