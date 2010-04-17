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
import java.io.File

object Bash {
    
    def main(args: Array[String]) {
        val temp = args(0)
        temp match {
            case "find" =>
                find(args(1));
            case "grep" =>
                grep(args);
            case "ls" =>
                ls(args);
            case "lo" =>
                lo
        }
    }
    
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
    
    def ls(args: Array[String]) {
        
    }
    
    def lo {
        
    }
    
    def find(pattern: String) {
        for (file <- new File(".").listFiles) {
            if (file.getName().containsSlice(pattern)) {
                println(file)
            }
        }
    }
}