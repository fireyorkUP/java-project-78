package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected List<Predicate<Object>> predicates = new ArrayList<>();

    /**
     * @param predicate allows you to add predicates to list
     */
    public void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    /** null validation.
     * @return This object type
     */
    public abstract BaseSchema required();

    /** Checks that all validations are pass.
     * @param obj Strongly parametrized object
     * @return true if all validations passed, false otherwise
     */

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        return predicates.stream()
                .allMatch(p -> p.test(obj));
    }
}
