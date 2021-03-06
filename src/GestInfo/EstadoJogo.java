package GestInfo;
/**
 * Estado jogo.
 *
 * @author grupo 3
 * @version 210402
 */

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.stream.Collectors;
import java.time.*;
import java.time.temporal.*;

public class EstadoJogo{
    private LocalDate data;
    private Equipa equipaCasa;
    private Equipa equipaFora;
    private int scoreCasa;
    private int scoreFora;
    private List<Integer> jogadoresCasa;
    private List<Integer> jogadoresFora;
    private Map<Integer,Integer> substituicoesCasa;
    private Map<Integer,Integer> substituicoesFora;
    private int nrSubstituicoesCasa;
    private int nrSubstituicoesFora;
    
    /**
     * Construtores da classe EstadoJogo.
     */
    
    public EstadoJogo(){
        this.data = LocalDate.now();
        this.equipaCasa = new Equipa();
        this.equipaFora = new Equipa();
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new ArrayList<Integer>();
        this.jogadoresFora = new ArrayList<Integer>();
        this.substituicoesCasa = new HashMap<Integer,Integer>();
        this.substituicoesFora = new HashMap<Integer,Integer>();
        this.nrSubstituicoesCasa = 0;
        this.nrSubstituicoesFora = 0;
    }
    
    public EstadoJogo(String nomeEquipaCasa, String nomeEquipaFora, Map<String, Equipa> equipas){
        this.data = LocalDate.now();
        this.equipaCasa = new Equipa(nomeEquipaCasa, equipas);
        this.equipaFora = new Equipa(nomeEquipaFora, equipas);
        this.scoreCasa = 0;
        this.scoreFora = 0;
        this.jogadoresCasa = new ArrayList<Integer>();
        this.jogadoresFora = new ArrayList<Integer>();
        this.substituicoesCasa = new HashMap<Integer,Integer>();
        this.substituicoesFora = new HashMap<Integer,Integer>();
        this.nrSubstituicoesCasa = 0;
        this.nrSubstituicoesFora = 0;
    }
    
    public EstadoJogo(LocalDate data, Equipa equipaCasa, Equipa equipaFora, int scoreCasa, int scoreFora, 
                      List<Integer> jogadoresCasa, List<Integer> jogadoresFora, Map<Integer, Integer> substituicoesCasa, Map<Integer, Integer> substituicoesFora,
                      int nrSubstituicoesCasa, int nrSubstituicoesFora){
        this.data = data;
        this.equipaCasa = equipaCasa;
        this.equipaFora = equipaFora;
        this.scoreCasa = scoreCasa;
        this.scoreFora = scoreCasa;
        this.jogadoresCasa = jogadoresCasa.stream().collect(Collectors.toList());
        this.jogadoresFora = jogadoresFora.stream().collect(Collectors.toList());
        this.substituicoesCasa.putAll(substituicoesCasa);
        this.substituicoesFora.putAll(substituicoesFora);
        this.nrSubstituicoesCasa = nrSubstituicoesCasa;
        this.nrSubstituicoesFora = nrSubstituicoesFora;
    }
   
    public EstadoJogo(EstadoJogo estado){
        this.data = estado.getData();
        this.equipaCasa = estado.getEquipaCasa();
        this.equipaFora = estado.getEquipaFora();
        this.scoreCasa = estado.getScoreCasa();
        this.scoreFora = estado.getScoreFora();
        this.jogadoresCasa = estado.getJogadoresCasa();
        this.jogadoresFora = estado.getJogadoresFora();
        this.substituicoesCasa = estado.getSubstituicoesCasa();
        this.substituicoesFora = estado.getSubstituicoesFora();
        this.nrSubstituicoesCasa = estado.getNrSubstituicoesCasa();
        this.nrSubstituicoesFora = estado.getNrSubstituicoesFora();
    }
    
    /**
    * M??todo que obt??m a data e inst??ncia do jogo.
    * @return a data e inst??ncia do jogo
    */
    public LocalDate getData(){
        return this.data;
    }
    
    /**
    * M??todo que obt??m a equipa que joga em casa.
    * @return a equipa que joga em casa
    */
    public Equipa getEquipaCasa(){
        return this.equipaCasa;
    }

    /**
    * M??todo que obt??m a equipa que joga fora.
    * @return a equipa que joga fora
    */
    public Equipa getEquipaFora(){
        return this.equipaFora;
    }

    /**
    * M??todo que obt??m o score da equipa que joga em casa.
    * @return o score da equipa que joga em casa
    */
    public int getScoreCasa(){
        return this.scoreCasa;
    }

    /**
    * M??todo que obt??m o score da equipa que joga fora.
    * @return o score da equipa que joga fora
    */
    public int getScoreFora(){
        return this.scoreFora;
    }

    /**
    * M??todo que obt??m a lista de jogadores que joga em casa.
    * @return a lista de jogadores que joga em casa
    */
    public List<Integer> getJogadoresCasa(){
        return this.jogadoresCasa;
    }
    
    /**
    * M??todo que obt??m um conjunto de pares das substitui????es que foram feitas em casa
    * @return um conjunto de pares das substitui????es que foram feitas em casa
    */
    public Map<Integer,Integer> getSubstituicoesCasa(){
        return this.substituicoesCasa;
    }
    
    /**
    * M??todo que obt??m a lista de jogadores que joga fora.
    * @return a lista de jogadores que joga fora
    */
    public List<Integer> getJogadoresFora(){
        return this.jogadoresFora;
    }

    /**
    * M??todo que obt??m um conjunto de pares das substitui????es que foram feitas fora
    * @return um conjunto de pares das substitui????es que foram feitas fora
    */
    public Map<Integer,Integer> getSubstituicoesFora(){
        return this.substituicoesFora;
    }
    
    /**
    * M??todo que obt??m o n??mero de substitui????es da equipa que joga em casa.
    * @return o n??mero de substitui????es da equipa que joga em casa
    */
    public int getNrSubstituicoesCasa(){
        return this.nrSubstituicoesCasa;
    }
    
    /**
    * M??todo que obt??m o n??mero de substitui????es da equipa que joga fora.
    * @return o n??mero de substitui????es da equipa que joga fora
    */
    public int getNrSubstituicoesFora(){
        return this.nrSubstituicoesFora;
    }
    
    /**
    * M??todo que muda a data e inst??ncia do jogo.
    * @param a nova data
    */
    public void setData(LocalDate data){
        this.data = data;
    }
    
    /**
    * M??todo que muda a equipa que joga em casa.
    * @param a nova equipa que joga em casa
    */
    public void setEquipaCasa(Equipa equipaCasa){
        this.equipaCasa = equipaCasa;
    }

    /**
    * M??todo que muda a tatica da equipa da casa.
    * @param a nova tatica
    */
    public void setTaticaCasa(int tatica){
        this.equipaCasa.setNrTatica(tatica);
    }
 
    /**
    * M??todo que muda a equipa que joga fora.
    * @param a nova equipa que joga fora
    */
    public void setEquipaFora(Equipa equipaFora){
        this.equipaFora = equipaFora;
    }

    /**
    * M??todo que muda a tatica da equipa da fora.
    * @param a nova tatica
    */
    public void setTaticaFora(int tatica){
        this.equipaFora.setNrTatica(tatica);
    }
    
    /**
    * M??todo que muda o score da equipa que joga em casa.
    * @param o novo score
    */
    public void setScoreCasa(int scoreCasa){
        this.scoreCasa = scoreCasa;
    }

    /**
    * M??todo que muda o score da equipa que joga fora.
    * @param o novo score
    */
    public void setScoreFora(int scoreFora){
        this.scoreFora = scoreFora;
    }

    /**
    * M??todo que muda o conjunto de jogadores que joga em casa.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresCasa(List<Integer> jogadoresCasa){
        this.jogadoresCasa = new ArrayList<>();
        for(Integer numCamisola : jogadoresCasa) {
            this.jogadoresCasa.add(numCamisola);
        }
    }
    
    /**
    * M??todo que muda as substitui????es feitas em casa.
    * @param as novas substitui????es
    */
    public void setSubstituicoesCasa(Map<Integer,Integer> substituicoesCasa){
        this.substituicoesCasa = substituicoesCasa.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
    * M??todo que muda o conjunto de jogadores que joga fora.
    * @param o novo conjunto de jogadores 
    */
    public void setJogadoresFora(List<Integer> jogadoresFora){
        this.jogadoresFora = new ArrayList<>();
        for(Integer numCamisola : jogadoresFora) {
            this.jogadoresFora.add(numCamisola);
        }
    }

    /**
    * M??todo que muda as substitui????es feitas fora.
    * @param as novas substitui????es
    */
    public void setSubstituicoesFora(Map<Integer,Integer> substituicoesFora){
        this.substituicoesFora = substituicoesFora.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
    * M??todo que muda o n??mero de substitui????es da equipa que joga em casa.
    * @param o novo n??mero de substitui????es
    */
    public void setNrSubstituicoesCasa(int nrSubstituicoesCasa){
        this.nrSubstituicoesCasa = nrSubstituicoesCasa;
    }
    
    /**
    * M??todo que muda o n??mero de substitui????es da equipa que joga fora.
    * @param o novo n??mero de substitui????es
    */
    public void setNrSubstituicoesFora(int nrSubstituicoesFora){
        this.nrSubstituicoesCasa = nrSubstituicoesCasa;
    }
    
    /**
     * M??todo que define que equipa ?? que joga em casa e que equipa joga fora.
     * @param equipas - o conjunto de todas as equipas
     * @param nomeEquipaCasa - o nome da equipa selecionada para jogar em casa
     * @param nomeEquipaFora - o nome da equipa selecionada para jogar fora
     */
    public void equipasEmCampo(Map<String, Equipa> equipas, String nomeEquipaCasa, String nomeEquipaFora){
        if(equipas.containsKey(nomeEquipaCasa))
            this.equipaCasa = equipas.get(nomeEquipaCasa).clone();
            
        if(equipas.containsKey(nomeEquipaFora))
            this.equipaFora = equipas.get(nomeEquipaFora).clone();
    }
}