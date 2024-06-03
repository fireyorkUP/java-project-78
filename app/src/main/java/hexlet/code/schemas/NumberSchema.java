package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        this.isRequired = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", n -> n == null || (int) n > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", n -> ((int) n >= min) && ((int) n <= max));
        return this;
    }
}
