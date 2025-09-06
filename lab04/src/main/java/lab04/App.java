package lab04;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Consulta de contas!");
        String url = "jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack";
        /*Connection c = DriverManager.getConnection(url);
        System.out.println("Conexão ok!");
        String sql = "SELECT * FROM CONTAS";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet resultado = stm.executeQuery();
        while (resultado.next()) {
            long nro = resultado.getLong("nro_conta");
            double saldo = resultado.getDouble("saldo");
            System.out.println("Número: " + nro + " - R$ " + saldo);
        }
        c.close(); */

        boolean sair = false;

        while (!sair) {
            System.out.println("CONTA");
            System.out.println("(1)CRIAR");
            System.out.println("(2)CONSULTAR");
            System.out.println("(3)ALTERAR");
            System.out.println("(4)EXCLUIR");
            System.out.println("Escolha sua opção: ");

            String opcao = sc.nextLine();

            switch(opcao){
                case "1":
                    create();
                    break;
                case "2":
                    read();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    delete();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        }
    }

    public static void create() throws SQLException {
        System.out.print("Número para a nova conta: ");
        long nro = Long.parseLong(System.console().readLine());
        System.out.print("Saldo da nova conta: ");
        BigDecimal saldo = new BigDecimal(System.console().readLine());
        String url = System.getenv("jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack");

        Connection c = DriverManager.getConnection(url);
        String sql = "INSERT INTO conta VALUES (?, ?)";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setLong(1, nro);
        prepstm.setBigDecimal(2, saldo);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros inseridos: " + ret);
        c.close();
    }

    public static void read() throws SQLException {
        String url = System.getenv("jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack");

        Connection c = DriverManager.getConnection(url);
        String sql = "SELECT * FROM contas";
        PreparedStatement stm = c.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            long nro = rs.getLong("nro_conta");
            BigDecimal saldo = rs.getBigDecimal("saldo");
            System.out.println("Conta número: " + nro + "tem salde R$ " + saldo);
        }
        c.close();

    }

    public static void update() throws SQLException {

        System.out.print("Novo saldo para esta conta: ");
        BigDecimal saldo = new BigDecimal(System.console().readLine());
        String url = System.getenv("jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack");

        Connection c = DriverManager.getConnection(url);
        c.close();
    }

    public static void delete() throws SQLException {
        System.out.print("Número de uma conta já existente: ");
        long nro = Long.parseLong(System.console().readLine());
        String url = System.getenv("jdbc:postgresql://aws-1-sa-east-1.pooler.supabase.com:6543/postgres?user=postgres.mmiybvprayfuloxyzipo&password=ps2#2025mack");

        Connection c = DriverManager.getConnection(url);
        String sql = "DELETE FROM contas WHERE nro_contas=?";
        PreparedStatement prepstm = c.prepareStatement(sql);
        prepstm.setLong(1, nro);
        int ret = prepstm.executeUpdate();
        System.out.println("Número de registros apagados: " + ret);
        c.close();

    }
}