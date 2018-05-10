package com.crickbit.fragments

import android.os.Bundle
import android.view.View

class FriendsFragment : BaseFragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.setOnClickListener {
            mFragmentNavigation.pushFragment(FriendsFragment.newInstance(mInt + 1))
        }
        btn.text = javaClass.simpleName + " " + mInt
    }

    companion object {

        fun newInstance(instance: Int): FriendsFragment {
            val args = Bundle()
            args.putInt(BaseFragment.ARGS_INSTANCE, instance)
            val fragment = FriendsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
