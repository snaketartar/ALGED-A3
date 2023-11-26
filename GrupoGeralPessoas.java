import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrupoGeralPessoas {
    private Map<String, Set<String>> pessoas;

    public GrupoGeralPessoas() {
        this.pessoas = new HashMap<>();
    }

    public void criarGrupo(String individuo, String[] listaConhecidos) {
        Set<String> amigosIndividuoMap = new HashSet<>(Arrays.asList(listaConhecidos));
        pessoas.put(individuo, amigosIndividuoMap);
    }

    public String verificarExistenciaPessoa(String nome) {
         for (Map.Entry<String, Set<String>> entry : pessoas.entrySet()) {
            if (entry.getValue().contains(nome)) {
                return nome + " existe!";
            }
         }
        return pessoas.containsKey(nome) ? nome + " existe!" : nome + " não existe!";
    }

    public String verificarConhecimentoPessoas(String nome1, String nome2) {
        return pessoas.values().stream()
                .filter(amigosIndividuoMap -> filtroConhecidos(amigosIndividuoMap, nome1, nome2))
                .findFirst()
                .map(m -> nome1 + " conhece " + nome2)
                .orElse(nome1 + " não conhece " + nome2);
    }
    
    
    
    private boolean filtroConhecidos(Set<String> map,  String nome1, String nome2) {
        if(pessoas.containsKey(nome1) && map.contains(nome2)){
            return true;
        } else if (pessoas.containsKey(nome2) && map.contains(nome1)) {
          return true;
        } 
        return false;
   }
}
