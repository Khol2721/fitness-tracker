package ru.fefu.activitytracker.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.main_page.App
import ru.fefu.activitytracker.main_page.BaseFragment
import ru.fefu.activitytracker.main_page.lists.ListItem
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityMyDetailsFragmentBinding
import ru.fefu.activitytracker.main_page.room.ActivityRoom
import java.time.*

class MyActivityDetailsFragment(id: Int) :
    BaseFragment<ActivityMyDetailsFragmentBinding>(R.layout.activity_my_details_fragment) {
    private var _binding: ActivityMyDetailsFragmentBinding? = null
    override val binding get() = _binding!!
    private val details = App.INSTANCE.db.activityDao().getById(id)

    private fun getDetails(value: ActivityRoom): ListItem.Item {
        val id = value.id
        val type = MyActivityFragment.getActivityType(value.type)
        val startDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(value.startTime), ZoneId.systemDefault())
        val endDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(value.endTime), ZoneId.systemDefault())

        val duration = Duration.between(startDate, endDate)
        var seconds: Long = Math.abs(duration.getSeconds())
        val hours = seconds / 3600
        seconds -= hours * 3600
        val minutes = seconds / 60
        val hours_ = MyActivityFragment.getNoun(hours, "час", "часа", "часов")
        val minutes_ = MyActivityFragment.getNoun(minutes, "минута", "минуты", "минут")
        var time = ""
        if (hours > 0) {
            time = "%d %s %d %s".format(hours, hours_, minutes, minutes_)
        } else {
            time = "%d %s".format(minutes, minutes_)
        }

        var date = ""
        if (LocalDate.now().isEqual(endDate.toLocalDate())) {
            date = Duration.between(endDate, LocalDateTime.now()).toHours().toString() +
                    MyActivityFragment.getNoun(Duration.between(endDate, LocalDateTime.now())
                        .toHours(), " час", " часа", " часов") +
                    " назад"
        }
        else {
            date = "%d.%d.%d".format(endDate.dayOfMonth, endDate.monthValue, endDate.year)
        }

        val distance = "256 м"
        return ListItem.Item(id, distance, time, date, type, startDate, endDate)
    }

    companion object {
        fun newInstance(id: Int): MyActivityDetailsFragment {
            return MyActivityDetailsFragment(id)
        }
    }

    private val detail = getDetails(details)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textMyDistance.text = detail.distance
        val startTime = "%02d".format(detail.startTime.hour) + ":" + "%02d".format(detail.startTime.minute)
        val endTime = "%02d".format(detail.endTime.hour) + ":" + "%02d".format(detail.endTime.minute)
        binding.textMyStartTime.text = startTime
        binding.textMyFinishTime.text = endTime

        binding.textMyDate.text = detail.date

        binding.toolbarMy.title = detail.activity
        binding.toolbarMy.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        binding.toolbarMy.setOnMenuItemClickListener {
            true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityMyDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}