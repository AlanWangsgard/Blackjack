class Deck {
    var deck = ArrayList<Int>()
    var number = 1
    fun createDeck() {
        for (num in 1..52) {
            if (number == 14) {
                number = 1
            }
            deck.add(number)
            number++
        }
    }
}