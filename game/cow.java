import greenfoot.*;

public class cow extends Actor
{   
    public void act() 
    {
        Timer++;
        colider();
        randomMove();
        ruin();
    }
    
    int HP = 60;
    int Timer = 0;
    
    public void colider(){
        if(isTouching(bullet1.class)){
            removeTouching(bullet1.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav");
            this.dropItem();
        }
        if(isTouching(bullet2.class)){
            removeTouching(bullet2.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
            this.dropItem();
        }
        if(isTouching(staff1.class)){
            removeTouching(staff1.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav");
            this.dropItem();
        }
        if(isTouching(staff2.class)){
            removeTouching(staff2.class);
            this.HP-=10;
            Greenfoot.playSound("hit1.wav"); 
            this.dropItem();
        }
    }
    
    public void ruin(){
        if(this.HP == 0){
            getWorld().removeObject(this);
            Greenfoot.playSound("ruined1.wav");
        }
    }
    
    public void dropItem()  {
        int prob = Greenfoot.getRandomNumber(2);
        int xpos = getX();
        int ypos = getY();
        
        if(prob == 0)   {
            meat meat = new meat();
            getWorld().addObject(meat, xpos, ypos);
        }
    }
    
    public void randomMove()    {
        int rand = Greenfoot.getRandomNumber(4) + 1;
        int xpos = getX();
        int ypos = getY();
        
        if (Timer % 75 == 0)   {
            switch(rand)    {
                case 1:
                ypos -= 20;
                break;
                
                case 2:
                xpos += 20;
                break;
                
                case 3:
                if(ypos > 20 && ypos < 720)   {
                    ypos += 20;
                }
                break;
                
                case 4:
                xpos -= 20;
                break;
            }
            setLocation(xpos, ypos);
        }
    }
}