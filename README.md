# ALGED-A3

Fase 1:

Foi criada a classe **GrupoGeralPessoas** para centralizar os valores, ela possui uma variável pessoas do tipo Map<String, Set<String>>, cada entrada desse map recebe uma string chave (nome da pessoa) e uma lista de nomes de pessoas conhecidas da pessoa chave.

Para verificar a existência precisamos ver se o nome buscado existe:
- Entre as chaves de entrada do nosso map
- Entre as listas armazenadas no nosso map

Caso o nome seja encontrado em algum desses grupos retornamos avisando de sua existência, caso contrário retornamos avisando da sua não existência.

Para verificar se duas pessoas se conhecem percorremos um processo similar, mas dessa vez é determinante que os nomes estejam compreendidos dentro da mesma relação chave-valor do map. Para isso, podemos percorrer as entradas do nosso map, verificamos a coexistência desses nomes dentro de uma chave e suas entradas ou de apenas suas entradas retornando de acordo.

Foi criada uma função **verificaconhecimentoPessoas** para auxiliar na Fase 2 e determinar com booleanos o conhecimento entre pessoas, essa função utiliza da mesma lógica anterior apenas com um tipo de retorno diferente para melhor atender a fase seguinte.


Fase 2:

Foi criada a classe **FilaBrasileira** que nos ajudará a determinar o conhecimento entre os indivíduos na hora de escolherem seu lugar na fila. Ela possui duas variáveis:
- Uma variável do tipo **GrupoGeralPessoas**
- Um map com uma string chave (nome da fila) relativo a uma lista de strings, sendo essa a fila ordenada com os nomes que compõem tal fila.

As funções base de criar a fila, atender, desistir e imprime usam das funções base do próprio Java, como um forEach para percorrer e printar nosso mapa. A função chegou receberá uma lista de strings com nomes das pessoas que acabaram de chegar e através de um for loop percorrerá essa lista e individualmente fará uso da função **adicionaNaFila** que contém a lógica que de fato insere esses nomes em suas listas conforme as regras de negócio determinadas.

A função adicionaNaFila funciona através dos seguintes passos:
 - Recebe um parâmetro string, o nome da pessoa a ser adicionada. 
 - Utilizamos 4 variáveis auxiliares internas para:
   - Guardar a chave relativa a melhor fila geral/de desconhecidos
   - Chave relativa a melhor fila de conhecidos
   - Comprimento da menor fila geral
   - Posição que o nome seria inserido após encontrar um conhecido

 - Através de um for loop percorremos as chaves do nosso map de filas.
 - Para cada fila em nosso map faremos um novo for loop
   - Cada iteração interna da fila verifica se a pessoa relativa a iteração conhece a pessoa a ser inserida (faremos uso da função verificaconhecimentoPessoas)
   - Caso encontremos um conhecido, verificamos se já havíamos salvo uma posição nessa mesma fila:
     - Caso sim, atualizamos o valor apenas da posição.
     - Caso contrário, estamos numa fila diferente e precisamos verificar se essa posição na nova fila é melhor que a posição da fila que salvamos anteriormente:
       - Caso ela seja nós atualizamos a posição e nome da fila nova.
       - Caso contrário mantemos os valores anteriores.
   - Percorridas todas as pessoas da fila resta apenas verificarmos se a fila que acabou de ser percorrida é a menor fila até agora, caso seja, guardamos sua chave e tamanho.
 - Percorridas todas as filas, precisamos verificar:
   - Encontramos uma posição após algum amigo E também se essa posição é menor do que a menor fila geral:
   - Caso seja, adicionamos o nome logo após o seu conhecido
   - Caso não seja, adicionamos o nome à melhor fila geral.
