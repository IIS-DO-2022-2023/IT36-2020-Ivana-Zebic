package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
		// this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		setColor(color);
	}

	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setColor(color);
	}

	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {

			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint)) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return (this.startPoint.distance(x, y) + this.endPoint.distance(x, y)) - length() <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX() - 2, startPoint.getY() - 2, 4, 4);
			g.drawRect(endPoint.getX() - 2, endPoint.getY() - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		// Necemo implementirati

	}

	@Override
	public void moveBy(int byX, int byY) {
		this.startPoint.moveBy(byX, byY);
		this.endPoint.moveBy(byX, byY);
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public String toString() {
		return startPoint + "-->" + endPoint;
	}

}
