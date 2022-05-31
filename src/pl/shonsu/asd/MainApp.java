package pl.shonsu.asd;

public class MainApp {

    public static void main(String[] args) {
        SimpleHashMap<String,String> test = new SimpleHashMap<String,String>();
        test.put ("asd", "tyret");
        test.put ("3", "er");
        test.put ("2", "fd");
        test.put ("asd", "sdf");
        test.put ("asd", "er");
        System.out.println(test.size());
        System.out.println(test.containsValue("ert"));
    }

}
