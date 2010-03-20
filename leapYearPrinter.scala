class LeapYearPrinter() {
    
    val years = askInput()
    var yearList = years._1 until years._2+1
    if (years._1 > years._2) {
        yearList = yearList.by(-1)
    } else {
        yearList = yearList.by(1)
    }
    
    for (year <- yearList) {
        if (isLeapYear(year)) {
            println(year)
        }
    }
    
    def isLeapYear(year: Int): Boolean = {
        year % 4 == 0 && year % 100 != 0 || year % 400 == 0
    }
    
    def askInput(): (Int, Int) = {
        println("Please insert 2 years. I will print all leap years in between. (order is irrelevant):")
        val year1 = Console.readInt
        val year2 = Console.readInt
        (year1, year2)
    }
    
}

object LeapYears extends Application {
    new LeapYearPrinter()
}