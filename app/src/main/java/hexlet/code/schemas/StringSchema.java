package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StringSchema {

    private boolean isRequired = false;
    private final List<Predicate<Object>> predicates = new ArrayList<>();

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int minLength) {
        Predicate<Object> predicate = s -> ((String) s).length() >= minLength;
        return this;
    }

    public StringSchema contains(String word) {
        Predicate<Object> containsWord = s -> ((String) s).toLowerCase().contains(word.toLowerCase());
        predicates.add(containsWord);
        return this;
    }

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.stream()
                .allMatch(predicate -> predicate.test(obj));
    }
}
