package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
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

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtXcenter;
	public JTextField txtYcenter;
	private JTextField txtInnerRad;
	private JTextField txtRadius;

	private Color innerColor = Color.white;
	private Color color = Color.black;

	private Donut donut = new Donut();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setTitle("Donut");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCenter = new JLabel("X center");
			GridBagConstraints gbc_lblXCenter = new GridBagConstraints();
			gbc_lblXCenter.anchor = GridBagConstraints.EAST;
			gbc_lblXCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCenter.gridx = 1;
			gbc_lblXCenter.gridy = 1;
			contentPanel.add(lblXCenter, gbc_lblXCenter);
		}
		{
			txtXcenter = new JTextField();
			txtXcenter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtXcenter = new GridBagConstraints();
			gbc_txtXcenter.insets = new Insets(0, 0, 5, 0);
			gbc_txtXcenter.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXcenter.gridx = 2;
			gbc_txtXcenter.gridy = 1;
			contentPanel.add(txtXcenter, gbc_txtXcenter);
			txtXcenter.setColumns(10);
		}
		{
			JLabel lblYCenter = new JLabel("Y center");
			GridBagConstraints gbc_lblYCenter = new GridBagConstraints();
			gbc_lblYCenter.anchor = GridBagConstraints.EAST;
			gbc_lblYCenter.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCenter.gridx = 1;
			gbc_lblYCenter.gridy = 2;
			contentPanel.add(lblYCenter, gbc_lblYCenter);
		}
		{
			txtYcenter = new JTextField();
			txtYcenter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtYCenter = new GridBagConstraints();
			gbc_txtYCenter.insets = new Insets(0, 0, 5, 0);
			gbc_txtYCenter.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYCenter.gridx = 2;
			gbc_txtYCenter.gridy = 2;
			contentPanel.add(txtYcenter, gbc_txtYCenter);
			txtYcenter.setColumns(10);
		}
		{
			JLabel lblInnerRad = new JLabel("Inner Radius");
			GridBagConstraints gbc_lblInnerRad = new GridBagConstraints();
			gbc_lblInnerRad.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRad.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRad.gridx = 1;
			gbc_lblInnerRad.gridy = 3;
			contentPanel.add(lblInnerRad, gbc_lblInnerRad);
		}
		{
			txtInnerRad = new JTextField();
			txtInnerRad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtInnerRad = new GridBagConstraints();
			gbc_txtInnerRad.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerRad.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerRad.gridx = 2;
			gbc_txtInnerRad.gridy = 3;
			contentPanel.add(txtInnerRad, gbc_txtInnerRad);
			txtInnerRad.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 4;
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
			gbc_txtRadius.gridx = 2;
			gbc_txtRadius.gridy = 4;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JButton btnFillColourDonut = new JButton("Inner Colour");
			btnFillColourDonut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Choose Inner Color", donut.getInnerColor());
					if (innerColor != null)
						donut.setInnerColor(innerColor);
					// innerColor = Color.WHITE;
				}
			});
			GridBagConstraints gbc_btnFillColourDonut = new GridBagConstraints();
			gbc_btnFillColourDonut.insets = new Insets(0, 0, 5, 5);
			gbc_btnFillColourDonut.gridx = 1;
			gbc_btnFillColourDonut.gridy = 6;
			contentPanel.add(btnFillColourDonut, gbc_btnFillColourDonut);
		}
		{
			JButton btnBorderColour = new JButton("Border Colour");
			btnBorderColour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose Border Color", donut.getColor());
					if (color != null)
						donut.setColor(color);
					// color = Color.BLACK;
				}
			});
			GridBagConstraints gbc_btnBorderColour = new GridBagConstraints();
			gbc_btnBorderColour.insets = new Insets(0, 0, 0, 5);
			gbc_btnBorderColour.gridx = 1;
			gbc_btnBorderColour.gridy = 7;
			contentPanel.add(btnBorderColour, gbc_btnBorderColour);
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
							int xD = Integer.parseInt(txtXcenter.getText());
							int yD = Integer.parseInt(txtYcenter.getText());
							int rD = Integer.parseInt(txtRadius.getText());
							int irD = Integer.parseInt(txtInnerRad.getText());

							if (xD < 0 || yD < 0 || rD < 1 || irD < 1 || irD >= rD) {
								JOptionPane.showOptionDialog(null, "You entered wrong value!", "Error",
										JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
								return;
							}
							donut.setCenter(new Point(xD, yD));
							donut.setRadius(rD);
							donut.setInnerRadius(irD);

							dispose();
						} catch (Exception e1) {
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
						donut = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Donut getDonutNew() {
		return donut;
	}

	public void setDonutNew(Donut donut) {
		this.donut = donut;
		txtXcenter.setText("" + donut.getCenter().getX());
		txtYcenter.setText("" + donut.getCenter().getY());
		txtRadius.setText("" + donut.getRadius());
		txtInnerRad.setText("" + donut.getInnerRadius());
		color = donut.getColor();
		innerColor = donut.getInnerColor();
	}
}
