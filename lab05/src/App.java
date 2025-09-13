import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        ContaDao dao;
        
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack";
        dao = new ContaDao(ConnectionFactory.getConnection(url));
        List<Conta> contas;
        contas = dao.lerTodas();
        System.out.println(contas);
        
    }
}
