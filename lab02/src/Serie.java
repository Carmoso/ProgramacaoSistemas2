import java.util.ArrayList;
import java.util.List;

public class Serie extends Midia {
    private List<Temporada> temporadas;

    public Serie(String titulo){
        super(titulo);
        temporadas = new ArrayList<>();
    }

    public void adicionar(Temporada temp){
        temporadas.add(temp);
    }

    public long getDuracao(){
        long duracao = 0;
        for (int i = 0; i < temporadas.size(); i++) {
            duracao += temporadas.get(i).getDuracao();
        }
        return duracao;
    }

    public String info(){
        return "Serie: " + super.info() + "; Duração: " + getDuracao();
    }


    
}
