import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BracoEspada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BracoEspada extends Actor {
     private boolean rotacionando = false;
    private boolean ataqueEmAndamento = false;
    private final int anguloAtaque = 45;  // Ângulo final para o ataque
    private int rotacaoAtual = 0;  // Para controlar a rotação atual em pequenos passos
    private long ultimoDano = 0;  // Armazena o último tempo em que causou dano
    private final long intervaloDano = 1000;
    private int direcaoRotacao = 1;  // 1 = indo para frente, -1 = retornando
    private int incrementoRotacao = 5;
    public void act() {
        // Detecta a tecla para iniciar a rotação
        if (Greenfoot.isKeyDown("down") && !rotacionando) {
            rotacionando = true;  // Inicia a rotação
            ataqueEmAndamento = true; // Chama o método para rotacionar suavemente
        }
        
        if(Greenfoot.isKeyDown("left")) {
            move(-5); 
        }
        if(Greenfoot.isKeyDown("right")) {
            move(5);
        }
        
         if (rotacionando) {
            rotacionarGradualmente();
        }
        
        if (isTouching(Esqueleto.class) && ataqueEmAndamento) {
            Esqueleto esqueleto = (Esqueleto) getOneIntersectingObject(Esqueleto.class);
            esqueleto.receberDano();
        }
        ataqueEmAndamento = false;
    }

    // Método que realiza a rotação em pequenos passos
    public void rotacionarGradualmente() {
        // Realiza a rotação conforme a direção atual
        setRotation(rotacaoAtual);
        rotacaoAtual += direcaoRotacao * incrementoRotacao;  // Incrementa ou decrementa o ângulo

        // Verifica se atingiu o ângulo final ou voltou à posição inicial
        if (rotacaoAtual >= anguloAtaque) {
            direcaoRotacao = -1;  // Começa a voltar
        } else if (rotacaoAtual <= 0) {
            direcaoRotacao = 1;  // Finaliza o ataque e reseta a rotação
            rotacionando = false;
            ataqueEmAndamento = false;
        }
    }

    // Método que retorna se o braço está rotacionando
    public boolean estaRotacionando() {
        return rotacionando;
    }

}
