package dessins;


public class Rectangle {
    private int longueur;
    private int largeur;
    private int origineX;
    private int origineY;

    public Rectangle(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.origineX = 0;
        this.origineY = 0;
    }

    public int surface() {
        return longueur * largeur;
    }

    public int perimetre() {
        return (longueur+largeur)*2;
    }
}
