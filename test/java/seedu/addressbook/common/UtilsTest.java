package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull() throws Exception {
        // empty list
        assertAllNotNull();

        // all objects not null
        assertAllNotNull("abc", "123", "xyz", "789");
        assertAllNotNull(1, 2, 3, 4);

        // one object is null
        assertAnyNull("abc", null, "123", "xyz");
        assertAnyNull(1, 2, 3, null);

        // some objects are null
        assertAnyNull(null, "abc", null, "123");
        assertAnyNull(1, null, 2, 3, null);
        assertAnyNull(null, "xyz", "567", null, null);
    }

    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAnyNull(Object... objects) { assertTrue(Utils.isAnyNull(objects)); }

    private void assertAllNotNull(Object... objects) { assertFalse(Utils.isAnyNull(objects)); }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
