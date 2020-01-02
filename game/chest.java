import greenfoot.*;

public class chest extends Actor
{
    public void act() 
    {
        Timer++;
        colider();
        ruin();
    }
        
    int HP = 100;
    int Timer = 0;
    
    public void colider(){
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
            dropitem();
            getWorld().removeObject(this);
            Greenfoot.playSound("ruined1.wav");
        }
        if(Timer >= 2000){
            getWorld().removeObject(this);
        }
    }
    
    public void dropitem()  {
        int prob = Greenfoot.getRandomNumber(2);
        int xpos = getX();
        int ypos = getY();
        
        if(prob == 0){
            potion potion = new potion();
            getWorld().addObject(potion, xpos, ypos-20);
        }
        else if(prob == 1){
            bullet bullet = new bullet();
            getWorld().addObject(bullet, xpos, ypos-20);
        }
    }
}