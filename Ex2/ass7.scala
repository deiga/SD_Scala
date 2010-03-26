
class Sekunttilaskuri() {
    private var seconds = 0
    private var minutes = 0
    private var hours   = 0
    
    def getSekunnit(): Int = seconds
    
    def getMinuutit(): Int = minutes
    
    def getTunnit(): Int = hours
    
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

object Sekunttilaskuri {
    def apply() = new Sekunttilaskuri()
}

object TimerRunner extends Application {
    val testTimer = new Sekunttilaskuri
    while (true) {
        testTimer.lisaaSekunti()
        println(testTimer)
    }
}