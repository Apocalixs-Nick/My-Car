package com.example.mycar.data

import androidx.room.*
import com.example.mycar.model.MyCar
import kotlinx.coroutines.flow.Flow

@Dao
interface MyCarDao {
    @Query("SELECT * from my_car_database")
    fun getCars(): Flow<List<MyCar>>
    @Query("SELECT * from my_car_database WHERE id = :id")
    fun getCar(id: Long): Flow<MyCar>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myCar: MyCar)
    @Update
    suspend fun update(myCar: MyCar)
    @Delete
    suspend fun delete(myCar: MyCar)
}