package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        checks.clear();
        addCheck("minLength", s -> s.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String word) {
        addCheck("contains", s -> ((String) s).contains(word));
        return this;
    }
}
