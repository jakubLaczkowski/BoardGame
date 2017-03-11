import java.util.Arrays;
import java.util.Scanner;
public class BattleBoard {
    private static int monsterCount;
    private static final char[][] battleBoard = new char[10][10];
    private Scanner scanner = new Scanner(System.in);


    public void buildBattleBoard(){
        for(char[] row : battleBoard){
            Arrays.fill(row, '*');
        }
        battleBoard[9][9] = 'G';
    }

    public void placePlayer(Player player){
        battleBoard[player.getPositionY()][player.getPositionX()] = player.getInitial();
    }

    public void placeMonster(Monster[] monsters){
        for(int i = 0; i < monsters.length; i ++){
            if(battleBoard[monsters[i].getPositionY()][monsters[i].getPositionX()] != 'G' && battleBoard[monsters[i].getPositionY()][monsters[i].getPositionX()] != 'P')
                battleBoard[monsters[i].getPositionY()][monsters[i].getPositionX()] = monsters[i].getInitial();
        }
    }

    public void drawBattleBoard(Monster[] monsters, Player player){
        buildBattleBoard();
        placePlayer(player);
        placeMonster(monsters);
        for(int i = 0; i < battleBoard.length; i++){
            for(int j = 0; j < battleBoard[i].length; j++){
                System.out.print("|" + battleBoard[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int specifyMonsterAmount(){
        System.out.println("How many monsters would you like to have in your game?");
        monsterCount = Integer.parseInt(scanner.nextLine());
        return monsterCount;
    }

    public Monster[] createMonsters(){
        Monster[] monsters = new Monster[monsterCount];
        for(int i = 0; i < monsters.length; i++){
            monsters[i] = new Monster();
        }
        return monsters;
    }

    public boolean isGameFinished(Player player){
        if(!player.isAlive() || player.isWinner())
            return true;
        else
            return false;
    }


    public static int getMonsterCount() {
        return monsterCount;
    }

}
