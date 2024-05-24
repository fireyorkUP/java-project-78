package hexlet.code.schemas;


public class StringSchema {

    private boolean required = false;
    private String contains = null;
    private int minLength = 0;

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String contains) {
        this.contains = contains;
        return this;
    }

    public boolean isValid(String value) {
        if (required && (value == null || value.isEmpty())) {
            return false;
        }
        if (contains != null && !value.contains(contains)) {
            return false;
        }
        if (value.length() < minLength) {
            return false;
        }
        return true;
    }
}
