
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

object Test {
    def main(args: Array[String]) {
        println("a.) Anna luku kuinka monta alkulukua tuotetaan: ")
        new Sievea(Console.readInt)
        println("b.) Anna luku mihin saakka tuotetaan alkulukuja: ")
        new Sieveb(Console.readInt)
    }
}