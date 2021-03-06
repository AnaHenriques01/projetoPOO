import java.util.*;
import GestInfo.*;
import Exceptions.*;

/**
 * Apresenta um menu destinado ao jogo.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class JogMenu 
{
    private int option;
    private Jogo jogo;
    private EstadoJogo estado;
    private Data dados;
    private boolean fim = false;
    
    /**
    * Construtor que apresenta as opções
    * @param novoEstado do jogo planeado
    * @param dados completos do jogo
    */
    public JogMenu(EstadoJogo novoEstado, Data dados){
        this.dados = dados;
        Scanner sc = new Scanner(System.in);
        
        while(!fim){
            System.out.println("\n");
            System.out.println("Introduza a sua escolha:");
            System.out.println("1: Começar Jogo");
            System.out.println("2: Escolher tática");
            System.out.println("3: Escolher substituições");
            System.out.println("4: Sair");
    
            this.option = sc.nextInt();
            this.jogo = new Jogo(estado);
            this.estado = novoEstado;
        
            makeChoice(this.option);
        }
    }
    
    /**
    * Método que sitribui os metodos de acordo com a opção inserida pelo utilizador.
    * @param option opção escolhida pelo utilizador
    */
    
    public void makeChoice(int option){
       switch (option) {
          case 1:
            jogo.startGame(this.estado);
            jogo.iniciaJogada(this.estado);
            jogo.endGame(this.estado);  
            
            dados.inserirJogo(this.estado);
            fim = true;
            break;
            
          case 2:
            escTatica();
            break;
                
          case 3:
            try{
                escSubs();
            }
            catch(OpcaoInvalidaException exc){
                  System.out.println("Opção introduzida é inválida");
            }
            break;
        
          case 4:
              fim = true;
            return;
            
          default: System.out.println("Opção Inválida");
        }
    }
    
    /**
    * Método que permite escolher uma tática para a sua respetiva equipa
    */
    public void escTatica(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual equipa pretende que mude a tática:");
        System.out.println("1: " + estado.getEquipaCasa().getNome());
        System.out.println("2: " + estado.getEquipaFora().getNome());
        
        int equipa = sc.nextInt();
        
        
        System.out.println("Introduza a tática:");
        System.out.println("1: 1-4-4-2");
        System.out.println("2: 1-4-3-3");
        
        int tatica = sc.nextInt();
        switch(equipa){
            case 1:
                estado.getEquipaCasa().setNrTatica(tatica);
                estado.getEquipaCasa().criaTitularesSuplentes();
                break;
                
            case 2:
                estado.getEquipaFora().setNrTatica(tatica);
                estado.getEquipaFora().criaTitularesSuplentes();
                break;
                
            default:
                break;
        }
        
        System.out.println("Tatica modificada com sucesso");
    }

    /**
    * Método que permite escolher as substituições e em que equipa são feitas
    */
    public void escSubs() throws OpcaoInvalidaException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual equipa que pretende definir as substituições:");
        System.out.println("1: " + estado.getEquipaCasa().getNome());
        System.out.println("2: " + estado.getEquipaFora().getNome());
        int equipa = sc.nextInt();
        String nomeEq;

        switch (equipa) {
            case 1:
                nomeEq = estado.getEquipaCasa().getNome();
                estado.getEquipaCasa().apresentarTitulares();
                break;
            case 2:
                nomeEq = estado.getEquipaFora().getNome();
                estado.getEquipaFora().apresentarTitulares();
                break;
            default:
                throw new OpcaoInvalidaException();
        }

        switch (equipa) {
            case 1:
                estado.getEquipaCasa().apresentarSuplentes();
                break;
            case 2:
                estado.getEquipaFora().apresentarSuplentes();
                break;
            default:
                throw new OpcaoInvalidaException();
        }
        System.out.println("\n");
        System.out.println("Escreva o número do Titular que pretende substituir:");
        int titular = sc.nextInt();

        System.out.println("Escreva o número do Suplente que pretende que substitua o nr." + titular + " da equipa titular");
        int suplente = sc.nextInt();

        if (equipa == 1) estado.getEquipaCasa().substituirDentroEquipa(estado, titular, suplente, nomeEq);
        else estado.getEquipaFora().substituirDentroEquipa(estado, titular, suplente, nomeEq);

        System.out.println("Substituição " + titular + " -> " + suplente + " pedida");
          /*
        } catch(JogadorNaoExisteException ex0){
            System.out.println("Erro! Jogador " + ex0.getMessage());
        } catch(SubstituicaoNaoValidaException ex1){
            System.out.println("Erro! Troca de jogadores não permitida");
        } catch(SubstituicaoNaoPermitidaException ex2){
            System.out.println("Erro! Já fez 3 substituições");
        }
        */
    }
}
