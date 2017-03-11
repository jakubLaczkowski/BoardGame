public class Main {
    public static void main(String[] args){
        Monster[] monsters;
        StringBuilder rules = new StringBuilder(200);
        Fight fight = new Fight();
        Player player = new Player();
        BattleBoard battleBoard = new BattleBoard();
        Movement movement = new Movement();

        rules.append("Game rules:\n")
                .append("1. The goal is to reach the 'G' mark by rolling the dice and moving in desired direction. \n")
                .append("2. Monsters' goal is not to let you reach it. You meet a monster if you stand on any of its surrounding fields.\n")
                .append("3. Every monster has a random attack number between 0 and 100\n")
                .append("4. You have 200 health. Every time you meet a monster you lose health equal to its attack number\n")
                .append("5. Monsters can randomly move 1 space in 4 directions.\n")
                .append("6. You can choose the difficulty level by specifying the amount of monsters that will walk on the board.\n")
                .append("LET'S BEGIN!\n");
        System.out.println(rules);

        battleBoard.specifyMonsterAmount();
        monsters = battleBoard.createMonsters();
        battleBoard.drawBattleBoard(monsters, player);
        while(!battleBoard.isGameFinished(player)) {
            System.out.println("----------------------------");
            movement.rollTheDice();
            System.out.println("You rolled " + movement.getDice());
            movement.movePlayer(player);
            movement.moveMonsters(monsters);
            battleBoard.drawBattleBoard(monsters, player);
            player.checkIfPlayerWon();
            if(player.isWinner())
                break;
            fight.checkIfFight(monsters, player);
            player.checkIfPlayerAlive();
        }


    }
}
