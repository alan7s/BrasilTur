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
public abstract class Onibus implements Pagavel{
    protected String tipo; //covencional, executivo, leito
    protected int diaSaida; //dia de partida
    protected int mesSaida; //mes de partida
    protected int horaSaida; //hora da partida, somente hora cheia 1, 2, 3, 12, 14...
    protected double valor; //preço passagem
    protected String destino; //destino da viagem
    protected String origem; //local de partida da viagem
    protected int id;
    protected Passageiro[] passageiro;
  
    public Onibus(){ }

    public Onibus(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem, int capacidade) {
        //this.tipo = tipo;
        this.id = id;
        this.diaSaida = diaSaida;
        this.mesSaida = mesSaida;
        this.horaSaida = horaSaida;
        this.valor = valor;
        this.destino = destino;
        this.origem = origem;
        passageiro = new Passageiro[capacidade];
    } 
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDiaSaida() {
        return diaSaida;
    }

    public void setDiaSaida(int diaSaida) {
        this.diaSaida = diaSaida;
    }

    public int getMesSaida() {
        return mesSaida;
    }

    public void setMesSaida(int mesSaida) {
        this.mesSaida = mesSaida;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    public void addPassageiro(int pos, Passageiro pessoa){
       passageiro[pos] = pessoa; //cada posição é uma poltrona
    }
       
    public Passageiro getPassageiro(int pos){
        return passageiro[pos];
    }
    
    public Passageiro[] getPassageiro(){
        return passageiro;
    }
    
    public int capacidadeOnibus(){
        return passageiro.length;
    }
    
    public int capacidadeOcupada(){
        int j=0;
        for(int i=0;i<passageiro.length;i++){
            if(passageiro[i]!=null){
                j++;
            }
        }
        return j;
    }
    
    public int retornaCPFPOSICAO(int pos){
        if(passageiro[pos]!=null){
            return passageiro[pos].getCpf();
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return "Onibus{" + "tipo=" + tipo + ", diaSaida=" + diaSaida + ", mesSaida=" + mesSaida + ", horaSaida=" + horaSaida + ", valor=" + valor + ", destino=" + destino + ", passageiros: " + passageiro.length +'}';
    }
    
    
   
}
