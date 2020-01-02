import greenfoot.*;

public class p1 extends Actor
{
    public p1(int newSpeed, int newMaxHP, int newMaxHungry, int newBulletCapacity, int newResource){
        this.speed = newSpeed;
        this.maxHP = newMaxHP;
        this.maxHungry = newMaxHungry;
        this.currentHP = this.maxHP;
        this.bulletCapacity = newBulletCapacity;
        this.resource = newResource;
    }
    
    int speed;
    int maxHP, currentHP;
    int maxHungry;
    int currentHungry = 0;
    int bulletCapacity;
    static int resource;
    
    int Timer = 0;
    int exect= 10;
    
    int direction = 2;
    
    public void act(){
        Timer++;
        move();
        changeSprite();
        stuckByStoneWall();
        stuckByWoodenWall();
        fire();
        stab();
        build();
        hit();
        hungry();
        eatMeat();
        drinkPotion();
        reload();
        p1HP.checkHP(maxHP, currentHP);
        p1Bullet.checkBullet(bulletCapacity);
        p1Hungry.checkHungry(maxHungry, currentHungry);
        p1Resource.checkResource(resource);
        die();
    }  
    
    private void move(){
        int xpos = this.getX();
        int ypos = this.getY();
        
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("w")){
                if(direction == 1){
                    ypos -= speed;
                    beHunger();
                }
                else{
                    direction = 1;
                }  
            }
            if(Greenfoot.isKeyDown("s")){
                if(direction == 3){
                    ypos += speed;
                    beHunger();
                }
                else{
                    direction = 3;
                }
            }
            if(Greenfoot.isKeyDown("a")){
                if(direction == 4){
                    xpos -= speed;
                    beHunger();
                }
                else{
                    direction = 4;
                }
            }
            if(Greenfoot.isKeyDown("d")){
                if(direction == 2){
                    xpos += speed;
                    beHunger();
                }
                else{
                    direction = 2;
                }
            }
        }
        setLocation(xpos, ypos);
    }
    
    private void fire(){
        int xpos = this.getX();
        int ypos = this.getY();
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("g")){     
                if(bulletCapacity >= 1){
                    bullet1 bullet1 = new bullet1(direction);
                    getWorld().addObject(bullet1, xpos,ypos);
                    bulletCapacity--;
                    Greenfoot.playSound("laser1.wav");
                }
            }
        }
    }

        private void stab(){
        int xpos = this.getX();
        int ypos = this.getY();
        
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("f")){
                if(direction == 1){
                    staff1 staff1 = new staff1();
                    getWorld().addObject(staff1, xpos, ypos-20);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 2){
                    staff1 staff1 = new staff1();
                    getWorld().addObject(staff1, xpos+20, ypos);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 3){
                    staff1 staff1 = new staff1();
                    getWorld().addObject(staff1, xpos, ypos+20);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 4){
                    staff1 staff1 = new staff1();
                    getWorld().addObject(staff1, xpos-20, ypos);
                    Greenfoot.playSound("laser1.wav");
                }
            }
        }
    }
    
    private void build(){
        int xpos = this.getX();
        int ypos = this.getY();
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("h")){
                if(resource >= 1){
                    if(direction == 1){
                        wall2 woodWall1 = new wall2();
                        getWorld().addObject(woodWall1, xpos, ypos-20);
                    }
                    else if(direction == 2){
                        wall2 woodWall2 = new wall2();
                        getWorld().addObject(woodWall2, xpos+20, ypos);
                    }
                    else if(direction == 3){
                        wall2 woodWall3 = new wall2();
                        getWorld().addObject(woodWall3, xpos, ypos+20);
                    }
                    else if(direction == 4){
                        wall2 woodWall4 = new wall2();
                        getWorld().addObject(woodWall4, xpos-20, ypos);
                    }
                    resource --;
                    Greenfoot.playSound("build1.wav");
                }
            }
        }
    }
   
    private void changeSprite(){
        switch(direction){
            case 1:
                setImage("P1Up.png");
                break;
            case 2:
                setImage("P1Right.png");
                break;
            case 3:
                setImage("P1Down.png");
                break;
            case 4:
                setImage("P1Left.png");
                break;
        }
    }
    
    private void stuckByStoneWall(){
        int xpos = this.getX();
        int ypos = this.getY();
        if(isTouching(wall1.class)){
            if(direction == 1){
                ypos += speed;
            }
            else if(direction == 2){
                xpos -= speed;
            }
            else if(direction == 3){
                ypos -= speed;
            }
            else if(direction == 4){
                xpos += speed;
            }
            Greenfoot.playSound("denied1.wav");
            setLocation(xpos, ypos);
        }
    }
    
    private void stuckByWoodenWall(){
        int xpos = this.getX();
        int ypos = this.getY();
        if(isTouching(wall2.class)){
            if(direction == 1){
                ypos += speed;
            }
            else if(direction == 2){
                xpos -= speed;
            }
            else if(direction == 3){
                ypos -= speed;
            }
            else if(direction == 4){
                xpos += speed;
            }
            Greenfoot.playSound("denied1.wav");
            setLocation(xpos, ypos);
        }
    }
    
    private void beHunger(){
        if(currentHungry < maxHungry){
            currentHungry++;
        }
    }
    
    private void hungry(){
        if(currentHungry >= 100 && Timer % 100 == 0){
            currentHP--;
        }
        else if (currentHungry == 200 && Timer % 50 == 0){
            currentHP--;
        }
    }
    
    private void eatMeat(){
        if(isTouching(meat.class)){
            int amount = Greenfoot.getRandomNumber(25)+25;
            
            removeTouching(meat.class);
            if(currentHungry - amount >= 0){
                currentHungry -= amount;
            }
            else{
                currentHungry = 0;
            }
            Greenfoot.playSound("meat1.wav");
        }
    }
    
    private void drinkPotion(){
        if(isTouching(potion.class)){
            int amount = Greenfoot.getRandomNumber(30)+20;
            
            removeTouching(potion.class);
            
            if(currentHP + amount >= maxHP){
                currentHP = maxHP;
            }
            else{
                currentHP+=amount;
            }
        }
    }
    
    private void reload(){
        if(isTouching(bullet.class)){
            int amount = Greenfoot.getRandomNumber(15)+15;
            
            removeTouching(bullet.class);
            bulletCapacity += amount;
            Greenfoot.playSound("bullet1.wav");
        }
    }
    
    private void hit(){
        if(isTouching(bullet2.class)){
            removeTouching(bullet2.class);
            this.currentHP -= bullet2.damage;
            Greenfoot.playSound("hit1.wav");     
        }
        if(isTouching(staff2.class)){
            removeTouching(staff2.class);
            this.currentHP -= staff2.damage;
            Greenfoot.playSound("hit1.wav");     
        }
    }
    
    private void die(){
        if(currentHP <= 0){
            getWorld().removeObject(this);
        }
    }
}
