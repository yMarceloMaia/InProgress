# Entendendo o Servidor HTTP em C

Este documento explica cada parte do código `http_server.c` e onde deve adicionar a lógica para interpretar (fazer o "parse") da requisição HTTP.

## Análise do Código

O código cria um servidor web muito básico:

### 1. Includes e Defines

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define PORT 8099
#define BUFFER_SIZE 1024
```

- **Includes**: Importam bibliotecas essenciais. `stdio.h` para entrada/saída (como `printf`), `stdlib.h` para funções gerais (como `exit`), `string.h` para manipulação de strings (como `strlen`), e as outras para as chamadas de rede (sockets).
- **Defines**: Criam constantes para a porta do servidor (`8099`) e o tamanho do buffer (`1024` bytes), o que torna o código mais legível e fácil de modificar.

### 2. Preparação do Servidor

```c
int main()
{
  int server_fd, new_socket;
  struct sockaddr_in address;
  int addrlen = sizeof(address);
  char buffer[BUFFER_SIZE] = {0};
  const char *response =
      "HTTP/1.1 200 OK\r\n"
      "Content-Type: text/plain\r\n"
      "Content-Length: 13\r\n"
      "\r\n"
      "Hello, World!";

  // ... (código de configuração do socket) ...
}
```

- Aqui, é declarado as variáveis principais:
  - `server_fd`, `new_socket`: Descritores de arquivo para os sockets do servidor e do cliente.
  - `address`: Estrutura que guarda as informações do endereço do servidor (família de endereços, IP, porta).
  - `buffer`: Um espaço na memória para armazenar a requisição que vem do cliente.
  - `response`: A resposta HTTP fixa que seu servidor envia.

### 3. Configuração do Socket

```c
  // Criando o socket
  if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) { /*...*/ }

  // Configurando o endereço do servidor
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = INADDR_ANY;
  address.sin_port = htons(PORT);

  // Ligando o socket ao endereço e porta
  if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) { /*...*/ }

  // Colocando o socket em modo de escuta
  if (listen(server_fd, 3) < 0) { /*...*/ }
```

- **`socket()`**: Cria o "ponto de acesso" da rede para o servidor.
- **Configuração do `address`**: Define que vai ser usado IPv4 (`AF_INET`), que o servidor aceitará conexões de qualquer interface de rede (`INADDR_ANY`) e na porta definida (`PORT`). `htons` garante que o número da porta esteja no formato correto para a rede.
- **`bind()`**: Associa o socket que você criou com o endereço e a porta configurados.
- **`listen()`**: Marca o socket como passivo, ou seja, ele ficará "escutando" por conexões de entrada.

### 4. O Loop Principal (Onde a Mágica Acontece)

```c
  printf("Servidor HTTP iniciado na porta %d...\n", PORT);

  while (1)
  {
    // ... (aceita conexão, lê e escreve) ...
  }
```

Este `while(1)` é o coração do servidor. Ele roda para sempre, esperando por novas conexões.

### 5. Interação com o Cliente

Dentro do `while(1)`:

```c
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t *)&addrlen)) < 0) { /*...*/ }

    // Lendo a solicitação do cliente
    read(new_socket, buffer, BUFFER_SIZE);
    printf("Requisição recebida:\n%s\n", buffer);

    // Enviando a resposta HTTP
    write(new_socket, response, strlen(response));

    // Fechando o socket do cliente
    close(new_socket);
```

- **`accept()`**: Esta função é bloqueante. O programa para aqui e fica esperando até que um cliente se conecte. Quando isso acontece, ela cria um **novo socket** (`new_socket`) para a comunicação com aquele cliente específico e o programa continua.
- **`read()`**: Lê os dados enviados pelo cliente (a requisição HTTP) e os armazena no `buffer`.
- **`write()`**: Envia a sua resposta fixa (`response`) de volta para o cliente.
- **`close(new_socket)`**: Encerra a conexão com o cliente atual. O servidor então volta para o `accept()` para esperar o próximo.

---

## Onde Implementar o Passo 1 (Parse da Requisição)

Você deve adicionar sua lógica **logo após a requisição ser lida e antes da resposta ser enviada**.

O local ideal é aqui:

```c
    // Lendo a solicitação do cliente (opcional, dependendo do uso)
    read(new_socket, buffer, BUFFER_SIZE);
    printf("Requisição recebida:\n%s\n", buffer);

    // ==================================================================
    // ==                                                              ==
    // ==          É AQUI QUE VOCÊ DEVE ADICIONAR SEU CÓDIGO           ==
    // ==                                                              ==
    // ==================================================================
    //
    // OBJETIVO: Analisar o conteúdo da variável 'buffer' para descobrir
    // o método (GET, POST) e o caminho (/, /index.html).
    //
    // DICA: A primeira linha do buffer terá algo como "GET / HTTP/1.1".
    // Você pode usar a função strtok() para quebrar essa linha em partes.
    //
    // char method[10];
    // char path[255];
    // sscanf(buffer, "%s %s", method, path);
    // printf("Método: %s, Caminho: %s\n", method, path);
    //

    // Enviando a resposta HTTP
    write(new_socket, response, strlen(response));
```

Nesse ponto, a variável `buffer` contém a requisição completa do navegador. Seu trabalho é extrair as informações de dentro dela antes de decidir qual resposta enviar com a função `write()`. A dica com `sscanf` é uma forma bem direta de começar!

```

```
