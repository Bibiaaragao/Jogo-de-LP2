import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TelaPreta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TelaPreta extends MyWorld
{

    /**
     * Constructor for objects of class TelaPreta.
     * 
     */
    private int etapaDialogo = 0;

    public TelaPreta() {
        super(); 
        GreenfootImage background = new GreenfootImage(600, 400); 
        background.setColor(Color.BLACK);
        background.fill(); // Preenche a tela com preto
        setBackground(background);
        
        iniciarDialogo();
    }

    public void iniciarDialogo() {
        switch (etapaDialogo) {
            case 0:
                caixa1.setTexto("Kitsune: Consegui me esconder, mas aqui é bem abafado!\n Espera! A tampa não tá saindo!"); 
                break;
            case 1:
                caixa1.setTexto("Kitsune: E agora? O que faço???");
                break;
            case 2:
                caixa1.setTexto("Voz Misteriosa: Não há mais o que fazer... O jogo acabou.");
                break;
            case 3:
                gameOver(); 
                return;
        }
        etapaDialogo++; 
        Greenfoot.delay(100); 
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            iniciarDialogo(); 
        }
    }

    public void gameOver() {
        setBackground("gameOver.jpeg");
    }
}
