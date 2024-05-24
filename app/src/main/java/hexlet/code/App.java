package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        var v = new Validator();
        var schema = v.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));

        schema.required();

        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid("what does the fox say"));
        System.out.println(schema.isValid("hexlet"));

        System.out.println(schema.contains("wh").isValid("what does the fox say"));
        System.out.println(schema.contains("what").isValid("what does the fox say"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));

        System.out.println(schema.isValid("what does the fox say"));
    }
}
