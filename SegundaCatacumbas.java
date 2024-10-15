import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SegundaCatacumbas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SegundaCatacumbas extends MyWorld
{
    private int etapaSegundoDialogo = 0; // Para controlar o diálogo
    private boolean aguardandoResposta = false;
    private boolean perguntaFeita = false;
    /**
     * Constructor for objects of class SegundaCatacumbas.
     * 
     */
    public SegundaCatacumbas()
    {
    }
    
    public void prepare() {
        // Aqui você pode adicionar a Kitsune6 ou outros objetos relevantes
        Kitsune6 kitsune6 = new Kitsune6(); 
        addObject(kitsune6, 125, 251); // Adiciona a nova Kitsune ao cenário
        iniciarDialogo(); // Inicia o diálogo
    }

    public void iniciarDialogo() {
        switch (etapaSegundoDialogo) {
            case 0:
                caixa1.setTexto("Kitsune: Esses caras eram ossos duros, hein! Hum... Uma porta, o que tem atrás dela? \n(clique aqui para avançar)");
                break;
            case 1:
                caixa1.setTexto("Aldrava: Por que você mesma não olha? (clique aqui para avançar)");
                break;
            case 2:
                caixa1.setTexto("Kitsune: Nossa! Até uma alvadra pode falar nesse lugar, que esquisito! Bem, eu já estava planejando\n entrar. (clique aqui para avançar)");
                break;
            case 3:
                caixa1.setTexto("Aldrava: Então me diga a senha. (clique aqui para avançar)");
                break;
            case 4:
                caixa1.setTexto("Kitsune: Senha? Não bastou ter enfrentado aqueles esqueletos? (clique aqui para avançar)");
                break;
            case 5:
                caixa1.setTexto("Aldrava: Sou o guardião deste lugar, não posso deixar você entrar tão facilmente. \n(clique aqui para avançar)");
                break;
            case 6:
                caixa1.setTexto("Kitsune: Senha, certo? Hummm... Abracadabra! (clique aqui para avançar)");
                break; 
            case 7: 
                caixa1.setTexto("Aldrava: Hahaha! Achou mesmo que seria tão clichê assim? (clique aqui para avançar)");
                break;
            case 8: 
                caixa1.setTexto("Kitsune: Abre-te sésamo! (clique aqui para avançar)");
                break;
            case 9: 
                caixa1.setTexto("Aldrava: Você não é muito criativa, hein. (clique aqui para avançar)");
                break;
            case 10: 
                caixa1.setTexto("Kitsune: Alohomora! (clique aqui para avançar)");
                break;
            case 11:
                caixa1.setTexto("Aldrava: Não... (clique aqui para avançar)");
                break;
            case 12: 
                caixa1.setTexto("Kitsune: Por favor...? (clique aqui para avançar)");
                break;
            case 13: 
                caixa1.setTexto("Aldrava: Que tal me deixar ajudar primeiro? É melhor para você, pequena kitsune.\n (clique aqui para avançar)");
                break;
            case 14: 
                caixa1.setTexto("Kitsune: Está bem. Qual a pista? (clique aqui para avançar)");
                break;
            case 15:
                caixa1.setTexto("Pista: Uma garrafa de futuro e uma garrafa de passado são mantidos em um beijo que os mantém\n unidos. Quando um deles pega, o outro dá e então eles trocam de lugar enquanto cada um vive.");
                break; // Retorna para evitar incremento
        }
        etapaSegundoDialogo++; // Progride para a próxima parte do diálogo
        Greenfoot.delay(100); // Pausa para dar tempo ao jogador de ler
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) { // Verifica se houve um clique do mouse em qualquer lugar
            if (!aguardandoResposta) {
                if (etapaSegundoDialogo < 16) { // Se ainda não chegou ao final do diálogo
                    iniciarDialogo(); // Avança o diálogo
                }
            }
        }
        if (etapaSegundoDialogo == 16 && perguntaFeita != true){
            showText("Clique na tecla Up para responder", 300, 200);
            if(Greenfoot.isKeyDown("Up")){
                fazerPergunta();
            }
        }
    }

    public void fazerPergunta() {
        perguntaFeita = true;
        int tentativasErradas = 0;

        String resposta = Greenfoot.ask("Qual é a senha?");

        while (!resposta.equalsIgnoreCase("Ampulheta")) {
            tentativasErradas++; 

            if (tentativasErradas >= 3) {
                showText("Oh, não! Você precisa de uma ajudinha. \nDica: Tempo.", 300, 200);
                Greenfoot.delay(200); 
            } else {
                showText("Senha incorreta! Tente novamente.", 300, 200);
                Greenfoot.delay(200); 
            }

            resposta = Greenfoot.ask("Qual é a senha?");
        }
        showText("Senha correta! Pode passar.", 300, 200);
        Greenfoot.delay(180);
        terceiraFase(); // Chama o terceiro cenário após resposta correta
    }

    public void terceiraFase() {
        // Aqui você pode mudar para o terceiro cenário do jogo
        Greenfoot.setWorld(new SalaTesouro()); // Altere para a nova classe do terceiro cenário
    }
}
