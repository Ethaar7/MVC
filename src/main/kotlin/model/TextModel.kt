package model

class TextModel {
    private var text: String = ""
    private val observers = mutableListOf<TextObserver>()

    fun setText(text: String) {
        this.text = text
        notifyObservers()
    }


    fun addObserver(observer: TextObserver) {
        observers.add(observer)
    }


    private fun notifyObservers() {
        for (observer in observers) {
            observer.onUpdate(text)
        }
    }
}
