import greenfoot.*;  

public class wall2 extends Actor
{
    public void act() 
    {
        colider();
        ruin();
    }
    
    int HP = 50;
    
    public void colider(){
        if(isTouching(bullet1.class)){
            removeTouching(bullet1.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
        }
        if(isTouching(bullet2.class)){
            removeTouching(bullet2.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
        }
        if(isTouching(staff1.class)){
            removeTouching(staff1.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
        }
        if(isTouching(staff2.class)){
            removeTouching(staff2.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
        }
    }
    
    public void ruin(){
        if(this.HP == 0){
            getWorld().removeObject(this);
            Greenfoot.playSound("ruined1.wav");
        }
    }
}
