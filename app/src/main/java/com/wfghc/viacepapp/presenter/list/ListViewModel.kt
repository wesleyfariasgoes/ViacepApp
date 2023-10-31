package com.wfghc.viacepapp.presenter.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wfghc.viacepapp.data.mapper.toDomain
import com.wfghc.viacepapp.domain.local.usecase.GetAllAddressUseCase
import com.wfghc.viacepapp.domain.model.Address
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getAllAddressUseCase: GetAllAddressUseCase
) : ViewModel() {

    private val _addressList = MutableLiveData(mutableListOf<Address>())
    val addressList: LiveData<MutableList<Address>> = _addressList

    private val _addressChanged = MutableLiveData(Unit)
    val addressChanged: LiveData<Unit> = _addressChanged

        init {
        getAllAddress()
    }
    fun getAllAddress() = viewModelScope.launch {
        getAllAddressUseCase.invoke().collect { address ->
            _addressList.value = address.map { it.toDomain() }.toMutableList()
        }
    }

    fun addressChanged() {
        _addressChanged.value = Unit
    }
}