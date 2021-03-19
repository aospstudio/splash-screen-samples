package com.aospstudio.sample.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val context: Context = this
    private var active: Boolean = true
    private var splashTime: Int = 500

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashTread: Thread = object : Thread() {
            override fun run() = try {
                var waited = 0
                while (active && (waited < splashTime)) {
                    sleep(500)
                    if (active) {
                        waited += 500
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(context, MainActivity::class.java))
                finish()
            }
        }
        splashTread.start()
    }
}
