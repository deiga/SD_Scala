class ComplexNumber(r: Double, i: Double) {
    
    val real = r
    val imaginary = i
    
    def +(that: ComplexNumber): ComplexNumber = {
        new ComplexNumber(real + that.real, imaginary + that.imaginary)
    }
    
    def -(that: ComplexNumber): ComplexNumber = {
        this + that.complement
    }
    
    def *(that: ComplexNumber): ComplexNumber = {
        new ComplexNumber(real * that.real - imaginary * that.imaginary, real * that.imaginary + that.real * imaginary)
    }
    
    def /(that: ComplexNumber): ComplexNumber = {
        this * that.reciprocal()
    }
    
    def complement(): ComplexNumber = new ComplexNumber(-real, -imaginary)
    
    def reciprocal(): ComplexNumber = {
        new ComplexNumber(real/(real*real + imaginary*imaginary), -imaginary/(real*real + imaginary*imaginary))
    }
    
    override def toString(): String = {
        var tmpString = real
        if (Math.signum(imaginary) == -1) {
            tmpString + "" + imaginary + "i"
        } else {
            tmpString + "+" + imaginary + "i"
        }
    }
    
}

object ComplexTester extends Application {
    val complexTest = new ComplexNumber(1.4, 3.14)
    println(complexTest)
    println(complexTest + new ComplexNumber(3.1,-6.432133123))
    println(complexTest - new ComplexNumber(3.1,-6.432133123))
    println(complexTest * new ComplexNumber(3.1,-6.432133123))
    println(complexTest / new ComplexNumber(3.1,-6.432133123))
}