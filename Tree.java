class Node {
    int key;
    String data;
    Node leftChild, rightChild;
}

class Tree{
    Node root;

    public void insert(int key, String data){
        Node newNode = new Node();
        newNode.key = key;
        newNode.data = data;
        if (root == null){
            root = newNode;
        }else {
            Node current = root;
            Node parent;
            while (newNode.key != current.key){
                parent = current;
                if (key < current.key){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node node){
        if (node != null){
            inorderRec(node.leftChild);
            System.out.println(node.key);
            inorderRec(node.rightChild);
        }
    }

    public Node findKey(int key){
        Node current = root;
        while(current.key != key)
        {
            if(key < current.key)
                current = current.leftChild;
            else {
                current = current.rightChild;
            }if(current == null) {
                System.out.println("Студент не найден!");
                return null;
            }
        }
        System.out.println("Студент найден " + current.data);
        return current;
    }

    public static void main(String[] agrs){
        Tree tree = new Tree();

        tree.insert(6, "Шакирбеков");
        tree.insert(7, "Серкебаев");
        tree.insert(5, "Акматов");
        tree.insert(8, "Курманалиев");
        tree.insert(9, "Болотов");
        tree.insert(2, "Усенбаев");
        tree.insert(3, "Джолдошбеков");
        tree.insert(4, "Марал уулу");
        tree.insert(1, "Забиров");

        tree.inorder();

        tree.findKey(1);
        tree.findKey(9);
        tree.findKey(5);
        tree.findKey(3);
        tree.findKey(8);
        tree.findKey(0);
        tree.findKey(43);
        tree.findKey(22);
    }
}
