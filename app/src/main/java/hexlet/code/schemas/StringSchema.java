package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        addPredicate(s -> ((String) s).length() >= length);
        return this;
    }

    public StringSchema contains(String word) {
        addPredicate(s -> ((String) s).contains(word.toLowerCase()));
        return this;
    }
}
