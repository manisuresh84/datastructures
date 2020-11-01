import java.util.*;

class Node1 {
    int val;
    Node1 left,right,random;

    Node1(int x) {
        val = x;
    }
}

class TestData {
    public static void main(String args[]) {
        Node1 x = new Node1(4);
        x.left = new Node1(2);
        x.right = new Node1(6);
        x.left.left = new Node1(1);
        x.left.right = new Node1(3);
        x.right.left = new Node1(5);
        x.right.right = new Node1(7);
        inorderConstruct(x);
        while(x.left!=null) {
            x = x.left;
        }
        while(x!=null) {
            System.out.print(x.val+" ");
            x = x.random;
        }
    }

    public static void inorderConstruct(Node1 root) {
        Stack<Node1> s = new Stack<Node1>();
        Node1 current = root;
        Node1 prev = null;
        while(true) {
            if(current!=null) {
                s.push(current);
                current = current.left;
            }
            else if(!s.isEmpty()) {
                current = s.pop();
                if(prev!=null) {
                    prev.random = current;
                }
                prev = current;
                current = current.right;
            }
            else {
                break;
            }
        }
    }
}