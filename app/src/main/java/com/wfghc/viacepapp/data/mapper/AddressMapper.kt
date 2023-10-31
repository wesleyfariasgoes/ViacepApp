package com.wfghc.viacepapp.data.mapper

import com.wfghc.viacepapp.data.model.AddressResponse
import com.wfghc.viacepapp.domain.model.Address

fun AddressResponse.toDomain(): Address {
    return Address(
         cep = cep,
        localidade = logradouro,
        complemento = complemento,
        bairro = bairro,
        logradouro = logradouro,
        uf = uf
    )
}