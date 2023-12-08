package gameStateTest;

import game.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {

    GameState gameState;

    @BeforeEach
    void init() {
        gameState = GameState.START;
    }

    @Test
    void enumIsNotNULL() {
        assertNotNull(gameState);
    }

    @Test
    void initialStateIsSTART() {
        var expected = GameState.START;
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"START"})
    void initialStateIsNot(GameState state) {
        var expected = state;
        var actual = gameState;
        assertNotEquals(expected, actual);
    }

    @Test
    void GET_GOAL() {
        var expected = GameState.GET_GOAL;
        var actual = gameState.nextState(0, 0);
        assertEquals(expected, actual);
    }

    @Test
    void SEEK_GOAL() {
        var expected = GameState.SEEK_GOAL;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @Test
    void winGame() {
        var expected = GameState.WIN;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @Test
    void loseGame() {
        var expected = GameState.LOSE;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(7, 4);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @Test
    void endGameAfterLose() {
        var expected = GameState.END;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(7, 4);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @Test
    void endGameAfterWin() {
        var expected = GameState.END;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @Test
    void backToStart() {
        var expected = GameState.START;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"END"})
    void stateAfterWINisNot(GameState state) {
        var expected = state;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"END"})
    void stateAfterLOSEisNot(GameState state) {
        var expected = state;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.EXCLUDE, names = {"START"})
    void stateAfterENDisNot(GameState state) {
        var expected = state;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(4, 0);
        gameState = gameState.nextState(4, 4);
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(0, 0);
        var actual = gameState;
        assertNotEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 11})
    void winOnFirstRoll(int arguments) {
        var expected = GameState.WIN;
        gameState = gameState.nextState(0, 0);
        var actual = gameState.nextState(arguments, 0);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 12})
    void loseOnFirstRoll(int arguments) {
        var expected = GameState.LOSE;
        gameState = gameState.nextState(0, 0);
        var actual = gameState.nextState(arguments, 0);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 8, 9, 10})
    void seekGoalOnFirstRoll(int argument) {
        var expected = GameState.SEEK_GOAL;
        gameState = gameState.nextState(0, 0);
        var actual = gameState.nextState(argument, 0);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"4, 4", "5, 5", "6, 6", "8, 8", "9, 9", "10, 10"})
    void WINAfterGettingGoal(int argument, int goal) {
        var expected = GameState.WIN;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(argument, 0);
        var actual = gameState.nextState(argument, goal);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 8, 9, 10})
    void LOSEAfterGettingGoal(int argument) {
        var expected = GameState.LOSE;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(argument, 0);
        var actual = gameState.nextState(7, 0);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"4, 5", "4, 6", "4, 8", "4, 9", "4, 10",
            "5, 4", "5, 6", "5, 8", "5, 9", "5, 10",
            "6, 4", "6, 5", "6, 8", "6, 9", "6, 10",
            "8, 4", "8, 5", "8, 6", "8, 9", "8, 10",
            "9, 4", "9, 5", "9, 6", "9, 8", "9, 10",
            "10, 4", "10, 5", "10, 6", "10, 8", "10, 9"})
    void SEEK_GOALAfterGettingGoal(int argument, int goal) {
        var expected = GameState.SEEK_GOAL;
        gameState = gameState.nextState(0, 0);
        gameState = gameState.nextState(argument, 0);
        var actual = gameState.nextState(argument, goal);
        assertEquals(expected, actual);
    }

}
