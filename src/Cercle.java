import java.awt.Color;
import java.lang.Math;

/** Cercle modélise un cercle dans un repère cartésiens.
 * Un Cercle peut être affiché et translaté.
 *
 * @author  Xavier Crégut <Prénom.Nom@enseeiht.fr>
 */

public class Cercle implements Mesurable2D {
	public static final double PI = Math.PI;
	private Point centre;		// point du centre du cercle
	private Color couleur;	// couleur du cercle
	private double rayon;

	
	/** Construire un cercle par rapport à son centre et son rayon.
	 * @param p centre
	 * @param r rayon 
	 */
	public Cercle(Point p, double r) {
		assert(p != null && r > 0);
		this.centre = copyPoint(p);
		this.rayon = r;
		this.couleur = Color.blue;
	}
	
	/** Construire un cercle par rapport à deux points, le centre et un point du cercle
	 * @param O centre
	 * @param B point
	 */
	public static Cercle creerCercle(Point O, Point B) {
		assert(B != null && O != null);
		Cercle C = new Cercle(O,O.distance(B));
		return C;
	}
	
	/** Construire un cercle par rapport à deux points diametralement opposés.
	 * @param A 1er point
	 * @param B 2eme point
	 */
	public Cercle(Point A, Point B) {
		verifPoint(A, B);
		double vx = A.getX()-B.getX();
		double vy = A.getY()-B.getY();
		Point O = new Point(vx,vy);
		this.centre = O;
		this.rayon = (A.distance(B)/2.0);
		this.couleur = Color.blue;
	}
	
	/** Construire un cercle par rapport à deux points diametralement opposés et de sa couleur.
	 * @param A 1er point
	 * @param B 2eme point
	 * @param Couleur
	 */
	public Cercle(Point A, Point B, Color Couleur) {
		verifPoint(A, B);
		assert(Couleur != null);
		double vx = A.getX()-B.getX();
		double vy = A.getY()-B.getY();
		Point O = new Point(vx,vy);
		this.centre = O;
		this.rayon = (A.distance(B)/2.0);
		this.couleur = Couleur;
	}
	
	
	/** Vérifier les conditions nécessaires sur les points 
	 * @param A point
	 * @param B point 
	 */
	
	private void verifPoint(Point A, Point B) {
		assert(A != null && B != null );
		if (A.getX() == B.getX()) {
			assert(A.getY() != B.getY());
		}
	}
	
	
	/** Copier un point (utile pour valider les exigences de robustesse)
	 * @param A point
	 */
	
	private Point copyPoint(Point A) {
		Point C = new Point(A.getX(),A.getY());
		return C;
	}
	
	
	public String toString() {
		   return "C" + this.rayon +
			  "@(" + this.getCentre().getX() +
			  ", " + this.getCentre().getY() + ")";
		}

	
	/** Translater un cercle suivant les ordonnees et abscisses
	 * @param dx distance de translation suivant les ordonnées
	 * @param dy distance de translation suivant les abscisses
	 */
	public void translater(double dx, double dy) {
		this.centre.translater(dx, dy);
	}
	
	/** Afficher le Cercle. */
	public void afficher() {
		System.out.print(this);
	}

	
	/** Obtenir le centre d'un cercle
	 */
	public Point getCentre() {
		return copyPoint(this.centre);
	}
	
	/** Obtenir le rayon d'un cercle
	 */
	public double getRayon() {
		double rayonbis = this.rayon;
		return rayonbis;
	}
	
	/** Obtenir le diametre d'un cercle
	 */
	public double getDiametre() {
		return this.getRayon()*2;
	}

	/** Obtenir la couleur d'un cercle
	 */
	public Color getCouleur() {
		Color Couleurbis = this.couleur;
		return Couleurbis;
	}
	
	/** Changer la couleur d'un cercle
	 * @param couleur la nouvelle couleur du cercle
	 */
	public void setCouleur(Color couleur) {
		assert(couleur != null);
		this.couleur = couleur;
	}
	
	/** S'assurer qu'un cercle contient un point
	 * @param A point à évaluer
	 */
	public boolean contient(Point A) {
		assert(A != null);
		return this.centre.distance(A) <= this.rayon;
	}
	
	/** Calculer le perimetre d'un cercle
	 */
	public double perimetre() {
		return this.rayon*2*PI;
	}
	
	/** Calculer l'aire d'un cercle
	 */
	public double aire() {
		return this.rayon*rayon*PI;
	}
	
	/** Définir le rayon d'un cercle
	 * @param R rayon
	 */
	public void setRayon(double R) {
		assert(R > 0);
		this.rayon = R;
	}
	
	/** Définir le diamètre d'un cercle
	 * @param D diamètre
	 */
	public void setDiametre(double D) {
		assert(D > 0);
		this.rayon = D/2;
	}
	
}
