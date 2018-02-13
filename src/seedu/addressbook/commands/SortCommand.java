package seedu.addressbook.commands;

/**
 * Sorts all person in the address book by their names in ascending order
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all person in the address book by their names in ascending order\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address Book sorted. Enter the list command to view the sorted list.";


    @Override
    public CommandResult execute() {
        addressBook.sortAllPersons();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
