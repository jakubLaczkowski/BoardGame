import javax.sound.midi.Soundbank;

public class Player {
    private int positionX;
    private int  positionY;
    private int health;
    private char initial;
    private boolean alive;
    private boolean winner;

    public Player(){
        positionX = 0;
        positionY = 0;
        health = 200;
        initial = 'P';
        alive = true;
        winner = false;
    }
    public void checkIfPlayerAlive(){
        if(health <= 0) {
            alive = false;
            System.out.println("You're dead.");
        }
    }
    public void checkIfPlayerWon(){
        if(positionX == 9 && positionY == 9){
            winner = true;
            System.out.println("You've reached the goal alive! Congratulations!");
        }
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public char getInitial() {
        return initial;
    }

    public boolean isWinner() {
        return winner;
    }
}
