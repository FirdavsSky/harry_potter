package com.example.harry_potter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.harry_potter.R
import com.example.harry_potter.databinding.FragmentMainBinding
import kotlinx.coroutines.launch


private const val TAG = "MainFragment"

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {

        MainViewModelFactory()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.character.collect { character ->

                binding.tvName.text = character.name
                binding.tvHouse.text = character.hogwartsHouse
                binding.imageCharacter.load(character.imageUrl)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.state.collect { progressState ->

                if (progressState is ProgressState.Success) {

                    binding.progressBar.isVisible = false
                } else {

                    binding.progressBar.isVisible = true
                }
            }
        }

        binding.btnRandomCharacter.setOnClickListener {

            viewModel.randomCharacter()
//            parentFragmentManager.commit {
//                replace(R.id.container, DbFragment())
//                addToBackStack(MainFragment::class.java.simpleName)
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}