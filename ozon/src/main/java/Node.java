import java.util.*;

public class Node {
    private Node parent = null;
    private Node node0 = null;
    private Node node1 = null;
    private boolean closed = false;
    private int depth = 0;

    private static final int MAX_DEPTH = 4;

    public Node(Collection<Integer> ids) {
        for (int id : ids) {
            fillNode(id, calculateUnnecessaryZeroes(id));
        }
    }

    private Node(int depth, Node parent) {
        this.depth = depth;
        this.parent = parent;
    }

    private int calculateUnnecessaryZeroes(int id) {
        int binaryDigitLength = 0;
        while (id != 0) {
            binaryDigitLength++;
            id /= 2;
        }
        return MAX_DEPTH - binaryDigitLength;
    }

    private void calculateUnnecessaryZeroes(int id) {
        int binaryDigitLength = 0;
        while (id != 0) {
            binaryDigitLength++;
            id /= 2;
        }
        return MAX_DEPTH - binaryDigitLength;
    }

    private void fillNode(int id) {
        fillNode(id, 0);
    }

    private void fillNode(int id, int unnecessaryZeroes) {
        if (unnecessaryZeroes != 0) {
            if (node0 == null) { // нужная нода пустая
                node0 = new Node(depth + 1, this);
            }
            node0.fillNode(id, unnecessaryZeroes - 1);
            return;
        }

        if (id == 0) {
            closeThisAndParents();
            System.out.println("Filled node: " + calculateThisDigit());
            return;
        }
        if (id % 2 == 0) {
            if (node0 == null) { // нужная нода пустая
                node0 = new Node(depth + 1, this);
            }
            node0.fillNode(id / 2);
        } else {
            if (node1 == null) { // нужная нода пустая
                node1 = new Node(depth + 1, this);
            }
            node1.fillNode(id / 2);
        }
    }

    public int getAndSetMex() {
        return getAndSetMex(0);
    }

    private int getAndSetMex(int currentMex) {
        if (depth == MAX_DEPTH) {
            closeThisAndParents();
            if (this == parent.node0) {
                return currentMex;
            } else { //  if this == parent.node1
                return currentMex + 1;
            }
        }
        if (node0 == null) { // нужная нода пустая
            node0 = new Node(depth + 1, this);
            return node0.getAndSetMex(currentMex);
        } else if (!node0.closed) { // нода не закрыта
            return node0.getAndSetMex(currentMex);
        } else if (node1 == null) { // нода закрыта
            node1 = new Node(depth + 1, this);
            return node1.getAndSetMex(currentMex + (int) Math.pow(2, MAX_DEPTH - depth));
        } else { // if !node1.closed
            return node1.getAndSetMex(currentMex + (int) Math.pow(2, MAX_DEPTH - depth));
        }
    }

    private void closeThisAndParents() {
        this.closed = true;
        Node currentNode = this;
        while (currentNode.parent != null) {
            Node parentNode = currentNode.parent;
            if (parentNode.node0 != null && parentNode.node1 != null && parentNode.node0.closed && parentNode.node1.closed) {
                parentNode.closed = true;
                currentNode = parentNode;
            } else { // Есть свободная дырка, больше ничего закрывать не надо
                break;
            }
        }
    }

    private int calculateThisDigit() {
        int sum = 0;
        Node parentNode = parent;
        while (parentNode != null) {
            if (parentNode.node1 == this) {
                sum += (int) Math.pow(2, MAX_DEPTH - depth);
            }
            parentNode = parentNode.parent;
        }
        return sum;
    }

    @Override
    public String toString() {
        int thisNode;
        if (parent == null) {
            thisNode = -1;
        } else if (parent.node0 == this) {
            thisNode = 0;
        } else {
            thisNode = 1;
        }
        return "depth:" + depth + ", " + (closed ? "closed" : "open") + ", " + thisNode + (depth == MAX_DEPTH ? ", currentDigit: " + calculateThisDigit() : " non list");
    }
}
