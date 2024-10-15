import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CaixaTexto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaixaTexto1 extends Actor
{
    /**
     * Act - do whatever the CaixaTexto1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String texto;
    public CaixaTexto1() {
        texto = "";
        atualizarImagem(); 
    }
    
    public void setTexto(String novoTexto) {
        this.texto = novoTexto;
        atualizarImagem();
    }
    
    private void atualizarImagem() {
        GreenfootImage imagem = new GreenfootImage(580, 50); 
        imagem.setColor(Color.WHITE); 
        imagem.fill(); 
        imagem.setColor(Color.BLACK);
        imagem.drawString(texto, 5, 25); 
        setImage(imagem); 
    }
    public void act()
    {
        // Add your action code here.
    }
}
