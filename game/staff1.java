import greenfoot.*;

public class staff1 extends Actor
{    
    int Timer = 0;
    public static int damage = 10;
    
    public void act(){
        Timer++;
        desolve();
    }
    
    public void desolve(){
        if(Timer >= 10){
            getWorld().removeObject(this);
        }
    }
}
