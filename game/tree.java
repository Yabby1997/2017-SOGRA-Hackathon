import greenfoot.*; 
public class tree extends Actor
{
    public void act() 
    {
        colider();
        ruin();
    }
    
    int HP = 40;
    
    public void colider(){
        if(isTouching(staff1.class)){
            removeTouching(staff1.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
            Greenfoot.playSound("wood1.wav"); 
            p1.resource ++;
        }
        if(isTouching(staff2.class)){
            removeTouching(staff2.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
            Greenfoot.playSound("wood1.wav"); 
            p2.resource ++;
        }
    }
    
    public void ruin(){
        if(this.HP == 0){
            getWorld().removeObject(this);
            Greenfoot.playSound("ruined1.wav");
        }
    }
}
