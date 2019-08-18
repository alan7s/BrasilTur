package brasiltur;

import java.util.Scanner;

public class BrasilTur {

    public static void main(String[] args) {
        // OS ÔNIBUS SÃO DIRETOS, ORIGEM -> DESTINO
        
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
        janelaPrincipal.setVisible(true);
      
        Scanner ler = new Scanner(System.in);
        ControleGaragem garagem = new ControleGaragem();
        //ControlePassageiro pagamento = new ControlePassageiro();
       
    
        //cadastrando ônibus (id, diaSaida, mesSaida, horaSaida, valor, destino, origem)
        //garagem.adicionarOnibusCovencional(Integer.parseInt(janelaPrincipal.getCadastro_viagens().getID()), Integer.parseInt(janelaPrincipal.getCadastro_viagens().getDia()), Integer.parseInt(janelaPrincipal.getCadastro_viagens().getMes()), Integer.parseInt(janelaPrincipal.getCadastro_viagens().getHora()), Double.parseDouble(janelaPrincipal.getCadastro_viagens().getValor()), janelaPrincipal.getCadastro_viagens().getDestino(), janelaPrincipal.getCadastro_viagens().getOrigem());        
        
        //garagem.adicionarOnibusCovencional(1000, 19, 11, 18, 90, "Guarapari", "Belo Horizonte");
        //garagem.adicionarOnibusExecutivo(1001,19,11,19,100,"São Paulo", "Belo Horizonte");
        
        //imprimi todos onibus cadastrados
        //garagem.relacaoOnibus();
        
        //somente cadastra passageiro no sistema (nome, sobrenome, idade, cpf)
        
        
        //pagamento.cadastrarPassageiro(janelaPrincipal.getCadastro_novo().getNome(), janelaPrincipal.getCadastro_novo().getSobrenome(),Integer.parseInt(janelaPrincipal.getCadastro_novo().getIdade()), Integer.parseInt(janelaPrincipal.getCadastro_novo().getCpf()));        
        
        //pagamento.cadastrarPassageiro("Fulano", "Detal", 21, 124);
        //pagamento.cadastrarPassageiro("Joaozinho", "Silva", 50, 5485);
       
        //lista todos passageiros cadastrados no sistema
      
        
        //pagamento.relacaoPassageiros();
        
        //Atribuindo na janela de Mostrar Passageiros os campos 
        //janelaPrincipal.getPassageiros().setNome(janelaPrincipal.getCadastro_novo().getNome());
        //janelaPrincipal.getPassageiros().setSobrenome(janelaPrincipal.getCadastro_novo().getSobrenome());
        //janelaPrincipal.getPassageiros().setIdade(pagamento.getPassageiro(0).getIdade());
        //janelaPrincipal.getPassageiros().setCpf(pagamento.getPassageiro(0).getCpf());
       
        
        //System.out.println("Colocar passageiro na viagem: ");
        //precisa de método pra verificar se a ID informada abaixo existe
        /*System.out.println("ID ônibus/viagem: ");
        int idbus = ler.nextInt();
        if(garagem.vagasNoOnibus(idbus)==true){ //método para verificar se ainda tem vagas no onibus
            System.out.println("CPF: ");
            int cpf = ler.nextInt();            
            System.out.println("Poltrona: ");
            int poltrona = ler.nextInt();
            if(garagem.verificaAssento(poltrona, idbus)==true){ //método pra verificar se já tem passgeiro na poltrona escolhida
                //poe passageiro no assento: poltrona, cpf, id onibus
                try{
                    garagem.escolherAssento(poltrona, pagamento.passageiro.get(pagamento.retornaPosicaoPassageiroNoArray(cpf)), idbus);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Passageiro de CPF informado não encontrado");
                }
            }
            else{
                System.out.println("Poltrona ocupada");
            }
        } else{
            System.out.println("Busão lotado");
        } *///////////////
        
   /*     System.out.println("Colocar passageiro na viagem: ");
        System.out.println("ID ônibus/viagem: ");
        idbus = ler.nextInt();
        if(garagem.vagasNoOnibus(idbus)==true){ //método para verificar se ainda tem vagas no onibus
            System.out.println("CPF: ");
            int cpf = ler.nextInt();            
            System.out.println("Poltrona: ");
            int poltrona = ler.nextInt();
            if(garagem.verificaAssento(poltrona, idbus)==true){ //método pra verificar se já tem passgeiro na poltrona escolhida
                //poe passageiro no assento: poltrona, cpf, id onibus
                try{
                    garagem.escolherAssento(poltrona, pagamento.passageiro.get(pagamento.retornaPosicaoPassageiroNoArray(cpf)), idbus);
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Passageiro de CPF informado não encontrado");
                }
            }
            else{
                System.out.println("Poltrona ocupada");
            }
        } else{
            System.out.println("Busão lotado");
        }   */   
       
        
        //imprime info sobre viagem: passar ID do ônibus
        //garagem.viagemInfoOnibus(1000);
        //garagem.viagemInfoOnibus(1001);
        
        //viagemInfoPassageiros listar passageiros que tão na viagem, passar ID do ônibus
        //garagem.viagemInfoPassageiros(1000);
        //garagem.viagemInfoPassageiros(1001);
        
    }
    
}
