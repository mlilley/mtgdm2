package com.rippasoft.mtgdm2

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val scores = mutableListOf(20, 20)

    override fun onCleared() {
        super.onCleared()
    }

    fun getScores(): MutableList<Int> {
        return scores
    }

    fun newGame() {
        scores[0] = 20
        scores[1] = 20
    }

}