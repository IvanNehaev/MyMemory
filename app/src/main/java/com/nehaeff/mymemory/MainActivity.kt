package com.nehaeff.mymemory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nehaeff.mymemory.models.BoardSize
import com.nehaeff.mymemory.models.MemoryCard
import com.nehaeff.mymemory.models.MemoryGame
import com.nehaeff.mymemory.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private var boardSize : BoardSize = BoardSize.EASY

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        val memoryGame = MemoryGame(boardSize)

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object : MemoryBoardAdapter.CardClickListner {
            override fun onCardClicked(position: Int) {
                Log.i(TAG, "card clicked $position")
            }

        })
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this, boardSize.getWidth())

    }
}