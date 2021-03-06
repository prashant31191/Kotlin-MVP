package com.crickbit.fragments

import android.os.Bundle
import android.view.View

class FoodFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(FoodFragment.newInstance(mInt + 1))
        }
        btn.text = javaClass.simpleName + " " + mInt
    }

    companion object {

        fun newInstance(instance: Int): FoodFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = FoodFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
