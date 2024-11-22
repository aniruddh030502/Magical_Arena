package arena;

public class PlayerTest {

    public static void main(String[] args) {
        testPlayerAttributes();
        testHealthReduction();
        testPlayerIsAlive();
    }

    static void testPlayerAttributes() {
        Player player = new Player("TestPlayer", 50, 5, 10);

        assertEqual("TestPlayer", player.getName(), "Player name should be set correctly");
        assertEqual(50, player.getHealth(), "Player health should be set correctly");
        assertEqual(5, player.getStrength(), "Player strength should be set correctly");
        assertEqual(10, player.getAttack(), "Player attack should be set correctly");
    }

    static void testHealthReduction() {
        Player player = new Player("TestPlayer", 50, 5, 10);
        player.reduceHealth(20);

        assertEqual(30, player.getHealth(), "Player health should reduce correctly");
    }

    static void testPlayerIsAlive() {
        Player player = new Player("TestPlayer", 50, 5, 10);
        assertTrue(player.isAlive(), "Player should be alive initially");

        player.reduceHealth(50);
        assertFalse(player.isAlive(), "Player should be dead when health is 0");
    }

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
