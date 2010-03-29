
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
        
    }
    
}

object Protozoan {
    private var orderNumber = 0
}