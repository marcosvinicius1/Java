/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package painelfx;

import br.com.atmatech.painel.view.ViewPrincipal;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Marcos
 */
public class PainelFX extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{        
        new ViewPrincipal().setVisible(true);                   
       // DBConfigBeans dbc= new DBConfig().getConfig();
//        Button btn = new Button();
//        btn.setText("Teste");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                new ViewPrincipal().setVisible(true);
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Teste");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
