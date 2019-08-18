/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brasiltur;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author FLS
 */
public class GravarAssentos {
    private static Formatter output; // envia uma saída de texto para um arquivo
    private static Scanner input;
    private ArrayList<Integer> id = new ArrayList<>(); 
    private ArrayList<Integer> posbus = new ArrayList<>(); 
    private ArrayList<Integer> poltrona = new ArrayList<>();  
    private ArrayList<Integer> cpf = new ArrayList<>();     

    public void openFileWrite(){
        try{
            output = new Formatter("assentos.txt"); // abre o arquivo
        }catch (SecurityException securityException){
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // termina o programa
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // termina o programa
        }
    }

    //abre o arquivo onibus.txt para leitura
    public boolean openFileRead(){
        
        try{
            input = new Scanner(Paths.get("assentos.txt"));
            return true;
        }catch (IOException ioException){
            System.err.println("Error opening file. Terminating.");
            return false;
        }
    }
    
    // adiciona registros ao arquivo
    public void addRecords(int id, int poltrona, int cpf){
        //gravar posição do onibus e passageiro nos array
        try{
            output.format("%d %d %d%n",id,poltrona,cpf);
        }catch(FormatterClosedException formatterClosedException){
            System.err.println("Error writing to file. Terminating.");
        }
    }

    // ler registros do arquivo
    public void readRecords(){
        System.out.printf("%-10s%-10s%-12s%n", "ID (onibus)", "Poltrona", "CPF");
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                // exibe o conteúdo de registro
                System.out.printf("%-10s%-10s%-12s%n", input.nextInt(), input.nextInt(), input.nextInt());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating.");
        }
    }    

    public void loadRecords(){
        int id, poltrona, cpf; //posbus
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                id = input.nextInt();
                poltrona = input.nextInt();
                cpf = input.nextInt();
//                posbus = input.nextInt();
                this.id.add(id);
                this.poltrona.add(poltrona);
                this.cpf.add(cpf);
//                this.posbus.add(posbus);
            } 
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating.");
        }

    }   
    
    // fecha o arquivo
    public void closeFile(){
        if(output != null){
            output.close();
        }
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

    public ArrayList<Integer> getPosbus() {
        return posbus;
    }

    public void setPosbus(ArrayList<Integer> posbus) {
        this.posbus = posbus;
    }

    public ArrayList<Integer> getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(ArrayList<Integer> poltrona) {
        this.poltrona = poltrona;
    }

    public ArrayList<Integer> getCpf() {
        return cpf;
    }

    public void setCpf(ArrayList<Integer> cpf) {
        this.cpf = cpf;
    }

    
}
