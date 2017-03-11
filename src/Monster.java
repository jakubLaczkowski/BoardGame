import java.lang.Math;
import java.util.Scanner;
public class Monster {
    private int attack;
    private char initial;
    private int positionX = 0;
    private int positionY = 0;
    private Scanner scanner = new Scanner(System.in);

    public Monster(){
        while ((positionX == 0 && positionY == 0) || (positionX == 9 && positionY == 9)) {
            positionX = (int) Math.round(Math.random() * 9);
            positionY = (int) Math.round(Math.random() * 9);
        }
        initial = 'M';
        attack = (int) Math.round(Math.random()*100);
    }


    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public char getInitial() {
        return initial;
    }

    public int getAttack() {
        return attack;
    }
}
