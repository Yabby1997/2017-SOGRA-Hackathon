import greenfoot.*;

public class p1Hungry extends Actor
{
    static int maxHungry;
    static int currentHungry;
    public void act() 
    {
        setImage(new GreenfootImage("Hungry :"+currentHungry+"/" +maxHungry, 25, Color.WHITE, new Color(255,255,255,0)));
    }
    
    public static void checkHungry(int maxAmount, int currentAmount){
        maxHungry = maxAmount;
        currentHungry = currentAmount;
    }
}