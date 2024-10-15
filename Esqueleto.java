import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Esqueleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Esqueleto extends Actor {
    private int cooldownDano = 60;
    private int vida = 3; 
    private BarraVidaEsqueleto barraVida;

    public Esqueleto() {
        barraVida = new BarraVidaEsqueleto(vida); // Cria a barra de vida
    }

    public void act() {
        moverParaKitsune(); // Continua seguindo a Kitsune

        if (cooldownDano > 0) {
            cooldownDano--;
        }

        if (getWorld() != null && barraVida != null) {
            // Calcula a posição acima do esqueleto
            int alturaEsqueleto = getImage().getHeight();
            barraVida.setLocation(getX(), getY() - (alturaEsqueleto / 2) - 10);
        }
    }

    public void moverParaKitsune() {
        if (getWorld() != null) {
            KitsuneLuta kitsune = (KitsuneLuta) getWorld().getObjects(KitsuneLuta.class).get(0);
            if (kitsune != null) {
                // Se o esqueleto estiver à direita da Kitsune, move para a esquerda
                if (getX() > kitsune.getX()) {
                    setLocation(getX() - 1, getY());
                }
                // Se o esqueleto estiver à esquerda da Kitsune, move para a direita
                else if (getX() < kitsune.getX()) {
                    setLocation(getX() + 1, getY());
                }
            }
        }
    }

    public void receberDano() {
        if (getWorld() != null && cooldownDano <= 0) {
            if (vida > 0) {
                vida--; // Reduz a vida do esqueleto
    
                if (vida > 0) {
                    barraVida.atualizarBarra(vida); 
                } else {
                    // Primeiro, remova a barra de vida antes de remover o esqueleto
                    if (barraVida.getWorld() != null) {
                        getWorld().removeObject(barraVida); // Remove a barra de vida do mundo
                    }
                    // Agora remova o esqueleto, garantindo que o getWorld não é null
                    if (getWorld() != null) {
                        getWorld().removeObject(this); // Remove o esqueleto do mundo
                    }
                }
            }
        }
    }

    public int getVida() {
        return vida;
    }

    public BarraVidaEsqueleto getBarraVida() {
        return barraVida;
    }
}