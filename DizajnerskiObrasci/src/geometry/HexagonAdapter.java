package geometry;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import geometry.Point;

public class HexagonAdapter extends SurfaceShape{
	
	private Hexagon hex; // ADAPTEE IZ HEXAGON JAR-A
	
	public HexagonAdapter() {}
	
	public HexagonAdapter(Point center, int r) {
		this.hex = new Hexagon(center.getX(), center.getY(), r);
	}
	
	public HexagonAdapter(Point center, int r, Color borderColor, Color areaColor) {
		this(center,r);
		setColor(borderColor);
		setInnerColor(areaColor);
	}
	
	public HexagonAdapter(Point center, int r, boolean selected, Color borderColor, Color areaColor) {
		this(center, r, borderColor, areaColor);
		setSelected(selected);
	}
	
	@Override
    public Color getColor() {
        return (hex != null) ? hex.getBorderColor() : super.getColor();
    }
	
	@Override
    public void setColor(Color c) {
        super.setColor(c);
        if (hex != null && c != null) hex.setBorderColor(c);
    }
	
	@Override
    public Color getInnerColor() {
        return (hex != null) ? hex.getAreaColor() : super.getInnerColor();
    }
	
	@Override
    public void setInnerColor(Color c) {
        super.setInnerColor(c);
        if (hex != null && c != null) hex.setAreaColor(c);
    }
	
	@Override
	public boolean isSelected() {
	    return (hex != null) ? hex.isSelected() : super.isSelected();
	}
	 
	@Override
	public void setSelected(boolean selected) {
	    super.setSelected(selected);
	    if (hex != null) hex.setSelected(selected);
	}
	
	@Override
    public void draw(Graphics g) {
        if (hex == null) return;
    
        if (getColor() != null) hex.setBorderColor(getColor());
        if (getInnerColor() != null) hex.setAreaColor(getInnerColor());
        hex.paint(g);
    }
	
	@Override
    public void fill(Graphics g) {
        // jar radi fill u preko areaColor
    }
	
	@Override
    public boolean contains(int x, int y) {
        return hex != null && hex.doesContain(x, y);
    }

    
    public boolean contains(Point p) {
        return contains(p.getX(), p.getY());
    }
    
    @Override
    public void moveTo(int x, int y) {
        if (hex == null) return;
        hex.setX(x);
        hex.setY(y);
    }

    @Override
    public void moveBy(int byX, int byY) {
        if (hex == null) return;
        hex.setX(hex.getX() + byX);
        hex.setY(hex.getY() + byY);
    }
    
    public Point getCenter() {
        return new Point(hex.getX(), hex.getY());
    }

    public void setCenter(Point p) {
        if (hex == null) return;
        hex.setX(p.getX());
        hex.setY(p.getY());
    }

    public int getR() {
        return hex.getR();
    }

    public void setR(int r) {
        hex.setR(r);
    }

    @Override
    public String toString() {
        return "Hexagon(center=(" + hex.getX() + "," + hex.getY() + "), r=" + hex.getR() + ")";
    }

	@Override
	public int compareTo(Object o) {
		if(o instanceof SurfaceShape) {
			return (int) (this.area() - ((SurfaceShape) o).area());
		}
		return 0;
	}

	@Override
	public double area() {
		if(hex == null) return 0;
		double r = hex.getR();
		return (3 * Math.sqrt(3) / 2) * r * r;
	}
}
