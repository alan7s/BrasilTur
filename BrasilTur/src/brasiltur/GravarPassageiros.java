package brasiltur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.SecurityException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GravarPassageiros {
    private static Formatter output; // envia uma saída de texto para um arquivo
    private static Scanner input;
    private ArrayList<Passageiro> pessoa = new ArrayList<>();
    //private Passageiro pessoa = new Passageiro();
    
    // abre o arquivo passageiros.txt para escrita
    public void openFileWrite(){
        try{
            output = new Formatter("passageiros.txt"); // abre o arquivo
        }catch (SecurityException securityException){
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // termina o programa
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // termina o programa
        }
    }
    
    //abre o arquivo passageiros.txt para leitura
    public boolean openFileRead(){
        
        try{
            input = new Scanner(Paths.get("passageiros.txt"));
            return true;
        }catch (IOException ioException){
            System.err.println("Error opening file. Terminating.");
            return false;
        }
    }  
    
    // adiciona registros ao arquivo
    public void addRecords(String nome, String sobrenome, int idade, int cpf){
        try{
            output.format("%s %s %d %d%n",nome,sobrenome,idade,cpf);
        }catch(FormatterClosedException formatterClosedException){
            System.err.println("Error writing to file. Terminating.");
        }
    }
    
    // ler registros do arquivo
    public void readRecords(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Nome", "Sobrenome", "Idade", "CPF");
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                // exibe o conteúdo de registro
                System.out.printf("%-10s%-12s%-12d%10d%n", input.next(),input.next(), input.nextInt(), input.nextInt());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("File improperly formed. Terminating.");
        }catch (IllegalStateException stateException){
            System.err.println("Error reading from file. Terminating.");
        }
    }
    
    public ArrayList<Passageiro> loadRecords(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Nome", "Sobrenome", "Idade", "CPF");
        try{
            while ( input.hasNext() ){ // enquanto houver mais para ler
                // exibe o conteúdo de registro
                //System.out.printf("%-10s%-12s%-12d%10d%n", input.next(),input.next(), input.nextInt(), input.nextInt());
                pessoa.add(new Passageiro(input.next(),input.next(),input.nextInt(),input.nextInt()));
            } return pessoa;
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
