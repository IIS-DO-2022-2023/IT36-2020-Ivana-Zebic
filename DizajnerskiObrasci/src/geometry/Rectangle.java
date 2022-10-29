package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape {
	private Point upperLeftPoint;
	private int height;
	private int width;
	private boolean selected;

	public Rectangle() {
	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
		// this.selected = selected;

	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
		this(upperLeftPoint, width, height, selected);
		setColor(color);
	}

	public Rectangle(Point upperLeftPoint, int width, int height, Color color, Color innerColor) {
		this(upperLeftPoint, width, height);
		setColor(color);
		setInnerColor(innerColor);
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, selected);
		setColor(color);
		setInnerColor(innerColor);
	}

	public double area() {
		return this.height * this.width;
	}

	public int circumference() {
		return this.height * 2 + 2 * this.width;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {

			Rectangle pomocna = (Rectangle) obj;
			if (this.upperLeftPoint.equals(pomocna.upperLeftPoint) && this.width == pomocna.width
					&& this.height == pomocna.height) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		if (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width && y >= upperLeftPoint.getY()
				&& y <= upperLeftPoint.getY() + height)
			return true;
		else
			return false;
	}

	public boolean contains(Point p) {
		if (p.getX() >= upperLeftPoint.getX() && p.getX() <= upperLeftPoint.getX() + width
				&& p.getY() >= upperLeftPoint.getY() && p.getY() <= upperLeftPoint.getY() + height)
			return true;
		else
			return false;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX() + 1, this.getUpperLeftPoint().getY() + 1, width - 1, height - 1);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		this.fill(g);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);

	}

	@Override
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);

	}

	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return (int) (this.area() - ((Rectangle) o).area());
		}
		return 0;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String toString() {
		return "Upper left point:" + upperLeftPoint + ", width = " + width + ", height = " + height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
