package grid.xo;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("tic-tac-toe for GOTO"); //Заголовок ОКна
		initRootLayout();
		showGridOverview();
	}


	private void initRootLayout() { //инициализация корневого макета
		try{
			//Загрузка корневого макета из fxml
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

		//сцена корневой макет
		Scene scene=new Scene(rootLayout);
		primaryStage.setScene(scene);
        primaryStage.show();
        this.primaryStage.getIcons().add(new Image("file:resources/images/gotologo.png"));
       // scene.getStylesheets().add((getClass().getResource("application.css")).toExternalForm());
		} catch (IOException e) {
            e.printStackTrace();
		}

	}

	private void showGridOverview() {
	try{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/GridOverview.fxml"));
		AnchorPane GridOverview = (AnchorPane) loader.load();
	    rootLayout.setCenter(GridOverview);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

	 public Stage getPrimaryStage() {
	        return primaryStage;
	    }


	public static void main(String[] args) {
		launch(args);
	}
}
