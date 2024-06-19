package universite_paris8.iut.kkr.zelda.modele.Arme;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import universite_paris8.iut.kkr.zelda.modele.Arme.Arc;
import universite_paris8.iut.kkr.zelda.modele.Arme.Boomerang;
import universite_paris8.iut.kkr.zelda.modele.Arme.Sabre;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Bonnoctus;
import universite_paris8.iut.kkr.zelda.modele.Ennemis.Ennemis;
import universite_paris8.iut.kkr.zelda.modele.Environnement;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionAcide;
import universite_paris8.iut.kkr.zelda.modele.Potion.PotionForce;

public class TestArmes {
    private Environnement env= new Environnement(800, 800);
    private Boomerang boomerang= new Boomerang(100, 100);
    private Sabre sabre= new Sabre(100, 100);
    private Arc arc = new Arc(100, 100);
    private Ennemis ennemi= new Bonnoctus(env);


    @Test
    void testBoomerangAttaque() {
        int initialPv = ennemi.getPv();
        boomerang.attaquer(ennemi);
        assertTrue(ennemi.getPv() < initialPv, "Boomerang should damage enemies");
    }

    @Test
    void testSabreAttaqueAvecOrbe() {
        int initialPv = ennemi.getPv();
        sabre.attaquer(ennemi);
        assertTrue(ennemi.getPv() < initialPv - sabre.getDegatsOrbe(), "Sabre inflige des dégat d'orbes");
    }

    @Test
    void testArcDegatFeu() {
        int initialPv = ennemi.getPv();
        arc.attaquer(ennemi);
        assertTrue(ennemi.getPv() < initialPv - arc.getDegatsFeu(), "degat de feu");
    }
    @Test
    void testPotionAcideAppliqueeAuSabre() {
        Environnement env = new Environnement(800, 800);
        Sabre sabre = new Sabre(100, 100);
        int attaqueInitiale = sabre.getPtAttaque();
        PotionAcide potionAcide = new PotionAcide(100, 100);
        sabre.appliquerPotionAcide(potionAcide);
        assertEquals(attaqueInitiale + potionAcide.getPtAttaque(), sabre.getPtAttaque(), "Potion Acide augmente les points d'attaque du sabre de 2");
    }



    @Test
    void testPotionForceAppliqueeALArc() {
        Environnement env = new Environnement(800, 800);
        Arc arc = new Arc(100, 100);
        int porteeInitiale = arc.getPortee();
        PotionForce potionForce = new PotionForce(100, 100);

        arc.appliquerPotionDeForce(potionForce);
        assertEquals(porteeInitiale + potionForce.getPortee(), arc.getPortee(), "Potion de Force augmente la portée de l'arc de 3");
    }

}