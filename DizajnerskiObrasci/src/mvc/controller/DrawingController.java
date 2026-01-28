package mvc.controller;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import mvc.model.DrawingModel;
import mvc.view.DrawingView;
import ui.FrmDrawing;
import ui.dialogs.DlgCircle;
import ui.dialogs.DlgDonut;
import ui.dialogs.DlgHexagon;
import ui.dialogs.DlgLine;
import ui.dialogs.DlgPoint;
import ui.dialogs.DlgRectangle;

public class DrawingController {

    private final DrawingModel model;
    private final DrawingView view;
    private final FrmDrawing frame;
    
    public enum Mode {DRAW, SELECT}
    public enum Tool {NONE, POINT, LINE, RECTANGLE, CIRCLE, DONUT, HEXAGON}
    
    private Mode mode = Mode.DRAW;
    private Tool tool = Tool.NONE;
    
    private Color activeEdgeColor = Color.BLACK;
    private Color activeInnerColor = Color.WHITE;
    
    private Point startPoint = null;
    
    public DrawingController(DrawingModel model, DrawingView view, FrmDrawing frame) {
        this.model = model;
        this.view = view;
        this.frame = frame;
    }
    
    public void setMode(Mode mode) {
    	if(mode != null) {
    		this.mode = mode;
    		if(mode == Mode.SELECT) {
    			startPoint = null;
    		}
    	}
    }
    
    public void setTool(Tool tool) {
    	if (tool != null) {
            this.tool = tool;
            if (tool != Tool.LINE) {
                startPoint = null;
            }
    	}
    }
    
    public void setActiveEdgeColor(Color c) {
        if (c != null) activeEdgeColor = c;
    }

    public void setActiveInnerColor(Color c) {
        if (c != null) activeInnerColor = c;
    }
    
    //GLAVNI ULAZ ZA KLIK NA KANVASU
    public void handleCanvasClick(int x, int y) {
        if (mode == Mode.SELECT) {
            handleSelect(x, y);
        } else {
        	if (tool == Tool.NONE) {
        		return; // ne radi nista ako nije selektovan tool 
        	}
            handleDraw(x, y);
        }
        view.repaint();
    }
    
    private void handleSelect(int x, int y) {
        List<Shape> shapes = model.getShapes();

        // deselect svih
        for (Shape s : shapes) {
            s.setSelected(false);
        }
        model.setSelected(null);

        // pronadji poslednji koji sadrži tačku
        Shape selected = null;
        Iterator<Shape> it = shapes.iterator();
        while (it.hasNext()) {
            Shape s = it.next();
            if (s.contains(x, y)) {
                selected = s;
            }
        }

        if (selected != null) {
            selected.setSelected(true);
            model.setSelected(selected);
        }
    }
    
    private void handleDraw(int x, int y) {
        // kad crtaš, obično se sve deselectuje
        for (Shape s : model.getShapes()) {
            s.setSelected(false);
        }
        model.setSelected(null);

        switch (tool) {
            case POINT:
                model.addShape(new Point(x, y, activeEdgeColor));
                break;

            case LINE:
                if (startPoint == null) {
                    startPoint = new Point(x, y);
                } else {
                    model.addShape(new Line(startPoint, new Point(x, y), activeEdgeColor));
                    startPoint = null;
                }
                break;

            case RECTANGLE:
                drawRectangle(x, y);
                break;

            case CIRCLE:
                drawCircle(x, y);
                break;

            case DONUT:
                drawDonut(x, y);
                break;
                
            case HEXAGON:
                drawHexagon(x, y);
                break;
        }
    }
    
    private void drawRectangle(int x, int y) {
        DlgRectangle dlg = new DlgRectangle();
        dlg.txtXulp.setText(Integer.toString(x));
        dlg.txtYulp.setText(Integer.toString(y));
        dlg.setVisible(true);

        Rectangle r = dlg.getRectNew();
        if (r != null && r.getUpperLeftPoint() != null) {
            
            if (r.getColor() == null) r.setColor(activeEdgeColor); // Ako dijalog nije postavio boje, postavi aktivne (fallback)
            if (r.getInnerColor() == null) r.setInnerColor(activeInnerColor);
            model.addShape(r);
        }
    }
    
    private void drawCircle(int x, int y) {
        DlgCircle dlg = new DlgCircle();
        dlg.txtXcoord.setText(Integer.toString(x));
        dlg.txtYcoord.setText(Integer.toString(y));
        dlg.setVisible(true);

        Circle c = dlg.getCircleNew();
        if (c != null && c.getCenter() != null) {
            if (c.getColor() == null) c.setColor(activeEdgeColor);
            if (c.getInnerColor() == null) c.setInnerColor(activeInnerColor);
            model.addShape(c);
        }
    }
    
    private void drawDonut(int x, int y) {
        DlgDonut dlg = new DlgDonut();
        dlg.txtXcenter.setText(Integer.toString(x));
        dlg.txtYcenter.setText(Integer.toString(y));
        dlg.setVisible(true);

        Donut d = dlg.getDonutNew();
        if (d != null && d.getCenter() != null) {
            if (d.getColor() == null) d.setColor(activeEdgeColor);
            if (d.getInnerColor() == null) d.setInnerColor(activeInnerColor);
            model.addShape(d);
        }
    }
    
    private void drawHexagon(int x, int y) {
        ui.dialogs.DlgHexagon dlg = new ui.dialogs.DlgHexagon();
        dlg.txtX.setText(Integer.toString(x));
        dlg.txtY.setText(Integer.toString(y));
        dlg.setVisible(true);

        geometry.HexagonAdapter h = dlg.getHexagon();
        if (h != null) {
            // fallback na aktivne boje ako dijalog nije birao
            if (h.getColor() == null) h.setColor(activeEdgeColor);
            if (h.getInnerColor() == null) h.setInnerColor(activeInnerColor);
            model.addShape(h);
        }
    }
    
    public void deleteSelected() {
        Shape s = model.getSelected();
        if (s != null) {
            model.removeShape(s);
            view.repaint();
        }
    }
    
    public void modifySelected() {
       Shape selected = model.getSelected();
       if(selected == null) return;
       
       if(selected instanceof Point) {
    	   DlgPoint dlg = new DlgPoint();
    	   dlg.setPoint((Point) selected);
    	   dlg.setModal(true);
           dlg.setVisible(true);
           view.repaint();
           return; 
       }
       if(selected instanceof Line) {
    	   DlgLine dlg = new DlgLine();
    	   dlg.setLine((Line) selected);
    	   dlg.setModal(true);
    	   dlg.setVisible(true);
    	   view.repaint();
    	   return;
       }
       if(selected instanceof Rectangle) {
    	   DlgRectangle dlg = new DlgRectangle();
    	   dlg.setRectNew((Rectangle) selected);
    	   dlg.setModal(true);
    	   dlg.setVisible(true);
    	   view.repaint();
    	   return;
       }
       if(selected instanceof Donut) {
    	   DlgDonut dlg = new DlgDonut();
    	   dlg.setDonutNew((Donut) selected);
    	   dlg.setModal(true);
    	   dlg.setVisible(true);
    	   view.repaint();
    	   return;
       }
       if(selected instanceof Circle) {
    	   DlgCircle dlg = new DlgCircle();
    	   dlg.setCircleNew((Circle) selected);
    	   dlg.setModal(true);
    	   dlg.setVisible(true);
    	   view.repaint();
    	   return;
       }
       if (selected instanceof HexagonAdapter) {
    	    DlgHexagon dlg = new DlgHexagon();
    	    dlg.setHexagon((HexagonAdapter) selected);
    	    dlg.setVisible(true);
    	    view.repaint();
    	    return;
    	}
    }
}
