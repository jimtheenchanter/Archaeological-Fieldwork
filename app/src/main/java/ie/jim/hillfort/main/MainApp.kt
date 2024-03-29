// A single instance of this class will be created when our application will be launched.
// A reference to this application can be acquired in other activities as needed.
package ie.jim.hillfort.main

import android.app.Application
import ie.jim.hillfort.HillfortStore
import ie.jim.hillfort.UserStore
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
//    var users = ArrayList<UserModel>()
      lateinit var users : UserStore

    override fun onCreate() {
        super.onCreate()
        hillforts = HillfortJSONStore(applicationContext)
        users = UserJSONStore(applicationContext)
        info("Hillfort Here! started")
        users.create(UserModel(1, "homer@simpson.com", "secret", 1))
        users.create(UserModel(2, "homer@simpson.com", "secret", 4))
        users.create(UserModel(3, "homer@simpson.com", "secret", 5))
        info("User database loaded")
        hillforts.create(HillfortModel(1, "Caherdrinny Hillfort", "Contour Fort" , "", 52.249103, -8.298497, 0f ))
        hillforts.create(HillfortModel(2, "Mooghaun Hillfort", "Pile of rocks" , "", 52.782556, -8.879239, 0f ))
        hillforts.create(HillfortModel(3, "Allihies ", "Promontory fort" , "", 51.64829, -10.05654, 0f ))
        hillforts.create(HillfortModel(4, "Ardaturrish More", "Promontory fort" , "", 51.71894, -9.4917, 0f ))
        hillforts.create(HillfortModel(5, "Ballycotten", "Contour fort" , "", 52.96108, -9.39171, 0f ))
        info("Hillfort database loaded")
    }
}