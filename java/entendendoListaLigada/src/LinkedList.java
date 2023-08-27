public class LinkedList {
    Node first, last;

    LinkedList() {
        first = null;
        last = null;
    }

    public boolean emptyList() {
        return first == null && last == null;
    }

    public void destroyList() {
        first = null;
        last = null;
    }

    public int sizeList() {
        int avg = 0;
        Node aux = first;
        while (aux != null) {
            avg++;
            aux = aux.next;
        }
        return avg;
    }

    public void showLinkedList() {
        Node aux = first;
        for (int i = 0; i < sizeList(); i++) {
            System.out.println("elemento " + aux.data + " na posição " + i);
            aux = aux.next;
        }
    }

    public void firstElementLinkedList() {
        if (emptyList()) {
            System.out.println("Lista vazia");
        } else {
            System.out.println(first.data);
        }
    }

    public void lastElementLinkedList() {
        if (emptyList()) {
            System.out.println("Lista vazia");
        } else {
            System.out.println(last.data);
        }
    }

    public void addStartList(Node newNode) {
        if (emptyList()) {
            last = newNode;
        } else {
            newNode.next = first;
        }
        first = newNode;
    }

    public void addEndList(Node newNode) {
        if (emptyList()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    public void addMiddleList(Node newNode, int position) {
        Node aux = first;
        int numNodes, posAux = 1;
        numNodes = sizeList();
        if (position <= 1) {
            addStartList(newNode);
        } else {
            if (position > numNodes) {
                addEndList(newNode);
            } else {
                while (posAux < (position - 1)) {
                    aux = aux.next;
                    posAux++;
                }
                newNode.next = aux.next;
                aux.next = newNode;
            }
        }
    }

    public void removeToLinkedList(int element) {
        Node aux = first;
        Node before = null;
        if (first.data == element) {
            first = first.next;
        } else {
            while(aux != null && aux.data != element){
                before = aux;
                aux = aux.next;
            }
            if (aux != null){
                before.next = aux.next;
            }
            if(aux == last){
                last = aux;
            }
        }
    }

    public Node findNode(int element){
        int i = 1;
        Node aux = first;
        while(aux != null){
            if(aux.data == element){
                return aux;
            }
            i++;
            aux = aux.next;
        }
        return null;
    }
}



















