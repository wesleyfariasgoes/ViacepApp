package com.wfghc.viacepapp.data.api

import com.wfghc.viacepapp.data.model.AddressResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApi {

    @GET("{cep}/json")
    suspend fun getAddress(
        @Path("cep")cep: String
    ): AddressResponse
}