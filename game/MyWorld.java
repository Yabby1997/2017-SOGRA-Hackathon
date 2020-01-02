import greenfoot.*;  

public class MyWorld extends World{
    GreenfootSound BGM = new GreenfootSound("BGM.mp3");
    
    public void act(){
        Timer++;
        BGM.playLoop();
        randomChest();
    }
    int Timer = 0;
    public MyWorld()
    {    
        
        super(1600, 900, 1); 
      
        int cellLength = 20;
        
        p1 player1 = new p1(cellLength, 100, 200, 20, 5);   //speed, hp, hungry, bullet, resource
        p2 player2 = new p2(cellLength, 100, 200, 20, 5);
        
        p1HP hp1 = new p1HP();
        p1Bullet bullet1 = new p1Bullet();
        p1Hungry hungry1 = new p1Hungry();
        p1Resource resource1 = new p1Resource();
        
        p2HP hp2 = new p2HP();
        p2Bullet bullet2 = new p2Bullet();
        p2Hungry hungry2 = new p2Hungry();
        p2Resource resource2 = new p2Resource();
        
        addObject(player1, 100,100);  
        addObject(player2, 1500,620);
        
        addObject(hp1, 150, 800);
        addObject(hungry1, 150, 850);
        addObject(bullet1, 350, 800);
        addObject(resource1, 350, 850);
        
        addObject(hp2, 1250, 800);
        addObject(hungry2, 1250, 850);
        addObject(bullet2, 1450,800);
        addObject(resource2, 1450,850);
        
        
        wall1[] wall;
        wall = new wall1[1500];

        tree[] tree;
        tree = new tree[40];
        
        cow[] cow;
        cow = new cow[40];

        chest[] chest;
        chest = new chest[2];
      
        int RandomWall = Greenfoot.getRandomNumber(11) * 15 + 100;
        
        int RandomWood = Greenfoot.getRandomNumber(10) + 20;

        int RandomCow = Greenfoot.getRandomNumber(11) + 20;
        
        int RandomChest = Greenfoot.getRandomNumber(2) + 1;

        for (int i = 0; i < RandomCow; i++)   {
            cow[i] = new cow();
            addObject(cow[i], Greenfoot.getRandomNumber(79) * 20 + 20, Greenfoot.getRandomNumber(36) * 20 + 20);
        }
        
        for (int i = 0; i < RandomWall; i++)   {
            wall[i] = new wall1();
            addObject(wall[i], Greenfoot.getRandomNumber(79) * 20 + 20, Greenfoot.getRandomNumber(36) * 20 + 20);
        }
        
        for (int i = 0; i < RandomWood; i++)   {
            tree[i] = new tree();
            addObject(tree[i], Greenfoot.getRandomNumber(79) * 20 + 20, Greenfoot.getRandomNumber(36) * 20 + 20);
        }
        
        for(int i = 0; i < 80; i++) {
            wall[i] = new wall1();
            addObject(wall[i], 20*i, 0);
        }
        
        for(int i = 0; i < 80; i++) {
            wall[i] = new wall1();
            addObject(wall[i], 20*i, 900);
        }
        
        for(int i = 0; i < 45; i++) {
            wall[i] = new wall1();
            addObject(wall[i], 0, 20*i);
        }
        
        for(int i = 0; i < 46; i++) {
            wall[i] = new wall1();
            addObject(wall[i], 1600, 20*i);
        }
        
        for(int i = 0; i < 80; i++){
            wall[i] = new wall1();
            addObject(wall[i], 20*i, 740);
        }

        for(int i = 0; i < RandomChest; i++){
            chest[i] = new chest();
            addObject(chest[i], Greenfoot.getRandomNumber(79) * 20 + 20, Greenfoot.getRandomNumber(36) * 20 + 20);
        }        
    }
    
    public void randomChest()   {
        int rand = Greenfoot.getRandomNumber(2) + 1;
        
        if(Timer % 2000 == 0)   {
            chest[] chest;
            chest = new chest[2];
            for(int i = 0; i < rand; i++){
                chest[i] = new chest();
                addObject(chest[i], Greenfoot.getRandomNumber(79) * 20 + 20, Greenfoot.getRandomNumber(36) * 20 + 20);
            }
        }
    }
}
