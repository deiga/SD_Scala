
class Protozoan() {
    val serial = Protozoan.orderNumber
    Protozoan.orderNumber += 1
    var genome = generateGenome()
    private val nukleotide = Array('A', 'C', 'G', 'T')
    
    def this(genotype: List[Char]) = {
        this()
        genome = genotype
    }
    
    def generateGenome(): List[Char] =  {
        var tmpGenome = new Array[Char](10)
        for (i <- 0 to 10) {
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
        for (i <- 0 to 10) {
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
        
        return rtrnString
    }
    
}

object Protozoan {
    private var orderNumber = 0
}

object Geenilaboratorio extends Application {
    
}