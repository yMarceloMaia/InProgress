class Node:
    """Classe que representa um nó na lista ligada."""
    def __init__(self, data):
        self.data = data  # O dado que o nó armazena
        self.next = None  # O ponteiro para o próximo nó, inicializado como None

class LinkedList:
    """Classe que representa a lista ligada."""
    def __init__(self):
        """Inicializa a lista com a cabeça (head) apontando para None."""
        self.head = None

    def append(self, data):
        """Adiciona um nó ao final da lista."""
        new_node = Node(data)
        # Se a lista estiver vazia, o novo nó se torna a cabeça
        if not self.head:
            self.head = new_node
            return
        
        # Percorre a lista até encontrar o último nó
        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        
        # Aponta o 'next' do último nó para o novo nó
        last_node.next = new_node

    def prepend(self, data):
        """Adiciona um nó no início da lista."""
        new_node = Node(data)
        # O 'next' do novo nó aponta para a cabeça atual da lista
        new_node.next = self.head
        # A cabeça da lista agora é o novo nó
        self.head = new_node

    def delete(self, data):
        """Remove o primeiro nó com o valor especificado."""
        if not self.head:
            print("A lista está vazia.")
            return

        # Caso especial: o nó a ser deletado é a cabeça
        if self.head.data == data:
            self.head = self.head.next
            return

        # Procura pelo nó a ser deletado, mantendo o controle do nó anterior
        current_node = self.head
        while current_node.next and current_node.next.data != data:
            current_node = current_node.next

        # Se o nó foi encontrado, remove-o da lista
        if current_node.next:
            current_node.next = current_node.next.next
        else:
            print(f"O valor {data} não foi encontrado na lista.")

    def display(self):
        """Exibe todos os valores na lista."""
        if not self.head:
            print("A lista está vazia.")
            return

        elements = []
        current_node = self.head
        while current_node:
            elements.append(str(current_node.data))
            current_node = current_node.next
        
        print("Lista: " + " -> ".join(elements) + " -> None")

# --- Bloco de Execução Principal ---
if __name__ == "__main__":
    # Criando uma nova lista ligada
    llist = LinkedList()

    print("--- Adicionando elementos ---")
    llist.append(10)
    llist.append(20)
    llist.append(30)
    llist.display()  # Saída: Lista: 10 -> 20 -> 30 -> None

    print("\n--- Adicionando no início ---")
    llist.prepend(5)
    llist.display()  # Saída: Lista: 5 -> 10 -> 20 -> 30 -> None

    print("\n--- Deletando elementos ---")
    print("Deletando o valor 20:")
    llist.delete(20)
    llist.display()  # Saída: Lista: 5 -> 10 -> 30 -> None

    print("\nDeletando o primeiro elemento (valor 5):")
    llist.delete(5)
    llist.display()  # Saída: Lista: 10 -> 30 -> None

    print("\nTentando deletar um valor que não existe (99):")
    llist.delete(99)
    llist.display()  # Saída: O valor 99 não foi encontrado na lista.
                     #        Lista: 10 -> 30 -> None
