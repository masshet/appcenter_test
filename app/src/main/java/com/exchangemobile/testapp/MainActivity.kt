package com.exchangemobile.testapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCenter.setLogLevel(Log.VERBOSE)
        AppCenter.start(
            application,
            "ddd8d772-edf2-4162-b29a-64794dea8ffa",
            Analytics::class.java,
            Crashes::class.java,
            Distribute::class.java
        )

        event.setOnClickListener {
            Analytics.trackEvent("My custom event")
        }

        crash.setOnClickListener {
            Crashes.generateTestCrash()
        }

    }

}
