package me.skiffinmc.advdialog.dialog;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import me.skiffinmc.advdialog.AdvDialog;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * TODO: Add node cleaning method (removes nodes that are never called)
 */

/**
 * Stores information about the dialog. Including
 * prompts, options, routing, etc..
 *
 * @author SkiffinMC
 * @since 2018-10-26
 */
public class DialogData {
    private List<DialogNode> nodes = new ArrayList<>();

    /**
     * Gets a dialog node by the nodes id
     * @param nodeId the node id
     * @return the node if it is found, otherwise null
     */
    public DialogNode getNodeById(String nodeId) {
        for (DialogNode node : nodes) {
            if (node.getId().equals(nodeId)) {
                return node;
            }
        }

        return null;
    }

    /**
     * Adds a node to the list
     * @param node node to add
     */
    public void addNode(DialogNode node) {
        nodes.add(node);
    }

    /**
     * Loads the dialog, that corresponds to the dialogID
     * from the dialog.json file, into Java object
     *
     * @param dialogID the id of the dialog to load
     * @return true if loaded successfully, false if not
     */
    public boolean loadDialog(String dialogID) {
        try {

            DialogNode[] nodes;
            JsonReader jsonReader = new JsonReader(new FileReader(AdvDialog.instance.getDataFolder() + "/dialog.json"));

            AdvDialog.instance.getLogger().info("Loaded dialog JSON");

            Gson gson = new Gson();
            nodes = gson.fromJson(jsonReader, DialogNode[].class);
            this.nodes = Arrays.asList(nodes);

            System.out.println(nodes.length);

            System.out.println(getNodeById("start").getPrompt());
            for (DialogOption option : getNodeById("start").getOptions()) {
                System.out.println(option.getPrompt());
            }

        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }
}
