
class Sievea(limit: Int) {
   var numbers = 2 to (limit*limit) toList
   
   for (i <- numbers; j <- 2 to limit) {
           numbers = numbers - i*j
   }
   println(numbers.take(limit))
}

class Sieveb(limit: Int) {
   var numbers = 2 to limit toList
   
   for (i <- numbers; j <- 2 to limit) {
           numbers = numbers - i*j
   }
   println(numbers)
}

class Sievec(min: Int, max: Int) {
   var numbers = 2 to max toList
   
   for (i <- numbers; j <- 2 to max) {
           numbers = numbers - i*j
   }
   println(numbers.filter(x => x >= min && x <= max))
}

object Test {
    def main(args: Array[String]) {
        println("a.) Anna luku kuinka monta alkulukua tuotetaan: ")
        new Sievea(Console.readInt)
        println("b.) Anna luku mihin saakka tuotetaan alkulukuja: ")
        new Sieveb(Console.readInt)
        println("c.) Anna luku mistä lähtirn ja mihin saakka tuotetaan alkulukuja: ")
        new Sievec(Console.readInt, Console.readInt)
    }
}