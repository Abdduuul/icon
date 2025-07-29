package com.example.gamejanken

import com.example.icon.R
import kotlin.random.Random

object Game {

    // Aturan permainan suit Jepang (janken)
    private val rules = mapOf(
        "ROCK-SCISSORS" to true,  // Batu menang melawan gunting
        "ROCK-PAPER" to false,     // Batu kalah melawan kertas
        "SCISSORS-PAPER" to true,  // Gunting menang melawan kertas
        "SCISSORS-ROCK" to false,   // Gunting kalah melawan batu
        "PAPER-ROCK" to true,      // Kertas menang melawan batu
        "PAPER-SCISSORS" to false   // Kertas kalah melawan gunting
    )

    // Pilihan yang tersedia dalam permainan
    private val options = listOf("ROCK", "SCISSORS", "PAPER")

    // Memetakan pilihan ke sumber daya drawable (gambar) yang sesuai
    private val optionDrawable = mapOf(
        "ROCK" to R.drawable.batu,
        "SCISSORS" to R.drawable.gunting,
        "PAPER" to R.drawable.kertas
    )

    // Fungsi untuk memilih pilihan secara acak
    fun pickRandomOption(): String = options[Random.nextInt(from = 0, until = 3)]

    // Fungsi untuk mendapatkan sumber daya drawable berdasarkan pilihan
    fun pickDrawable(option: String): Int = optionDrawable[option]!!

    // Fungsi untuk memeriksa apakah hasilnya seri
    fun isDraw(from: String, to: String): Boolean = from == to

    // Fungsi untuk memeriksa apakah pemain pertama (from) menang
    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!
}