import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        for(int i = 0; i < 5; i++){
            int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));

            if(num % 3 == 0){
                linkedList.addEndList(new Node(num));
            }
        }
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número no meio da lista ligada"));
        linkedList.addMiddleList(new Node(num), 3);
        linkedList.removeToLinkedList(3);
        linkedList.findNode(6);
        linkedList.showLinkedList();
        linkedList.firstElementLinkedList();
        linkedList.lastElementLinkedList();
    }
}