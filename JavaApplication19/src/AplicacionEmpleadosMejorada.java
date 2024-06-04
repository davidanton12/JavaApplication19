import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionEmpleadosMejorada extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nombreField, apellidoField, cedulaField, hijosField, tipoField, infoField;

    public AplicacionEmpleadosMejorada() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Cédula");
        tableModel.addColumn("Cantidad de hijos");
        tableModel.addColumn("Tipo de Empleado");
        tableModel.addColumn("Información Adicional");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        nombreField = new JTextField(10);
        apellidoField = new JTextField(10);
        cedulaField = new JTextField(10);
        hijosField = new JTextField(5);
        tipoField = new JTextField(10);
        infoField = new JTextField(15);

        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Desea guardar la información?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    limpiarParametros();
                    JOptionPane.showMessageDialog(null, "Los datos fueron almacenados.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton limpiarButton = new JButton("Limpiar");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea limpiar todos los parámetros?", "Advertencia", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    limpiarParametros();
                }
            }
        });

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Nombre:"));
        panel1.add(nombreField);
        panel1.add(new JLabel("Apellido:"));
        panel1.add(apellidoField);
        panel1.add(new JLabel("Cédula:"));
        panel1.add(cedulaField);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Cantidad de hijos:"));
        panel2.add(hijosField);
        panel2.add(new JLabel("Tipo de Empleado:"));
        panel2.add(tipoField);
        panel2.add(new JLabel("Información Adicional:"));
        panel2.add(infoField);

        JPanel panel3 = new JPanel();
        panel3.add(guardarButton);
        panel3.add(limpiarButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        add(mainPanel, BorderLayout.SOUTH);

        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void limpiarParametros() {
        nombreField.setText("");
        apellidoField.setText("");
        cedulaField.setText("");
        hijosField.setText("");
        tipoField.setText("");
        infoField.setText("");
    }

    public static void main(String[] args) {
        AplicacionEmpleadosMejorada aplicacionEmpleados = new AplicacionEmpleadosMejorada();
    }
}