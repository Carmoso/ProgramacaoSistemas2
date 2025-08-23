
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) {
        public List<Midia> midias = new ArrayList<>();
        Scanner sc = new Scanner(System.in);



        int op = 0;
        do{ 
            System.out.print("(1) Adicionar novo Filme./n(2) Adicionar nova Série./n(3) Listar todas as mídias./n(4) Sair");
            switch (op){
                case 1:
                    System.out.println("QUAL O TÍTULO DO FILME?");
                    String titulo = sc.nextLine();
                    System.out.println("QUAL A DURAÇÃO DO FILME?");
                    long duracao = sc.nextLong();
                    Filme filme = new Filme(titulo, duracao);
                    midias.add(filme);
                    System.out.println("FILME ADICIONADO COM SUCESSO!");
                    break;
                case 2:
                case 3:
                case 4:
                    break;
            }

        }while(op<4);

    }
}
