package mvc.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import mvc.model.DrawingModel;
import ui.FrmDrawing;
import ui.dialogs.DlgCircle;
import ui.dialogs.DlgDonut;
import ui.dialogs.DlgRectangle;

public class DrawingView extends JPanel{
	
	private FrmDrawing frame;
	//private ArrayList<Shape> shapes=new ArrayList<Shape>();
	private Point startPoint;
	//private Shape selected;
	private final DrawingModel model;
	
	/*
	 * public DrawingView(FrmDrawing frame) { //super.paint(g);
	 * setBackground(Color.WHITE); this.frame=frame; addMouseListener(new
	 * MouseAdapter() { public void mouseClicked(MouseEvent arg0) {
	 * thisMouseClicked(arg0); } }); }
	 */
	public DrawingView(FrmDrawing frame, DrawingModel model) {
		setBackground(Color.WHITE);
		this.frame = frame;
		this.model = model;
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}
	protected void thisMouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		java.util.List<Shape> shapes = model.getShapes();
		
		if(frame.getTglbtnSelect().isSelected()) {
			Shape selected=null;
			Iterator<Shape> it=shapes.iterator();
			while(it.hasNext()) {
				
				Shape shape=it.next();
				shape.setSelected(false);
				if(shape.contains(e.getX(), e.getY()))
					selected=shape;
			}
			model.setSelected(selected);
			if (selected!=null) {
				selected.setSelected(true);
			}
			
		} else if (frame.getTglbtnDraw().isSelected()) {
				Iterator<Shape> it=shapes.iterator();
				while(it.hasNext()) {
					Shape shape=it.next();
					shape.setSelected(false);
				}
			
				 if (frame.getTglbtnPoint().isSelected()) {
				shapes.add(new Point(x, y, frame.getActiveColor()));
			}else if(frame.getTglbtnLine().isSelected()) {
				if(startPoint==null)
					startPoint=new Point(x, y);
				else {
					shapes.add(new Line(startPoint, new Point(x, y), frame.getActiveColor()));
					startPoint=null;
				}
			}else if (frame.getTglbtnRectangle().isSelected()) {
				DlgRectangle dlg=new DlgRectangle();
				dlg.txtXulp.setText(Integer.toString(e.getX()));
				dlg.txtYulp.setText(Integer.toString(e.getY()));
				dlg.setVisible(true);
				Rectangle r = dlg.getRectNew();
			    if (r != null && r.getUpperLeftPoint() != null) {
			        shapes.add(r);   
			    }
	
			}else if (frame.getTglbtnCircle().isSelected()) {
				DlgCircle dlg=new DlgCircle();
				dlg.txtXcoord.setText(Integer.toString(e.getX()));
				dlg.txtYcoord.setText(Integer.toString(e.getY()));
				dlg.setVisible(true);
				Circle c = dlg.getCircleNew();
				if (c != null && c.getCenter() != null) {
					shapes.add(c);
				}
				//shapes.add(new Circle(dlg.getCircleNew().getCenter(),dlg.getCircleNew().getRadius(), frame.getActiveColor(), frame.getActiveInnerColor()));
				
			} else if (frame.getTglbtnDonut().isSelected()) {
				DlgDonut dlg = new DlgDonut();
				dlg.txtXcenter.setText(Integer.toString(e.getX()));
				dlg.txtYcenter.setText(Integer.toString(e.getY()));
				dlg.setVisible(true);
				Donut d = dlg.getDonutNew();
				if (d != null && d.getCenter() != null) {
					shapes.add(d);
				}
				//shapes.add(new Donut(dlg.getDonutNew().getCenter(), dlg.getDonutNew().getRadius(), dlg.getDonutNew().getInnerRadius(), frame.getActiveColor(), frame.getActiveInnerColor()));
		
			}
		}
		repaint();
		
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
	        }
	    }
	}

	
	public Shape getSelected() {
		return model.getSelected();
	}
	
	public java.util.List<Shape> getShapes() {
		return model.getShapes();
	}
	
	public void setSelected(Shape selected) {
		model.setSelected(selected);
	}
}