import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kitsune5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kitsune5 extends Actor
{
    private boolean noLimiteDireito = false;
    /**
     * Act - do whatever the Kitsune5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        mover();
    }
    
    public void mover(){
         if (!noLimiteDireito) {
            if (Greenfoot.isKeyDown("Right")) { 
                setLocation(getX() + 5, getY());
            } else if (Greenfoot.isKeyDown("Left")) { 
                setLocation(getX() - 5, getY());
            }
        }
    }
}
