import greenfoot.*;

public class p2 extends Actor
{
    public p2(int newSpeed, int newMaxHP, int newMaxHungry, int newBulletCapacity, int newResource){
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
        p2HP.checkHP(maxHP, currentHP);
        p2Bullet.checkBullet(bulletCapacity);
        p2Hungry.checkHungry(maxHungry, currentHungry);
        p2Resource.checkResource(resource);
        die();
    }  
    
    private void move(){
        int xpos = this.getX();
        int ypos = this.getY();
        
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("up")){
                if(direction == 1){
                    ypos -= speed;
                    beHunger();
                }
                else{
                    direction = 1;
                }  
            }
            if(Greenfoot.isKeyDown("down")){
                if(direction == 3){
                    ypos += speed;
                    beHunger();
                }
                else{
                    direction = 3;
                }
            }
            if(Greenfoot.isKeyDown("left")){
                if(direction == 4){
                    xpos -= speed;
                    beHunger();
                }
                else{
                    direction = 4;
                }
            }
            if(Greenfoot.isKeyDown("right")){
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
            if(Greenfoot.isKeyDown(".")){     
                if(bulletCapacity >= 1){
                    bullet2 bullet2 = new bullet2(direction);
                    getWorld().addObject(bullet2, xpos,ypos);
                    bulletCapacity--;
                }
                Greenfoot.playSound("laser1.wav");
            }
        }
    }
    
    private void stab(){
        int xpos = this.getX();
        int ypos = this.getY();
        
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown(",")){
                if(direction == 1){
                    staff2 staff2 = new staff2();
                    getWorld().addObject(staff2, xpos, ypos-20);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 2){
                    staff2 staff2 = new staff2();
                    getWorld().addObject(staff2, xpos+20, ypos);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 3){
                    staff2 staff2 = new staff2();
                    getWorld().addObject(staff2, xpos, ypos+20);
                    Greenfoot.playSound("laser1.wav");
                }
                else if(direction == 4){
                    staff2 staff2 = new staff2();
                    getWorld().addObject(staff2, xpos-20, ypos);
                    Greenfoot.playSound("laser1.wav");
                }
            }
        }
    }
    
    private void build(){
        int xpos = this.getX();
        int ypos = this.getY();
        if(Timer % exect == 0){
            if(Greenfoot.isKeyDown("/")){
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
                setImage("P2Up.png");
                break;
            case 2:
                setImage("P2Right.png");
                break;
            case 3:
                setImage("P2Down.png");
                break;
            case 4:
                setImage("P2Left.png");
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
        if(isTouching(bullet1.class)){
            removeTouching(bullet1.class);
            this.currentHP -= bullet1.damage;
            Greenfoot.playSound("hit1.wav");
        }
        if(isTouching(staff1.class)){
            removeTouching(staff1.class);
            this.currentHP -= staff1.damage;
            Greenfoot.playSound("hit1.wav");     
        }
    }    
    
    private void die(){
        if(currentHP <= 0){
            getWorld().removeObject(this);
        }
    }
}
