public class Fight {

    private int monsterWereFightingId;

    public void checkIfFight(Monster[] monsters, Player player){
        for(int i = 0; i < monsters.length; i++){
                if(player.getPositionX() == monsters[i].getPositionX()){
                    if(player.getPositionY() == (monsters[i].getPositionY() - 1)) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                    else if(player.getPositionY() == (monsters[i].getPositionY() +1)) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                    else if(player.getPositionY() == monsters[i].getPositionY()) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                }
                else if((player.getPositionX() == (monsters[i].getPositionX() + 1)) || (player.getPositionX() == (monsters[i].getPositionX() - 1))){
                    if(player.getPositionY() == (monsters[i].getPositionY() -1)) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                    else if(player.getPositionY() == (monsters[i].getPositionY() +1)) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                    else if(player.getPositionY() == monsters[i].getPositionY()) {
                        startFight(monsters, player);
                        monsterWereFightingId = i;
                        break;
                    }
                }
        }
    }

    public void startFight(Monster[] monsters, Player player){
        System.out.println("You meet a monster!");
        System.out.println("He attacks you for " + monsters[monsterWereFightingId].getAttack() + " dmg!");
        player.setHealth(player.getHealth() - monsters[monsterWereFightingId].getAttack());
        System.out.println("You have " + player.getHealth() + " health left");
    }

}
