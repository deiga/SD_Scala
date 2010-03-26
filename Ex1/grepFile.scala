import scala.io.Source

class GrepFile(filename: String) {
    val file = Source.fromFile(filename)
    var fileRepeater = file
    var searchString = ""
    val question = "What string do you want to look for in file " + filename + "?\n"
    var count = 0
    do {
        searchString = Console.readLine(question)
        count = 0
        for (line <- fileRepeater.getLines) {
            count += 1
            if (searchString != "" && line.contains(searchString)) {
                print(count + ": " + line)
            }
        }
        fileRepeater = fileRepeater.reset
    } while (searchString != "") 
}

object GrepRunner {
    def main(args: Array[String]) {
        if (args.length > 0) {
            val filename = args(0)
            new GrepFile(filename)
        } else {
            Console.err.println("Please enter filename!")
        }
    }
}