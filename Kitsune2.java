import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kitsune2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kitsune2 extends Actor
{
    private boolean noLimiteDireito = false;
    /**
     * Act - do whatever the Kitsune2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public boolean isInWorld() {
        return this.getWorld() != null; 
    }
    
    public void act()
    {
        mover();
        if (((MyWorld)getWorld()).getCenario() == 2) {
            if (getX() >= getWorld().getWidth() / 2) {
                ((MyWorld)getWorld()).adicionarImagem(); 
                Greenfoot.delay(1); 
                getWorld().removeObject(this);
            }
        }
        if (this.getWorld() != null) { 
            int x = this.getX();
            int y = this.getY();
            
            verificarLimite();
            
        }
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
    
    private void verificarLimite()
    {   
        if (!isInWorld()) return;
        
        if (getX() >= getWorld().getWidth() - 1) {
            ((MyWorld)getWorld()).quartoCenario(); 
            getWorld().removeObject(this); 
        }
        
    }

}
