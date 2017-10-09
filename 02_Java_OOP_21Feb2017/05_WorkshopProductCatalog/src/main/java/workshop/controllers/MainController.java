package workshop.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import workshop.constants.ProductConstants;
import workshop.db.Repository;
import workshop.models.Product;
import workshop.parsers.ExcelReader;
import workshop.parsers.interfaces.Reader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;
import static workshop.constants.ProductConstants.*;

public class MainController {
    private static final String FX_ALIGN_CENTER = "-fx-alignment: CENTER;";
    private static final String[] EXCEL_EXTENSIONS = { "*.xls", "*.xlsx" };
    private static final String[] PRODUCTS_PROPERTIES = Stream.of(Product.class.getDeclaredFields())
            .map(Field::getName)
            .toArray(String[]::new);
    FileChooser.ExtensionFilter filterFileChooser = new FileChooser.ExtensionFilter("Excel Files", EXCEL_EXTENSIONS);
    private static final Map<String, Integer> columns = new HashMap<String, Integer>() {
        {
            put("A", 0);
            put("B", 1);
            put("C", 2);
            put("D", 3);
            put("E", 4);
            put("F", 5);
            put("G", 6);
            put("H", 7);
            put("I", 8);
            put("J", 9);
            put("K", 10);
            put("L", 11);
            put("M", 12);
            put("N", 13);
            put("O", 14);
            put("P", 15);
            put("Q", 16);
            put("R", 17);
            put("S", 18);
            put("T", 19);
            put("U", 20);
            put("V", 21);
            put("W", 22);
            put("X", 23);
            put("Y", 24);
            put("Z", 25);
        }
    };
    private static final List<String> options = new ArrayList<String>() {
        {
            add(ProductConstants.ID);
            add(ProductConstants.DESCRIPTION);
            add(ProductConstants.TYPE);
            add(ProductConstants.WEIGHT_TYPE);
            add(ProductConstants.WEIGHT_VALUE);
            add(ProductConstants.BRAND_NAME);
            add(ProductConstants.BRAND_COUNTRY);
            add(ProductConstants.NAME);
            add(ProductConstants.PRICE);
            add(ProductConstants.EXPIRATION_DATE);
        }
    };
    private static final Repository repository = Repository.getInstance();

    @FXML
    private TableView productsTable;
    @FXML
    private AnchorPane tablePane;

    public void importData(ActionEvent actionEvent) {
        Window currentStage = Button.class.cast(actionEvent.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(filterFileChooser);
        File selectedFile = fileChooser.showOpenDialog(currentStage);
        try {
            if (selectedFile != null) {
                Reader reader = new ExcelReader();
                Set<Product> products = reader.read(selectedFile, this.mappingObjects());
                repository.persist(products);
                String debug ="";
            }
        } catch (Exception e) {

        }
    }

    public void exportData(ActionEvent actionEvent) {
        Set<Product> products = new HashSet<>(repository.getAll());
        String debug = "";
    }

    public void showTable(ActionEvent actionEvent) {
        this.productsTable = this.populateTable();
        this.productsTable.setVisible(true);
        this.tablePane.getChildren().add(this.productsTable);
        String debug = "";
    }

    private Map<Integer, String> mappingObjects() {
        Map<Integer, String> map = new HashMap<>();
        ChoiceDialog<String> dialog = new ChoiceDialog<String>("A", columns.keySet());
        dialog.setTitle("Column map dialog");
        dialog.setHeaderText("Choose column that contains current value!");
        Iterator<String> iterator = options.iterator();
        final int[] optionsCounter = {0};
        while (iterator.hasNext()) {
            dialog.setContentText("Please enter column letter that contains " + options.get(optionsCounter[0]) + " value: ");
            Optional<String> result = dialog.showAndWait();

            result.ifPresent(column -> {
                int cellIndex = columns.get(column);
                if (!map.containsKey(cellIndex)) {
                    String option = iterator.next();
                    optionsCounter[0]++;
                    map.put(cellIndex, option);
                } else {
//                DIALOG.columnTakenErrorBox(String.valueOf(column));
                }
            });
        }

        return map;
    }

    @SuppressWarnings("unchecked")
    private TableView populateTable() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        repository.getAll().forEach(products::add);

        TableView tableView = new TableView();
        tableView.toFront();

        TableColumn idCol = new TableColumn(ID);
//        //Alternative record:
//        TableColumn<Integer, Product> idCol = new TableColumn<>(ID);
        idCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>(PRODUCTS_PROPERTIES[0]));
        idCol.setResizable(false);
        idCol.setStyle(FX_ALIGN_CENTER);

        TableColumn descCol = new TableColumn(DESCRIPTION);
        descCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[1]));
        descCol.setResizable(false);
        descCol.setStyle(FX_ALIGN_CENTER);

        TableColumn typeCol = new TableColumn(TYPE);
        typeCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[2]));
        typeCol.setResizable(false);
        typeCol.setStyle(FX_ALIGN_CENTER);

        TableColumn weightTypeCol = new TableColumn(WEIGHT_TYPE);
        weightTypeCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[3]));
        weightTypeCol.setResizable(false);
        weightTypeCol.setStyle(FX_ALIGN_CENTER);

        TableColumn weightValueCol = new TableColumn(WEIGHT_VALUE);
        weightValueCol.setCellValueFactory(new PropertyValueFactory<Product, Double>(PRODUCTS_PROPERTIES[4]));
        weightValueCol.setResizable(false);
        weightValueCol.setStyle(FX_ALIGN_CENTER);

        TableColumn brandNameCol = new TableColumn(BRAND_NAME);
        brandNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[5]));
        brandNameCol.setResizable(false);
        brandNameCol.setStyle(FX_ALIGN_CENTER);

        TableColumn brandCountryCol = new TableColumn(BRAND_COUNTRY);
        brandCountryCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[6]));
        brandCountryCol.setResizable(false);
        brandCountryCol.setStyle(FX_ALIGN_CENTER);

        TableColumn nameCol = new TableColumn(NAME);
        nameCol.setCellValueFactory(new PropertyValueFactory<Product, String>(PRODUCTS_PROPERTIES[7]));
        nameCol.setResizable(false);
        nameCol.setStyle(FX_ALIGN_CENTER);

        TableColumn priceCol = new TableColumn(PRICE);
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Double>(PRODUCTS_PROPERTIES[8]));
        priceCol.setResizable(false);
        priceCol.setStyle(FX_ALIGN_CENTER);

        TableColumn expDateCol = new TableColumn(EXPIRATION_DATE);
        expDateCol.setCellValueFactory(new PropertyValueFactory<Product, Date>(PRODUCTS_PROPERTIES[9]));
        expDateCol.setResizable(false);
        expDateCol.setStyle(FX_ALIGN_CENTER);

        tableView.getColumns().addAll(idCol, descCol, typeCol, weightTypeCol, weightValueCol, brandNameCol, brandCountryCol, nameCol, priceCol, expDateCol);

        tableView.setItems(products);
        tableView.prefWidthProperty().bind(((Pane) this.tablePane.getParent()).widthProperty());
        return tableView;
    }
}
