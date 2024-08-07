package ru.fefu.activitytracker.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.fefu.activitytracker.main_page.App
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.main_page.MainActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (App.INSTANCE.sharedPrefs.getString("token", null) !== null) {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val btnRegistration = findViewById<Button>(R.id.registrationButton)
        btnRegistration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        val clickText = findViewById<TextView>(R.id.loginButton)
        clickText.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
