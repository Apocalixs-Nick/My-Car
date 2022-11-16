package com.example.mycar.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mycar.data.MyCarDao
import com.example.mycar.model.MyCar

class CarViewModel(private val myCarDao: MyCarDao) : ViewModel() {

    val allCar: LiveData<List<MyCar>> = myCarDao.getCars().asLiveData()
}