package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T, V> extends BaseSchema<Map> {

    public MapSchema<T, V> required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema<T, V> sizeof(int size) {
        addPredicate(map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public MapSchema<T, V> shape(Map<String, BaseSchema<String>> map) {
        addPredicate(s -> {
            if (!(s instanceof Map)) {
                return false;
            }
            for (var key : map.keySet()) {
                if (!map.get(key).isValid(((Map<?, ?>) s).get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;

    }
}
