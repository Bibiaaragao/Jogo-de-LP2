import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aranhas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aranhas extends Actor
{
    public void act(){
        setLocation(getX(), getY() + 1);  // Faz a aranha cair lentamente
            if (getY() >= getWorld().getHeight() - 1) {
                getWorld().removeObject(this);  // Remove a aranha se ela tocar o chão
            }
    }
}
