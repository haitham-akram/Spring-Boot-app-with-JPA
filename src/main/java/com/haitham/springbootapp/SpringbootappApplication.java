package com.haitham.springbootapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootappApplication extends Application{

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootappApplication.class, args);
                launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/chfx.fxml"));
        loader.setControllerFactory(SpringApplication.run(SpringbootappApplication.class)::getBean);
        Pane pane = loader.load();
        Scene scene = new Scene (pane);
        primaryStage.setTitle("Spring Boot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
