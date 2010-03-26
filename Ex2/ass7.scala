
class Sekunttilaskuri() {
    private var seconds = 0
    private var minutes = 0
    private var hours   = 0
    
    def getSekunnit(): Int = {
        return seconds
    }
    
    def getMinuutit(): Int = {
        return minutes
    }
    
    def getTunnit(): Int = {
        return hours
    }
    
    def lisaaSekunti(): Unit = {
        seconds += 1
        while (seconds == 60 || minutes == 60 || hours == 24) {
            if (seconds == 60) {
                seconds = 0
                minutes += 1
            } else if (minutes == 60) {
                minutes = 0
                hours += 1
            } else if (hours == 24) {
                hours = 0
            }
        }
    }
    
    override def toString(): String = {
        return hours + ":" + minutes + ":" + seconds
    }
    
}

object TimerRunner extends Application {
    val testTimer = new Sekunttilaskuri
    while (true) {
        testTimer.lisaaSekunti()
        println(testTimer)
    }
}