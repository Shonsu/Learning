package pl.shonsu.onewaylist;

public class MainApp {
    public static void main(String[] args) {

        SingleLinkedList<String> node = new SingleLinkedList<>();

        node.add(0,new String("Test"));
        node.add(0,new String("DADAS"));
        node.add(0,new String("qwer"));
        node.add(0,new String("dsa"));
        node.add(0,new String("poi"));
        node.add(0,new String("DADvbcxAS"));
        System.out.println("test nodes:");
        int size = node.size();
        while(size>0) {
            System.out.println(node.get(size-1).toString());
            size--;
        }
    }
}
