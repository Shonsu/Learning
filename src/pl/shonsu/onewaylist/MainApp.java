package pl.shonsu.onewaylist;

public class MainApp {
    public static void main(String[] args) {

        SingleLinkedList<String> node = new SingleLinkedList<>();
        SingleLinkedList<String> second;

        node.add(0, "Test");
        node.add(0, "DADAS");
        node.add(0, "qwer");
        node.add(0, "dsa");
        node.add(0, "poi");
        node.add(0, "DADvbcxAS");
        System.out.println("test nodes:");
        int size = node.size();
        System.out.println("Number of node elements: " + size);
        while (size > 0) {
            size--;
            System.out.println("Element " + size + " " + node.get(size));
        }

        System.out.println("\nSecond reversed node:");
        second = node.reverse();
        int sizeReversed = second.size();
        System.out.println("Number of node elements: " + sizeReversed);
        int i = 0;
        while (i < sizeReversed) {
            System.out.println("Element " + i + " " + second.get(i));
            i++;
        }
    }
}
