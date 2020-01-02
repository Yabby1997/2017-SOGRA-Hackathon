import greenfoot.*;

public class bullet2 extends Actor
{
    int speed = 10;
    int direction;
    public static int damage = 10;
    
    public bullet2(int direction)  {
        this.direction = direction;
    }
   
    public void act() 
    {
        int xpos = this.getX();
        int ypos = this.getY();
        
        if(direction == 1)  {
            ypos -= speed;
        }
        else if(direction == 2)  {
            xpos += speed;
        }
        else if(direction == 3)  {
            ypos += speed;
        }
        else if(direction == 4)  {
            xpos -= speed;
        }
        
        
        if(ypos <= 0 || ypos >= 900 || xpos <= 0 || xpos >= 1600){
            getWorld().removeObject(this);
        }
        setLocation(xpos, ypos);
    }    
}
