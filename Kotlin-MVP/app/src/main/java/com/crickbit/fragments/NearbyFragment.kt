package com.crickbit.fragments

import android.os.Bundle
import android.view.View

class NearbyFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(NearbyFragment.newInstance(mInt + 1))
        }
        btn.text = javaClass.simpleName + " " + mInt
    }

    companion object {

        fun newInstance(instance: Int): NearbyFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = NearbyFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
