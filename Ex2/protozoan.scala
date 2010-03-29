
class Protozoan() {
    val serial = Protozoan.orderNumber
    private val nukleotide = Array('A', 'C', 'G', 'T')
    Protozoan.orderNumber += 1
    var genome = generateGenome()
    
    
    def this(genotype: List[Char]) = {
        this()
        genome = genotype
    }
    
    def generateGenome(): List[Char] =  {
        var tmpGenome = new Array[Char](10)
        for (i <- 0 until 10) {
            tmpGenome(i) = randomNukleotide()
        }  
        return tmpGenome.toList
    }
    
    def randomNukleotide(): Char = {
        val index = Math.random * 4
        nukleotide(index.toInt)
    }
    
    def split(): Protozoan = new Protozoan(genome)
    
    def mate(that: Protozoan): Protozoan = {
        val newGenome = new Array[Char](10)
        for (i <- 0 until 10) {
            if (Math.random >= 0.5) {
                newGenome(i) = genome(i)
            } else {
                newGenome(i) = that.genome(i)
            }
        }
        new Protozoan(newGenome.toList)
    }
    
    def identify(): Int = serial
    
    override def toString(): String = {
        var rtrnString = "Serial: " + serial +"\nGenome: "
        for (item <- genome) {
            rtrnString += item + " "
        }
        
        return rtrnString + "\n"
    }
    
}

object Protozoan {
    private var orderNumber = 0
}

object Geenilaboratorio extends Application {
    val origin = new Protozoan
    println(origin)
    val splir = origin.split
    println(splir)
    val paired = origin.mate(new Protozoan)
    println(paired)
}