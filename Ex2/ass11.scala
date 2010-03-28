
class Protozoan() {
    val serial = orderNumber
    orderNumber += 1
    val genome: List[Char]
    
    def this(genotype: List[Char]) = {
        this()
        genome = genotype
    }
    
}

object Protozoan {
    private var orderNumber = 0
}