package com.crickbit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crickbit.R

class HomeFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)?.apply {
            btn = findViewById(R.id.button)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(HomeFragment.newInstance(mInt + 1))
        }
        btn.text = javaClass.simpleName + " " + mInt
    }

    companion object {

        fun newInstance(instance: Int): HomeFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
