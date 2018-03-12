package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

import java.util.Objects;

/**
 * Represents an adding or deleting of a tag for a specific person during a session
 */
public class Tagging {

    public static final String SYMBOL_ADD = "+";
    public static final String SYMBOL_REMOVE = "-";

    public enum Change {
        ADD, REMOVE;
    }

    private Person person;
    private Tag tag;
    private Change change;

    public Tagging(Person person, Tag tag, Change change) {
        this.person = person;
        this.tag = tag;
        this.change = change;
    }

    public Person getPerson() {
        return person;
    }

    public Tag getTag() {
        return tag;
    }

    public Change getChange() {
        return change;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this // short circuit if same object
                || obj instanceof Tagging // instanceof handles null
                && ((Tagging) obj).getPerson().equals(this.person)
                && ((Tagging) obj).getTag().equals(this.tag)
                && ((Tagging) obj).getChange().equals(this.getChange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, tag, change);
    }

    @Override
    public String toString() {
        String symbol = (change == Change.ADD) ? SYMBOL_ADD : SYMBOL_REMOVE;
        return symbol + " " + person.getName() + " [" + tag + "]";
    }
}
