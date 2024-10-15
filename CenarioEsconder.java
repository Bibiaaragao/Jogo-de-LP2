import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cenarioEsconder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CenarioEsconder extends MyWorld
{
    private int etapaDialogo = 0;
    /**
     * Constructor for objects of class cenarioEsconder.
     * 
     */
    public CenarioEsconder()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(); 
        prepare();
    }
    
    public void prepare(){
        Kitsune6 kitsune6 = new Kitsune6();  // Cria uma nova instância de Kitsune4
        addObject(kitsune6, 125, 251);    
        
        iniciarDialogo();
    }
    
    public void iniciarDialogo() {
        switch (etapaDialogo) {
            case 0:
                caixa1.setTexto("Voz misteriosa: você deve procurar um lugar logo, antes que aquilo aconteça... \n      (clique aqui para avançar)");
                break;
            case 1:
                caixa1.setTexto("Kitsune: Aquilo o que?              (clique aqui para avançar)");
                break;
            case 2:
                caixa1.setTexto("Voz misteriosa: Apenas esconda-se logo!          (clique aqui para avançar)");
                break;
            case 3:
                caixa1.setTexto("Kitsune: Estou prcurando, mas não encontro...      (clique aqui para avançar)");
                break;
            case 4:
                caixa1.setTexto("Kitsune: Achei! Aquele caixão aberto parece ser o melhor lugar.         (clique aqui para avançar)");
                break;
            case 5:
                caixa1.setTexto("Voz Misteriosa: Então vá, apressse-se!     (clique aqui para avançar)");
                break;
            case 6: // Após o diálogo, aparecem os botões
                return; // Saímos do switch para evitar outro incremento
        }
        etapaDialogo++; // Progredir para a próxima parte do diálogo
        Greenfoot.delay(100); // Pausa para dar tempo ao jogador de ler
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(null)) { // Verifica se houve um clique do mouse em qualquer lugar
            iniciarDialogo(); // Avança o diálogo
        }
    }
    
    public void dentroCaixao() {
        Greenfoot.setWorld(new TelaPreta()); // Muda para a tela preta
    }
}
