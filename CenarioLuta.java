import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class cenarioLuta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CenarioLuta extends World {
    private KitsuneLuta kitsuneLuta;
    public BracoEspada bracoEspada;
    private int numeroDeEsqueletos = 20; 
    private int contagemEsqueletos = 0; 
    private int intervaloEsqueletos = 120; // Intervalo de 2 segundos (120 frames)
    private int temporizadorEsqueletos = 0;
    private int alturaEsqueleto = 300; // Coordenada Y fixa para os esqueletos
    private int limiteAranhas = 4; // Limite máximo de aranhas simultâneas
    private int intervaloAranhas = 120; 
    private int temporizadorAranhas = 0;

    public CenarioLuta() {
        super(600, 400, 1);
        kitsuneLuta = new KitsuneLuta();
        bracoEspada = new BracoEspada();
        addObject(kitsuneLuta, 100, 285); 
        addObject(bracoEspada, 138, 345);
        adicionarEsqueleto(); 
    }

    public void act() {
        temporizadorEsqueletos++;
        temporizadorAranhas++;

        // Verifica se é hora de criar um novo esqueleto e se ainda pode criar mais
        if (temporizadorEsqueletos >= intervaloEsqueletos && contagemEsqueletos < numeroDeEsqueletos) {
            adicionarEsqueleto();
            contagemEsqueletos++; 
            temporizadorEsqueletos = 0; // Reseta o temporizador
        }

        // Verifica se é hora de criar uma nova aranha, respeitando o limite
        if (temporizadorAranhas >= intervaloAranhas && getObjects(Aranhas.class).size() < limiteAranhas) {
            adicionarAranha();
            temporizadorAranhas = 0; // Reseta o temporizador para aranhas
        }

        // Verifica se a Kitsune ainda está no mundo
        if (getObjects(KitsuneLuta.class).isEmpty()) {
            return; 
        }
        
        if (kitsuneLuta.getWorld() == null || kitsuneLuta.getVida() <= 0) {
            gameOver(); 
        }
        
        if (getObjects(Esqueleto.class).isEmpty()) {
            mudarParaSegundaCatacumba();
        }
    }

    public void adicionarEsqueleto() {
        Esqueleto esqueleto = new Esqueleto();
        int larguraMundo = getWidth(); // Obtém a largura do mundo (limite direito)

        // Adiciona o esqueleto ao mundo
        addObject(esqueleto, larguraMundo + esqueleto.getImage().getWidth() / 2, alturaEsqueleto);

        // Agdicionar a barra de vida
        addObject(esqueleto.getBarraVida(), esqueleto.getX(), esqueleto.getY() - (esqueleto.getImage().getHeight() / 2) - 10);
    }

    public void adicionarAranha() {
        Aranhas aranha = new Aranhas();
        addObject(aranha, Greenfoot.getRandomNumber(getWidth()), 0); // Aranha aparece no topo
    }

    public void gameOver() {
        setBackground("gameOver.jpeg");

        // Remove todos os objetos da classe Spider e KitsuneLuta
        KitsuneLuta kitsune = (KitsuneLuta) getObjects(KitsuneLuta.class).get(0);
        if (kitsune != null) {
            // Remove a Kitsune do mundo
            removeObject(kitsune);
        }
        removeObjects(getObjects(Aranhas.class));
        removeObjects(getObjects(BracoEspada.class));
        List<Esqueleto> esqueletos = getObjects(Esqueleto.class);
        for (Esqueleto esqueleto : esqueletos) {
            BarraVidaEsqueleto barraVida = esqueleto.getBarraVida();
            if (barraVida != null) {
                removeObject(barraVida); // Remove a barra de vida se existir
            }
            removeObject(esqueleto); // Remove o esqueleto
        }

        Greenfoot.stop();
    }
    
    private void mudarParaSegundaCatacumba() {
        Greenfoot.setWorld(new SegundaCatacumbas()); 
    }
    
}
