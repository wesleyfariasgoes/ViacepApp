package com.wfghc.viacepapp.presenter.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wfghc.viacepapp.R
import com.wfghc.viacepapp.databinding.FragmentListAddressBinding
import com.wfghc.viacepapp.presenter.list.adapter.AddressAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAddressFragment : Fragment() {
    private val viewModel: ListViewModel by activityViewModels()

    private var _binding: FragmentListAddressBinding? = null
    private val binding get() = _binding!!
    private lateinit var addressAdapter: AddressAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObservers()
        initListners()
    }

    private fun initListners() {
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listAddressFragment_to_searchAddressFragment)
        }
    }

    private fun initObservers() {
        viewModel.addressList.observe(viewLifecycleOwner) { address ->
            addressAdapter.submitList(address)
        }

        viewModel.addressChanged.observe(viewLifecycleOwner) {
            viewModel.getAllAddress()
        }
    }

    private fun initRecycler() {
        addressAdapter = AddressAdapter()
        with(binding.recyclerAdrress) {
            adapter = addressAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}