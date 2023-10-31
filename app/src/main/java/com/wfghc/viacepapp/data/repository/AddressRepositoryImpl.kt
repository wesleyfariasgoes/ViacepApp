package com.wfghc.viacepapp.data.repository

import com.wfghc.viacepapp.data.api.CepApi
import com.wfghc.viacepapp.data.model.AddressResponse
import com.wfghc.viacepapp.domain.repository.AddressRepository
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    private val cepApi: CepApi
): AddressRepository {
    override suspend fun getAddress(cep: String): AddressResponse {
        return cepApi.getAddress(cep = cep)
    }
}