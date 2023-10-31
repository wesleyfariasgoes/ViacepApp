package com.wfghc.viacepapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wfghc.viacepapp.data.local.dao.AddressDao
import com.wfghc.viacepapp.data.local.entity.AddressEntity

@Database(entities = [AddressEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun addressDao(): AddressDao
}