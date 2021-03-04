import java.util.*;

public class Main {
    public static void main(String[] args) {
        int testKey = 3;

        LinkedList<Integer> testList = new LinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        testList.add(6);

        Node startTree = new Node(testList);
        System.out.println(startTree.getAndSetMex());
        System.out.println(startTree.getAndSetMex());
        System.out.println(startTree.getAndSetMex());


        LinkedList<Integer> encryptedList = new LinkedList<>();
        for (Integer el : testList) {
            int encrypted = el ^ testKey;
            encryptedList.add(encrypted);
            System.out.print(encrypted + ", ");
        }
    }
}
