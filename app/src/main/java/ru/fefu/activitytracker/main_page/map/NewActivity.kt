package ru.fefu.activitytracker.main_page.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarNewActivity.setNavigationOnClickListener {
            onBackPressed()
        }

        supportFragmentManager.beginTransaction().apply {
            add(
                R.id.fragment_container_map,
                StartTrackingFragment.newInstance(),
                "start_tracking"
            )
            commit()
        }
    }
}