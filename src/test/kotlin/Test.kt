import data.CafeDB
import data.Coffee


fun main(){
    val result = CafeDB.addCoffee12(
        Coffee(
            id = 0,
            name = "MAsha COffee",
            price = 12.0,
            description = "Очень вкусный и много молока"
        )
    )
    println()
}