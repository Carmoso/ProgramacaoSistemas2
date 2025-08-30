public class CriterioPrecoMaximo implements CriterioBusca {
    public boolean testar(Produto p, String valor) {
        double maximo = Double.parseDouble(valor);
            return p.getPreco()<=maximo;
        }

    }

