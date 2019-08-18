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
public class Executivo extends Onibus{
    private final int lugares = 46;
    private final String carro = "Executivo";    

    public Executivo(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem) {
        super(id, diaSaida, mesSaida, horaSaida, valor, destino, origem, 46);
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
        return "Carro executivo: " + lugares + " lugares | ID:" + id + " | Possui poltronas bem reclináveis, apoio para as pernas, toialete e ar condicionado.";
    }
}
