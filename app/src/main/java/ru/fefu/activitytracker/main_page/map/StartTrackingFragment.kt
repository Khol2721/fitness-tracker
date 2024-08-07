package ru.fefu.activitytracker.main_page.map

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import ru.fefu.activitytracker.main_page.App
import ru.fefu.activitytracker.main_page.BaseFragment
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.main_page.adapters.NewActivityAdapter
import ru.fefu.activitytracker.databinding.ActivityStartTrakingFragmentBinding
import ru.fefu.activitytracker.main_page.lists.ListActivityTypes
import ru.fefu.activitytracker.main_page.room.ActivityRoom

class StartTrackingFragment :
        BaseFragment<ActivityStartTrakingFragmentBinding>(R.layout.activity_start_traking_fragment) {
    private val listActivityTypes = ListActivityTypes()
    private val adapterTypes = NewActivityAdapter(listActivityTypes.getItem())


    companion object {
        fun newInstance(): StartTrackingFragment {
            return StartTrackingFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.rcViewListTypes) {
            adapter = adapterTypes
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.buttonStart.setOnClickListener {
            val endTime = System.currentTimeMillis()
            val startTime = endTime - (600000..86400000).random()
            App.INSTANCE.db.activityDao().insert (
                ActivityRoom (
                    0,
                    adapterTypes.selected,
                    startTime,
                    endTime,
                    mutableListOf()
                )
            )

            parentFragmentManager.beginTransaction().apply {
                replace(
                    R.id.fragment_container_map,
                    ProcessTrackingFragment.newInstance(),
                    "process_tracking"
                )
                addToBackStack(null)
                commit()
            }
        }
    }
}