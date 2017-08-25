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
    public void start(Stage primaryStage) throws IOException {        
        new ViewPrincipal().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
