package mvc.model;

import java.util.ArrayList;
import java.util.List;

import geometry.Shape;

public class DrawingModel {

    private final ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selected;

    public List<Shape> getShapes() {
        return shapes;
    }

    // Ako ti baš treba ArrayList u postojećem kodu, koristi ovo:
    public ArrayList<Shape> getShapesList() {
        return shapes;
    }

    public Shape getSelected() {
        return selected;
    }

    public void setSelected(Shape selected) {
        this.selected = selected;
    }

    public void addShape(Shape s) {
        if (s != null) {
            shapes.add(s);
        }
    }

    public void removeShape(Shape s) {
        shapes.remove(s);
        if (selected == s) {
            selected = null;
        }
    }

    public void clearSelection() {
        selected = null;
    }
}
