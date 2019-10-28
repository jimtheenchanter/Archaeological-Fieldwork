package ie.jim.hillfort.activities

//import android.content.Context
//import android.os.Bundle
//import android.os.Handler
//import android.support.v7.app.AppCompatActivity
//import androidx.appcompat.app.AppCompatActivity
//import ie.jim.hillfort.R
//
//class SplashActivity: AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)
//
//        scheduleSplashScreen()
//    }
//
//    private fun scheduleSplashScreen() {
//        val splashScreenDuration = getSplashScreenDuration()
//        Handler().postDelayed(
//            {
//                // After the splash screen duration, route to the right activities
//                val user = UserDb.getCurrentUser()
//                routeToAppropriatePage(user)
//                finish()
//            },
//            splashScreenDuration
//        )
//    }
//
//    private fun getSplashScreenDuration(): Long {
//        val sp = getPreferences(Context.MODE_PRIVATE)
//        val prefKeyFirstLaunch = "pref_first_launch"
//
//        return when(sp.getBoolean(prefKeyFirstLaunch, true)) {
//            true -> {
//                // If this is the first launch, make it slow (> 3 seconds) and set flag to false
//                sp.edit().putBoolean(prefKeyFirstLaunch, false).apply()
//                5000
//            }
//            false -> {
//                // If the user has launched the app, make the splash screen fast (<= 1 seconds)
//                1000
//            }
//        }
//    }
//
//    private fun routeToAppropriatePage(user: User) {
//        // Example routing
//        when {
//            user == null -> OnboardingActivity.start(this)
//            user.hasPhoneNumber() -> EditProfileActivity.start(this)
//            user.hasSubscriptionExpired() -> PaymentPlansActivity.start(this)
//            else -> HomeActivity.start(this)
//        }
//    }
//
//}