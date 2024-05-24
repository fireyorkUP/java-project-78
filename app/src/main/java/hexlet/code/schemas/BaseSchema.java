package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    boolean isRequired = false;
    public List<Predicate<Object>> predicates = new ArrayList<>();

    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.stream()
                .allMatch(p -> p.test(obj));
    }
}
