import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarraVidaEsqueleto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarraVidaEsqueleto extends Actor {
    private int larguraMaxima = 50; 
    private int altura = 10; 
    private int vidaAtual;

    public BarraVidaEsqueleto(int vida) {
        this.vidaAtual = vida; 
        atualizarBarra(); 
    }

    public void atualizarBarra(int vida) {
        this.vidaAtual = vida; 
        atualizarBarra(); 
    }

    private void atualizarBarra() {
        // Cria uma nova imagem para a barra
        GreenfootImage barra = new GreenfootImage(larguraMaxima, altura);
        barra.setColor(Color.RED); // Cor da barra
        int larguraAtual = (int) (larguraMaxima * (vidaAtual / 3.0)); // Largura proporcional à vida
        barra.fillRect(0, 0, larguraAtual, altura); // Preencher a barra com a largura atual
        setImage(barra); // Define a imagem da barra para o ator
    }
}
