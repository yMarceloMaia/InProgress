import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número, caso queira parar o programa digite o número zero"));

        while(num != 0){
            num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número, caso queira parar o programa digite o número zero"));
            tree.insertNode(num);
        }

        tree.showInOrder();
    }
}