public class CriterioPrecoMinimo implements CriterioBusca {
    public boolean testar(Produto p, String valor) {
        double minimo = Double.parseDouble(valor);
            return p.getPreco()>=minimo;
        }

    }

