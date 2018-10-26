package me.skiffinmc.advdialog.dialog.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * A dialog node is one step in a dialog
 * it stores the prompt and the list of options
 * possible.
 *
 * @author SkiffinMC
 * @since 2018-10-26
 */
public class DialogNode {
    private String id;
    private String prompt;
    private List<DialogOption> options = new ArrayList<>();

    /**
     * Gets the node id
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the nodes prompt
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Searches for the option with the specified alias
     * @param alias the alias to search for
     * @return the dialog option, if not found return null
     */
    public DialogOption getOption(String alias) {
        for (DialogOption option : options) {
            if (option.getAliases().contains(alias)) {
                return option;
            }
        }

        return null;
    }

    /**
     * Gets a list of all options
     * @return list of options
     */
    public List<DialogOption> getOptions() {
        return options;
    }

    /**
     * Adds an option
     * @param option option to add
     */
    public void addOption(DialogOption option) {
        options.add(option);
    }
}
