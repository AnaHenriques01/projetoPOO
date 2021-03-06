package Exceptions;
/**
 * Classe que se encarrega de denotar o facto de uma equipa não existir e lança uma mensagem se tal acontecer.
 * 
 * @author grupo 3
 * @version (número de versão ou data)
 */
public class EquipaNaoExisteException extends Exception{
    
    public EquipaNaoExisteException(){
        super();
    }

    public EquipaNaoExisteException(String msg){
        super(msg);
    }
}
