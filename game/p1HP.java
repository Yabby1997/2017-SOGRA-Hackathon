import greenfoot.*;

public class p1HP extends Actor
{
    static int maxHP;
    static int currentHP;
    public void act() 
    {
        setImage(new GreenfootImage("HP :"+currentHP+"/" +maxHP, 25, Color.RED, new Color(255,255,255,0)));
    }   
    
    public static void checkHP(int maxAmount, int currentAmount){
        maxHP = maxAmount;
        currentHP = currentAmount;
    }
}
