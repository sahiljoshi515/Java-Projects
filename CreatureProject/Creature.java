public class Creature {
   private String name;
   private String weapon;
   private int lifeLevel;
 	 
   //Constructor that initializes name and weapon and sets lifeLevel to 100
   public Creature(String name, String weapon) {
     this.name = name;
     this.weapon = weapon;
     lifeLevel = 100;
   }
 
  public String getName(){return name;}
  public String getWeapon(){return weapon;}
  public int getLifeLevel(){return lifeLevel;}
  public void die(){lifeLevel = 0;}
  public boolean isAlive(){return (lifeLevel>0);}
   
   /*   Adds the argument: incAmt to the lifeLevel.
	* Note: if the lifeLevel is currently 0 it should not change
	*/
   public void updateLifeLevel(int incAmt){
 	if(lifeLevel > 0)
     lifeLevel += incAmt;
   }
 
   public String speak(){
 	return " ";
   }
 
   public String toString()  {
 	return name+", weapon: "+weapon+", life level: "+lifeLevel;
   }
}
