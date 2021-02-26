package com.example.mvvmrecyclerviewtutorial.DB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber) : Long

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber) : Long

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscriber() : LiveData<List<Subscriber>>
}