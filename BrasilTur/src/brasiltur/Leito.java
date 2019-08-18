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
public class Leito extends Onibus{
    private final int lugares = 26;
    private final String carro = "Leito";

    public Leito(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem) {
        super(id, diaSaida, mesSaida, horaSaida, valor, destino, origem, 26);
        setTipo(carro);
    }
    
    @Override
    public double getValorAPagar() {
        return getValor();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLugares() {
        return lugares;
    }  

    @Override
    public String toString() {
        return "Carro leito: " + lugares + " lugares | ID:" + id + " | Possui poltronas mais reclináveis do que o executivo e convencional, travesseiro e manta, apoio para as pernas, toialete, água gelada e ar condicionado.";
    }
    
    
}
