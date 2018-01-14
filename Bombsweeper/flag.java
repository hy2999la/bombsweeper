import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class flag extends Actor
{
    /**
     * Act - do whatever the flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Greenfoot.isKeyDown("shift")&&
        if (Greenfoot.mouseClicked(this)&&Greenfoot.isKeyDown("shift")) {
            getWorld().removeObject(this);
        }
    }    
}
