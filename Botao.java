import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botao extends Actor {
    private String texto;
    private Runnable acao; 
    public Botao(String texto) {
        this.texto = texto;
        setImage(new GreenfootImage(texto, 24, Color.WHITE, Color.BLACK)); 
    }

    public void setOnClick(Runnable acao) {
        this.acao = acao; 
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) { 
            if (acao != null) {
                acao.run(); 
            }
        }
    }
}







