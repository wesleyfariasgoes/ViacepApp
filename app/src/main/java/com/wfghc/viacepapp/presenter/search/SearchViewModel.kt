package com.wfghc.viacepapp.presenter.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.wfghc.viacepapp.domain.local.usecase.InsertAddressUseCase
import com.wfghc.viacepapp.domain.model.Address
import com.wfghc.viacepapp.domain.usecase.GetAddressUseCase
import com.wfghc.viacepapp.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAddressUseCase: GetAddressUseCase,
    private val insertAddressUseCase: InsertAddressUseCase
) : ViewModel() {

    fun getAddress(cep: String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            val address = getAddressUseCase(cep)
            emit(StateView.Success(address))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(StateView.Error(e.message))
        }catch (e: Exception) {
            e.printStackTrace()
            emit(StateView.Error(e.message))
        }
    }

    fun insertAddress(address: Address) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            val id = insertAddressUseCase(address)
            emit(StateView.Success(id))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(StateView.Error(e.message))
        }
    }

}