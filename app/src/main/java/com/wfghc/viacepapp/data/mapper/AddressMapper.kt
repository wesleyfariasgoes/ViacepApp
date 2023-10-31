package com.wfghc.viacepapp.data.mapper

import com.wfghc.viacepapp.data.local.entity.AddressEntity
import com.wfghc.viacepapp.data.model.AddressResponse
import com.wfghc.viacepapp.domain.model.Address

fun AddressResponse.toDomain(): Address {
    return Address(
         cep = cep,
        localidade = logradouro,
        complemento = complemento,
        bairro = bairro,
        logradouro = logradouro,
        uf = uf,
        ddd = ddd
    )
}

fun Address.toEntity(): AddressEntity {
    return AddressEntity(
        id = id,
        cep = cep,
        localidade = logradouro,
        bairro = bairro,
        logradouro = logradouro,
        uf = uf
    )
}

fun AddressEntity.toDomain(): Address {
    return Address(
        id = id,
        cep = cep,
        logradouro  = logradouro,
        bairro = bairro,
        localidade = localidade,
        uf = uf,
        ddd = null,
        complemento = null
    )
}