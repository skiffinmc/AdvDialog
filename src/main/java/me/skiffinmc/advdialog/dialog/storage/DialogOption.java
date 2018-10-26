package me.skiffinmc.advdialog.dialog.storage;

import java.util.ArrayList;
import java.util.List;

/**
 * A dialog option is one of the options that can
 * be chosen within a dialog node.
 *
 * @author SkiffinMC
 * @since 2018-10-26
 */
public class DialogOption {
    private List<String> aliases = new ArrayList<>();
    private String prompt;
    private String action;

    /**
     * Gets the prompt
     * @return the prompt
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Gets the list of aliases
     * @return list of aliases
     */
    public List<String> getAliases() {
        return aliases;
    }

    /**
     * Gets the action
     * @return the action
     */
    public String getAction() {
        return action;
    }
}
