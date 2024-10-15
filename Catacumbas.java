import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Catatumbas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Catacumbas extends MyWorld {
    private int etapaDialogo = 0;
    private int etapaSegundoDialogo = 0; 
    private int cenarioCatacumba = 0;
    private boolean aguardandoResposta = false; 

    public Catacumbas() {    
        super(); 
        prepare();
    }
    
    public void prepare() {
        Kitsune4 kitsune4 = new Kitsune4();  
        addObject(kitsune4, 125, 251);    
        iniciarDialogo(); 
    }
    
    public void iniciarDialogo() {
        switch (etapaDialogo) {
            case 0:
                caixa1.setTexto("Kitsune: Aqui é mais assustador ainda, cara! (clique aqui para avançar)");
                break;
            case 1:
                caixa1.setTexto("Voz Misteriosa: Você chegou às catacumbas do castelo, jovem. (clique aqui para avançar)");
                break;
            case 2:
                caixa1.setTexto("Kitsune: Será que fiz uma boa escolha? (clique aqui para avançar)");
                break;
            case 3:
                caixa1.setTexto("Voz Misteriosa: Se fez, não sei. Mas agora terá que ir até o fim. (clique aqui para avançar)");
                break;
            case 4:
                caixa1.setTexto("Kitsune: Você está certo, não posso mais voltar atrás. (clique aqui para avançar)");
                break;
            case 5:
                caixa1.setTexto("Voz Misteriosa: Me ouça, te darei duas opções: Lutar ou esconder-se! (clique aqui para avançar)");
                break;
            case 6:
                apresentarOpcoes(); 
                return; 
        }
        etapaDialogo++; 
        Greenfoot.delay(100); 
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(null)) { 
                if (etapaDialogo < 7) { 
                    iniciarDialogo(); 
                }
            
        }
        
    }
    
    public void apresentarOpcoes() {
        caixa1.setTexto("O que você escolhe?");
        Botao botaoLutar = new Botao("Lutar");
        Botao botaoEsconder = new Botao("Esconder-se");

        addObject(botaoLutar, getWidth() / 2 - 100, getHeight() - 50);
        addObject(botaoEsconder, getWidth() / 2 + 100, getHeight() - 50);

        // Atribuir as ações para os botões
        botaoLutar.setOnClick(() -> escolherLutar());
        botaoEsconder.setOnClick(() -> escolherSeEsconder());
    }
    
    public void escolherLutar() {
        caixa1.setTexto("Você escolheu lutar! Prepare-se para a batalha.");
        Greenfoot.delay(100); 
        mudarParaCenarioLuta(); 
    }

    public void escolherSeEsconder() {
        caixa1.setTexto("Você escolheu esconder-se!");
        Greenfoot.delay(100); 
        iniciarCenarioEsconder();
    }
    
    public void mudarParaCenarioLuta() {
        Greenfoot.setWorld(new CenarioLuta());
    }
    
    public void iniciarCenarioEsconder() {
        Greenfoot.setWorld(new CenarioEsconder());
    }
}
