package mvc.view;


import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import mvc.controller.DrawingController;
import mvc.model.DrawingModel;

public class DrawingView extends JPanel{
	
//	private FrmDrawing frame;
//	//private ArrayList<Shape> shapes=new ArrayList<Shape>();
//	private Point startPoint;
//	//private Shape selected;
	private final DrawingModel model;
	private DrawingController controller;
	
	/*
	 * public DrawingView(FrmDrawing frame) { //super.paint(g);
	 * setBackground(Color.WHITE); this.frame=frame; addMouseListener(new
	 * MouseAdapter() { public void mouseClicked(MouseEvent arg0) {
	 * thisMouseClicked(arg0); } }); }
	 */
	public DrawingView(DrawingModel model) {
		//setBackground(Color.WHITE);
		//this.frame = frame;
		this.model = model;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(controller != null) {
					controller.handleCanvasClick(e.getX(), e.getY());
				}
			}
		});
	}
	
	public void setController(DrawingController controller) {
        this.controller = controller;
    }
	
		 
	/*
	 * public void paint(Graphics g) { super.paint(g); Iterator<Shape>
	 * it=shapes.iterator(); while(it.hasNext()) { Shape s=it.next(); if(s
	 * instanceof Point) { ((Point)s).draw(g); } else if (s instanceof Line) {
	 * ((Line)s).draw(g); } else if (s instanceof Rectangle) {
	 * ((Rectangle)s).draw(g); } else if (s instanceof Donut) { ((Donut)s).draw(g);
	 * } else if (s instanceof Circle) { ((Circle)s).draw(g); } } }
	 */
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    for (Shape s : model.getShapes()) {
	        if (s instanceof Point) {
	            ((Point) s).draw(g);
	        } else if (s instanceof Line) {
	            ((Line) s).draw(g);
	        } else if (s instanceof Rectangle) {
	            ((Rectangle) s).draw(g);
	        } else if (s instanceof Donut) {
	            ((Donut) s).draw(g);
	        } else if (s instanceof Circle) {
	            ((Circle) s).draw(g);
	        } else if (s instanceof geometry.HexagonAdapter) {
	            ((geometry.HexagonAdapter) s).draw(g);
	        }
	    }
	}

	
//	public Shape getSelected() {
//		return model.getSelected();
//	}
//	
//	public java.util.List<Shape> getShapes() {
//		return model.getShapes();
//	}
//	
//	public void setSelected(Shape selected) {
//		model.setSelected(selected);
//	}
}