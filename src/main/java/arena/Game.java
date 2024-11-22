package arena;

public class Game {
    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
        System.out.println("Game begins!");
        System.out.println(playerA);
        System.out.println(playerB);

        while (playerA.isAlive() && playerB.isAlive()) {
            playRound();
        }

        Player winner = playerA.isAlive() ? playerA : playerB;
        System.out.println(winner.getName() + " wins!");
    }

    private void playRound() {
        Player attacker = playerA.getHealth() <= playerB.getHealth() ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;

        int attackRoll = Dice.roll(6);
        int defenseRoll = Dice.roll(6);

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int netDamage = Math.max(0, attackDamage - defenseStrength);

        defender.reduceHealth(netDamage);

        System.out.printf("%s attacks %s: Attack Roll=%d, Defense Roll=%d, Net Damage=%d%n",
                attacker.getName(), defender.getName(), attackRoll, defenseRoll, netDamage);
        System.out.println(playerA);
        System.out.println(playerB);
    }
}
