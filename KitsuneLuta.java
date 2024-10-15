import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KitsuneLuta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KitsuneLuta extends Actor {
    private BracoEspada bracoEspada;
    private int vida = 100;
    private int cooldownDanoKitsune = 0;
    private BarraVidaKitsune barraVida;
    private int esqueletosDerrotados = 0;

    public KitsuneLuta() {
        barraVida = new BarraVidaKitsune(vida);
    }

    public void act() {
        if (getWorld() == null) {
            return; 
        }

        if (Greenfoot.isKeyDown("left")) {
            move(-5); 
        }
        if (Greenfoot.isKeyDown("right")) {
            move(5);
        }

        Aranhas aranha = (Aranhas) getOneIntersectingObject(Aranhas.class);
        if (aranha != null && checkPixelCollision(aranha)) {
            getWorld().removeObject(aranha);
            causarDano(10); 
        }

        if (cooldownDanoKitsune > 0) {
            cooldownDanoKitsune--;  
        }

        Esqueleto esqueleto = (Esqueleto) getOneIntersectingObject(Esqueleto.class);
        if (esqueleto != null && checkPixelCollision(esqueleto) && cooldownDanoKitsune <= 0) {
            causarDano(15); 
            cooldownDanoKitsune = 60; 
        }

        barraVida.setLocation(getX(), getY() - 10);
    }

    public void addedToWorld(World world) {
        if (world != null) {
            world.addObject(barraVida, getX(), getY() - 10); 
        }
    }

    private boolean checkPixelCollision(Actor other) {
        GreenfootImage myImage = getImage();
        GreenfootImage otherImage = other.getImage();

        int myX = getX() - myImage.getWidth() / 2;
        int myY = getY() - myImage.getHeight() / 2;
        int otherX = other.getX() - otherImage.getWidth() / 2;
        int otherY = other.getY() - otherImage.getHeight() / 2;

        // Verifica a área de sobreposição
        int leftX = Math.max(myX, otherX);
        int rightX = Math.min(myX + myImage.getWidth(), otherX + otherImage.getWidth());
        int topY = Math.max(myY, otherY);
        int bottomY = Math.min(myY + myImage.getHeight(), otherY + otherImage.getHeight());

        // Varre os pixels na área de sobreposição
        for (int x = leftX; x < rightX; x++) {
            for (int y = topY; y < bottomY; y++) {
                // Verifica se ambos os pixels são visíveis (não transparentes)
                if (myImage.getColorAt(x - myX, y - myY).getAlpha() > 0 &&
                    otherImage.getColorAt(x - otherX, y - otherY).getAlpha() > 0) {
                    return true; // Colisão detectada
                }
            }
        }
        return false; // Não houve colisão
    }

    public void causarDano(int dano) {
        if (getWorld() == null) {
            return; 
        }

        vida -= dano; 
        if (vida < 0) {
            vida = 0; 
            barraVida.atualizarVida(vida); 
             
        } else {
            barraVida.atualizarVida(vida); 
        }
    }

    public int getVida() {
        return vida; 
    }
}
