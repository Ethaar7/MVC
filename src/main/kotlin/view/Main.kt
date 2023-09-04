package view

import controller.BlueTextDisplayStrategy
import controller.RedTextDisplayStrategy
import controller.TextController
import controller.YellowTextDisplayStrategy
import model.TextModel
import java.util.*

fun main() {
    val textModel = TextModel()
    val scanner = Scanner(System.`in`)

    val redDisplayStrategy = RedTextDisplayStrategy()
    val blueDisplayStrategy = BlueTextDisplayStrategy()
    val yellowTextDisplayStrategy = YellowTextDisplayStrategy()

    var textController = TextController(textModel, yellowTextDisplayStrategy)

    println("Enter the text:")
    val inputText = scanner.nextLine()

    textController.updateText(inputText)

    println("Choose a text display strategy:")
    println("1-red")
    println("2-blue")

    val choice = scanner.nextInt()

    when (choice) {
        1 -> textController = TextController(textModel, redDisplayStrategy)
        2 -> textController = TextController(textModel, blueDisplayStrategy)
        else -> textController = TextController(textModel, yellowTextDisplayStrategy)
    }

    textController.updateText(inputText)
}
