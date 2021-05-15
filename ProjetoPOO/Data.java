
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

/**
 * Escreva a descrição da classe Data aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Data {
    Map<String, Equipa> equipas; //nome, equipa
    Map<Integer, Jogador> jogadores; //numero, jogador
    List<EstadoJogo> jogos;
    
    public Data (){
        this.equipas = new HashMap<String, Equipa>(); //nome, equipa
        this.jogadores = new HashMap<Integer, Jogador>(); //numero, jogador
        this.jogos = new ArrayList<>();
    }
    
    public Data (Map<String, Equipa> equipas, Map<Integer, Jogador> jogadores,List<EstadoJogo> jogos){
        this.equipas = equipas; //nome, equipa
        this.jogadores = jogadores; //numero, jogador
        this.jogos = jogos;
    }
    
    public Map<String, Equipa> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    public Map<Integer, Jogador> getJogadores(){
        return this.jogadores.entrySet().stream().collect(Collectors.toMap(par->par.getKey(), par->par.getValue().clone()));
    }
    
    public List<EstadoJogo> getJogos(){
        return this.jogos;
    }
}
