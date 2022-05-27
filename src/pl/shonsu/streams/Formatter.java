package pl.shonsu.streams;

public class Formatter {
    static String s;
    static class Inner {
        void testMethod() {
           s = "Set from Inner";
        }
    }
}