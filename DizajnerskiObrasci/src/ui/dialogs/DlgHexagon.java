package ui.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.HexagonAdapter;
import geometry.Point;

public class DlgHexagon extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public JTextField txtX;
    public JTextField txtY;
    public JTextField txtR;

    private HexagonAdapter hexagon; // rezultat

    private Color borderColor = Color.BLACK;
    private Color areaColor = Color.WHITE;

    public DlgHexagon() {
        setModal(true);
        setTitle("Hexagon");
        setBounds(100, 100, 450, 260);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
        gbl.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        contentPanel.setLayout(gbl);

        // X
        JLabel lblX = new JLabel("Center X");
        GridBagConstraints gbc_lblX = new GridBagConstraints();
        gbc_lblX.insets = new Insets(0, 0, 5, 5);
        gbc_lblX.gridx = 1; gbc_lblX.gridy = 0;
        contentPanel.add(lblX, gbc_lblX);

        txtX = new JTextField();
        GridBagConstraints gbc_txtX = new GridBagConstraints();
        gbc_txtX.insets = new Insets(0, 0, 5, 0);
        gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtX.gridx = 2; gbc_txtX.gridy = 0;
        contentPanel.add(txtX, gbc_txtX);

        // Y
        JLabel lblY = new JLabel("Center Y");
        GridBagConstraints gbc_lblY = new GridBagConstraints();
        gbc_lblY.insets = new Insets(0, 0, 5, 5);
        gbc_lblY.gridx = 1; gbc_lblY.gridy = 1;
        contentPanel.add(lblY, gbc_lblY);

        txtY = new JTextField();
        GridBagConstraints gbc_txtY = new GridBagConstraints();
        gbc_txtY.insets = new Insets(0, 0, 5, 0);
        gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtY.gridx = 2; gbc_txtY.gridy = 1;
        contentPanel.add(txtY, gbc_txtY);

        // R
        JLabel lblR = new JLabel("Radius (R)");
        GridBagConstraints gbc_lblR = new GridBagConstraints();
        gbc_lblR.insets = new Insets(0, 0, 5, 5);
        gbc_lblR.gridx = 1; gbc_lblR.gridy = 2;
        contentPanel.add(lblR, gbc_lblR);

        txtR = new JTextField();
        GridBagConstraints gbc_txtR = new GridBagConstraints();
        gbc_txtR.insets = new Insets(0, 0, 5, 0);
        gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtR.gridx = 2; gbc_txtR.gridy = 2;
        contentPanel.add(txtR, gbc_txtR);

        // Colors
        JButton btnArea = new JButton("Area Color");
        btnArea.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(null, "Choose area color", areaColor);
            if (chosen != null) areaColor = chosen;
        });
        GridBagConstraints gbc_btnArea = new GridBagConstraints();
        gbc_btnArea.insets = new Insets(0, 0, 5, 5);
        gbc_btnArea.gridx = 1; gbc_btnArea.gridy = 3;
        contentPanel.add(btnArea, gbc_btnArea);

        JButton btnBorder = new JButton("Border Color");
        btnBorder.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(null, "Choose border color", borderColor);
            if (chosen != null) borderColor = chosen;
        });
        GridBagConstraints gbc_btnBorder = new GridBagConstraints();
        gbc_btnBorder.insets = new Insets(0, 0, 5, 0);
        gbc_btnBorder.gridx = 2; gbc_btnBorder.gridy = 3;
        contentPanel.add(btnBorder, gbc_btnBorder);

        // Buttons
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> onOk());
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            hexagon = null;
            dispose();
        });
        buttonPane.add(cancelButton);
    }

    private void onOk() {
        try {
            int x = Integer.parseInt(txtX.getText());
            int y = Integer.parseInt(txtY.getText());
            int r = Integer.parseInt(txtR.getText());

            if (x < 0 || y < 0 || r < 1) {
                JOptionPane.showMessageDialog(this, "Neispravne vrijednosti!", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (hexagon == null) {
                // ADD: pravi novi
                hexagon = new HexagonAdapter(new Point(x, y), r, borderColor, areaColor);
            } else {
                // MODIFY: mijenja postojeći (edit-in-place)
                hexagon.setCenter(new Point(x, y));
                hexagon.setR(r);
                hexagon.setColor(borderColor);
                hexagon.setInnerColor(areaColor);
            }

            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neispravne vrijednosti!", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }


    public HexagonAdapter getHexagon() {
        return hexagon;
    }

    // za modify (edit-in-place): popuni polja iz postojećeg
    public void setHexagon(HexagonAdapter h) {
        this.hexagon = h;
        txtX.setText("" + h.getCenter().getX());
        txtY.setText("" + h.getCenter().getY());
        txtR.setText("" + h.getR());
        borderColor = h.getColor();
        areaColor = h.getInnerColor();
    }
}
