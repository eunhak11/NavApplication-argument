package com.example.mynavapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.mynavapplication.databinding.FragmentExaminBinding


class ExaminFragment : Fragment() {

    var binding: FragmentExaminBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExaminBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    fun examinMBTI(): String {
        binding?.let {
            val ieStr = if(it.chkE.isChecked) "E" else "I"
            val snStr = if(it.chkN.isChecked) "N" else "S"
            val tfStr = if(it.chkF.isChecked) "F" else "T"
            val jpStr = if(it.chkJ.isChecked) "J" else "P"

            return ieStr + snStr + tfStr + jpStr
        }

        return ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnResult?.setOnClickListener{
            val result = examinMBTI()
            val bundle = bundleOf("MBTI" to result)
            findNavController().navigate(R.id.action_examinFragment_to_resultFragment, bundle)
        }
    }
}