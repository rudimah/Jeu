package universite_paris8.iut.kkr.zelda.modele;

public class Potion extends ObjetEnvironnement {
    private int ptAttaque;
    private int pv;
    private int portee;

    public Potion(String nom, int x, int y, int ptAttaque, int pv, int portee) {
        super(nom, x, y);
        if (ptAttaque < 0 || pv < 0 || portee < 0) {
            System.out.println("Les valeurs de ptAttaque, pv, et portee doivent être positives.");
        }
        this.ptAttaque = ptAttaque;
        this.pv = pv;
        this.portee = portee;
    }

    public int getPtAttaque() { return ptAttaque; }
    public int getPv() { return pv; }
    public int getPortee() { return portee; }

}