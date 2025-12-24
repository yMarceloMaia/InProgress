package main

import "fmt"

// Node representa um nó na lista ligada
type Node struct {
	Data int
	Next *Node
}

// LinkedList representa a lista ligada
type LinkedList struct {
	Head *Node
}

// Append adiciona um nó ao final da lista
func (ll *LinkedList) Append(data int) {
	newNode := &Node{Data: data}
	if ll.Head == nil {
		ll.Head = newNode
		return
	}
	last := ll.Head
	for last.Next != nil {
		last = last.Next
	}
	last.Next = newNode
}

// Prepend adiciona um nó no início da lista
func (ll *LinkedList) Prepend(data int) {
	newNode := &Node{Data: data}
	newNode.Next = ll.Head
	ll.Head = newNode
}

// Delete remove o primeiro nó com o valor especificado
func (ll *LinkedList) Delete(data int) {
	if ll.Head == nil {
		fmt.Println("A lista está vazia.")
		return
	}

	// Se o nó a ser deletado é o Head
	if ll.Head.Data == data {
		ll.Head = ll.Head.Next
		return
	}

	current := ll.Head
	for current.Next != nil && current.Next.Data != data {
		current = current.Next
	}

	if current.Next == nil {
		fmt.Printf("O valor %d não foi encontrado na lista.\n", data)
		return
	}

	current.Next = current.Next.Next
}

// Display exibe todos os valores na lista
func (ll *LinkedList) Display() {
	if ll.Head == nil {
		fmt.Println("A lista está vazia.")
		return
	}
	current := ll.Head
	fmt.Print("Lista: ")
	for current != nil {
		fmt.Printf("%d -> ", current.Data)
		current = current.Next
	}
	fmt.Println("nil")
}

func main() {
	// Criando uma nova lista ligada
	list := LinkedList{}

	fmt.Println("--- Adicionando elementos ---")
	list.Append(10)
	list.Append(20)
	list.Append(30)
	list.Display() // Saída: Lista: 10 -> 20 -> 30 -> nil

	fmt.Println("\n--- Adicionando no início ---")
	list.Prepend(5)
	list.Display() // Saída: Lista: 5 -> 10 -> 20 -> 30 -> nil

	fmt.Println("\n--- Deletando elementos ---")
	fmt.Println("Deletando o valor 20:")
	list.Delete(20)
	list.Display() // Saída: Lista: 5 -> 10 -> 30 -> nil

	fmt.Println("\nDeletando o primeiro elemento (valor 5):")
	list.Delete(5)
	list.Display() // Saída: Lista: 10 -> 30 -> nil

	fmt.Println("\nTentando deletar um valor que não existe (99):")
	list.Delete(99)
	list.Display() // Saída: O valor 99 não foi encontrado na lista.																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																			A lista está vazia.
}