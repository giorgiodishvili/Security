package com.android.quizapp.ui.passwordsecurity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.android.football.base.BaseFragment
import com.android.quizapp.adapter.SecurityAdapter
import com.android.quizapp.callback.SecurityItemCallback
import com.android.quizapp.databinding.PasswordSecurityFragmentBinding

class PasswordSecurityFragment : BaseFragment<PasswordSecurityFragmentBinding>(PasswordSecurityFragmentBinding::inflate) {

    private var inputPass: String = ""
    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        binding.recyclerView.adapter = SecurityAdapter(object : SecurityItemCallback{
            override fun onClickItem(absoluteAdapterPosition: Int) {
                inputPass += absoluteAdapterPosition.toString()

            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
    }

}