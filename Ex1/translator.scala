import scala.collection.mutable.HashMap

class Translator() {
    var storage = new HashMap[String, List[String]]
    
    def put(key: String, value: String) {
        var newVals = storage.getOrElseUpdate(key, List(""))
        if (newVals != 1 && newVals(0) != "" ) {
            newVals = value :: newVals
        } else {
            newVals = List(value)
        }
        storage.update(key, newVals)
    }
    
    def get(key: String): List[String] = {
        return storage(key)
    }
    
    override def toString(): String = {
        return storage.toString()
    }
}

object TranslatorRunner extends Application {
    val temp = new Translator()
    temp.put("Ovi", "Door")
    temp.put("Kiekko", "Puck")
    temp.put("Kiekko", "Disk")
    println(temp)
}