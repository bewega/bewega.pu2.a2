/**
* Programm zum Rechnen mit Vektoren, das Skalarprodukt, Kreuzprodukt, Betrag, Multiplikation, 
* Addition, Subtraktion und Einheitsvektor berechnen kann.
* 
* @author Rebekka Weissinger
* @author Thomas Berthold
* @author Norbert Galuschek
*/
package beWeGaTPEPu1A3;

public class Vector {

	private double x;
	private double y;
	private double z;

	// Konstruktor
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * erstellt einen Nullvektor
	 */
	public Vector() {
		x = 0;
		y = 0;
		z = 0;
	}

	/**
	 * Addiert zwei Vektoren zueinander
	 * 
	 * @param v2 Vektor, der dazuaddiert werden soll vom Typ Vector
	 * @return Der R�ckgabewert der Methode ist vom Typ Vector und enth�lt das Ergebnis der Addition
	 */
	//Methode, die 2 Vektoren miteinander addiert
	public Vector plus(Vector v2) {
		double x = this.x + v2.x;
		double y = this.y + v2.y;
		double z = this.z + v2.z;

		//Ein neuer Vektor wird angelegt, in dem das Ergebnis gespeichert wird
		Vector v3 = new Vector(x, y, z);
		return v3;
	}

	/**
	 * Zieht einen Vektor vom anderen ab
	 * 
	 * @param v2 Vektor, der abgezogen werden soll vom Typ Vector
	 * @return Der R�ckgabewert der Methode ist vom Typ Vector und enth�lt das Ergebnis der Subtraktion
	 */
	//Methode, die 2 Vektoren voneinander subtrahiert
	public Vector minus(Vector v2) {
		double x = this.x - v2.x;
		double y = this.y - v2.y;
		double z = this.z - v2.z;

		//Neuer Vektor, in den Ergebnis gespeichert wird
		Vector v3 = new Vector(x, y, z);
		return v3;
	}

	/**
	 * Gibt den X-Wert des Vektors zur�ck
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ double
	 */
	//Gettermethode, die den X-Wert des Vektors zur�ck gibt
	public double getX() {
		return x;
	}

	/**
	 * Gibt den Y-Wert des Vektors zur�ck
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ double
	 */
	//Gettermethode, die den Y-Wert des Vektors zur�ck gibt
	public double getY() {
		return y;
	}

	/**
	 * Gibt den Z-Wert des Vektors zur�ck
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ double
	 */
	//Gettermethode, die den Z-Wert des Vektors zur�ck gibt
	public double getZ() {
		return z;
	}

	/**
	 * Speichert die Koordinaten des Vektors in einem Array
	 * 
	 * @return Der R�ckgabewert ein Arrays des Typs double
	 */
	//Die Methode gibt den Vektor zur�ck
	public double[] getAll() {
		double[] all = { x, y, z };
		return all;
	}

	/**
	 * Multipliziert einen Vektor mit einem Skalar
	 * 
	 * @param scalar Skalar vom Typ double, mit dem der Vektor multipliziert wird
	 * @return Der R�ckgabewert der Methode ist vom Typ Vector und enth�lt das Ergebnis der Multiplikation
	 */
	//Methode multipliziert einen Vektor mit einem Skalar
	public Vector mult(double scalar) {
		double x = this.x * scalar;
		double y = this.y * scalar;
		double z = this.z * scalar;
		
		//Ergebnis wird in neuen Vektor gespeichert
		Vector v2 = new Vector(x, y, z);
		return v2;
	}

	/**
	 * Berechnet das Skalarprodukt zweier Vektoren
	 * 
	 * @param v2 Vektor mit dem skalarmultipliziert werden soll vom Typ Vector
	 * @return Der R�ckgabewert der Methode ist vom Typ double und enth�t das Ergebnis des Skalarprodukts
	 */
	//Berechnet das Skalarprodukt zweier Vektoren
	public double scalarMult(Vector v2) {
		return x * v2.x + y * v2.y + z * v2.z;
	}

	/**
	 * Berechnet das Kreuzprodukt zweier Vektoren
	 * 
	 * @param v2 Vektor mit dem kreuzmultipliziert werden soll vom Typ Vector
	 * @return Der R�ckgabewert der Methode ist vom Typ Vector und enth�lt das Ergebnis des Kreuzprodukts
	 */
	//Methode berechnet das Kreuzprodukt zweier Vektoren
	public Vector crossProduct(Vector v2) {
		double x = (this.y * v2.z) - (this.z * v2.y);
		double y = (this.z * v2.x) - (this.x * v2.z);
		double z = (this.x * v2.y) - (this.y * v2.x);
		Vector v3 = new Vector(x, y, z);
		return v3;
	}

	/**
	 * Berechnet den Betrag eines Vekrors
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ double und enth�lt den Betrag
	 */
	//Methode berechnet den Betrag des Vektors
	public double abs() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Berechnet den Einheitsvektor 
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ Vector und gibt den Einheitsvektor zur�ck
	 */
	//Berechnung des Einheitsvektors
	public Vector unitVector() {
		return this.mult(1 / this.abs());
	}

	/**
	 * Vergleicht den Vektor mit dem dem �bergegebenen Objekt. Liefert true bei Gleichheit (Unter berr�cksichtigung einer Epsilonumgebung)
	 * 
	 * 
	 * @param o Objekt, mit dem der instanz Vektor verglichen werden soll vom typ Object
	 * @return Der R�ckgabewert der Methode ist vom Typ boolean 
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Vector)) {
			return false;
		} else {
			Vector v1 = (Vector) o;
			return this.equals(v1);
		}
	}
	/**
	 * Vergleicht die zwei Vektoren. Liefert true bei Gleichheit (Unter berr�cksichtigung einer Epsilonumgebung)
	 * 
	 * �berladen
	 *  
	 * @param v Vektor, mit dem der instanz Vektor verglichen werden soll vom typ Vector
	 * @return Der R�ckgabewert der Methode ist vom Typ boolean
	 */
	private boolean equals(Vector v) {
		//Epsilonumgebung
		double epsilon = 0.00001;
		// |x1-x2|<epsilon && |y1-y2|<epsilon && |z1-z2|<epsilon
		return (Math.abs(x - v.x) < epsilon) && (Math.abs(y - v.y) < epsilon)
				&& (Math.abs(z - v.z) < epsilon);
	}

	/**
	 * Schreibt die Koordinaten des Vektors in einen String
	 * 
	 * @return Der R�ckgabewert der Methode ist vom Typ String und enth�lt die Koordinaten des Vektors
	 */
	
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}