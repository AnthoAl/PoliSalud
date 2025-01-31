package UserInterface.GUI;

import BusinessLogic.BLCita;
import DataAccess.DTO.CitaDTO;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cita extends JPanel implements ActionListener {
    private BLCita BLCita;
    private CitaDTO citaActual;
    private JTable table;
    private DefaultTableModel tableModel;
    private PatTextBox txtMedico, txtPaciente, txtFecha, txtHora;
    private PatButton btnNuevo, btnGuardar, btnCancelar, btnEliminar;

    public Cita() {
        BLCita = new BLCita();
        setupUI();
        cargarCitas();
    }

    private void setupUI() {
        setLayout(new BorderLayout());
        
        JPanel pnlFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        pnlFormulario.setBorder(BorderFactory.createTitledBorder("Agendar Cita"));
        
        pnlFormulario.add(new JLabel("Médico:"));
        txtMedico = new PatTextBox();
        pnlFormulario.add(txtMedico);
        
        pnlFormulario.add(new JLabel("Paciente:"));
        txtPaciente = new PatTextBox();
        pnlFormulario.add(txtPaciente);
        
        pnlFormulario.add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new PatTextBox();
        pnlFormulario.add(txtFecha);
        
        pnlFormulario.add(new JLabel("Hora (HH:MM):"));
        txtHora = new PatTextBox();
        pnlFormulario.add(txtHora);
        
        JPanel pnlBotones = new JPanel(new FlowLayout());
        btnNuevo = new PatButton("Nuevo");
        btnGuardar = new PatButton("Guardar");
        btnCancelar = new PatButton("Cancelar");
        btnEliminar = new PatButton("Eliminar");
        
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnCancelar);
        pnlBotones.add(btnEliminar);
        
        btnNuevo.addActionListener(e -> limpiarFormulario());
        btnGuardar.addActionListener(e -> guardarCita());
        btnCancelar.addActionListener(e -> cargarCitas());
        btnEliminar.addActionListener(e -> {
            try {
                eliminarCita();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        
        tableModel = new DefaultTableModel(new Object[]{"ID", "Médico", "Paciente", "Fecha", "Hora"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.getSelectionModel().addListSelectionListener(event -> {
            try {
                seleccionarCita();
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        
        add(pnlFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH);
    }

    private void cargarCitas() {
        tableModel.setRowCount(0); 
        try {
            List<CitaDTO> citas = BLCita.getAll();
            for (CitaDTO c : citas) {
                System.out.println("Cargando cita: " + c.getFechaCita() + " " + c.getHoraCita()); 
                tableModel.addRow(new Object[]{
                    c.getIdCita(), 
                    c.getMedico(),     
                    c.getPaciente(),   
                    c.getFechaCita(), 
                    c.getHoraCita()
                });
            }
            tableModel.fireTableDataChanged(); 
        } catch (Exception e) {
            e.printStackTrace();
            IAStyle.showMsgError("Error al cargar citas: " + e.getMessage());
        }
    }
    
    private void guardarCita() {
        try {
            int idMedico = Integer.parseInt(txtMedico.getText());
            int idPaciente = Integer.parseInt(txtPaciente.getText());
            String fecha = txtFecha.getText();
            String hora = txtHora.getText();
            
            if (citaActual == null) {
                citaActual = new CitaDTO(idMedico, idPaciente, idPaciente, fecha, hora);
                BLCita.create(citaActual);
            } else {
                citaActual.setIdMedico(idMedico);
                citaActual.setIdPaciente(idPaciente);
                citaActual.setFechaCita(fecha);
                citaActual.setHoraCita(hora);
                BLCita.update(citaActual);
            }
            limpiarFormulario();
            cargarCitas();
        } catch (Exception e) {
            IAStyle.showMsgError("Error al guardar la cita: " + e.getMessage());
        }
    }

    private void eliminarCita() throws Exception {
        if (citaActual != null) {
            BLCita.delete(citaActual.getIdCita());
            limpiarFormulario();
            cargarCitas();
        } else {
            IAStyle.showMsgError("Seleccione una cita para eliminar.");
        }
    }

    private void seleccionarCita() throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int idCita = (int) tableModel.getValueAt(selectedRow, 0);
            citaActual = BLCita.getByIdCita(idCita);
            txtMedico.setText(String.valueOf(citaActual.getIdMedico()));
            txtPaciente.setText(String.valueOf(citaActual.getIdPaciente()));
            txtFecha.setText(citaActual.getFechaCita());
            txtHora.setText(citaActual.getHoraCita());
        }
    }

    private void limpiarFormulario() {
        citaActual = null;
        txtMedico.setText("");
        txtPaciente.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}

