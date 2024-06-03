package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected boolean isRequired = false;
    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    /**
     * @param checkName allows you to add check name to map
     * @param predicate allows you to add predicates to map
     */
    protected final void addCheck(String checkName, Predicate<T> predicate) {
        checks.put(checkName, predicate);
    }

    /** null validation.
     * @return This object type
     */
    public abstract BaseSchema required();

    /** Checks that all validations are pass.
     * @param obj Strongly parametrized object
     * @return true if all validations passed, false otherwise
     */
    protected boolean isValid(T obj) {
        if (obj == null || obj.equals("")) {
            return !isRequired;
        }
        for (var check : checks.entrySet()) {
            if (!check.getValue().test(obj)) {
                return false;
            }
        }
        return true;
    }
}
