import java.lang.Math;
import java.util.Scanner;
public class Movement {
    private int dice;
    private Scanner scanner = new Scanner(System.in);


    public void rollTheDice(){
        dice = (int) Math.round(Math.random()*5 +1);
    }
    public void movePlayer(Player player){
        System.out.println("Which way do you wanna move? up/down/left/right/stay");
        switch(scanner.nextLine()){
            case "up":
                if((player.getPositionY()- dice) >= 0)
                    player.setPositionY(player.getPositionY() - dice);
                else
                    player.setPositionY(0);
                break;
            case "down":
                if((player.getPositionY()+ dice) <= 9)
                    player.setPositionY(player.getPositionY() + dice);
                else
                    player.setPositionY(9);
                break;
            case "left":
                if((player.getPositionX()- dice) >= 0)
                    player.setPositionX(player.getPositionX() - dice);
                else
                    player.setPositionX(0);
                break;
            case "right":
                if((player.getPositionX()+ dice) <= 9)
                    player.setPositionX(player.getPositionX() + dice);
                else
                    player.setPositionX(9);
                break;
            case "stay":
                break;
            default:
                System.out.println("Incorrect command! You lose a round.");
        }
    }
    public void moveMonsters(Monster[] monsters){
        int moveY = 0;
        int moveX = 0;
        int moveRandomizer;
        for(int i = 0; i < monsters.length; i++){
            moveRandomizer = (int) Math.round(Math.random()*100);
            if(moveRandomizer<33){
                moveY = -1;
                if(monsters[i].getPositionY() != 0)
                    monsters[i].setPositionY(monsters[i].getPositionY() + moveY);
            }
            else if(moveRandomizer>=33 && moveRandomizer<67) {
                moveY = 0;
                moveRandomizer = (int) Math.round(Math.random()*100);
                if(moveRandomizer<33){
                    moveX = -1;
                    if(monsters[i].getPositionX() != 0)
                        monsters[i].setPositionX(monsters[i].getPositionX() + moveX);
                }
                else if(moveRandomizer>=33 && moveRandomizer<67) {
                    moveX = 0;
                }
                else {
                    moveX = 1;
                    if(monsters[i].getPositionX() != 9)
                        monsters[i].setPositionX(monsters[i].getPositionX() + moveX);
                }
            }
            else {
                moveY = 1;
                if(monsters[i].getPositionY() != 9)
                    monsters[i].setPositionY(monsters[i].getPositionY() + moveY);
            }
        }
    }
    public int getDice() {
        return dice;
    }
}
