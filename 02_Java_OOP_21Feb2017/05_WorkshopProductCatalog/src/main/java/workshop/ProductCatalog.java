package workshop;


import javafx.application.Application;
import javafx.stage.Stage;
import workshop.constants.AppConstants;
import workshop.utils.stageUtils.StageManager;
import workshop.utils.stageUtils.StageManagerImpl;

public class ProductCatalog extends Application {

    public void start(Stage primaryStage) throws Exception {
        StageManager manager = new StageManagerImpl();
        manager.loadSceneToStage(primaryStage, AppConstants.MAIN_VIEW, null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
