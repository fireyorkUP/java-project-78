package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    @Test
    void positive() {
        var v = new Validator();
        var schema = v.number();

        schema.required();

        assertFalse(schema.positive().isValid(-10));
        assertFalse(schema.isValid(0));
        assertTrue(schema.isValid(5));
    }

    @Test
    void range() {
        var v = new Validator();
        var schema = v.number();

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }

    @Test
    void isValid() {
        var v = new Validator();
        var schema = v.number();

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }
}
