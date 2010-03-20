class StarPyramid {
    
    private var height: Int = 0
    
    println("Please insert height of star Pyramid:")
    height = Console.readInt
    
    val pyramidLines = new Array[String](height)
    
    for (i <- 0 until height) {
        val numStars = (i+1) * 2 - 1
        pyramidLines(i) = "*" * numStars
    }
    
    val maxWidth = pyramidLines(height-1).length / 2
    
    for (line <- pyramidLines) {
        val numSpaces = maxWidth - line.length / 2
        val padding = " "* numSpaces
        println(padding + line)
    }
}

object Pyramid extends Application {
    new StarPyramid()
}