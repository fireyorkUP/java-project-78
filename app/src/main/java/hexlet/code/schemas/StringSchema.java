package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        addPredicate(s -> ((String) s).length() >= minLength);
        return this;
    }

    public StringSchema contains(String word) {
        addPredicate(s -> ((String) s).toLowerCase().contains(word.toLowerCase()));
        return this;
    }
}
