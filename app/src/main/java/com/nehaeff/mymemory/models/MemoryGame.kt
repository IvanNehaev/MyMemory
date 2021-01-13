package com.nehaeff.mymemory.models

import com.nehaeff.mymemory.utils.DEFAULT_ICONS

class MemoryGame (private val boardSize: BoardSize) {

    val cards: List<MemoryCard>
    val numPairsFound = 0

    init {
        val chosenImages : List<Int> = DEFAULT_ICONS.shuffled().take(boardSize.getPairs())
        val randomizedImages : List<Int> = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it) }
    }
}