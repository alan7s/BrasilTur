/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasiltur;

import java.util.ArrayList;

/**
 *
 * @author fls
 */
public class ControleGaragem {
    ArrayList<Onibus> onibus;
    ArrayList<Passageiro> passageiro;
    GravarOnibus gravar = new GravarOnibus();    
    GravarAssentos assentos = new GravarAssentos();
    ControlePassageiro cp = new ControlePassageiro();

    public ControleGaragem() {
        onibus = new ArrayList();
        //cp.carregarArquivo();
        //passageiro = cp.getPassageiro();
    } 
       
    public void adicionarOnibusCovencional(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem){
        onibus.add(new Covencional(id, diaSaida, mesSaida, horaSaida, valor, destino, origem));
    }
    
    public void adicionarOnibusExecutivo(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem){
        onibus.add(new Executivo(id, diaSaida, mesSaida, horaSaida, valor, destino, origem));
    }
    
    public void adicionarOnibusLeito(int id, int diaSaida, int mesSaida, int horaSaida, double valor, String destino, String origem){
        onibus.add(new Leito(id, diaSaida, mesSaida, horaSaida, valor, destino, origem));
    }    

    public void relacaoOnibus(){ //lista todos ônibus cadastrados
        for(int i=0;i<onibus.size();i++){
            System.out.printf("\n"+onibus.get(i).toString()+"\n");
        }        
    } 
    
    public int retornaPosicaoOnibusNoArray(int id){
        for(int i=0;i<onibus.size();i++){
            if(onibus.get(i).id == id){
                return i;
            }
        }
        return -1;
    }
    
    public boolean vagasNoOnibus(int id){ //retorna false se lotado
        int info = retornaPosicaoOnibusNoArray(id);
        if(onibus.get(info).capacidadeOcupada()==onibus.get(info).capacidadeOnibus()){
            return false;
        }
        return true;
    }
    
    //poltrona, id onibus
    public boolean verificaAssento(int poltrona, int id){
        int info = retornaPosicaoOnibusNoArray(id);
        if(onibus.get(info).getPassageiro(poltrona)!=null){
            return false;
        }
        else{
            return true;
        }
    }
    
    //recebe poltrona, passageiro, e id do onibus
    public void escolherAssento(int poltrona, Passageiro pessoa, int id){
        int posbus;
        posbus = retornaPosicaoOnibusNoArray(id);
        onibus.get(posbus).addPassageiro(poltrona, pessoa); //poltrona e pessoa
    }
    
    public void gravarOnibusArquivo(){
        gravar.openFileWrite();
        for(int i=0;i<onibus.size();i++){
            //tipo,id,dia,mes,hora,valor,destino,origem
            gravar.addRecords(onibus.get(i).getTipo(),onibus.get(i).id, onibus.get(i).getDiaSaida(), onibus.get(i).getMesSaida(), onibus.get(i).getHoraSaida(), onibus.get(i).getValor(), onibus.get(i).getDestino(), onibus.get(i).getOrigem());
        }
        gravar.closeFile();
    } 
    
    public void gravarAssentosArquivo(){
        assentos.openFileWrite();
        for(int i=0;i<onibus.size();i++){
            for(int j=0;j<onibus.get(i).capacidadeOnibus();j++){
                if(verificaAssento(j,onibus.get(i).id)==false){
                    if(onibus.get(i).retornaCPFPOSICAO(j)!=-1){
                        assentos.addRecords(onibus.get(i).id, j, onibus.get(i).retornaCPFPOSICAO(j));                        
                    }
                }
            }
        }
        assentos.closeFile();
    }
    
    public void listarAssentosArquivo(){
        assentos.openFileRead();
        assentos.readRecords();
        assentos.closeFile();
    }
    
    public void listarOnibusArquivo(){
        gravar.openFileRead();
        gravar.readRecords();
        gravar.closeFile();
    }

    public boolean carregarArquivoAssento(){
        int poltrona, cpf, id;
        carregarArquivo();
        cp.carregarArquivo();
        passageiro = cp.getPassageiro();
        if(assentos.openFileRead()){
            assentos.loadRecords();
            for(int i=0;i<assentos.getPoltrona().size();i++){
                poltrona = assentos.getPoltrona().get(i);
                cpf = assentos.getCpf().get(i);
                id = assentos.getId().get(i);
//                cp.carregarArquivo();
//                passageiro = cp.getPassageiro();
                escolherAssento(poltrona, passageiro.get(cp.retornaPosicaoPassageiroNoArray(cpf)), id);
            }
            assentos.closeFile();
            return true;
        }
        else{
            return false;
        }
    }    
    
    public boolean carregarArquivo(){
        if(gravar.openFileRead()){
            onibus=gravar.loadRecords(); //retorna nulo se nao conseguir carregar array
            if(onibus==null){
                return false;
            }
            gravar.closeFile();            
            return true;
        }
        else{
            return false;
        }
    }    
    
    public void viagemInfoOnibus(int id){
        int info = retornaPosicaoOnibusNoArray(id);
        System.out.println("\nViagem info: ");
        System.out.println("ID: "+onibus.get(info).id);
        System.out.println("Tipo: "+onibus.get(info).tipo);
        System.out.println("Origem: "+onibus.get(info).origem);
        System.out.println("Destino: "+onibus.get(info).destino);
        System.out.println("Dia: "+onibus.get(info).diaSaida);
        System.out.println("Mes: "+onibus.get(info).mesSaida);
        System.out.println("Hora: "+onibus.get(info).horaSaida+"h");
        System.out.println("Lugares ocupados: "+onibus.get(info).capacidadeOcupada());
        System.out.println("Lugares disponíveis: "+(onibus.get(info).capacidadeOnibus()-onibus.get(info).capacidadeOcupada()));
    }   

    
    public void viagemInfoPassageiros(int id){
        int posbus;
        Passageiro pessoa;
        posbus = retornaPosicaoOnibusNoArray(id);
        System.out.println("\n==INFO PASSAGEIROS==");
        System.out.println("Ônibus ID: "+id);
        System.out.println("======================");
        for(int i=0;i<onibus.size();i++){
            if(onibus.get(posbus).getPassageiro(i) != null){ //só pega info de passageiro se existir
                pessoa = onibus.get(posbus).getPassageiro(i);
                System.out.println("Nome: "+pessoa.getNome());
                System.out.println("Sobrenome: "+pessoa.getSobrenome());
                System.out.println("Idade: "+pessoa.getIdade());
                System.out.println("CPF: "+pessoa.getCpf());
                System.out.println("============================");
            }
        }
        
    }
}
