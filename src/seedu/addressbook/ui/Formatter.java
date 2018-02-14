package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public class Formatter {

    private static final String DIVIDER = "===================================================";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** Message that prompts for user command */
    public String getPromptMsgForCommand() {
        return LINE_PREFIX + "Enter command: ";
    }

    /** Message that echos command entered by user */
    public String getEchoCommandMsg(String command) {
        return "[Command entered:" + command + "]";
    }

    public String[] getWelcomeMsgStringArray(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        String[] msg
                = {DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER};
        return msg;
    }

    public String[] getGoodByeMsgStringArr() {
        String[] msg = {MESSAGE_GOODBYE, DIVIDER, DIVIDER};
        return msg;
    }

    public String[] getInitFailedMessage() {
        String[] msg = {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
        return msg;
    }

    /** Formats message to display to user
     *
     * @param msg Message to be displayed
     * @return Displayed message decorated with a prefix and line separator
     */
    public String formatMsgToDisplay(String msg) {
        return LINE_PREFIX + msg.replace("\n", LS + LINE_PREFIX);
    }

    public String[] getShowResultMsgStringArr(String feedbackMsg) {
        String[] msg = {feedbackMsg, DIVIDER};
        return msg;
    }

    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
