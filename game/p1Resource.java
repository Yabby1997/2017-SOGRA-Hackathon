import greenfoot.*;

public class p1Resource extends Actor
{
    static int currentResource;
    public void act() 
    {
        setImage(new GreenfootImage("Resource :" +currentResource, 25, Color.GREEN, new Color(255,255,255,0)));
    }   
    
    public static void checkResource(int currentAmount){
        currentResource = currentAmount;
    }
}
