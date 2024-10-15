import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarraVidaKitsune here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarraVidaKitsune extends Actor
{
    /**
     * Act - do whatever the BarraVidaKitsune wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int vida;

    public BarraVidaKitsune(int vida) {
        this.vida = vida;
        atualizarImagem();
    }

    public void atualizarVida(int novaVida) {
        vida = novaVida;
        atualizarImagem();
    }

    private void atualizarImagem() {
        
        GreenfootImage img = new GreenfootImage(100, 10); 
        img.setColor(Color.RED); 
        img.fillRect(0, 0, vida, 10); 
        setImage(img);
    }
    
    
}
