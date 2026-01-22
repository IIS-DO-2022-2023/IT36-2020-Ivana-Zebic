package ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtY2Rect;
	private JTextField txtX2Rect;
	private JTextField txtYRect;
	private JTextField txtXRect;

	private Line line = new Line();

	private Color color = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setModal(true);
		setTitle("Line");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXStartPoint = new JLabel("X startPoint");
			GridBagConstraints gbc_lblXStartPoint = new GridBagConstraints();
			gbc_lblXStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXStartPoint.gridx = 1;
			gbc_lblXStartPoint.gridy = 1;
			contentPanel.add(lblXStartPoint, gbc_lblXStartPoint);
		}
		{
			txtXRect = new JTextField();
			txtXRect.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtXRect = new GridBagConstraints();
			gbc_txtXRect.insets = new Insets(0, 0, 5, 0);
			gbc_txtXRect.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXRect.gridx = 3;
			gbc_txtXRect.gridy = 1;
			contentPanel.add(txtXRect, gbc_txtXRect);
			txtXRect.setColumns(10);
		}
		{
			JLabel lblYStartPoint = new JLabel("Y startPoint");
			GridBagConstraints gbc_lblYStartPoint = new GridBagConstraints();
			gbc_lblYStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYStartPoint.gridx = 1;
			gbc_lblYStartPoint.gridy = 3;
			contentPanel.add(lblYStartPoint, gbc_lblYStartPoint);
		}
		{
			txtYRect = new JTextField();
			txtYRect.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtYRect = new GridBagConstraints();
			gbc_txtYRect.insets = new Insets(0, 0, 5, 0);
			gbc_txtYRect.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYRect.gridx = 3;
			gbc_txtYRect.gridy = 3;
			contentPanel.add(txtYRect, gbc_txtYRect);
			txtYRect.setColumns(10);
		}
		{
			JLabel lblXEndPoint = new JLabel("X endPoint");
			GridBagConstraints gbc_lblXEndPoint = new GridBagConstraints();
			gbc_lblXEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblXEndPoint.gridx = 1;
			gbc_lblXEndPoint.gridy = 5;
			contentPanel.add(lblXEndPoint, gbc_lblXEndPoint);
		}
		{
			txtX2Rect = new JTextField();
			txtX2Rect.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtX2Rect = new GridBagConstraints();
			gbc_txtX2Rect.insets = new Insets(0, 0, 5, 0);
			gbc_txtX2Rect.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX2Rect.gridx = 3;
			gbc_txtX2Rect.gridy = 5;
			contentPanel.add(txtX2Rect, gbc_txtX2Rect);
			txtX2Rect.setColumns(10);
		}
		{
			JLabel lblYEndPoint = new JLabel("Y endPoint");
			GridBagConstraints gbc_lblYEndPoint = new GridBagConstraints();
			gbc_lblYEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblYEndPoint.gridx = 1;
			gbc_lblYEndPoint.gridy = 7;
			contentPanel.add(lblYEndPoint, gbc_lblYEndPoint);
		}
		{
			txtY2Rect = new JTextField();
			txtY2Rect.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtY2Rect = new GridBagConstraints();
			gbc_txtY2Rect.insets = new Insets(0, 0, 5, 0);
			gbc_txtY2Rect.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY2Rect.gridx = 3;
			gbc_txtY2Rect.gridy = 7;
			contentPanel.add(txtY2Rect, gbc_txtY2Rect);
			txtY2Rect.setColumns(10);
		}
		{
			JButton btnColourLine = new JButton("Colour");
			btnColourLine.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose Fill Color", line.getColor());
					if (color != null)
						line.setColor(color);
					// color = Color.WHITE;
				}
			});
			GridBagConstraints gbc_btnColourLine = new GridBagConstraints();
			gbc_btnColourLine.insets = new Insets(0, 0, 0, 5);
			gbc_btnColourLine.gridx = 1;
			gbc_btnColourLine.gridy = 8;
			contentPanel.add(btnColourLine, gbc_btnColourLine);
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
							int x1 = Integer.parseInt(txtXRect.getText());
							int y1 = Integer.parseInt(txtYRect.getText());
							int x2 = Integer.parseInt(txtX2Rect.getText());
							int y2 = Integer.parseInt(txtY2Rect.getText());

							if (x1 < 1 || y1 < 1 || x2 < 1 || y2 < 1) {
								JOptionPane.showOptionDialog(null, "You entered wrong value!", "Error",
										JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
								return;
							}

							line.setStartPoint(new Point(x1, y1));
							line.setEndPoint(new Point(x2, y2));
							dispose();
						} catch (Exception ex) {
							JOptionPane.showOptionDialog(null, "You entered wrong value!", "Error",
									JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

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
						line = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
		txtXRect.setText("" + line.getStartPoint().getX());
		txtYRect.setText("" + line.getStartPoint().getY());
		txtX2Rect.setText("" + line.getEndPoint().getX());
		txtY2Rect.setText("" + line.getEndPoint().getY());
		// .setBackground(line.getColor());
	}
}
