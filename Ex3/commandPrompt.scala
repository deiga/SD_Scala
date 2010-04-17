// 13. & 14.
// Toteuta komentotulkkilogiikalla tiedostojen tutkailuohjelma, joka osaa ainakin seuraavat komennot:
// 
// ls listaa hakemiston kaikki tiedostonimet aakkosjärjestyksessä (String-vertailu kelpaa aakkosjärjestykseksi)
// ls -e merkkijono listaa aakkosjärjestyksessä hakemiston tiedostonimet, jotka päättyvät annettuun merkkijonoon
// ls -b merkkijono listaa aakkosjärjestyksessä hakemiston tiedostonimet, jotka alkavat annetulla merkkijonolla
// ls -c merkkijono listaa aakkosjärjestyksessä hakemiston tiedostonimet, jotka sisältävät annettun merkkijonon
// find merkkijono listaa hakemiston tiedostonimet, joiden tarkoittamat tiedostot sisältävät annettun merkkijonon
// grep merkkijono [tiedostonimi]+ listaa annetuista tiedostoista kaikki rivit, jotka sisältävät merkkijonon (ilmaus [tiedostonimi]+ tarkoittaa tässä, että tiedostonimiä on yksi tai useampi)
// ...
// lo tulostaa tilastotietoja ohjelman tästä käyttökerrasta ja lopettaa ohjelman suorituksen

import scala.io.Source

object Bash {
    
    def main(args: Array[String]) {
        var continue = true
        var temp = ""
        var count = 0
        while (continue) {
            println("Scala shell:\nPlease insert commands (find, grep, ls, lo)")
            temp = Console.readLine("> ")
            val args = temp.split(" ")
            val command = args(0)
            command match {
                case "find" =>
                    ls.filesContaining(args(1))
                case "grep" =>
                    grep(args);
                case "ls" =>
                    val command = if (args.length > 1) args(1) else ""
                    command match {
                        case "-e" =>
                            ls.filesEnding(args(2))
                        case "-b" =>
                            ls.filesBeginning(args(2))
                        case "-c" =>
                            ls.filesContaining(args(2))
                        case _ =>
                            ls.files
                    }
                case "lo" =>
                    continue = lo(count);
                case _ =>
                    ;
            }
            count += 1
        }
    }
    
    private def filesHere = (new java.io.File(".")).listFiles
    
    def grep(args: Array[String]) {
        val files = args.slice(2,args.length)
        var searchString = args(1)
        for (file <- files) {
            var fileRepeater = Source.fromFile(file)
            var count = 0
            for (line <- fileRepeater.getLines) {
                count += 1
                if (searchString != "" && line.contains(searchString)) {
                    print(count + ": " + line)
                }
            }
            fileRepeater = fileRepeater.reset
        }
    }
    
    object ls {
        
        private def filesMatching(matcher: String => Boolean) = {
            for (file <- filesHere; if matcher(file.getName)) {
                println(file)
            }
        }
                
        def filesEnding(query: String) {
            filesMatching(_.endsWith(query))
        }
        def filesBeginning(query: String) { 
            filesMatching(_.startsWith(query))
        }
        def filesContaining(query: String) {
             filesMatching(_.containsSlice(query))
        }
        def files {
            for (file <- filesHere) {
                println(file)
            }
        }
    }
    
    def lo(times: Int): Boolean = {
        println("Olet suorittanut " + times + " käskyä!")
        return false
    }
    
    def find(pattern: String) {
        for (file <- filesHere; if (file.getName().containsSlice(pattern))) {
                println(file)
        }
    }
}