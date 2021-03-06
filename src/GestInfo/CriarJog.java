package GestInfo;

import javax.xml.crypto.Data;
import java.util.*;
/**
 * Esta classe destina-se a criar um jogador.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class CriarJog {
    /**
     * Método que pergunta ao usuário que tipo de jogador pretende criar.
     * @return o número da opção
     */
    public int escJogador()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Que jogador pretende criar?");
        System.out.println("1: Avançado");
        System.out.println("2: Lateral");
        System.out.println("3: Médio");
        System.out.println("4: Defesa");
        System.out.println("5: Guarda Redes");
        
        int jogEscolhido = sc.nextInt();
        if(jogEscolhido < 1 || jogEscolhido > 5){
                System.out.println("Não exite esta opção! Insira outra: ");
                jogEscolhido = sc.nextInt();
        }
        return jogEscolhido;
    }

    /**
     * Método que pede ao usuário valores para as características do tipo de jogador que escolheu.
     * 
     * Este método calcula, ainda, a habilidade do dito jogador consoante os valores dados.
     * 
     * @param jogEscolhido número da opção
     * @return o novo jogador criado
     */
    public Jogador criarJogador(int jogEscolhido)
    {
        Jogador jog = new Jogador();
        jog.setTipoJogador(jogEscolhido);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nome do Jogador: ");
        String nome = sc.nextLine();
        jog.setNome(nome);
        
        System.out.println("Os valores atribuídos as carateristicas tem estar entre 0 e 100");
        
        System.out.println("Velocidade: ");
        int velocidade = sc.nextInt();
        if (velocidade < 0 || velocidade > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            velocidade = sc.nextInt();
        }
        jog.setVelocidade(velocidade);
        
        System.out.println("Resistência: ");
        int resistencia = sc.nextInt();
        if (resistencia < 0 || resistencia > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            resistencia = sc.nextInt();
        }
        jog.setResistencia(resistencia);

        System.out.println("Destreza: ");
        int destreza = sc.nextInt();
        if (destreza < 0 || destreza > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            destreza = sc.nextInt();
        }
        jog.setDestreza(destreza);

        System.out.println("Impulsão: ");
        int impulsao = sc.nextInt();
        if (impulsao < 0 || impulsao > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            impulsao = sc.nextInt();
        }
        jog.setImpulsao(impulsao);

        System.out.println("Jogo de Cabeça: ");
        int jogoCabeca = sc.nextInt();
        if (jogoCabeca < 0 || jogoCabeca > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            jogoCabeca = sc.nextInt();
        }
        jog.setJogoCabeca(jogoCabeca);

        System.out.println("Remate: ");
        int remate = sc.nextInt();
        if (remate < 0 || remate > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            remate = sc.nextInt();
        }
        jog.setRemate(remate);

        System.out.println("Capaciadade de passe: ");
        int capPasse = sc.nextInt();
        if (capPasse < 0 || capPasse > 100){
            System.out.println("Este valor não é válido! Insira um novo: ");
            capPasse = sc.nextInt();
        }
        jog.setCapPasse(capPasse);
        
        double habilidade = 0;
        
              switch(jogEscolhido){
        
                    case 1:
                        Avancado jogAvancado = new Avancado();
                        
                        System.out.println("Capaciadade de drible: ");                       
                        int drible = sc.nextInt();
                        if (drible < 0 || drible > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            drible = sc.nextInt();
                        }                         
                        jogAvancado.setDrible(drible);
                        
                        
                        habilidade = jogAvancado.habAvancado(jog);
                        System.out.println("Habilidade do avançado: " + habilidade);
                        
                        jog = jogAvancado;
                        break;
            
                    case 2:
                        Lateral jogLateral = new Lateral();
        
                        System.out.println("Capaciadade de cruzamento: ");                       
                        int capCruzamento = sc.nextInt();
                        if (capCruzamento < 0 || capCruzamento > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            capCruzamento = sc.nextInt();
                        }                         
                        jogLateral.setCapCruzamento(capCruzamento);
                        
                        habilidade = jogLateral.habLateral(jog);
                        System.out.println("Habilidade do lateral: " + habilidade);
                        
                        jog = jogLateral;
                        break;
        
                    case 3:
                        Medio jogMedio = new Medio();
        
                        System.out.println("Capacidade de recuperação: ");
                        int capRecuperacao = sc.nextInt();
                        if (capRecuperacao < 0 || capRecuperacao > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            capRecuperacao = sc.nextInt();
                        }
                        
                        System.out.println("Domínio de bola: ");
                        int dominioBola = sc.nextInt();
                        if (dominioBola < 0 || dominioBola > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            dominioBola = sc.nextInt();
                        } 
                        jogMedio.setDominioBola(dominioBola);
    
                        habilidade = jogMedio.habMedio(jog);
                        System.out.println("Habilidade do médio: " + habilidade);
                        
                        jog = jogMedio;
                        break;
        
                    case 4:
                        Defesa jogDefesa = new Defesa();
                        
                        System.out.println("Desarme: ");
                        int desarme = sc.nextInt();
                        if (desarme < 0 || desarme > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            desarme = sc.nextInt();
                        }                        
                        jogDefesa.setDesarme(desarme);
                        
                        
                        habilidade = jogDefesa.habDefesa(jog);
                        System.out.println("Habilidade do defesa: " + habilidade);
                        
                        jog = jogDefesa;
                        break;
        
                    case 5:
                        GuardaRedes jogGR = new GuardaRedes();
        
                        System.out.println("Elastecidade: ");
                        int elasticidade = sc.nextInt();
                        if (elasticidade < 0 || elasticidade > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            elasticidade = sc.nextInt();
                        }                        
                        jogGR.setElasticidade(elasticidade);
                        
                        System.out.println("Lançamento: ");
                        int lancamento = sc.nextInt();
                        if (lancamento < 0 || lancamento > 100){
                            System.out.println("Este valor não é válido! Insira um novo: ");
                            lancamento = sc.nextInt();
                        }                        
                        jogGR.setElasticidade(lancamento);
                        
                        habilidade = jogGR.habGuardaRedes(jog);
                        System.out.println("Habilidade do guarda-redes: " + habilidade);
                        
                        jog = jogGR;
                        break;
        }
        return jog;
    }
     
    /**
     * Método que associa um jogador a uma equipa a partir dos dados do ficheiro.
     */
    public void atribEq(Jogador jog, Data dados)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("A que equipa pretende associar este jogador?");
        boolean valid = false;
        
        while(!valid){
            try {
                String escolhaEq = sc.nextLine();
                sc.nextLine();//flush
                Equipa eq = dados.getEquipas().get(escolhaEq);
                
                System.out.println("Numero da camisola do jogador: ");
                
                boolean v2 = false;
                while(!v2){
                    int nr_camisola = sc.nextInt();
                    if(eq.getJogadores().containsKey(nr_camisola))
                        System.out.println("Este número já está a ser usado, insira outro número: ");
                    else {
                        jog.setNrCamisola(nr_camisola);
                        v2 = true;
                    }
                }
                
                eq.insereJogador(jog);
                dados.getEquipas().put(escolhaEq,eq);
                valid = true;
                System.out.println(jog.getNome() +" faz agora parte de " + eq.getNome() + "!");
            }
            catch(NullPointerException e) {
                System.out.println("Equipa não existe! Volte a inserir opção");
            }
            catch(Exception exc) {
                System.out.println("Erro a inserir jogador!");
            }
        }
    }
}