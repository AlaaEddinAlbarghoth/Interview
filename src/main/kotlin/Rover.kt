import java.lang.Exception

class Rover {

    var x = 0
    var y = 0
    var n = N

    fun setNewPosition(newX: Int, newY: Int) {
        x = newX
        y = newY
    }

    fun setNewDirection(newN: Int) {
        n = newN
    }

    fun printCurrentPosition(): String {
        val direction = when (n) {
            N -> "N"
            E -> "E"
            S -> "S"
            W -> "W"
            else -> throw Exception("Not possible")
        }
        return "$x:$y:$direction"
    }

    fun stepForward() {
        when (n) {
            N -> y++
            E -> x++
            S -> {
                y--
                if (y < 0)
                    y = -y
            }

            W -> {
                x--
                if (x < 0)
                    x = -x
            }
        }
    }

    fun moveRight() {
        n++
        if (n > 3)
            n = 0
    }

    fun moveLeft() {
        --n
        if (n < 0)
            n = 3
    }

    companion object {
        const val N = 0
        const val E = 1
        const val S = 2
        const val W = 3
    }
}