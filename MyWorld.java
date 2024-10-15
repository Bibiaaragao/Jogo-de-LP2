import greenfoot.*;  

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    protected CaixaTexto1 caixa1;
    private int cenario = 1;
    private Actor imagem;
    protected Kitsune kitsune1;
    private Kitsune2 kitsune2;
    private Kitsune3 kitsune3;
    private boolean enigmaMostrado;
    private boolean perguntaFeita = false;
    private int texto = 0;
    private int dialogo2Etapa;
    private GreenfootSound backgroundMusic = new GreenfootSound("musicaJogo1.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
        caixa1 = new CaixaTexto1();
        addObject(caixa1, 300, 50);

        caixa1.setTexto("O personagem, uma kitsune das lendas, com 9 caudas, orelhas de raposa, anda pela floresta. Até que..."); 
        prepare();
        backgroundMusic.playLoop();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    public void prepare()
    {
        Kitsune kitsune1 = new Kitsune();
        addObject(kitsune1,125,251);
        kitsune1.setLocation(96,263);
        kitsune1.setLocation(111,274);

    }
    
    public void act(){
        if (Greenfoot.mouseClicked(null)) {  
            if (!perguntaFeita && enigmaMostrado) { 
                fazerPergunta(); 
                perguntaFeita = true; 
            } else if (cenario == 3){
                avancarDialogo(); 
            } else if (dialogo2Etapa == 1) {
                caixa1.setTexto("- Pode seguir em frente para começar o jogo - diz a voz misteriosa.");
                dialogo2Etapa++;  
            }
        }
    }
    
    
    public int getCenario() {
        return cenario;
    }
    
    public void mudarSegundoCenario()
    {
        removeObject(kitsune1);
        cenario = 2;
        
        removeObject(caixa1);
        setBackground("imagemDeFundo2.jpeg");
        caixa1 = new CaixaTexto1();
        addObject(caixa1, 300, 50);
        caixa1.setTexto("- Wow! Que castelo maneiro! Que tal dar uma olhadinha?");
        
        Kitsune2 kitsune2 = new Kitsune2(); 
        addObject(kitsune2, 125, 251); 
        
    }
    
     public void adicionarImagem() {
        removeObject(kitsune2);
        removeObject(caixa1); 

        imagem = new Actor() {}; 
        imagem.setImage(new GreenfootImage("enigmaJogo1.png"));
    
        addObject(imagem, getWidth() / 2, getHeight() / 2);
        
        Kitsune3 kitsune3 = new Kitsune3(); 
            addObject(kitsune3, 559, 251); 
            
        caixa1 = new CaixaTexto1();
        addObject(caixa1, 300, 50);
        caixa1.setTexto("ENIGMA: Eu sou leve como uma pena, mas mesmo a pessoa mais forte não consegue me segurar por \nmuito tempo. O que sou?");
        
        showText("Clique para responder", 300, 350);
        
        enigmaMostrado = true;
    }  

    public void fazerPergunta() {
        showText("", 300, 350);
        
        int tentativasErradas = 0;
    
        String resposta = Greenfoot.ask("Qual é a resposta?");
        
        while (!resposta.equalsIgnoreCase("Respiração")) {
            tentativasErradas++; 
    
            if (tentativasErradas >= 3) {
                showText("Dica: É algo que você faz constantemente para sobreviver!", 300, 200);
                Greenfoot.delay(200); 
            } else {
                showText("Resposta incorreta! Tente novamente.", 300, 200);
                Greenfoot.delay(200); 
            }
    
            resposta = Greenfoot.ask("Qual é a sua resposta?");
        }
    
        terceiroCenario(); 
    }
  

    public void terceiroCenario() {
        cenario = 3;
        
        removeObject(caixa1);
        removeObject(imagem);
        setBackground("terceiroCenario.jpeg");
        
        for (Kitsune3 kitsune : getObjects(Kitsune3.class)) {
            kitsune.removerMudarCenario(); 
        }
         
        Kitsune2 kitsune2a = new Kitsune2();
        addObject(kitsune2a, 125, 251); 
        
        caixa1 = new CaixaTexto1();
        addObject(caixa1, 300, 50);
        caixa1.setTexto("- Isso aí! Não foi tão difícil assim. \nReparando bem, esse castelo parece ser enorme, não terá problema explorar um pouco, certo?"); 
        
        showText("Parabéns! Você acertou!", 300, 200);
        Greenfoot.delay(100);
        showText("", 300, 200);
        
        caixa1.setTexto("Kitsune: Isso aí! Não foi tão difícil assim.                 (clique aqui para passar o diálogo)\nReparando bem, esse castelo parece ser enorme, não terá problema explorar um pouco, certo?");
    
        texto = 0; 
    }
    
    public void avancarDialogo() {
    switch(texto) {
        case 0:
            caixa1.setTexto("Voz Misteriosa: Na verdade, terá um problema, sim.                  (clique aqui para passar o diálogo) \nVocê precisa passar por alguns desafios... - diz a mesma voz misteriosa");
            break;
        case 1:
            caixa1.setTexto("Kitsune: De novo? O que ganharei depois de tudo isso?        (clique aqui para passar o diálogo)");
            break;
        case 2:
            caixa1.setTexto("Voz Misteriosa: Um tesouro.                                         (clique aqui para passar o diálogo)");
            break;
        case 3:
            caixa1.setTexto("Kitsune: SÉRIO? Então me explique quais são esses desafios.   (clique aqui para passar o diálogo)");
            break;
        case 4:
            caixa1.setTexto("Voz Misteriosa: Direi apenas o primeiro. Será um jogo da memória,    (clique aqui para passar o diálogo)\nmas cuidado, há um número fixo de tentativas.");
            break;
        case 5:
            caixa1.setTexto("Kitsune: Um jogo da memória não pode ser tão difícil assim,   (clique aqui para passar o diálogo) \nmas o que acontecerá se eu errar mais que o limite?");
            break;
        case 6:
            caixa1.setTexto("Voz Misteriosa: Um péssimo futuro estará a sua espera...             (clique aqui para passar o diálogo)");
            break;
        case 7:
            caixa1.setTexto("Kitsune: Hummm... Creio que não será tão difícil.             (clique aqui para passar o diálogo)\nAceitarei sua proposta.");
            break;
        case 8:
            caixa1.setTexto("Voz Misteriosa: Ok, saiba que não poderá desistir depois de começar.  (clique aqui para passar o diálogo)");
            break;
        case 9:
            caixa1.setTexto("Kitsune: Entendido.");
            break;
        default:
            break;
    }
    texto++;  
}
    
    public void quartoCenario(){
        cenario = 4;
        
        removeObject(caixa1);
        
        setBackground("quartoCenario.jpeg");
        
        Kitsune4 kitsune4 = new Kitsune4();
        addObject(kitsune4, 125, 251);
        
        caixa1 = new CaixaTexto1();
        addObject(caixa1, 300, 50);
        caixa1.setTexto("Kitsune: Aqui é um pouquinho assustador, não é?                  (clique aqui para passar o diálogo)\n Será que há fantasmas por aqui?");
        
        dialogo2Etapa = 1;
    }
    
    public void mudarParaHallEntrada() {
        cenario = 5;
        removeObject(caixa1);
        setBackground("quintoCenario.jpeg"); 
    
        HallEntrada hallEntrada = new HallEntrada();
        Greenfoot.setWorld(hallEntrada);
    }
}
