import greenfoot.*; 
import java.util.Collections;
import java.util.ArrayList;

/**
 * Write a description of class HallEntrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HallEntrada extends World
{
    private int tentativasErradas;
    private final int maxTentativas = 10; 
    private Carta[] cartas;
    private Carta cartaSelecionada1;
    private Carta cartaSelecionada2;
    private boolean cartasEmJogo; 
    
    /**
     * Constructor for objects of class HallEntrada.
     * 
     */
    public HallEntrada() {
        super(600, 400, 1); 
        tentativasErradas = 0;  
        prepararCartas();
        atualizarTentativas();  
        cartasEmJogo = true;  
    }

    private void prepararCartas() {
        
        cartas = new Carta[16];
        ArrayList<Integer> valores = new ArrayList<>();
        
        for (int i = 1; i < 9; i++) {
            valores.add(i);
            valores.add(i);
        }

        Collections.shuffle(valores);

        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta(valores.get(i));
            int x = (i % 8) * 70 + 50; 
            int y = (i / 8) * 150 + 150; 
            addObject(cartas[i], x, y);
        }
    }

    public void act() {
        if (cartaSelecionada1 != null && cartaSelecionada2 != null) {
            verificarPar();
        }
    }

    public void selecionarCarta(Carta carta) {
        if (!cartasEmJogo) {
            return; 
        }

        if (cartaSelecionada1 == null) {
            cartaSelecionada1 = carta;
            cartaSelecionada1.virarCarta();
        } else if (cartaSelecionada2 == null && carta != cartaSelecionada1) {
            cartaSelecionada2 = carta;
            cartaSelecionada2.virarCarta();
            cartasEmJogo = false;  
            Greenfoot.delay(20); 
        }
    }

    private void verificarPar() {
        if (cartaSelecionada1.getValor() == cartaSelecionada2.getValor()) {
            removeObject(cartaSelecionada1);
            removeObject(cartaSelecionada2);
        } else {
            Greenfoot.delay(20);  
            
            cartaSelecionada1.esconderCarta();  
            cartaSelecionada2.esconderCarta();  
            
            tentativasErradas++;
            atualizarTentativas(); 
        }
    
        cartaSelecionada1 = null;
        cartaSelecionada2 = null;
    
        if (todasCartasRemovidas()) {
            proximaFase(); 
        } else if (tentativasErradas >= maxTentativas) {
            gameOver();  
        } else {
            cartasEmJogo = true;  
        }
    }

    private boolean todasCartasRemovidas() {
        return getObjects(Carta.class).isEmpty();
    }

    private void atualizarTentativas() {
        showText("Chances restantes: " + (maxTentativas - tentativasErradas), 300, 50);
    }
    
    private void proximaFase() {
        showText("", 300, 50);
        
        showText("Parabéns! A primeira fase foi concluída!", 300, 200);
        
        Greenfoot.delay(200);  
        Greenfoot.setWorld(new Catacumbas()); 
    }

    public void gameOver() {
         setBackground("gameOver.jpeg");
         removeObjects(getObjects(Carta.class));
         showText("", 300, 50);
    }
}
    

