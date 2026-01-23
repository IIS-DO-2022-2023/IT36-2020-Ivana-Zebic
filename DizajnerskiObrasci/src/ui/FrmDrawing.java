package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import mvc.controller.DrawingController;
import mvc.model.DrawingModel;
import mvc.view.DrawingView;
import ui.dialogs.DlgCircle;
import ui.dialogs.DlgDonut;
import ui.dialogs.DlgLine;
import ui.dialogs.DlgPoint;
import ui.dialogs.DlgRectangle;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;

	private final ButtonGroup btnShapes = new ButtonGroup();
	private final ButtonGroup btnMode = new ButtonGroup();

	private JToggleButton tglbtnSelect;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnDonut;
	private JToggleButton tglbtnDraw;

	//private DrawingView pnlDrawing = new DrawingView(this);
	private DrawingModel model;
	private DrawingView view;
	private DrawingController controller;

	private Color activeColor = Color.BLACK;
	private Color activeInnerColor = Color.WHITE;
	private JButton btnDel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setTitle("Ivana Zebic IT36/2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		model = new DrawingModel();
		view = new DrawingView(model);
		controller = new DrawingController(model,view,this);
		view.setController(controller);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		JPanel panel_3 = new JPanel();
		JPanel panel_4 = new JPanel();
		tglbtnPoint = new JToggleButton("Point");
		panel.add(tglbtnPoint);
		btnShapes.add(tglbtnPoint);
		tglbtnPoint.addActionListener(e -> controller.setTool(DrawingController.Tool.POINT));
		
		tglbtnLine = new JToggleButton("Line");
		panel.add(tglbtnLine);
		btnShapes.add(tglbtnLine);
		tglbtnLine.addActionListener(e -> controller.setTool(DrawingController.Tool.LINE));

		tglbtnRectangle = new JToggleButton("Rectangle");
		panel.add(tglbtnRectangle);
		btnShapes.add(tglbtnRectangle);
		tglbtnRectangle.addActionListener(e -> controller.setTool(DrawingController.Tool.RECTANGLE));

		tglbtnCircle = new JToggleButton("Circle");
		panel.add(tglbtnCircle);
		btnShapes.add(tglbtnCircle);
		tglbtnCircle.addActionListener(e -> controller.setTool(DrawingController.Tool.CIRCLE));

		tglbtnDonut = new JToggleButton("Donut");
		panel.add(tglbtnDonut);
		btnShapes.add(tglbtnDonut);
		tglbtnDonut.addActionListener(e -> controller.setTool(DrawingController.Tool.DONUT));

		//JPanel panel_3 = new JPanel();
		JButton btnActiveEdgeColor = new JButton("Active Edge Color");
		btnActiveEdgeColor.setBackground(SystemColor.inactiveCaptionBorder);
		btnActiveEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosen = JColorChooser.showDialog(null, "Choose edge color", activeColor);
		        if (chosen != null) {
		            activeColor = chosen;
		            panel_3.setBackground(activeColor);
		            controller.setActiveEdgeColor(activeColor);
		        }
			}
		});
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		panel_2.add(btnActiveEdgeColor);

		panel_3.setBackground(activeColor);
		panel_2.add(panel_3);
		//JPanel panel_4 = new JPanel();
		JButton btnActiveInnerColor = new JButton("Active Inner Color");
		btnActiveInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosen = JColorChooser.showDialog(null, "Choose inner color", activeInnerColor);
		        if (chosen != null) {
		            activeInnerColor = chosen;
		            panel_4.setBackground(activeInnerColor);
		            controller.setActiveInnerColor(activeInnerColor);
		        }
			}
		});
		panel_2.add(btnActiveInnerColor);

		panel_4.setBackground(activeInnerColor);
		panel_2.add(panel_4);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		tglbtnDraw = new JToggleButton("Draw");
		panel_1.add(tglbtnDraw);
		btnMode.add(tglbtnDraw);
		tglbtnDraw.addActionListener(e -> controller.setMode(DrawingController.Mode.DRAW));
		
		tglbtnSelect = new JToggleButton("Select");
		panel_1.add(tglbtnSelect);
		btnMode.add(tglbtnSelect);
		tglbtnSelect.addActionListener(e -> controller.setMode(DrawingController.Mode.SELECT));

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shape selected = model.getSelected();
				if (selected != null) {
					if (selected instanceof Point) {
						Point point = (Point) selected;
						DlgPoint dlg = new DlgPoint();
						dlg.setPoint(point);
						dlg.setModal(true);
						dlg.setVisible(true);

						panel_3.setBackground(activeColor);
						panel_4.setBackground(activeInnerColor);
					} else if (selected instanceof Line) {
						Line line = (Line) selected;
						DlgLine dlg = new DlgLine();
						dlg.setLine(line);
						dlg.setModal(true);
						dlg.setVisible(true);
						panel_3.setBackground(activeColor);
						panel_4.setBackground(activeInnerColor);
					} else if (selected instanceof Rectangle) {
						Rectangle rectangle = (Rectangle) selected;
						DlgRectangle dlg = new DlgRectangle();
						dlg.setRectNew(rectangle);
						dlg.setModal(true);
						dlg.setVisible(true);
						panel_3.setBackground(activeColor);
						panel_4.setBackground(activeInnerColor);
					} else if (selected instanceof Donut) {
						Donut donut = (Donut) selected;
						DlgDonut dlg = new DlgDonut();
						dlg.setDonutNew(donut);
						dlg.setModal(true);
						dlg.setVisible(true);
						panel_3.setBackground(activeColor);
						panel_4.setBackground(activeInnerColor);
					}else if (selected instanceof Circle) {
						Circle circle = (Circle) selected;
						DlgCircle dlg = new DlgCircle();
						dlg.setCircleNew(circle);
						dlg.setModal(true);
						dlg.setVisible(true);
						panel_3.setBackground(activeColor);
						panel_4.setBackground(activeInnerColor);
					} 
				}
				view.repaint();
			}
		});
		panel_1.add(btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] options = { "Yes", "No" };
				Shape selected = model.getSelected();
				if (selected != null) {
					int option = JOptionPane.showOptionDialog(null, "Are you sure?", "WARNING!", JOptionPane.OK_OPTION,
							JOptionPane.ERROR_MESSAGE, null, options, options[0]);
					if (option == 0) {
						model.getShapes().remove(selected);
						view.repaint();
					}
				}
			}
		});
		panel_1.add(btnDelete);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnExit);

		view.setBackground(Color.WHITE);
		contentPane.add(view, BorderLayout.CENTER);

		panel.repaint();
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}

	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}

	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}

	public ButtonGroup getBtnShapes() {
		return btnShapes;
	}

	public Color getActiveColor() {
		return activeColor;
	}

	public void setActiveColor(Color activeColor) {
		this.activeColor = activeColor;
	}

	public Color getActiveInnerColor() {
		return activeInnerColor;
	}

	public void setActiveInnerColor(Color activeInnerColor) {
		this.activeInnerColor = activeInnerColor;
	}

	public ButtonGroup getBtnMode() {
		return btnMode;
	}

	public JToggleButton getTglbtnDraw() {
		return tglbtnDraw;
	}

	public void setTglbtnDraw(JToggleButton tglbtnDraw) {
		this.tglbtnDraw = tglbtnDraw;
	}

}