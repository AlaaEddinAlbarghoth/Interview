import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.math.E

class RoverTest {

    private lateinit var rover: Rover

    @Before
    fun init() {
        rover = Rover()
    }

    // region Output Test
    @Test
    fun validateOutputTrue() {
        rover.setNewDirection(Rover.N)
        rover.setNewPosition(1, 1)
        assertEquals(rover.printCurrentPosition(), "1:1:N")
    }

    @Test
    fun validateOutputFalse() {
        rover.setNewDirection(Rover.N)
        rover.setNewPosition(1, 0)
        assertNotEquals(rover.printCurrentPosition(), "1:1:N")
    }
    // endregion

    // region Operations

    // region setNewPosition
    @Test
    fun validateNewPositionSetTrue() {
        rover.setNewPosition(1, 1)
        assertEquals(rover.x, 1)
        assertEquals(rover.y, 1)
    }

    @Test
    fun validateNewPositionSetFalse() {
        rover.setNewPosition(0, 0)
        assertNotEquals(rover.x, 1)
        assertNotEquals(rover.y, 1)
    }
    // endregion

    // region setNewDirection
    @Test
    fun validateSetNewDirectionReturnTrue() {
        rover.setNewDirection(Rover.E)
        assertEquals(rover.n, Rover.E)
    }

    @Test
    fun validateSetNewDirectionReturnFalse() {
        rover.setNewDirection(Rover.E)
        assertNotEquals(rover.n, Rover.N)
    }
    // endregion

    // region Move Right
    @Test
    fun validateMoveRightTrue() {
        assertEquals(rover.printCurrentPosition(), "0:0:N")
        rover.moveRight()
        assertEquals(rover.printCurrentPosition(), "0:0:E")
        rover.moveRight()
        assertEquals(rover.printCurrentPosition(), "0:0:S")
        rover.moveRight()
        assertEquals(rover.printCurrentPosition(), "0:0:W")
    }

    @Test
    fun validateMoveRightFalse() {
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:W")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:N")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:E")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:S")
    }
    // endregion

    // region Move Left
    @Test
    fun validateMoveLeftTrue() {
        rover.moveLeft()
        assertEquals(rover.printCurrentPosition(), "0:0:W")
        rover.moveLeft()
        assertEquals(rover.printCurrentPosition(), "0:0:S")
        rover.moveLeft()
        assertEquals(rover.printCurrentPosition(), "0:0:E")
        rover.moveLeft()
        assertEquals(rover.printCurrentPosition(), "0:0:N")
    }

    @Test
    fun validateMoveLeftFalse() {
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:W")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:N")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:E")
        rover.moveRight()
        assertNotEquals(rover.printCurrentPosition(), "0:0:S")
    }
    // endregion

    // region Move step forward

    // RM
    @Test
    fun validateMoveStepRM() {
        rover.moveRight()
        rover.stepForward()
        assertEquals(rover.printCurrentPosition(), "1:0:E")
    }

    // LM
    @Test
    fun validateMoveStepLM() {
        rover.moveLeft()
        rover.stepForward()
        assertEquals(rover.printCurrentPosition(), "1:0:W")
    }

    // Position is “2:3:E”, sending ‘M’
    @Test
    fun validateMoveStepFrom23M() {
        rover.setNewPosition(2, 3)
        rover.setNewDirection(Rover.E)
        rover.stepForward()
        assertEquals(rover.printCurrentPosition(), "3:3:E")
    }

    // RMMLML
    @Test
    fun validateMoveStepRMMLML() {
        rover.moveRight()
        rover.stepForward()
        rover.stepForward()
        rover.moveLeft()
        rover.stepForward()
        rover.moveLeft()
        assertEquals(rover.printCurrentPosition(), "2:1:W")
    }
    // endregion

    // endregion
}