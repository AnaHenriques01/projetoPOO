
/**
 * Dados sobre um Jogador do tipo Médio.
 *
 * @author grupo
 * @version 210402
 */
public class Medio{
   
    public double habMedio (Jogador umJog){
        double habilidade = 0;
        
        habilidade += umJog.getVelocidade()*0.5;
        habilidade += umJog.getResistencia()*0.5;
        habilidade += umJog.getDestreza()*1;
        habilidade += umJog.getImpulsao()*0.5;
        habilidade += umJog.getJogoCabeca()*0.5;
        habilidade += umJog.getRemate()*0.5;
        habilidade += umJog.getCapPasse()*1;
        
        return habilidade;
    }
}
