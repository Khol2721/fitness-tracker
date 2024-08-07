package ru.fefu.activitytracker.main_page.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import ru.fefu.activitytracker.main_page.BaseFragment
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityProcessTrackingFragmentBinding

class ProcessTrackingFragment :
BaseFragment<ActivityProcessTrackingFragmentBinding>(R.layout.activity_process_tracking_fragment) {
    private var _binding: ActivityProcessTrackingFragmentBinding? = null
    override val binding get() = _binding!!

    companion object {
        fun newInstance(): ProcessTrackingFragment {
            return ProcessTrackingFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnFinish: ImageButton = view.findViewById(R.id.button_finish)
        btnFinish.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.buttonPause.setOnClickListener {
        }

        binding.buttonFinish.setOnClickListener {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityProcessTrackingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}