import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tiles extends Actor
{
    /**
     * Act - do whatever the tiles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!isTouching(flag.class)) {
            if (Greenfoot.mouseClicked(this)&&!Greenfoot.isKeyDown("shift")){
                getWorld().removeObject(this);
                return;
            }
        }    
    }
}
