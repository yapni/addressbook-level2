package seedu.addressbook.ui;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    public String getPromptMsgForCommand() {
        return LINE_PREFIX + "Enter command: ";
    }
}
