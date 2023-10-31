package com.wfghc.viacepapp.domain.api.repository

import com.wfghc.viacepapp.data.model.AddressResponse

interface AddressRepository {
    suspend fun getAddress(cep: String) :AddressResponse
}