/**
 * Testklasse zum Überprüfen des Programms zur Vektorrechnung
 */
package beWeGaTPEPu1A3;
//Packages, die importiert werden
import static org.junit.Assert.*;
import org.junit.Test;



//Klasse zum Testen
public class VectorTest {
	// Epsilon wird für die Epsilonumgebung festgelegt
	double epsilon = 0.00001;
	// verschiedene Vektoren, mit denen gerechnet wird
	Vector v0 = new Vector(0, 0, 0);
	Vector v1 = new Vector(3.0, 4.0, 5.0);
	Vector v2 = new Vector(-1.0, 5.0, -2.0);
	Vector v3 = new Vector(2.0, 1.0, 2.0);
	Vector v4 = new Vector(2.0, 0.0, 5.0);

	/**
	 * Berechnet die Multiplikation eines Vektors mit einem Skalar. Das Ergebnis
	 * wird mit dem zuvor vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Multiplikationsmethode
	@Test
	public void testMult() {
		// Anlegen der 2 Vektoren
		Vector v1 = new Vector(1.0, -5.0, 3.0);
		Vector v2 = new Vector(1, -5, 3);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(new Vector(4.0, -20.0, 12.0), v1.mult(4.0));
		assertEquals(new Vector(-3.0, 15, -9), v2.mult(-3.0));
		
		System.out.println(v1.crossProduct(v0));
		System.out.println(v0.unitVector());
	}

	/**
	 * Berechnet das Skalarprodukt zweier Vektoren. Das Ergebnis wird mit dem
	 * zuvor vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Skalarproduktmethode
	@Test
	public void testScalarMult() {
		// Anlegen der 2 Vektoren
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		Vector v2 = new Vector(-5.0, 9.0, 7.0);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(36.0, v1.scalarMult(new Vector(-7.0, 8.0, 9.0)), epsilon);
		assertEquals(33.0, v2.scalarMult(new Vector(10.0, 3.0, 8.0)), epsilon);
	}

	/**
	 * Berechnet die Addition und die Subtraktion zweier Vektoren. Das Ergebnis
	 * wird mit dem zuvor vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Additionsmethode und Subtraktionsmethode
	@Test
	public void plusUndMinusTest() {
		// Anlegen der 2 Vektoren
		Vector v1 = new Vector(4.0, 0.0, 8.0);
		Vector v2 = new Vector(-1.0, 4.0, 7.0);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(new Vector(3.0, 4.0, 15.0), v1.plus(new Vector(-1.0, 4.0,
				7.0)));
		assertEquals(new Vector(5.0, -4.0, 1.0), v1.minus(new Vector(-1.0, 4.0,
				7.0)));
		assertEquals(v2.plus(v1), v1.plus(v2));
	}

	/**
	 * Berechnet das Kreuzprodukt zweier Vektoren. Das Ergebnis wird mit dem
	 * zuvor vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Kreuzproduktmethode
	@Test
	public void crossProduct() {
		// Anlegen der 2 Vektoren
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		Vector v2 = new Vector(1.0, 2.0, 8.0);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(new Vector(-6.0, -30.0, 22.0), v1.crossProduct(new Vector(
				-7.0, 8.0, 9.0)));
		assertEquals(new Vector(-14.0, 27.0, -5.0), v2.crossProduct(new Vector(
				4.0, 3.0, 5.0)));
	}

	/**
	 * Berechnet den Betrag eines Vektors. Das Ergebnis wird mit dem zuvor
	 * vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Methode, die den Betrag berechnet
	@Test
	public void absTest() {
		// Anlegen des Vektors
		Vector v1 = new Vector(1.0, 1.0, 1.0);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(Math.sqrt(3), v1.abs(), epsilon);
	}

	/**
	 * Benutzt verschiedene Berechnungsmethoden, um deren Gültigkeit auch für
	 * komplexere Aufgaben zu garantieren. Das Ergebnis wird mit dem vermuteten
	 * Ergebnis verglichen - Fehlertest
	 */
	// Test für Rechnungen, bei denen mehrere Methoden benutzt werden
	@Test
	public void complexTest() {
		// Anlegen der 4 Vektoren
		Vector v1 = new Vector(3.0, 4.0, 5.0);
		Vector v2 = new Vector(-1.0, 5.0, -2.0);
		Vector v3 = new Vector(2.0, 1.0, 2.0);
		Vector v4 = new Vector(2.0, 0.0, 5.0);
		// Vergleich, ob vermutetes Ergebnis mit Rückgabewert der Methode
		// übereinstimmt
		assertEquals(Math.sqrt(50), v1.abs(), epsilon);
		assertEquals(-31, v4.scalarMult(v2.crossProduct(v3)), epsilon);
	}

	/**
	 * Berechnet den Nullvektor Das Ergebnis wird mit dem vermuteten Ergebnis
	 * verglichen - Fehlertest
	 */
	// Test für die Nullvektormethode
	@Test
	public void nullVectorTest() {
		assertEquals(new Vector(0, 0, 0), new Vector());
		// 0*v1=Nullvektor, Vergleich, ob Vektor der mit 0 multipliziert wird
		// gleich Nullvektor ist
		assertEquals(v1.mult(0), new Vector());

	}

	/**
	 * Schreibt die Vektorkoordinaten in einen String Das Ergebnis wird mit dem
	 * vermuteten Ergebnis verglichen - Fehlertest
	 */
	// Test für die Methode, die Vektorkoordinaten zu einem String ändert
	@Test
	public void toStringTest() {
		// Vergleich, ob String korrekt zurück gegeben wird
		assertEquals("(3.0, 4.0, 5.0)", v1.toString());
		assertEquals("(0.0, 0.0, 0.0)", v0.toString());

	}

	/**
	 * Überprüft, ob 2 Vektoren gleich sind Das Ergebnis wird mit dem vermuteten
	 * Ergebnis verglichen - Fehlertest
	 */

	@Test
	public void equalsTest() {
		// Vergleich, ob 2 Vektoren gleich sind
		assertTrue(v1.equals(v1));
		assertTrue(v0.equals(v0));
		assertFalse(v0.equals(v1));
		assertFalse(v1.equals(null));
		assertFalse(v1.equals("string"));

	}

	/**
	 * Testet die Methode equals mit Werten für die, die epsilon umgebung nötig
	 * ist Das Ergebnis wird mit dem vermuteten Ergebnis verglichen - Fehlertest
	 */

	@Test
	public void epsilonTest() {
		
		Vector v1 = new Vector(0.33333, 0.666667, 1.0);
		Vector v2 = new Vector(1.0, 2.0, 3.0);

		assertEquals(v1, v2.mult(1.0 / 3.0));
	}

	/**
	 *Testet die Getter Das Ergebnis wird mit dem vermuteten Ergebnis
	 * verglichen - Fehlertest
	 */
	// Testet die Getter
	@Test
	public void testGetter() {
		Vector v1 = new Vector(1.0, 2.0, 3.0);
		double[] all = { 1.0, 2.0, 3.0 };
		for (int i = 0; i < 3; i++) {
			assertEquals(all[i], v1.getAll()[i], epsilon);
		}
		assertEquals(1.0, v1.getX(), epsilon);
		assertEquals(2.0, v1.getY(), epsilon);
		assertEquals(3.0, v1.getZ(), epsilon);
	}

}
