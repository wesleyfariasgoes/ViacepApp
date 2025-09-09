package com.wfghc.viacepapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.wfghc.viacepapp.data.local.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAllAddress(): Flow<List<AddressEntity>>

    @Query("SELECT * FROM address WHERE id = :id")
    suspend fun getAddressByIds(id: Long): AddressEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAddress(addressEntity: AddressEntity): Long

    @Update
    suspend fun updateAddress(addressEntity: AddressEntity)

    @Delete
    suspend fun deleteAddress(addressEntity: AddressEntity)
}