package universite_paris8.iut.kkr.zelda.Controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import universite_paris8.iut.kkr.zelda.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleurMenu implements Initializable {
    @FXML
    VBox contenuRegles;
    @FXML
    VBox contenuBoutons;
    @FXML
    VBox contenuCredits;
    @FXML
    VBox contenuQuitter;
    @FXML
    Button boutonQuitter;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    //lance le jeu dès qu'on appuie sur jouer
    @FXML
    public void gererBoutonJouer(ActionEvent event) {
        System.out.println("Lancement du jeu...");
        try {
            Main main = new Main();
            main.start(new Stage());
            Scene scene = ((javafx.scene.Node)event.getSource()).getScene().getWindow().getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //affiche les regle lorsqu'on appuie sur 'Règles'
    @FXML
    public void gererBoutonRegles(ActionEvent event){
        System.out.println("Affichage des règles...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        contenuRegles.setVisible(true);
    }


    //affiche les crédits lorsqu'on appuie sur 'Crédits'
    @FXML
    public void gererBoutonCredits(ActionEvent event){
        System.out.println("Affichage des crédits en cours...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        contenuCredits.setVisible(true);
    }


    //Permet de quitter le jeu quand on appuie sur 'Quitter'
    @FXML
    public void gererBoutonQuitter(ActionEvent event){
        System.out.println("Ouverture de la fenêtre de quittage...");
        cacherLeContenu();
        contenuBoutons.setVisible(false);
        boutonQuitter.setVisible(false);
        contenuQuitter.setVisible(true);
    }


    //Gère l'action de retour au menu principal
    @FXML
    private void retourAuMenu(ActionEvent event) {
        cacherLeContenu();
    }


    //Elle termine l'exécution de l'application
    @FXML
    private void confirmerQuitter() {
        System.out.println("Vous avez choisi de quitter...");
        System.exit(0);
    }


    //reviens sur le menu du début
    @FXML
    private void annulerQuitter() {
        System.out.println("Fermeture de la fenêtre de quittage");
        cacherLeContenu();
    }


    private void cacherLeContenu() {
        contenuBoutons.setVisible(true);
        contenuRegles.setVisible(false);
        contenuCredits.setVisible(false);
        contenuQuitter.setVisible(false);
        boutonQuitter.setVisible(true);
    }
}