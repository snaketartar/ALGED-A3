import java.util.*;

class FilaBrasileira {
    private Map<String, List<String>> filas;
    private GrupoGeralPessoas grupoGeralPessoas;

    public FilaBrasileira(GrupoGeralPessoas grupoGeralPessoas) {
        this.filas = new HashMap<>();
        this.grupoGeralPessoas = grupoGeralPessoas;
    }

    public void criaFila(String id, List<String> pessoas) {
        List<String> fila = new LinkedList<>(pessoas);
        filas.put(id, fila);
    }

    public void atendeFilas(List<String> ids) {
        for (String id : ids) {
            filas.get(id).remove(0);
        }
    }

    public void chegou(List<String> nomes) {
        for (String nome : nomes) {
            adicionaNaFila(nome);
        }
    }

    private void adicionaNaFila(String nome) {
        String melhorFilaDeDesconhecidos = "";
        int comprimentoMenorFila = Integer.MAX_VALUE;

        for (Map.Entry<String, List<String>> fila : filas.entrySet()) {
            for (int i = 0; i < fila.getValue().size(); i++) {
                String pessoaNaFila = fila.getValue().get(i);
                boolean conheceAlguemNaFila = grupoGeralPessoas.verificaconhecimentoPessoas(nome, pessoaNaFila);

                if (conheceAlguemNaFila) {
                    filas.get(fila.getKey()).add(i + 1, nome);
                    return;
                }
            }
            if (fila.getValue().size() < comprimentoMenorFila) {
                melhorFilaDeDesconhecidos = fila.getKey();
                comprimentoMenorFila = fila.getValue().size();
            }
        }
        filas.get(melhorFilaDeDesconhecidos).add(nome);
    }

    public void desiste(List<String> nomes) {
        for (String nome : nomes) {
            filas.values().forEach(fila -> fila.remove(nome));
        }
    }

    public void imprimeFilas() {
        filas.forEach((id, fila) -> System.out.println("#" + id + " " + fila));
    }
}
