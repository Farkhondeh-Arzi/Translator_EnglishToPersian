package translation_package;

import data_package.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class DrawTree {

    private TreeItem<String> treeItem = new TreeItem<>();
    private TreeView<String> treeView = new TreeView<>(treeItem);

    public DrawTree(Node root) {

        treeItem.setValue(root.getValue().getText()
                + " [" + root.getValue().getTranslation() + "]");
        addItems(treeItem, root);
    }

    private void addItems(TreeItem<String> currentTree, Node currentNode) {

        if (currentNode.getLeft() != null) {
            TreeItem<String> leftItem = new TreeItem<>(currentNode.getLeft().getValue().getText()
                    + " [" + currentNode.getLeft().getValue().getTranslation() + "]");
            currentTree.getChildren().add(leftItem);
            addItems(leftItem, currentNode.getLeft());
        }

        if (currentNode.getRight() != null) {
            TreeItem<String> rightItem = new TreeItem<>(currentNode.getRight().getValue().getText()
                    + " [" + currentNode.getRight().getValue().getTranslation() + "]");
            currentTree.getChildren().add(rightItem);
            addItems(rightItem, currentNode.getRight());
        }
    }

    public TreeView<String> getTreeView() {
        return treeView;
    }
}
