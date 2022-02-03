class Player(var name : String, var number: Int, var money: Int) {
    var hand = ArrayList<Int>()

    fun addMoney(x: Int){
        money += x
    }

    fun subtractMoney(x: Int){
        money -= x
    }
}