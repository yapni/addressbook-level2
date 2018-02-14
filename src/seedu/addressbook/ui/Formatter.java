package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

public class Formatter {

    private static final String DIVIDER = "===================================================";

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
}
