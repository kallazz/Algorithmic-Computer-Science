import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;

public class BoardController {
    @FXML
    private TilePane board;

    private int rows;
    private int columns;
    private int delay;
    private double probability;
    private final Object mutex = new Object();

    private void myInitialize() {
        final double tileWidth = Math.floor(640.0 / columns);
        final double tileHeight = Math.floor(400.0 / rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Tile tile = new Tile(tileWidth, tileHeight, delay, probability, i, j, rows, columns, mutex);
                tile.setId(i + "," + j);
                board.getChildren().add(tile);
            }
        }

        for (Node node : board.getChildren()) {
            Thread thread = new Thread((Tile) node);
            thread.start();
        }
    }

    public void setData(int rows, int columns, int delay, double probability) {
        this.rows = rows;
        this.columns = columns;
        this.delay = delay;
        this.probability = probability;
        myInitialize();
    }
}
