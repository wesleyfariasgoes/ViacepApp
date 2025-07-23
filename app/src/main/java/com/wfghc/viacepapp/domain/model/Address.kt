package com.wfghc.viacepapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val id: Long = 0,
    val cep: String?,
    val logradouro: String?,
    val complemento: String?,
    val bairro: String?,
    val localidade: String?,
    val uf: String?,
    val ddd: String?,
): Parcelable {

    fun getFullAddress(): String {
        return buildString {
            append("$logradouro - $bairro")
            appendLine()
            append("$localidade/$uf - $cep")
            if (!complemento.isNullOrBlank()) { // Verifica se o complemento não é nulo nem está em branco
                appendLine()
                append(complemento)
            } else {
                appendLine()
                append("Complemento não informado")
            }
        }
    }
}

