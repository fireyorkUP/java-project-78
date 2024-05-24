package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        addPredicate(n -> n == null || (int) n > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addPredicate(n -> ((int) n >= min) && ((int) n <= max));
        return this;
    }
}
