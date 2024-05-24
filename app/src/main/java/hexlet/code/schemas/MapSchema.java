package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        this.isRequired = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addPredicate(map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> map) {
        addPredicate(s -> {
            if (!(s instanceof Map)) {
                return false;
            }
            for (String key : map.keySet()) {
                if (!map.get(key).isValid(((Map<?, ?>) s).get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;

    }
}
