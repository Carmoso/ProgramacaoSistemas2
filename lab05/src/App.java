import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ContaDao dao;
        
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack";
        dao = new ContaDao(ConnectionFactory.getConnection(url));

        boolean sair = false;
        
        while(!sair) {
            System.out.println("(1) Listar todas as contas");
            System.out.println("(2) Buscar uma conta especifica pelo número");
            System.out.println("(3) Criar uma nova conta");
            System.out.println("(4) Alterar saldo de uma conta");
            System.out.println("(5) Apagar uma conta");
            System.out.println("(6) Sair");

            System.out.println("Escolha uma opção: ");

            String op = sc.nextLine();

            switch(op) {
                case "0":
                    sair = true;
                    return;
                case "1":
                    List<Conta> contas;
                    contas = dao.lerTodas();
                    System.out.println(contas);
                case "2":
                    System.out.println("Digite o número da conta: ");
                    long nro = sc.nextLong();

                    Conta c = dao.buscarPeloNumero(nro);

                    System.out.println(c);
                case "3":
                    System.out.println("Criando uma conta");
                case "4":
                case "5":
                case "6":

            }
        }
    }
}
