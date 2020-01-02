import greenfoot.*;

public class p1Bullet extends Actor
{
    static int currentBullet;
    public void act() 
    {
        setImage(new GreenfootImage("Bullet :" +currentBullet, 25, Color.YELLOW, new Color(255,255,255,0)));
    }   
    
    public static void checkBullet(int currentAmount){
        currentBullet = currentAmount;
    }
}