class GuessingGame {
    private val guessingNumber = randomNumber()
    private var winnings = 0
    
    for (i <- 1 to 3) {
        makeGuess(i)
    }
    if (winnings > 0) {
        println("You won " + winnings + " euro")
        println("Congratulations!")
    } else {
        println("Game Over! You lost 100 euro")        
    }

    def randomNumber(): Int = {
        val number = Math.random
        number.toInt * 9
    }
    
    def makeGuess(turn: Int) = {
        println("Please insert your guess (0-9):")
        val guess = Console.readInt
        turn match {
            case 1 => if (guessMatches(guess)) winnings += 400
            case 2 => if (guessMatches(guess)) winnings += 200
            case 3 => if (guessMatches(guess)) winnings += 100
        }
        if (winnings == 0 && turn == 3) winnings -= 100
    }
    
    def guessMatches(guess: Int): Boolean = {
        guess == guessingNumber
    }
}

object Game extends Application {
    new GuessingGame()
}