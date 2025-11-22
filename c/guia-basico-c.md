# 🧠 Guia Completo de Linguagem C — Fundamentos e Sintaxe

> Este guia cobre os principais conceitos da linguagem **C**, com exemplos práticos comentados para facilitar o aprendizado.

---

## 📘 1. Estrutura básica de um programa em C

```c
#include <stdio.h>  // Biblioteca padrão de entrada e saída

int main() {
    printf("Hello, World!\n");  // Exibe texto no console
    return 0;                   // Indica que o programa terminou com sucesso
}
```

- `#include` → importa bibliotecas
- `main()` → ponto de entrada do programa
- `printf()` → imprime texto
- `return 0` → encerra o programa

---

## 🔢 2. Tipos de dados

| Tipo     | Tamanho aproximado | Exemplo                | Descrição                  |
| -------- | ------------------ | ---------------------- | -------------------------- |
| `int`    | 4 bytes            | `int idade = 25;`      | Números inteiros           |
| `float`  | 4 bytes            | `float peso = 72.5;`   | Números decimais           |
| `double` | 8 bytes            | `double pi = 3.14159;` | Decimais com mais precisão |
| `char`   | 1 byte             | `char letra = 'A';`    | Um único caractere         |
| `_Bool`  | 1 byte             | `_Bool ativo = 1;`     | Booleano (0 ou 1)          |

---

## 📥 3. Entrada e saída

```c
#include <stdio.h>

int main() {
    int idade;
    printf("Digite sua idade: ");
    scanf("%d", &idade); // Lê um número inteiro
    printf("Você tem %d anos.\n", idade);
    return 0;
}
```

### Formatos de leitura (`scanf`) e escrita (`printf`)

| Tipo     | Formato |
| -------- | ------- |
| `int`    | `%d`    |
| `float`  | `%f`    |
| `double` | `%lf`   |
| `char`   | `%c`    |
| `string` | `%s`    |

---

## 🧮 4. Operadores

### Aritméticos

`+  -  *  /  %`

```c
int a = 10, b = 3;
printf("%d\n", a + b);  // 13
printf("%d\n", a % b);  // 1 (resto)
```

### Relacionais

`==  !=  >  <  >=  <=`

### Lógicos

`&&  ||  !`

```c
if (a > 0 && b > 0) {
    printf("Ambos são positivos.\n");
}
```

---

## 🔁 5. Estruturas de controle

### Condicionais

```c
if (idade >= 18) {
    printf("Maior de idade\n");
} else {
    printf("Menor de idade\n");
}
```

### `switch`

```c
int opcao = 2;
switch (opcao) {
    case 1:
        printf("Opção 1\n");
        break;
    case 2:
        printf("Opção 2\n");
        break;
    default:
        printf("Opção inválida\n");
}
```

---

## 🔄 6. Laços de repetição

### `for`

```c
for (int i = 0; i < 5; i++) {
    printf("i = %d\n", i);
}
```

### `while`

```c
int i = 0;
while (i < 5) {
    printf("%d\n", i);
    i++;
}
```

### `do...while`

```c
int i = 0;
do {
    printf("%d\n", i);
    i++;
} while (i < 5);
```

---

## 📦 7. Arrays (vetores)

```c
int numeros[5] = {1, 2, 3, 4, 5};

for (int i = 0; i < 5; i++) {
    printf("%d ", numeros[i]);
}
```

---

## 🔡 8. Strings (texto)

```c
char nome[20];
printf("Digite seu nome: ");
scanf("%s", nome);   // sem & para strings
printf("Olá, %s!\n", nome);
```

> ⚠️ C não possui tipo `string` nativo — uma string é um **array de `char`**.

---

## 🧱 9. Funções

```c
#include <stdio.h>

int soma(int a, int b) {
    return a + b;
}

int main() {
    int resultado = soma(10, 20);
    printf("Soma = %d\n", resultado);
    return 0;
}
```

---

## 📚 10. Estruturas (`struct`)

```c
#include <stdio.h>

struct Pessoa {
    char nome[50];
    int idade;
};

int main() {
    struct Pessoa p1 = {"Marcelo", 30};
    printf("Nome: %s, Idade: %d\n", p1.nome, p1.idade);
    return 0;
}
```

---

## 🧩 11. Ponteiros

```c
#include <stdio.h>

int main() {
    int x = 10;
    int *ptr = &x;   // ponteiro aponta para o endereço de x

    printf("Valor: %d\n", *ptr);  // acessa o valor de x
    printf("Endereço: %p\n", ptr); // mostra o endereço de memória
    return 0;
}
```

> `*` → acessa o valor apontado  
> `&` → obtém o endereço de memória

---

## 🧠 12. Alocação dinâmica de memória

```c
#include <stdio.h>
#include <stdlib.h>

int main() {
    int *v = malloc(3 * sizeof(int)); // aloca espaço para 3 inteiros
    if (v == NULL) return 1;

    for (int i = 0; i < 3; i++) {
        v[i] = i + 1;
        printf("%d ", v[i]);
    }

    free(v); // libera a memória
    return 0;
}
```

---

## 🗂️ 13. Manipulação de arquivos

```c
#include <stdio.h>

int main() {
    FILE *arquivo = fopen("dados.txt", "w");
    if (arquivo == NULL) return 1;

    fprintf(arquivo, "Texto gravado no arquivo.\n");
    fclose(arquivo);

    arquivo = fopen("dados.txt", "r");
    char linha[100];
    fgets(linha, 100, arquivo);
    printf("Conteúdo: %s", linha);
    fclose(arquivo);
    return 0;
}
```

---

## ⚙️ 14. Compilação

### Compilar e executar:

```bash
gcc programa.c -o programa
./programa
```

### Ativar avisos e depuração:

```bash
gcc programa.c -o programa -Wall -g
```

- `-Wall` → mostra todos os avisos
- `-g` → adiciona informações para debug

---

## 🧩 15. Boas práticas

Usar `const` para valores fixos  
Sempre usar `free()` após `malloc()`  
Ativar `-Wall` para evitar bugs ocultos

---

## 📚 16. Recursos recomendados

- 📘 _The C Programming Language_ — Brian W. Kernighan & Dennis M. Ritchie
- 🌐 [Learn-C.org](https://www.learn-c.org/)
- 🎓 [Tutorialspoint C Tutorial](https://www.tutorialspoint.com/cprogramming/)
- 🧪 [OnlineGDB C Compiler](https://www.onlinegdb.com/)

---
