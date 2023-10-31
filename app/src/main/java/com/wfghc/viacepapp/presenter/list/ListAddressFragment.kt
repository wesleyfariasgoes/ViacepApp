package com.wfghc.viacepapp.presenter.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.viacep.util.Constants.ADDRESS_BUNDLE_KEY
import com.example.viacep.util.Constants.REQUEST_KEY
import com.example.viacep.util.getParcelableCompat
import com.wfghc.viacepapp.R
import com.wfghc.viacepapp.databinding.FragmentListAddressBinding
import com.wfghc.viacepapp.domain.model.Address
import com.wfghc.viacepapp.presenter.list.adapter.AddressAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAddressFragment : Fragment() {
    private val viewModel: ListViewModel by viewModels()

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

        parentFragmentManager.setFragmentResultListener(
            REQUEST_KEY,
            this
        ){ _,bundle ->
            val address = bundle.getParcelableCompat(ADDRESS_BUNDLE_KEY, Address::class.java)
            if (address != null) {
                viewModel.insertAddress(address)
            }
        }
    }

    private fun initObservers() {
        viewModel.currentAddressList.observe(viewLifecycleOwner) { address ->
            addressAdapter.submitList(address)
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