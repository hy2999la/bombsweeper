import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class numTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class numTile extends Actor
{
    int i,j;
    public numTile(int i,int j) {
        this.i = i;
        this.j = j;
        setImage(Integer.toString(Level.board[i][j])+".png");
    }
    public void act() 
    {
    }    
}
