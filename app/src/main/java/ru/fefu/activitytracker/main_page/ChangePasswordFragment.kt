package ru.fefu.activitytracker.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.fefu.activitytracker.R
import ru.fefu.activitytracker.databinding.ActivityChangePasswordFragmentBinding

class ChangePasswordFragment :
    BaseFragment<ActivityChangePasswordFragmentBinding>(R.layout.activity_change_password_fragment) {
    private var _binding: ActivityChangePasswordFragmentBinding? = null
    override val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityChangePasswordFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar2.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }
}