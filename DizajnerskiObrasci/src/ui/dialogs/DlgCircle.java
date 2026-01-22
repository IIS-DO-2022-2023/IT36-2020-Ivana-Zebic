package ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	public JTextField txtYcoord;
	public JTextField txtXcoord;

	public Color innerColor = Color.white;
	public Color color = Color.black;
	public Circle circle = new Circle();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setModal(true);
		setTitle("Circle");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXcord = new JLabel("X coordinate");
			GridBagConstraints gbc_lblXcord = new GridBagConstraints();
			gbc_lblXcord.insets = new Insets(0, 0, 5, 5);
			gbc_lblXcord.gridx = 1;
			gbc_lblXcord.gridy = 1;
			contentPanel.add(lblXcord, gbc_lblXcord);
		}
		{
			txtXcoord = new JTextField();
			txtXcoord.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtXcoord = new GridBagConstraints();
			gbc_txtXcoord.insets = new Insets(0, 0, 5, 0);
			gbc_txtXcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcoord.gridx = 3;
			gbc_txtXcoord.gridy = 1;
			contentPanel.add(txtXcoord, gbc_txtXcoord);
			txtXcoord.setColumns(10);
		}
		{
			JLabel lblYcord = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblYcord = new GridBagConstraints();
			gbc_lblYcord.insets = new Insets(0, 0, 5, 5);
			gbc_lblYcord.gridx = 1;
			gbc_lblYcord.gridy = 2;
			contentPanel.add(lblYcord, gbc_lblYcord);
		}
		{
			txtYcoord = new JTextField();
			txtYcoord.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtYcoord = new GridBagConstraints();
			gbc_txtYcoord.insets = new Insets(0, 0, 5, 0);
			gbc_txtYcoord.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYcoord.gridx = 3;
			gbc_txtYcoord.gridy = 2;
			contentPanel.add(txtYcoord, gbc_txtYcoord);
			txtYcoord.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 3;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			txtRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 3;
			gbc_txtRadius.gridy = 3;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JToggleButton tglbtnFillColorCircle = new JToggleButton("Inner Colour");
			tglbtnFillColorCircle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Choose Inner Color", circle.getInnerColor());
					if (innerColor != null)
						circle.setInnerColor(innerColor);
					// innerColor = Color.WHITE;
				}
			});
			GridBagConstraints gbc_tglbtnFillColorCircle = new GridBagConstraints();
			gbc_tglbtnFillColorCircle.insets = new Insets(0, 0, 5, 5);
			gbc_tglbtnFillColorCircle.gridx = 1;
			gbc_tglbtnFillColorCircle.gridy = 5;
			contentPanel.add(tglbtnFillColorCircle, gbc_tglbtnFillColorCircle);
		}
		{
			JToggleButton tglbtnBorderColor = new JToggleButton("Border Colour");
			tglbtnBorderColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose Fill Color", circle.getColor());
					if (color != null)
						circle.setColor(color);
					// color = Color.BLACK;
				}
			});
			GridBagConstraints gbc_tglbtnBorderColor = new GridBagConstraints();
			gbc_tglbtnBorderColor.insets = new Insets(0, 0, 0, 5);
			gbc_tglbtnBorderColor.gridx = 1;
			gbc_tglbtnBorderColor.gridy = 6;
			contentPanel.add(tglbtnBorderColor, gbc_tglbtnBorderColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] options = { "OK" };
						try {
							int x = Integer.parseInt(txtXcoord.getText());
							int y = Integer.parseInt(txtYcoord.getText());
							int radius = Integer.parseInt(txtRadius.getText());

							if (x < 0 || y < 0 || radius < 1) {
								JOptionPane.showOptionDialog(null, "You entered wrong value!", "Error",
										JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
								return;
							}

							circle.setCenter(new Point(x, y));
							circle.setRadius(radius);
							dispose();

						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "You entered wrong data type!", "Error!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						circle = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Circle getCircleNew() {
		return circle;
	}

	public void setCircleNew(Circle circle) {
		this.circle = circle;
		txtXcoord.setText("" + circle.getCenter().getX());
		txtYcoord.setText("" + circle.getCenter().getY());
		txtRadius.setText("" + circle.getRadius());
		color = circle.getColor();
		innerColor = circle.getInnerColor();
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

}
