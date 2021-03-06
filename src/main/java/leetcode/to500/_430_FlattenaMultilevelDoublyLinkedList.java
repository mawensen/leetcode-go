package leetcode.to500;


public class _430_FlattenaMultilevelDoublyLinkedList {


    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node right = node.next;

                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
                while (node.next != null) {
                    node = node.next;
                }

                if (right != null) {
                    node.next = right;
                    node.next.prev = node;
                }
            }
            node = node.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

}
