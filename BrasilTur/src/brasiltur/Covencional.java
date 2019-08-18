/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasiltur;

/**
 *
 * @author fls
 */
public class Covencional extends Onibus{
    private final int lugares = 46;
    private final String carro = "Covencional";

    public Covencional(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem) {
        super(id, diaSaida, mesSaida, horaSaida, valor, destino, origem, 46);
        setTipo(carro);
    }
    
    @Override
    public double getValorAPagar() {
        return getValor();
    }

    public int getLugares() {
        return lugares;
    }      
    
    public String getCarro() {
        return carro;
    }      
    
    
    @Override
    public String toString() {
        return "Carro covencional: " + lugares + " lugares | ID:" + id + " | Possui poltronas bem reclináveis e toialete";
    }  
    
}
