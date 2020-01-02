import greenfoot.*;  
public class wall1 extends Actor
{
    public void act() 
    {
        colider();
    }
    
    public void colider(){
        if(isTouching(bullet1.class)){
            removeTouching(bullet1.class);
        }
        if(isTouching(bullet2.class)){
            removeTouching(bullet2.class);
        }
    }
}
