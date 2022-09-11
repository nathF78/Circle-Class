import static org.junit.Assert.assertEquals;
import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

/** Programme de test de la classe Segment.
  * @author  Xavier CrÃ©gut
  * @version 1.4
  */
public class CercleTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;

	// Les points du sujet
	private Point A, B, C, D;

	// Les cercles du sujet
	private Cercle C1, C2, C3;
	
	@Before public void setUp() {
		// Construire les points
		A = new Point(1, 2);
		B = new Point(2, 1);
		C = new Point(4, 1);
		D = new Point(8, 1);

		// Construire les cercles
	
	}
	
	@Test public void testerE12() {
		Cercle C1 = new Cercle(A,B);
		assertEquals("E12", 1.414, C1.getDiametre(), EPSILON);
		Cercle C2 = new Cercle(C,D);
		assertEquals("E12", 4.0, C2.getDiametre(), EPSILON);
	}
	
	@Test public void testerE13() {
		Cercle C1 = new Cercle(C,B,Color.yellow);
		assertEquals("E13", 2.0, C1.getDiametre(), EPSILON);
		assertEquals("E13", Color.yellow, C1.getCouleur());
		Cercle C2 = new Cercle(A,D,Color.green);
		assertEquals("E12", 7.071, C2.getDiametre(), EPSILON);
		assertEquals("E13", Color.green, C2.getCouleur());
	}
	
	@Test public void testerE14() {
		C3 = C3.creerCercle(A, B);
		assertEquals("E14", 1.414, C3.getRayon(), EPSILON);
		assertEquals("E13", Color.blue, C3.getCouleur());
	}
		
		
		
	}
