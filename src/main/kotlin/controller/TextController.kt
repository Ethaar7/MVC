package controller

import model.TextModel
import model.TextObserver

class TextController(private val textModel: TextModel, private val displayStrategy: TextDisplayStrategy) :
    TextObserver {
    init {
        textModel.addObserver(this)
    }

    override fun onUpdate(text: String) {
        displayStrategy.displayText(text)
    }

    fun updateText(text: String) {
        textModel.setText(text)
    }
}


class RedTextDisplayStrategy : TextDisplayStrategy {
    override fun displayText(text: String) {
        println("\u001B[31m$text\u001B[0m")
    }
}

class BlueTextDisplayStrategy : TextDisplayStrategy {
    override fun displayText(text: String) {
        println("\u001B[34m$text\u001B[0m")
    }
}


class YellowTextDisplayStrategy : TextDisplayStrategy {
    override fun displayText(text: String) {
        println("\u001B[33m$text\u001B[0m")
    }
}