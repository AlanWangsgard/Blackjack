import kotlin.random.Random

fun main() {

    var game = true

    println("WHat is your name?")
    var name = readln()

    println("how much money do you have?")
    var money = readln()

    var player1 = Player(name, 1, money.toInt())
    var dealer = Player("dealer", 0, 0)


    var rounds = 0
    while (game && player1.money > 0) {
        var play = true

        var cards = Deck()
        cards.createDeck()

        var cardsInDeck = 52

        var blackjack = ""

        player1.hand.clear()
        dealer.hand.clear()

        rounds++
        if (rounds > 1){
            println("Would you like to 1. Play Another round 2. Quit")
            blackjack = readln()
        }else {
            println("Would you like to 1. Play Blackjack 2. Quit")
            blackjack = readln()
        }

        if (blackjack.toInt() == 1){

            println("How much money would you like to bet on this round?")
            var bet = readln()

            while (player1.hand.sum() < 21 && play){
                cardsInDeck--
                var index = Random.nextInt(0,cardsInDeck)
                println(player1.hand.sum())
                println("another card? 1. yes 2. hold")
                var option = readln()

                if (player1.hand.sum() < 21 && option == "1") {
                    var card = cards.deck[index]

                    cards.deck.removeAt(index)
                    player1.hand.add(card)

                    var index2 = Random.nextInt(0,cardsInDeck-1)
                    var card2 = cards.deck[index]
                    cards.deck.removeAt(index2)
                    cardsInDeck--
                    dealer.hand.add(card2)

                }else{
                    play = false
                }
            }

            if ((player1.hand.sum() > dealer.hand.sum() || dealer.hand.sum() > 21) && player1.hand.sum() <= 21){
                println("You Win")
                player1.addMoney(bet.toInt()*2)
                println(player1.name + ": Money: " + player1.money + " Hand Total: " + player1.hand.sum())
                println(dealer.hand.sum())

                when (player1.hand.sum()) {
                    1 -> println("Why would you hold with this?")
                    2 -> println("what in tarnation")
                    3 -> println("why would you do this?")
                    4 -> println("Are you blind?")
                    5 -> println("interesting choice.")
                    6 -> println("really")
                    7 -> println("lucky number 7?")
                    8 -> println("was 8 great?")
                    9 -> println("hmmmmm")
                    10 -> println("perhaps")
                    11 -> println("maybe")
                    12 -> println("getting there")
                    13 -> println("closer")
                    14 -> println("not quite")
                    15 -> println("risky")
                    16 -> println("cutting it close")
                    17 -> println("resonable")
                    18 -> println("understandable")
                    19 -> println("Outstanding!!")
                    20 -> println("So close!")
                    21 -> println("21 Exactly")
                    22 -> println("Should have held jack!")
                    23 -> println("Absolute shame")
                    24 -> println("Shame")
                    25 -> println("Sad Day")
                    26 -> println("why didn't you stop?")
                    27 -> println("Mission failed")
                    28 -> println("Nooooooooooooooooooo")
                    29 -> println("Wack")
                    30 -> println("This is the worst trade deal in the history of trade deals.")
                }

                }else if ((player1.hand.sum() < dealer.hand.sum() || player1.hand.sum() > 21) && dealer.hand.sum() <= 21){
                println("dealer wins")
                player1.subtractMoney(bet.toInt())
                println(player1.name + ": Money: " + player1.money + " Hand Total: " + player1.hand.sum())
                println(dealer.hand.sum())
                when (dealer.hand.sum()) {
                    1 -> println("wow")
                    2 -> println("wack")
                    3 -> println("interesting")
                    4 -> println("get wrecked")
                    5 -> println("impossible")
                    6 -> println("really")
                    7 -> println("lucky number 7?")
                    8 -> println("was 8 great?")
                    9 -> println("hmmmmm")
                    10 -> println("perhaps")
                    11 -> println("maybe")
                    12 -> println("getting there")
                    13 -> println("closer")
                    14 -> println("not quite")
                    15 -> println("risky")
                    16 -> println("cutting it close")
                    17 -> println("resonable")
                    18 -> println("understandable")
                    19 -> println("shame!")
                    20 -> println("So close!")
                    21 -> println("21 Exactly")
                }
            }else{
                println("everyone loses")
                player1.subtractMoney(bet.toInt())
                println(player1.name + ": Money: " + player1.money + " Hand Total: " + player1.hand.sum())
                println(dealer.hand.sum())
            }
        }
        else{
            game = false
        }

    }
    if (player1.money <= 0){
        println("you are now bankrupt, get rekt")
    }
}