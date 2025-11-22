#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sqlite3.h>
#include "responses.h"

#define PORT 8099
#define BUFFER_SIZE 1024

sqlite3 *db;

void init_database()
{
  int rc = sqlite3_open("database.db", &db);
  if (rc)
  {
    fprintf(stderr, "Não foi possível abrir o banco de dados: %s\n", sqlite3_errmsg(db));
    exit(EXIT_FAILURE);
  }
  else
  {
    fprintf(stdout, "Banco de dados conectado com sucesso.\n");
  }
}

int main()
{
  init_database();

  int server_fd, new_socket;
  struct sockaddr_in address;
  int addrlen = sizeof(address);
  char buffer[BUFFER_SIZE] = {0};

  // Criando o socket
  if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0)
  {
    perror("Erro ao criar o socket");
    exit(EXIT_FAILURE);
  }

  // Configurando o endereço do servidor
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = INADDR_ANY;
  address.sin_port = htons(PORT);

  // Ligando o socket ao endereço e porta
  if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0)
  {
    perror("Erro ao associar o socket");
    close(server_fd);
    exit(EXIT_FAILURE);
  }

  // Colocando o socket em modo de escuta
  if (listen(server_fd, 3) < 0)
  {
    perror("Erro ao escutar");
    close(server_fd);
    exit(EXIT_FAILURE);
  }

  printf("Servidor HTTP iniciado na porta %d...\n", PORT);

  // Loop para aceitar conexões
  while (1)
  {
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t *)&addrlen)) < 0)
    {
      perror("Erro ao aceitar conexão");
      continue;
    }

    memset(buffer, 0, BUFFER_SIZE);
    read(new_socket, buffer, BUFFER_SIZE - 1);

    char method[16], path[255];
    memset(method, 0, sizeof(method));
    memset(path, 0, sizeof(path));
    sscanf(buffer, "%15s %254s", method, path);

    printf("--> Rota requisitada: %s %s\n", method, path);

    char http_response[BUFFER_SIZE * 2];
    memset(http_response, 0, sizeof(http_response));

    // Teste hello world
    if (strcmp(method, "GET") == 0 && strcmp(path, "/hello-world") == 0)
    {
      const char *html_body = get_root_html_response();
      sprintf(http_response,
              "HTTP/1.1 200 OK\r\n"
              "Content-Type: text/html\r\n"
              "Content-Length: %zu\r\n"
              "\r\n"
              "%s",
              strlen(html_body), html_body);
    }
    // else
    // {
    //   const char *not_found_body = "<h1>404 Not Found</h1>";
    //   sprintf(http_response,
    //           "HTTP/1.1 404 Not Found\r\n"
    //           "Content-Type: text/html\r\n"
    //           "Content-Length: %zu\r\n"
    //           "\r\n"
    //           "%s",
    //           strlen(not_found_body), not_found_body);
    // }

    write(new_socket, http_response, strlen(http_response));

    close(new_socket);
  }

  sqlite3_close(db);
  close(server_fd);
  return 0;
}
