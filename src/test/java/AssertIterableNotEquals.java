import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertIterableNotEquals {

    public static <T> void assertIterableNotEquals(Iterable<T> iterable1, Iterable<T> iterable2) {
        boolean areEqual = true;
        try {
            assertEquals(iterable1, iterable2);
        } catch (AssertionError e) {
            areEqual = false;
        }

        assertFalse(areEqual, "The iterables are unexpectedly equal.");
    }

}
