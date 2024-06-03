package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T, V> extends BaseSchema<Map> {

    public MapSchema<T, V> required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema<T, V> sizeof(int size) {
        addCheck("size", map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public MapSchema<T, V> shape(Map<String, BaseSchema<Object>> map) {
        addCheck("shape", s -> {
            return map.keySet().stream()
                    .allMatch(k -> map.get(k).isValid(((Map<?, ?>) s).get(k)));
        });
        return this;

    }
}
