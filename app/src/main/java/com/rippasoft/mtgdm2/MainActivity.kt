package com.rippasoft.mtgdm2

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private val model: MainViewModel by viewModels()
    private val gameOverColor = Color.RED

    private var scoreDefaultColor by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        scoreDefaultColor = textviewScore1.textColors.defaultColor

        updateScore1()
        updateScore2()
    }

    fun buttonPlus1(view: View) {
        model.getScores()[0] += 1
        updateScore1()
    }
    fun buttonPlus2(view: View) {
        model.getScores()[1] += 1
        updateScore2()
    }

    fun buttonMinus1(view: View) {
        model.getScores()[0] -= 1
        updateScore1()
    }
    fun buttonMinus2(view: View) {
        model.getScores()[1] -= 1
        updateScore2()
    }

    fun buttonNewGame(view: View) {
        model.newGame()
        updateScore1()
        updateScore2()
    }

    fun getScoreColor(score: Int): Int {
        if (score <= 0) {
            return gameOverColor
        } else {
            return scoreDefaultColor
        }
    }

    fun updateScore1() {
        var score = model.getScores()[0]
        var textView = findViewById<TextView>(R.id.textviewScore1)
        textView.text = score.toString()
        textView.setTextColor(getScoreColor(score))
    }
    fun updateScore2() {
        var score = model.getScores()[1]
        var textView = findViewById<TextView>(R.id.textviewScore2)
        textView.text = score.toString()
        textView.setTextColor(getScoreColor(score))
    }

}
