package drawing;


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

public class PnlDrawing extends JPanel{
	
	private FrmDrawing frame;
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	private Point startPoint;
	private Shape selected;
	
	public PnlDrawing(FrmDrawing frame) {
		//super.paint(g);
		setBackground(Color.WHITE);
		this.frame=frame;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				thisMouseClicked(arg0);
			}
		});
	}
	
	protected void thisMouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		
		if(frame.getTglbtnSelect().isSelected()) {
			selected=null;
			Iterator<Shape> it=shapes.iterator();
			while(it.hasNext()) {
				
				Shape shape=it.next();
				shape.setSelected(false);
				if(shape.contains(e.getX(), e.getY()))
					selected=shape;
			}
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
				dlg.setModal(true);
				dlg.txtXulp.setText(Integer.toString(e.getX()));
				dlg.txtYulp.setText(Integer.toString(e.getY()));
				dlg.setVisible(true);
					shapes.add(new Rectangle(dlg.getRectNew().getUpperLeftPoint(), dlg.getRectNew().getHeight(), dlg.getRectNew().getWidth(), frame.getActiveColor(), frame.getActiveInnerColor()));
	
			}else if (frame.getTglbtnCircle().isSelected()) {
				DlgCircle dlg=new DlgCircle();
				dlg.txtXcoord.setText(Integer.toString(e.getX()));
				dlg.txtYcoord.setText(Integer.toString(e.getY()));
				
				dlg.setVisible(true);
				shapes.add(new Circle(dlg.getCircleNew().getCenter(),dlg.getCircleNew().getRadius(), frame.getActiveColor(), frame.getActiveInnerColor()));
				
			} else if (frame.getTglbtnDonut().isSelected()) {
				DlgDonut dlg = new DlgDonut();
				dlg.txtXcenter.setText(Integer.toString(e.getX()));
				dlg.txtYcenter.setText(Integer.toString(e.getY()));
				dlg.setVisible(true);
				
				shapes.add(new Donut(dlg.getDonutNew().getCenter(), dlg.getDonutNew().getRadius(), dlg.getDonutNew().getInnerRadius(), frame.getActiveColor(), frame.getActiveInnerColor()));
		
			}
		}
		repaint();
		
	}
		
		 
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it=shapes.iterator();
		while(it.hasNext())
		{
			Shape s=it.next();
			if(s instanceof Point) {
				((Point)s).draw(g);
			} else if (s instanceof Line) {
				((Line)s).draw(g);
			} else if (s instanceof Rectangle) {
				((Rectangle)s).draw(g);
			} else if (s instanceof Circle) {
				((Circle)s).draw(g);
			} else if (s instanceof Donut) {
				((Donut)s).draw(g);
			}
		}
	}
	
	public Shape getSelected() {
		return selected;
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public void setSelected(Shape selected) {
		this.selected=selected;
	}
}