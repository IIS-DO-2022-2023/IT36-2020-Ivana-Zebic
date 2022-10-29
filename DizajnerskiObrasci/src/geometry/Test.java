package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		// vjezbe 2
		Point p = new Point();
		// x je promenljiva definisana kao private
		// System.out.println(p.x);

		// metoda instance i mora biti pozvana nad objektom
		// Point.getX();
		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		p.setX(10);
		p.setY(10);
		p.setSelected(true);

		System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		System.out.println(p.distance(40, 50));

		// vjezbe 3
		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);

		Rectangle r1 = new Rectangle();
		Line l1 = new Line();
		Circle c1 = new Circle();

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		System.out.println(p.getX());
		p.setX(p1.getY());
		System.out.println(p.getX());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		/*
		 * nije dobro p1.setY(23); l1.setEndPoint(p1);
		 */
		l1.getEndPoint().setY(23);

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println(r1.getUpperLeftPoint().getX() + " " + r1.getUpperLeftPoint().getY());

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		c1.setCenter(r1.getUpperLeftPoint());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		r1.setWidth(30);
		r1.setHeight(20);
		//c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		System.out.println(c1.getCenter().getX());

		// vjezbe 4
		Point p2 = new Point(50, 100);
		Line l2 = new Line(p2, new Point(400, 500));
		Rectangle r2 = new Rectangle(p2, 50, 80);
		Circle c2 = new Circle(p2, 10);

		System.out.println(p2); // System.out.println(p2.toString());
		System.out.println(l2);
		System.out.println(r2);
		System.out.println(c2);

		int c = 5;
		int d = 5;
		System.out.println(c == d);

		d = 7;
		System.out.println(c == d);

		String e = "abcd";
		String f = "abc"; // kreira se novi objekat
		System.out.println(e == f);

		String b = "abc";// referencira se postojeci objekat (f)
		System.out.println(f == b);

		String s1 = new String("Hello World");
		String s2 = new String("Hello World"); // kreira se novi objekat
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2)); // poredjenje po vrednosti jer je redefinisana u klasi String

		Point p5 = new Point();
		System.out.println(p5 == p2);
		p5 = p2; // dodeljuje se referenca i vrednost
		System.out.println(p5);
		System.out.println(p5 == p2);
		p2.setX(20);
		System.out.println(p5.getX());

		System.out.println(p2);
		Point p6 = new Point(20, 100);
		System.out.println(p6 == p2);
		System.out.println(p6.equals(p2)); // pre i posle redefinisanja metode

		System.out.println("\nVezbe 7 - testiranje metoda");
		System.out.println("\nTacka");
		System.out.println(p1);
		p1.moveBy(3, 5);
		System.out.println(p1);
		p1.moveTo(3, 5);
		System.out.println(p1);

		System.out.println("\nLinija");
		System.out.println(l1);
		l1.moveBy(3, 5);
		System.out.println(l1);
		l1.moveTo(3, 5);// nece nista uraditi
		System.out.println(l1);

		System.out.println("\nPravougaonik");
		System.out.println(r1);
		r1.moveBy(3, 5);
		System.out.println(r1);
		r1.moveTo(3, 5);
		System.out.println(r1);

		System.out.println("\nKrug");
		System.out.println(c1);
		c1.moveBy(3, 5);
		System.out.println(c1);
		c1.moveTo(3, 5);
		System.out.println(c1);

		System.out.println("\nKrug sa rupom");
		Donut d1 = new Donut(new Point(800, 100), 20, 10);
		System.out.println(d1);
		d1.moveBy(3, 5);
		System.out.println(d1);
		d1.moveTo(3, 5);
		System.out.println(d1);

		System.out.println("vjezbe 7-nizovi");
		Shape d3 = new Donut(p1, 10, 5);
		Shape p3 = new Point();
		Shape l9 = l1;
		Shape c9 = c1;
		Shape[] shapes = { d3, p3, l9, c9 };
		for (int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}
		System.out.println("\nVezbe 7 - nakon moveBy");
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].moveBy(1, 2);
			System.out.println(shapes[i]);
		}

		int[] ints = { 1, 8, 5, 15, 4 };
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}
		Arrays.sort(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}

		Point p10 = new Point(10, 10);
		Point p20 = new Point(20, 20);
		Point p30 = new Point(30, 30);
		Point p40 = new Point(40, 40);
		Point p50 = new Point(50, 50);
		System.out.println("\nNiz tacaka");
		Point[] points = { p20, p10, p40, p50, p30 };
		System.out.println("Nesortirani niz");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		Arrays.sort(points);
		System.out.println("Sortirani niz");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}

		System.out.println("\nNiz linija");
		Line l10 = new Line(new Point(10, 10), new Point(100, 100));
		Line l20 = new Line(new Point(10, 10), new Point(200, 200));
		Line l30 = new Line(new Point(10, 10), new Point(300, 300));
		Line[] lines = { l30, l10, l20 };
		System.out.println("Nesortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
		Arrays.sort(lines);
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}

		System.out.println("\nNiz pravougaonika");
		Point p31 = new Point(50, 50);
		Rectangle r10 = new Rectangle(p1, 10, 10);
		Rectangle r20 = new Rectangle(p2, 20, 20);
		Rectangle r30 = new Rectangle(p31, 30, 30);
		Rectangle[] rectangles = { r30, r10, r20 };
		System.out.println("Nesortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		Arrays.sort(rectangles);
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}

		System.out.println("\nNiz krugova");
		Circle c10 = new Circle(p1, 10);
		Circle c20 = new Circle(p1, 20);
		Circle c30 = new Circle(p1, 30);
		Circle c40 = new Circle(p1, 40);
		Circle[] circles = { c30, c20, c40, c10 };
		System.out.println("Ispis nesortiranog niza");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i]);
		}
		Arrays.sort(circles);
		System.out.println("Ispis sortiranog niza");
		for (int i = 0; i < circles.length; i++) {
			System.out.println(circles[i]);
		}

		System.out.println("\nNiz krugova sa rupom");
		Donut d10 = new Donut(p10, 100, 10);
		Donut d20 = new Donut(p10, 100, 20);
		Donut d30 = new Donut(p10, 100, 30);
		Donut[] donuts = { d30, d10, d20 };
		System.out.println("Nesortiran niz: ");
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}
		Arrays.sort(donuts);
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}

	}

}
