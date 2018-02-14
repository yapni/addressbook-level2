package seedu.addressbook.ui;

import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public class Formatter {

    private static final String DIVIDER = "===================================================";

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    private static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Formats message that prompts for user command */
    public String getPromptMsgForCommand() {
        return LINE_PREFIX + "Enter command: ";
    }

    /** Formats message that echos command entered by user */
    public String getEchoCommandMsg(String command) {
        return "[Command entered:" + command + "]";
    }

    /** Formats welcome message and store each line separately in a string array */
    public String[] getWelcomeMsgStringArray(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return new String[] {DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER};
    }

    /** Formats goodbye message and store each line separately in a string array */
    public String[] getGoodByeMsgStringArr() {
        return new String[] {MESSAGE_GOODBYE, DIVIDER, DIVIDER};
    }

    /** Formats failed initialisation message and store each line separately in a string array */
    public String[] getInitFailedMessage() {
        return new String[] {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
    }

    /** Formats message that is to be displayed to user
     *
     * @param msg Message to be displayed
     * @return Displayed message decorated with a prefix and line separator
     */
    public String formatMsgToDisplay(String msg) {
        return LINE_PREFIX + msg.replace("\n", LS + LINE_PREFIX);
    }

    /** Formats message that shows the result of the user's command and store each line separately in a string array */
    public String[] getShowResultMsgStringArr(String feedbackMsg) {
        return new String[] {feedbackMsg, DIVIDER};
    }

    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
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
    public String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
