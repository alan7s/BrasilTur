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
public class ControlePassageiro{
    //Arquivo arq = new Arquivo();
    ArrayList<Passageiro> passageiro;
    GravarPassageiros gravar = new GravarPassageiros();    
    
    public ControlePassageiro() {
        passageiro = new ArrayList<>();
    }
    
    public void cadastrarPassageiro(String nome, String sobrenome, int idade, int cpf){
        passageiro.add(new Passageiro(nome, sobrenome, idade, cpf));
    }
    
    public Passageiro getPassageiro(int i){
        return this.passageiro.get(i);
    }

    public ArrayList<Passageiro> getPassageiro() {
        return passageiro;
    }

    public void relacaoPassageiros(){ //lista todos passageiros cadastrados
        for(int i=0;i<passageiro.size();i++){
            System.out.printf("\n"+passageiro.get(i).toString()+"\n");
        }        
    }
    
    public int retornaPosicaoPassageiroNoArray(int cpf){
        for(int i=0;i<passageiro.size();i++){
            if(passageiro.get(i).getCpf() == cpf){
                return i;
            }
        }
        return passageiro.size()+1; //se não encontrar cpf retorna posição fora do array
    }
    
    /*public boolean gravarPassageiroArquivo(){
        String arquivo = "listapassageiros.txt";
        boolean controle = true;
        for(int i=0;i<passageiro.size();i++){
            String print = passageiro.get(i).getNome()+";"+passageiro.get(i).getSobrenome()+";"+passageiro.get(i).getIdade()+";"+passageiro.get(i).getCpf();
            controle = arq.Write(arquivo, print);
            
            if(controle == false){
                return controle;
            }
        }
        return controle;
    }*/
    
    public void gravarPassageiroArquivo(){
        gravar.openFileWrite();
        for(int i=0;i<passageiro.size();i++){
            gravar.addRecords(passageiro.get(i).getNome(), passageiro.get(i).getSobrenome(), passageiro.get(i).getIdade(), passageiro.get(i).getCpf());
        }
        gravar.closeFile();
    }
    
    public void listarPassageiroArquivo(){
        gravar.openFileRead();
        gravar.readRecords();
        gravar.closeFile();
    }
    
    public boolean carregarArquivo(){
        if(gravar.openFileRead()){
            passageiro=gravar.loadRecords(); //retorna nulo se nao conseguir carregar array
            if(passageiro==null){
                return false;
            }
            gravar.closeFile();            
            return true;
        }
        else{
            return false;
        }
    }
    
    
/*    public void carregarPassageiroDoArquivo(){
        String arquivo = "passageiros.txt";
        String conteudo = arq.Read(arquivo);
        String c1 = conteudo.split(" ")[0];
        String c2 = conteudo.split(" ")[1];
        String c3 = conteudo.split(" ")[2];        
        String c4 = conteudo.split(" ")[3];   
        System.out.println("Nome: "+c1);
        System.out.println("Sobrenome: "+c2);
        System.out.println("Idade: "+c3); 
        System.out.println("CPF: "+c4);
    }*/
}
