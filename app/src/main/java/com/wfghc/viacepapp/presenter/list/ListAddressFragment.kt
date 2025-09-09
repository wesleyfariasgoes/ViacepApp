package com.wfghc.viacepapp.presenter.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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

        addressAdapter.addressSelected = { address ->

            showBottomSheet(
                titleDialog = R.string.text_title_dialog_delete_address,
                message = getString(R.string.text_message_dialog_delete_address),
                titleButton = R.string.text_button_dialog_confirm_delete_address,
                onClick = {
                    viewModel.deleteAddress(address)
                    Toast.makeText(
                        requireContext(),
                        R.string.text_message_dialog_success_delete_address,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
        }
    }

    private fun showBottomSheet(
        titleDialog: Int? = null,
        titleButton: Int? = null,
        message: String,
        onClick: () -> Unit = {}
    ) {
        val dialog = android.app.AlertDialog.Builder(requireContext())
        dialog.setTitle(titleDialog ?: R.string.text_title_dialog)
        dialog.setMessage(message)
        dialog.setPositiveButton(
            titleButton ?: R.string.text_button_dialog
        ) { dialog, _ -> onClick(); dialog.dismiss() }
        dialog.show()
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