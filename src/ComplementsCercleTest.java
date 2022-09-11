import java.awt.Color;
import org.junit.*;
import static org.junit.Assert.*;

/**
  * Classe de test (incomplète) de la classe Cercle.
  * @author	Xavier Crégut
  * @version	$Revision$
  */
public class ComplementsCercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point A, B, C, D, E;

	// Les cercles du sujet
	private Cercle C1, C2;

	@Before public void setUp() {
		// Construire les points
		A = new Point(1, 2);
		B = new Point(2, 1);
		C = new Point(4, 1);
		D = new Point(8, 1);
		E = new Point(8, 4);

		// Construire les cercles
		C1 = new Cercle(A, 2.5);
		C2 = new Cercle(new Point(6, 1), 2);
		C2.setCouleur(Color.yellow);
	}
	
	/** Vérifier si deux points ont mêmes coordonnées.
	  * @param p1 le premier point
	  * @param p2 le deuxième point
	  */
	static void memesCoordonnees(String message, Point p1, Point p2) {
		assertEquals(message + " (x)", p1.getX(), p2.getX(), EPSILON);
		assertEquals(message + " (y)", p1.getY(), p2.getY(), EPSILON);
	}

	@Test public void testerE2() {
		memesCoordonnees("E2 sur C1", A, C1.getCentre());
		memesCoordonnees("E2 sur C2", new Point(6, 1), C2.getCentre());
	}
}


