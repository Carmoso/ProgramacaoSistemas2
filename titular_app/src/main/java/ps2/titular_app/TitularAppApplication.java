package ps2.titular_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static ps2.titular_app.ES.input;
import static ps2.titular_app.ES.print;

@SpringBootApplication
public class TitularAppApplication implements CommandLineRunner {

	@Autowired
	private TitularRepo titularrepo;

	public static void main(String[] args) {
		SpringApplication.run(TitularAppApplication.class, args);
	}

	public void criar() {
		Titular t;
		t = new Titular();
		t.setNome("Thiago");
		t.setCpf("333.333.333-3");
		titularrepo.save(t);
		System.out.println("Titular criado com o id " + t.getId());
	}

	public void lerTudo() {
		Iterable<Titular> titulares = titularrepo.findAll();
		for (Titular t : titulares) {
			print("Titular: " + t);
		}
	}

	public void buscarPeloNum() {
		Iterable<Titular> titulares = titularrepo.findAll();
		Long id = Long.valueOf(input("Digite o ID:"));
		for (Titular t : titulares) {
			if (!(t.getId() == id)) {
			} else {
                            ES.print("Titular"+ t);
                    }
		}

	}
	public void alterarDados() {
		Iterable<Titular> titulares = titularrepo.findAll();
		Long id = Long.valueOf(input("Digite o ID:"));
		
		}

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("# GERENCIADOR DE TITULARES!");
		boolean sair = false;
		String menu = "\n(1) Mostrar todos os titulares";
		menu += "\n(2) Buscar um titular específico pelo número";
		menu += "\n(3) Criar um novo titular";
		menu += "\n(4) Alterar os dados do titular";
		menu += "\n(5) Apagar um titular";
		menu += "\n(0) Sair \n";
		menu += "Escolha uma opção: ";

		while (!sair) {
			String op = input(menu);
			switch (op) {
				case "5":
					lerTudo();
					break;
				case "4":
					lerTudo();
					break;
				case "3":
					criar();
					break;
				case "2":
					buscarPeloNum();
					break;
				case "1":
					lerTudo();
					break;
				case "0":
					sair = true;
					break;
				default:
					print("Opção inválida!");
			}
		}
	}

}
