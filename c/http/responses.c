#include "responses.h"
#include <stdio.h>

// Implementação da função que monta e retorna a página HTML.
const char *get_root_html_response()
{
    const char *html_content =
        "<!DOCTYPE html>\n"
        "<html lang=\"pt-br\">\n"
        "<head>\n"
        "    <meta charset=\"UTF-8\">\n"
        "    <title>Servidor C</title>\n"
        "    <style>body { font-family: sans-serif; text-align: center; }</style>\n"
        "</head>\n"
        "<body>\n"
        "    <h1>Hello World!</h1>\n"
        "</body>\n"
        "</html>";

    return html_content;
}
