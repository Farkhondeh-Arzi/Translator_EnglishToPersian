package translation_package;

import data_package.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShowTree {

    AnchorPane anchorPane = new AnchorPane();
    ScrollPane scrollPane = new ScrollPane();

    public ShowTree(Node root) {
        recursiveDraw(root, 700, 50, 0);
//        anchorPane.getChildren().addAll(scrollPane);
    }

    public void recursiveDraw(Node currentNode, double x, double y, int depth) {
        Label label = new Label(currentNode.getValue().getText() + "\n" + currentNode.getValue().getTranslation());
        label.setLayoutX(x + 50);
        label.setLayoutY(y);

        anchorPane.getChildren().addAll(label);

        Line leftLine = new Line(x + 65 - (100 - 2 * (depth - 1)), y + 40, (x - 30) - (100 - 2 * depth), y + 70);
        Line rightLine = new Line(x + 65 + (100 - 2 * (depth - 1)), y + 40, (x + 130) + (100 - 2 * depth), y + 70);

        if (currentNode.getLeft() != null) {
            anchorPane.getChildren().add(leftLine);
            recursiveDraw(currentNode.getLeft(), x - 70, y + 70, depth + 1);
        } //else {
//            Circle circle = new Circle(x - 50, y + 100, 20);
//            anchorPane.getChildren().addAll(circle, leftLine);
//        }
        if (currentNode.getRight() != null) {
            anchorPane.getChildren().add(rightLine);
            recursiveDraw(currentNode.getRight(), x + 70, y + 70, depth + 1);
        } //else {
//            Circle circle = new Circle(x + 50, y + 100, 20);
//            anchorPane.getChildren().addAll(circle, rightLine);
//        }
    }
    // getter

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
