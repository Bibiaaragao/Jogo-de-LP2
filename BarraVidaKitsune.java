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
        // Aqui você pode desenhar a barra de vida
        GreenfootImage img = new GreenfootImage(100, 10); // Por exemplo, uma barra de 100x10 pixels
        img.setColor(Color.RED); // Cor da barra
        img.fillRect(0, 0, vida, 10); // Preenche a barra com a vida
        setImage(img);
    }
    
    
}
