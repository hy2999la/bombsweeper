import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class bombTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bombTiles extends Actor
{
    public void act() 
    {
        if (getWorld()!=null) {
            World world = getWorld();
            if(!isTouching(flag.class)&&Greenfoot.mouseClicked(this)) {
                if (Greenfoot.isKeyDown("shift")) {
                    Level.bombFlagged();
                } else {
                    getWorld().removeObjects(getWorld().getObjects(bombTiles.class));
                    world.addObject(new lost(),(world.getWidth()/2),(world.getHeight()/2));
                    Greenfoot.stop();
                }
            }
        }
    }
}
