import dessins.Rectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer la longueur");
        int longueur = sc.nextInt();
        System.out.println("Entrer la largeur");
        int largeur = sc.nextInt();
        Rectangle rectangle = new Rectangle(longueur, largeur);
        System.out.println("La surface du rectange est : " + rectangle.surface());
        System.out.println("Le perimetre du rectange est : " + rectangle.perimetre());

        System.out.println("Vous avez saisi : " + longueur);
    }
}