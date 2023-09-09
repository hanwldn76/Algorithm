import java.util.*;

class Node{
    Object data;
    Node leftChild, rightChild;

    public Node(Object data) {
        this.data = data;
    }
}

public class BinaryTree {
    static int number = 15;

    static void preorder(Node ptr){
        if(ptr!=null){
            System.out.print(ptr.data + " ");
            preorder(ptr.leftChild);
            preorder(ptr.rightChild);
        }
    }

    static void postorder(Node ptr){
        if(ptr!=null){
            postorder(ptr.leftChild);
            postorder(ptr.rightChild);
            System.out.print(ptr.data + " ");
        }
    }

    static void inorder(Node ptr){
        if(ptr!=null){
            inorder(ptr.leftChild);
            System.out.print(ptr.data + " ");
            inorder(ptr.rightChild);
        }
    }

    public static void main(String[] args){
        Node nodes[] = new Node[number+1];

        for(int i = 1; i<=number; i++){
            Node node = new Node(i);
            node.rightChild = null;
            node.leftChild = null;
            nodes[i] = node;
        }

        for(int i = 2; i<= number; i++){
            if(i % 2 == 0){
                nodes[i/2].leftChild = nodes[i];
            }else{
                nodes[i/2].rightChild = nodes[i];
            }
        }

        System.out.print("전위 순회: ");
        preorder(nodes[1]);
        System.out.println();

        System.out.print("중위 순회: ");
        inorder(nodes[1]);
        System.out.println();

        System.out.print("후위 순회: ");
        postorder(nodes[1]);
        System.out.println();
    }
}
