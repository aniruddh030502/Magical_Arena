package arena;

public class GameTest {

    public static void main(String[] args) {
        testGameEndsWhenPlayerHealthReachesZero();
        // testCorrectPlayerAttacksFirst();
    }

    static void testGameEndsWhenPlayerHealthReachesZero() {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 20, 5, 5);

        Game game = new Game(playerA, playerB);
        game.start();

        boolean isGameOver = !playerA.isAlive() || !playerB.isAlive();
        assertTrue(isGameOver, "Game should end when one player's health reaches 0");
    }

    // static void testCorrectPlayerAttacksFirst() {
    //     Player playerA = new Player("Player A", 50, 5, 10);
    //     Player playerB = new Player("Player B", 100, 5, 5);

    //     Game game = new Game(playerA, playerB);

    //     Player firstAttacker = game.getFirstAttacker();
    //     assertEqual(playerA, firstAttacker, "Player with lower health should attack first");
    // }

    // Helper methods for testing
    static void assertEqual(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            System.out.println("FAIL: " + message + " | Expected: " + expected + ", Actual: " + actual);
        } else {
            System.out.println("PASS: " + message);
        }
    }

    static void assertTrue(boolean condition, String message) {
        if (!condition) {
            System.out.println("FAIL: " + message);
        } else {
            System.out.println("PASS: " + message);
        }
    }

    static void assertFalse(boolean condition, String message) {
        assertTrue(!condition, message);
    }
}
