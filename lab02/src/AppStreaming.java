
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppStreaming {
    public static void main(String[] args) {
        List<Midia> midias = new ArrayList<>();

        Scanner sc = new Scanner(System.in);



        int op = 0;
        do{ 
            System.out.printf("(1) Adicionar novo Filme.\n(2) Adicionar nova Série.\n(3) Listar todas as mídias.\n(4) Sair\nDigite a opção: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.println("QUAL O TÍTULO DO FILME?");
                    String titulo = sc.nextLine();
            
                    System.out.println("QUAL A DURAÇÃO DO FILME?");
                    long duracao = sc.nextLong();
                    sc.nextLine();

                    Filme filme = new Filme(titulo, duracao);
                    midias.add(filme);
                    System.out.println("FILME ADICIONADO COM SUCESSO!");
                    break;

                case 2:
                    System.out.println("QUAL O TÍTULO DA SERIE?");
                    String tituloSerie = sc.nextLine();

                    Serie serie = new Serie(tituloSerie);
                    //temporada 01
                    Temporada temp1 = new Temporada(1);

                        //episodio 01
                    System.out.println("QUAL O TÍTULO DO EPISÓDIO 01?");
                    String tituloEp = sc.nextLine();

                    System.out.println("QUAL A DURAÇÃO DO EPISÓDIO 01?");
                    long duracaoEp = sc.nextLong();
                    sc.nextLine();

                    Episodio ep1 = new Episodio(tituloEp, duracaoEp);

                    temp1.adicionar(ep1);

                        //episodio 02
                    System.out.println("QUAL O TÍTULO DO EPISÓDIO 02?");
                    String tituloEp2 = sc.nextLine();

                    System.out.println("QUAL A DURAÇÃO DO EPISÓDIO 02?");
                    long duracaoEp2 = sc.nextLong();
                    sc.nextLine();

                    Episodio ep2 = new Episodio(tituloEp2, duracaoEp2);

                    temp1.adicionar(ep2);
                    serie.adicionar(temp1);

                    //temporada 02
                    Temporada temp2 = new Temporada(2);

                        //episodio 01
                    System.out.println("QUAL O TÍTULO DO EPISÓDIO 01?");
                    String tituloEpisodio = sc.nextLine();

                    System.out.println("QUAL A DURAÇÃO DO EPISÓDIO 01?");
                    long duracaoEpisodio = sc.nextLong();
                    sc.nextLine();

                    Episodio episodio1 = new Episodio(tituloEpisodio, duracaoEpisodio);

                    temp1.adicionar(episodio1);

                        //episodio 02
                    System.out.println("QUAL O TÍTULO DO EPISÓDIO 02?");
                    String tituloEpisodio2 = sc.nextLine();

                    System.out.println("QUAL A DURAÇÃO DO EPISÓDIO 02?");
                    long duracaoEpisodio2 = sc.nextLong();
                    sc.nextLine();

                    Episodio episodio2 = new Episodio(tituloEpisodio2, duracaoEpisodio2);

                    temp2.adicionar(episodio2);
                    serie.adicionar(temp2);


                    

                    midias.add(serie);
                    System.out.println("SÉRIE ADICIONADO COM SUCESSO!");
                    break;

                case 3:
                    for (Midia m:midias){
                        System.out.println(m.info());
                    }
                

                case 4:
                    break;
            }

        }while(op<4);

    }
}
