import greenfoot.*; 
public class potion extends Actor
{
    int Timer = 0;
    public void act() {
        Timer++;
        desolve();
    }    
    
    public void desolve(){
        if(Timer >= 1000){
            getWorld().removeObject(this);
        }
    }
}
