package com.example.expandablecardview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    lateinit var constraintViewMoreInfo: ConstraintLayout
    lateinit var constraintViewCard: ConstraintLayout
    lateinit var buttonExpandView: ImageButton
    var viewVisible: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewFragment = inflater.inflate(R.layout.fragment_home, container, false)

        initFields(viewFragment)

        constraintViewCard.setOnClickListener {
            when (viewVisible) {
                false -> expandCardview()
                true -> retractCardview()
            }
        }

        return viewFragment
    }

    private fun initFields(viewFragment: View) {
        constraintViewMoreInfo = viewFragment.findViewById(R.id.constraintViewMoreInfo)
        constraintViewCard = viewFragment.findViewById(R.id.constraintViewCard)
        buttonExpandView = viewFragment.findViewById(R.id.buttonExpand)
    }

    private fun retractCardview() {
        viewVisible = false
        constraintViewMoreInfo.visibility = View.GONE
        buttonExpandView.setBackgroundResource(R.drawable.ic_baseline_expand_more_24)

    }

    private fun expandCardview() {
        viewVisible = true
        constraintViewMoreInfo.visibility = View.VISIBLE
        buttonExpandView.setBackgroundResource(R.drawable.ic_baseline_expand_less_24)
    }
}