import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The level world for the game bomb sweeper.
 * 
 * @author Anson L
 * @version Mar 2017
 */
public class Level extends World
{
    boolean[][] bombfield;
    public static int[][] board;

    public static int counter = 0;

    public int bombAmount = 0;
    
    //public int row = 10;
    //public int col = 10;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level(int row, int col, int bombCount)
    {
        super(row+2,col+4,20);
        bombfield = new boolean[row][col];
        board = new int[row][col];
        bombAmount = bombCount;
        prepare();
    }

    public void prepare(){
        randomBombGen();
        numsForBomb();
        setBackground("background.png");
        displayTiles();
    }

    public void act() {
        flags();
        winCheck();
    }

    public void randomBombGen(){
        Random rng = new Random();
        int rngesus;
        while (counter < bombAmount) {
            for(int i = 0;i<bombfield.length;i++) {
                for (int j = 0;j<bombfield[i].length;j++) {
                    rngesus = rng.nextInt(16);
                    if (rngesus == 2) {
                        bombfield[i][j]=true;
                        counter++;
                        System.out.print(i);
                        System.out.print(" ");
                        System.out.println(j);
                    }
                }
            }
        }
    }

    public void numsForBomb() {
        int starty = 0;
        int startx = 0;
        int endy = 0;
        int endx = 0;
        for (int i = 0;i<board.length;i++) {
            for (int j = 0;j<board[i].length;j++) {
                if (bombfield[i][j]){
                    board[i][j]=-1;
                    if (i>0){
                        starty=-1;
                    }
                    if (i<bombfield.length-1){
                        endy=1;
                    }
                    if (j>0) {
                        startx=-1;
                    }
                    if(j<bombfield[i].length-1){
                        endx=1;
                    }

                    for(int y=starty;y<=endy;y++) {
                        for(int x=startx;x<=endx;x++) {
                            if (board[i+y][j+x]!=-1)
                                board[i+y][j+x]=board[i+y][j+x]+1;
                        }
                    }
                    starty = 0;
                    startx = 0;
                    endy = 0;
                    endx = 0;
                }
            }
        }
    }

    public void displayTiles() {
        for (int i = 0;i<board.length;i++) {
            for (int j = 0;j<board[i].length;j++) {
                if (board[i][j]!=-1) {
                    numTile tile = new numTile(i,j);
                    addObject(new numTile(i,j),1+i,3+j);
                    addObject(new tiles(),1+i,3+j);
                } else {
                    addObject(new bomb(),1+i,3+j);
                    addObject(new bombTiles(),1+i,3+j);
                }
            }
        }
    }

    public void flags(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.isKeyDown("shift")) {
            if (Greenfoot.mouseClicked(null)) {
                if (mouse.getX()>=1&&mouse.getX()<=this.getWidth()-1&&mouse.getY()>=3&&mouse.getY()<=this.getHeight()-1) {
                    addObject(new flag(),mouse.getX(),mouse.getY());
                }
            }
            //             if (Greenfoot.mouseClicked(this.getObjects(bombTiles.class))) {
            //                 if (mouse.getX()>=1&&mouse.getX()<=this.getWidth()-1&&mouse.getY()>=3&&mouse.getY()<=this.getHeight()-1) {
            //                     addObject(new flag(),mouse.getX(),mouse.getY());
            //                     counter--;
            //                 }
            //             }
        }
    }

    public void winCheck() {
        if (counter <= 0) {
            System.out.println("You Win!");
            Greenfoot.stop();
        }
    }

    public static void bombFlagged() {
        counter--;
    }
}
