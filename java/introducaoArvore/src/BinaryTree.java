public class BinaryTree {

    private BIntNo root;

    private BIntNo insert(BIntNo tree, int newValue) {
        if (tree == null) {
            return new BIntNo(newValue);
        } else {
            if (newValue < tree.value) {
                tree.left = insert(tree.left, newValue);
            } else {
                tree.right = insert(tree.right, newValue);
            }
        }
        return tree;
    }



    private void showLeft(BIntNo tree) {
        if (tree != null) {
            showLeft(tree.left);
            System.out.println(tree.value);
        }
    }

    private void showRight(BIntNo tree) {
        if (tree != null) {
            showRight(tree.right);
            System.out.println(tree.value);
        }
    }

    public void insertNode(int newValue) {
        root = insert(root, newValue);
    }

    public void showRoot() {
        System.out.println("Root " + root.value);
    }

    public void showNodeLeft() {
        showLeft(root);
    }

    public void showNodeRight() {
        showRight(root);
    }

    public void showNode() {
        showNodeLeft();
        showRoot();
        showNodeRight();
    }

    private void showInOrder(BIntNo tree) {
        if (tree != null) {
            showInOrder(tree.left);
            System.out.println(tree.value);
            showInOrder(tree.right);
        }
    }

    public void showInOrder() {
        showInOrder(root);
    }

    public void deleteNode(int value) {
        BIntNo auxNode, aux, son, dad;

        auxNode = root;
        dad = null;
        son = root;

        while (auxNode != null && auxNode.value != value) {
            dad = auxNode;
            if (value < auxNode.value) {
                auxNode = auxNode.left;
            } else {
                auxNode = auxNode.right;
            }
        }

        if (auxNode == null) {
            System.out.println("Value not found");
        }

        if (dad == null) {
//            assert auxNode != null;
            if (auxNode.right == null) {
                root = auxNode.left;
            } else {
                if (auxNode.left == null) {
                    root = auxNode.right;
                } else {
                    for (aux = auxNode, son = auxNode.left; son.right != null; aux = son, son = son.right) ;
                    if (son != auxNode.left) {
                        aux.right = son.left;
                        son.left = root.left;
                    }
                    son.right = root.right;
                    root = son;
                }
            }
        } else {
            if (auxNode.right == null) {
                if (dad.left == auxNode) {
                    dad.left = auxNode.left;
                } else {
                    dad.right = auxNode.left;
                }
            } else {
                if (auxNode == null) {
                    if (dad.left == auxNode) {
                        dad.left = auxNode.right;
                    } else {
                        dad.right = auxNode.right;
                    }
                } else {
                    for (aux = auxNode, son = auxNode.left; son.right != null; aux = son, son = son.right) ;
                    if (son != auxNode.left) {
                        aux.right = son.left;
                        son.left = auxNode.left;
                    }
                    son.right = auxNode.right;
                    if (dad.left == auxNode) {
                        dad.left = son;
                    } else {
                        dad.right = son;
                    }
                }
            }
        }
    }
}


