# Guia para Construção de uma Árvore Binária em Python

Este documento serve como um roteiro para você implementar sua própria árvore binária de busca em Python. O objetivo não é dar o código pronto, mas sim fornecer as regras e o norte para que você desenvolva a lógica por conta própria.

---

### Objetivo

Implementar do zero as estruturas de dados `Node` (Nó) e `BinaryTree` (Árvore Binária), incluindo os métodos para inserção de dados e os três percursos clássicos: Pré-Ordem, Em Ordem e Pós-Ordem.

---

### Regras e Diretrizes

Siga as regras abaixo para construir sua implementação.

#### 1. A Estrutura Fundamental: A Classe `Node`

-   **Propósito:** Representar um único elemento na árvore.
-   **Atributos Obrigatórios:**
    1.  `value`: Para armazenar o dado (um número, por exemplo).
    2.  `left`: Uma referência para o nó filho à esquerda.
    3.  `right`: Uma referência para o nó filho à direita.
-   **No Construtor (`__init__`):** O construtor deve receber um `value` e inicializar os atributos `left` e `right` com o valor `None`, pois um novo nó sempre começa sem filhos.

#### 2. O Gerenciador da Árvore: A Classe `BinaryTree`

-   **Propósito:** Orquestrar toda a árvore, gerenciando a raiz e fornecendo a interface para as operações.
-   **Atributo Obrigatório:**
    1.  `root`: A referência para o nó raiz da árvore.
-   **No Construtor (`__init__`):** A árvore deve começar vazia. Portanto, o atributo `root` deve ser inicializado com `None`.

#### 3. A Lógica de Inserção (Árvore de Busca Binária)

-   **Método Principal (`insert`):** Crie um método que recebe um valor. Se a árvore estiver vazia (`self.root` é `None`), o novo valor se torna a raiz. Caso contrário, ele deve delegar a busca pela posição correta a um método auxiliar recursivo.
-   **Método Auxiliar Recursivo:** Este método receberá um nó (começando pela raiz) e o valor a ser inserido. A regra é:
    -   Se o novo `valor` for **menor** que o `valor` do nó atual, a busca deve continuar pela subárvore **esquerda**.
    -   Se o novo `valor` for **maior**, a busca deve continuar pela subárvore **direita**.
    -   A recursão para quando um nó filho (`left` ou `right`) é `None`. É nesse local que o novo nó deve ser criado e inserido.
    -   (Opcional) Decida o que fazer se o valor já existir (por exemplo, ignorar a inserção para não ter duplicatas).

#### 4. A Lógica dos Percursos (Traversals)

Todos os percursos são naturalmente recursivos. A diferença entre eles é a **ordem** em que as três ações fundamentais são executadas:
1.  **Processar o nó atual** (ex: adicionar seu valor a uma lista).
2.  **Chamar a recursão para a subárvore esquerda**.
3.  **Chamar a recursão para a subárvore direita**.

#### 5. Regra do Percurso em Pré-Ordem (Pre-Order)

A ordem de execução é: **Processar o nó -> Esquerda -> Direita**.

#### 6. Regra do Percurso Em Ordem (In-Order)

A ordem de execução é: **Esquerda -> Processar o nó -> Direita**.
*Dica: Se sua inserção estiver correta, este percurso deve retornar os valores em ordem crescente.*

#### 7. Regra do Percurso em Pós-Ordem (Post-Order)

A ordem de execução é: **Esquerda -> Direita -> Processar o nó**.

---

### Como Testar seu Código

1.  Após implementar as classes e métodos, crie um bloco de execução principal (`if __name__ == "__main__":`).
2.  Instancie sua `BinaryTree`.
3.  Crie uma lista de números (ex: `[8, 3, 10, 1, 6, 14]`) e use um laço para inserir cada um deles na sua árvore usando o método `insert`.
4.  Chame cada um dos seus métodos de percurso (`pre_order`, `in_order`, `post_order`) e imprima o resultado.
5.  Antes de rodar, tente prever no papel qual seria a saída correta para cada percurso. Compare sua previsão com o resultado do seu código para validar a lógica.
