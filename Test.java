public class Test {
    int x = 1;
    String name = "John";

    static void HelloWorld() {
        System.out.println("Hello World");
    }
    public static void main(String[] args) {
        HelloWorld();
        Test test = new Test();
        System.out.println(test.x);

        test.x += 1;
        System.out.println(test.x);
    }
}

class SecondTest {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Name: " + test.name);
    }
}
