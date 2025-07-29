package com.example.icon

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gamejanken.Game

class GameActivity : AppCompatActivity(){
    private lateinit var computerImgView: ImageView
    private lateinit var batuImgButton: ImageButton
    private lateinit var guntingImgButton: ImageButton
    private lateinit var kertasImageButton: ImageButton
    private lateinit var resultImgView: ImageView

    private fun initComponents(){
        computerImgView = findViewById(R.id.computerImgView)
        batuImgButton = findViewById(R.id.batuImgButt)
        guntingImgButton = findViewById(R.id.guntingImgView)
        kertasImageButton = findViewById(R.id.kertasImgView)
        resultImgView = findViewById(R.id.resultImgView)
    }

    private fun initListener(){
        batuImgButton.setOnClickListener{ startGame("ROCK")}
        guntingImgButton.setOnClickListener{ startGame("SCISSORS")}
        kertasImageButton.setOnClickListener{ startGame("PAPER")}
    }

    private fun startGame(option : String){
        val computerOption = Game.pickRandomOption()
        computerImgView.setImageResource(Game.pickDrawable(computerOption))

        when{
            Game.isDraw(option, computerOption) -> resultImgView.setImageResource(R.drawable.ulang)
            Game.isWin(option, computerOption) -> resultImgView.setImageResource(R.drawable.win)
            else -> resultImgView.setImageResource(R.drawable.lose)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.game)

        initComponents()
        initListener()
    }
}
