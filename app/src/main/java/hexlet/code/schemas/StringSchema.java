package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        predicates.clear();
        addPredicate(s -> s.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String word) {
        addPredicate(s -> ((String) s).contains(word));
        return this;
    }
}
