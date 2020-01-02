import greenfoot.*; 
public class bullet extends Actor
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
