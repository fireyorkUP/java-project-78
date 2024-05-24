package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        var v = new Validator();
        var schema1 = v.string();
        System.out.println(schema1.minLength(10).minLength(4).isValid("Hexlet"));
    }
}
