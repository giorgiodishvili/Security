package com.android.quizapp.ui.passwordsecurity

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.GridLayoutManager
import com.android.football.base.BaseFragment
import com.android.quizapp.R
import com.android.quizapp.adapter.SecurityAdapter
import com.android.quizapp.callback.SecurityItemCallback
import com.android.quizapp.databinding.PasswordSecurityFragmentBinding


class PasswordSecurityFragment : BaseFragment<PasswordSecurityFragmentBinding>(PasswordSecurityFragmentBinding::inflate) {
    private var rememberInput: String = ""
    private var inputPass: String = ""

    override fun start(inflater: LayoutInflater, container: ViewGroup?) {
        binding.recyclerView.adapter = SecurityAdapter(object : SecurityItemCallback{
            override fun onClickItem(absoluteAdapterPosition: Int) {
                inputPass += absoluteAdapterPosition.toString()
                when(inputPass.length){
                    1 -> binding.dot1.background = (R.drawable.roundall_green.toDrawable())
                    2 -> binding.dot2.background = (R.drawable.roundall_green.toDrawable())
                    3 -> binding.dot3.background = (R.drawable.roundall_green.toDrawable())
                    4 -> {
                        binding.dot4.background = (R.drawable.roundall_green.toDrawable())
                        when {
                            rememberInput.isEmpty() -> {
                                binding.enterPassTv.text = "Repeat Passcode"
                                rememberInput = inputPass
                            }
                            rememberInput == inputPass -> {
                                binding.enterPassTv.text = "Enter your passcode"
                                Toast.makeText(requireContext(),"ACCEPTED",Toast.LENGTH_SHORT).show()
                            }
                            else -> {
                                binding.enterPassTv.text = "Enter your passcode"
                                Toast.makeText(requireContext(),"WRONG",Toast.LENGTH_SHORT).show()
                            }
                        }
                        inputPass=""
                        binding.dot1.background = (R.drawable.roundall.toDrawable())
                        binding.dot2.background = (R.drawable.roundall.toDrawable())
                        binding.dot3.background = (R.drawable.roundall.toDrawable())
                        binding.dot4.background = (R.drawable.roundall.toDrawable())
                    }
                }
            }
        })
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
    }

}