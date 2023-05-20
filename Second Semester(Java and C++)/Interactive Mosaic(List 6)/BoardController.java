import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;

public class BoardController {
    @FXML
    private TilePane board;

    int rows;
    int columns;
    int speed;
    double probability;

    private void myInitialize() {
        final double tileWidth = 640.0 / rows;
        final double tileHeight = 400.0 / columns;
        System.out.println(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Tile tile = new Tile(tileWidth, tileHeight, speed, probability, i, j);
                tile.setId(i + "," + j);
                board.getChildren().add(tile);
            }
        }

        for (Node node : board.getChildren()) {
            Thread thread = new Thread((Tile) node);
            thread.start();
        }
    }

    public void setData(int rows, int columns, int speed, double probability) {
        this.rows = rows;
        this.columns = columns;
        this.speed = speed;
        this.probability = probability;
        myInitialize();
    }
}
