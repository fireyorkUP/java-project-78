package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    @Test
    void isValid() {
        var v = new Validator();
        var schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));
    }

    @Test
    void sizeof() {
        var v = new Validator();
        var schema = v.map();

        var data = new HashMap<String, String>();
        data.put("key1", "value1");

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

        data.put("key3", "value3");
        assertFalse(schema.isValid(data));
    }

    @Test
    void shapeTest() {
        var v = new Validator();
        var schema = v.map();
        var firstName = v.string().required();
        var lastName = v.string().required().minLength(2);

        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("firstName", firstName);
        schemas.put("lastName", lastName);

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(schema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(schema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(schema.isValid(human3));
    }
}
