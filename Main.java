
import java.util.Arrays;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        GrupoGeralPessoas sistema = new GrupoGeralPessoas();
        File file = new File("exemplo_entrada.txt");
        processarComandos(file, sistema);
    }

    public static void processarComandos(File arquivoEntrada, GrupoGeralPessoas sistema) {
        Parser parser = new Parser(arquivoEntrada);

        while (parser.hasNext()) {
            String line = parser.nextLine();
            String tokens[] = line.split(" ");
            String input = tokens[0];

          switch (input) {
              case "grupo:" -> sistema.criarGrupo(tokens[1], Arrays.copyOfRange(tokens, 2, tokens.length));
              case "existe:" -> System.out.println(sistema.verificarExistenciaPessoa(tokens[1]));
              case "conhece:" -> System.out.println(sistema.verificarConhecimentoPessoas(tokens[1], tokens[2]));
          }
        }
    }
}
