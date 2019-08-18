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
 * @author fls
 */
public class GravarOnibus {
    private static Formatter output; // envia uma saída de texto para um arquivo
    private static Scanner input;
    private ArrayList<Onibus> onibus = new ArrayList<>();
    //private Passageiro pessoa = new Passageiro();
    
    // abre o arquivo onibus.txt para escrita
    public void openFileWrite(){
        try{
            output = new Formatter("onibus.txt"); // abre o arquivo
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
            input = new Scanner(Paths.get("onibus.txt"));
            return true;
        }catch (IOException ioException){
            System.err.println("Error opening file. Terminating.");
            return false;
        }
    }  
    
    // adiciona registros ao arquivo
    public void addRecords(String tipo, int id, int dia, int mes, int hora, double valor, String destino, String origem){
        try{
            output.format("%s %d %d %d %d %.2f %s %s%n",tipo,id,dia,mes,hora,valor,destino,origem);
        }catch(FormatterClosedException formatterClosedException){
            System.err.println("Error writing to file. Terminating.");
        }
    }
    
    // ler registros do arquivo
    public void readRecords(){
        System.out.printf("%-10s%-10s%-12s%-12s%10s%10s%12s%12s%n","Tipo", "ID", "Dia", "Mes", "Hora", "Valor", "Destino", "Origem");
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                // exibe o conteúdo de registro
                System.out.printf("%-10s%-10d%-12d%-12d%10d%10.2f%12s%12s%n", input.next(),input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
   public ArrayList<Onibus> loadRecords(){
        String tipo;
        //System.out.printf("%-10s%-10s%-12s%-12s%10s%10s%12s%12s%n","Tipo", "ID", "Dia", "Mes", "Hora", "Valor", "Destino", "Origem");
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                // exibe o conteúdo de registro
                //System.out.printf("%-10s%-10d%-12d%-12d%10d%10.2f%12s%12s%n", input.next(),input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next());
                tipo=input.next();
                if(tipo.equals("Covencional")){
                    onibus.add(new Covencional(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next()));
                } else if(tipo.equals("Executivo")){
                    onibus.add(new Executivo(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next()));
                } else if(tipo.equals("Leito")){
                    onibus.add(new Leito(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextDouble(), input.next(), input.next()));
                } else{
                    System.out.println("Tipo inexistente");
                    onibus = null;
                }
            } return onibus;
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating.");
        }
        return null;
    }
    
    // fecha o arquivo
    public void closeFile(){
        if(output != null){
            output.close();
        }
    }    
}
