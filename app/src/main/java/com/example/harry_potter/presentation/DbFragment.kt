package com.example.harry_potter.presentation

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.harry_potter.R
import com.example.harry_potter.databinding.FragmentDbBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DbFragment : Fragment() {

    private val viewModel: DbViewModel by viewModels()

    private var _binding: FragmentDbBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDbBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {

            viewModel.onBtnAdd()
        }
        binding.btnUpdate.setOnClickListener {


        }
        binding.btnDelete.setOnClickListener {


        }

        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.allCharacters.collect{

                binding.textView2.text = it.joinToString(separator = "\r\n")
            }
        }
    }

    companion object {
        fun newInstance() = DbFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}