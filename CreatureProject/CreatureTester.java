import java.util.*;

public class CreatureTester {
       
    public static void main(String[] args){


    Troll myTroll = new Troll("Sollix", "Lance", 500.00);
    myTroll.updateLifeLevel(10);
    System.out.println(myTroll.getName());
    System.out.println(myTroll.getLifeLevel());
    System.out.println(myTroll.isAlive());
    System.out.println(myTroll.speak());
    System.out.println();
    
    Troll enemy = new Troll("Matuna", "Hammer", 50.00);
    enemy.updateLifeLevel(-10);
    System.out.println(enemy.speak());
    System.out.println();
    
    Troll yourTroll = new Troll("Ragnarita", "Hammer",375.00);
    System.out.println(yourTroll.toString());
    
    int life = yourTroll.compareTo(enemy);
    System.out.println(life);
    
    
    yourTroll.attack(enemy);
    System.out.println(enemy.toString());
   

 }//end main
 
           
    
}//end class
