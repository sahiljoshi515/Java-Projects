public class Troll extends Creature implements Attackable
{
 private double happinessLevel;


public Troll(String name, String weapon, double happinessLevel) {
     super(name, weapon);
this.happinessLevel = happinessLevel;
 }

 public double getHappinessLevel(){ 
 return happinessLevel;
}

public void updateHappinessLevel(double incAmt){
if(getLifeLevel() > 0)
     happinessLevel += incAmt;
   }
   
   public String speak(){ 
   if(getHappinessLevel()>super.getLifeLevel())
return "Let's play!"; else
return "I must break you!";
 
}

public String toString() {
return super.toString()+", happiness level:"+happinessLevel; }



public void attack(Object other){
Troll otherTroll = (Troll)other;
if(this.getLifeLevel() > otherTroll.getLifeLevel()) otherTroll.die();
else if(getLifeLevel() < otherTroll.getLifeLevel()) die();
}
public static void main(String[] args){
Troll a=new Troll("a", "stick", 2);
Troll b=new Troll("b", "dick", 3);
b.updateLifeLevel(-1);
a.attack(b);
System.out.println(a.getLifeLevel());

System.out.print(b.getLifeLevel());}
}
