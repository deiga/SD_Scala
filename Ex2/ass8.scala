class MinMax() {
    
    var max: Double = 0.0
    var min: Double = 0.0
    var reset: Boolean = true
    
    def kirjaaLampotila(lampo: Double): Unit = {
        reset = false
        if (lampo > max) max = lampo
        if (lampo < min) min = lampo
    }
    
    def getMinimi(): Double = min
    
    def getMaksimi(): Double = max
    
    def onAlkutilassa(): Boolean = reset
    
    def asetaAlkutilaan(): Unit = {
        reset = true
    }
    
    override def toString(): String = {
        return "Min: " + min + ", Max: " + max + ", Reset: " + reset
    }
}

object MinMaxRunner extends Application {
    val testMinMax = new MinMax
    testMinMax.kirjaaLampotila(2.0)
    println(testMinMax)
    testMinMax.kirjaaLampotila(-5.0)
    println(testMinMax)
    testMinMax.kirjaaLampotila(12.0)
    println(testMinMax)
    testMinMax.kirjaaLampotila(1.0)
    println(testMinMax)
    testMinMax.kirjaaLampotila(-1.0)
    println(testMinMax)
}