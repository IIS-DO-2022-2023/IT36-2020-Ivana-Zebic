package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtXulp;
	public JTextField txtYulp;
	private JTextField txtHeight;
	private JTextField txtWidth;

	private Rectangle rectangle = new Rectangle();

	public Color innerColor = Color.white;
	public Color color = Color.black;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setModal(true);
		setTitle("Rectangle");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXulp = new JLabel("X UpperLeftPoint");
			GridBagConstraints gbc_lblXulp = new GridBagConstraints();
			gbc_lblXulp.insets = new Insets(0, 0, 5, 5);
			gbc_lblXulp.gridx = 1;
			gbc_lblXulp.gridy = 1;
			contentPanel.add(lblXulp, gbc_lblXulp);
		}
		{
			txtXulp = new JTextField();
			txtXulp.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtXulp = new GridBagConstraints();
			gbc_txtXulp.insets = new Insets(0, 0, 5, 0);
			gbc_txtXulp.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXulp.gridx = 3;
			gbc_txtXulp.gridy = 1;
			contentPanel.add(txtXulp, gbc_txtXulp);
			txtXulp.setColumns(10);
		}
		{
			JLabel lblYulp = new JLabel("Y UpperLeftPoint");
			GridBagConstraints gbc_lblYulp = new GridBagConstraints();
			gbc_lblYulp.insets = new Insets(0, 0, 5, 5);
			gbc_lblYulp.gridx = 1;
			gbc_lblYulp.gridy = 2;
			contentPanel.add(lblYulp, gbc_lblYulp);
		}
		{
			txtYulp = new JTextField();
			txtYulp.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtYulp = new GridBagConstraints();
			gbc_txtYulp.insets = new Insets(0, 0, 5, 0);
			gbc_txtYulp.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYulp.gridx = 3;
			gbc_txtYulp.gridy = 2;
			contentPanel.add(txtYulp, gbc_txtYulp);
			txtYulp.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			txtHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 3;
			gbc_txtHeight.gridy = 3;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 4;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			txtWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
						getToolkit().beep();
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 3;
			gbc_txtWidth.gridy = 4;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JButton btnFillColourRect = new JButton("Inner Colour");
			btnFillColourRect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					innerColor = JColorChooser.showDialog(null, "Choose Inner Color", rectangle.getInnerColor());
					if (innerColor != null)
						rectangle.setInnerColor(innerColor);
				}
			});

			GridBagConstraints gbc_btnFillColourRect = new GridBagConstraints();
			gbc_btnFillColourRect.insets = new Insets(0, 0, 5, 5);
			gbc_btnFillColourRect.gridx = 1;
			gbc_btnFillColourRect.gridy = 6;
			contentPanel.add(btnFillColourRect, gbc_btnFillColourRect);
		}
		{
			JButton btnBorderColourRect = new JButton("Border Colour");
			btnBorderColourRect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose Border Color", rectangle.getColor());
					if (color != null)
						rectangle.setColor(color);
				}
			});

			GridBagConstraints gbc_tglbtnBorderColourRect = new GridBagConstraints();
			gbc_tglbtnBorderColourRect.insets = new Insets(0, 0, 0, 5);
			gbc_tglbtnBorderColourRect.gridx = 1;
			gbc_tglbtnBorderColourRect.gridy = 7;
			contentPanel.add(btnBorderColourRect, gbc_tglbtnBorderColourRect);
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
							int x = Integer.parseInt(txtXulp.getText());
							int y = Integer.parseInt(txtYulp.getText());
							int width = Integer.parseInt(txtWidth.getText());
							int height = Integer.parseInt(txtHeight.getText());

							if (x < 0 || y < 0 || width < 1 || height < 1) {
								JOptionPane.showOptionDialog(null, "You entered wrong value!", "Error",
										JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
								return;
							}
							rectangle.setUpperLeftPoint(new Point(x, y));
							rectangle.setWidth(width);
							rectangle.setHeight(height);
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
						rectangle = null;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Rectangle getRectNew() {
		return rectangle;
	}

	public void setRectNew(Rectangle rectangle) {
		this.rectangle = rectangle;
		txtXulp.setText("" + rectangle.getUpperLeftPoint().getX());
		txtYulp.setText("" + rectangle.getUpperLeftPoint().getY());
		txtWidth.setText("" + rectangle.getWidth());
		txtHeight.setText("" + rectangle.getHeight());
		color = rectangle.getColor();
		innerColor = rectangle.getInnerColor();

	}

	public Color fillColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
