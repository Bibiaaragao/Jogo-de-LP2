import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta extends Actor
{
   private int valor;
    private boolean revelada = false; 

    public Carta(int valor) {
        this.valor = valor;
        setImage("cartaVerso.jpeg"); 
    }

    public int getValor() {
        return valor;
    }

    public void virarCarta() {
        revelada = true;
        setImage("cartaFrente" + valor + ".jpeg"); 
    }

    public void esconderCarta() {
        revelada = false;
        setImage("cartaVerso.jpeg"); 
    }
    
    public boolean estaRevelada() {
        return revelada;
    }

    public void act() {
        if (Greenfoot.mouseClicked(this) && !revelada) {
            ((HallEntrada)getWorld()).selecionarCarta(this); 
        }
    }
}
