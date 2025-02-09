package UserInterface.Form;

import DataAccess.DTO.CitaDTO;
import UserInterface.CustomerControl.CitaTableModel;
import UserInterface.CustomerControl.PatButton;
import UserInterface.CustomerControl.PatLabel;
import UserInterface.CustomerControl.PatTextBox;
import UserInterface.IAStyle;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import BusinessLogic.Entities.Cita;

public class CitaPanel extends JPanel implements ActionListener {
    private Cita oCita = new Cita();
    private CitaDTO citaActual = new CitaDTO();
    private List<CitaDTO> citas = oCita.getAll();
    private CitaTableModel tableModel;
    private JTable table;
        
    
        public CitaPanel() throws Exception {
            setupUI();
            cargarCitas();

            btnNuevo.addActionListener(e -> limpiarFormulario());
            btnGuardar.addActionListener(e -> guardarCita());
            btnCancelar.addActionListener(e -> {
                try {
                    cargarCitas();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            btnEliminar.addActionListener(e -> {
                try {
                    eliminarCita();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

            btnPrev.addActionListener(e -> {
                tableModel.previousPage();
                btnNext.setEnabled(true);
                btnPrev.setEnabled(tableModel.getRowCount() > 0);
            });
    
            btnNext.addActionListener(e -> {
                tableModel.nextPage();
                btnPrev.setEnabled(true);
                btnNext.setEnabled(tableModel.getRowCount() > 0);
            });

            table.getSelectionModel().addListSelectionListener(event -> {
                try {
                    seleccionarCita();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
        }

    private void cargarCitas() throws Exception {
    
        List<CitaDTO> citas = oCita.getAll();
        tableModel.setCitas(citas);
        table.revalidate();
        table.repaint();
    }
    

    private void guardarCita() {

        int filaSeleccionada = table.getSelectedRow();

        int idMedico = Integer.parseInt(txtMedico.getText());
        int idPaciente = Integer.parseInt(txtPaciente.getText());
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();  

        try {

            if (filaSeleccionada != -1) {
                citaActual.setIdCita((int) table.getValueAt(filaSeleccionada, 0));
                citaActual.setIdMedico(idMedico);
                citaActual.setIdPaciente(idPaciente);
                citaActual.setFechaCita(fecha);
                citaActual.setHoraCita(hora);
                oCita.update(citaActual);
                limpiarFormulario();
                cargarCitas();
                return;
            }

            if (fecha.isEmpty() || hora.isEmpty() || idMedico == 0 || idPaciente == 0) {
                IAStyle.showMsgError("Llenar todos los campos.");
                return;
            }

                citaActual.setIdMedico(idMedico);
                citaActual.setIdPaciente(idPaciente);
                citaActual.setFechaCita(fecha);
                citaActual.setHoraCita(hora);
                oCita.create(citaActual);
                limpiarFormulario();
                cargarCitas(); 

        } catch (Exception e) {
            IAStyle.showMsgError("Error al guardar la cita: " + e.getMessage());
        }
    }
    
    private void eliminarCita() throws Exception {

        int filaSeleccionada = table.getSelectedRow();
                    
        try {
            
            if (filaSeleccionada == -1) {
                IAStyle.showMsg("Seleccione la cita que quiere eliminar");
                return;
            }
                
            int IdCita = (int) table.getValueAt(filaSeleccionada, 0);
            
        boolean confirm = IAStyle.showConfirmYesNo("¿Está seguro de eliminar la cita seleccionada?");

        if (confirm == true)
            oCita.delete(IdCita);
            limpiarFormulario();
            cargarCitas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void seleccionarCita() throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int idCita = (int) tableModel.getValueAt(selectedRow, 0);
            citaActual = oCita.getByIdCita(idCita);
            
            if (citaActual != null) {
                txtMedico.setText(String.valueOf(citaActual.getIdMedico()));
                txtPaciente.setText(String.valueOf(citaActual.getIdPaciente()));
                txtFecha.setText(citaActual.getFechaCita());
                txtHora.setText(String.valueOf(citaActual.getHoraCita()));
            } else {
                System.out.println("Error: No se pudo encontrar la cita con ID " + idCita);
            }
        }
    }

    private void limpiarFormulario() {
        citaActual = null;
        txtMedico.setText("");
        txtPaciente.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }

/************************
 *      Diseño
 ************************/ 

    private PatLabel mylbltitulo = new PatLabel("POLISALUD | AGENDAMIENTO DE CITAS ");
    
    private PatTextBox 
     txtMedico       = new PatTextBox(),
     txtPaciente     = new PatTextBox(),
     txtFecha        = new PatTextBox(),
     txtHora         = new PatTextBox();
    private PatButton 
     btnNuevo        = new PatButton("Nuevo"),
     btnGuardar      = new PatButton("Guardar"),
     btnCancelar     = new PatButton("Cancelar"),
     btnEliminar     = new PatButton("Eliminar"),
     btnPrev         = new PatButton("Anterior"),
     btnNext         = new PatButton("Siguiente");
    
    private void setupUI() {
         setLayout(new GridBagLayout()); 
         GridBagConstraints gbc = new GridBagConstraints();
        
         gbc.insets = new Insets(5, 0, 5, 0); 
                 
         mylbltitulo.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto
         gbc.gridy = 0; // Fila 1
         gbc.gridx = 0; // Columna 0
         gbc.gridwidth = 2; // Ocupa 2 columnas
         add(mylbltitulo, gbc);

         gbc.gridy = 1;
         gbc.gridx = 0;
         gbc.gridwidth = 1;
         add(new PatLabel("Médico (ID):"), gbc);
         gbc.gridy = 1;
         gbc.gridx = 1;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
         add(txtMedico, gbc);
        
         gbc.gridy = 2;
         gbc.gridx = 0;
         gbc.gridwidth = 1;
         add(new PatLabel("Paciente (ID):"));
         gbc.gridy = 2;
         gbc.gridx = 1;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
         add(txtPaciente, gbc);
        
         gbc.gridy = 3;
         gbc.gridx = 0;
         gbc.gridwidth = 1;
         add(new PatLabel("Fecha (YYYY-MM-DD):"), gbc);
         gbc.gridy = 3;
         gbc.gridx = 1;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
         add(txtFecha, gbc);
        
         gbc.gridy = 4;
         gbc.gridx = 0;
         gbc.gridwidth = 1;
         add(new PatLabel("Hora (HH:MM):"));
         gbc.gridy = 4;
         gbc.gridx = 1;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
         add(txtHora, gbc);

         JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
         panelBotones.add(btnPrev);
         panelBotones.add(btnNext);
        
         gbc.gridy = 5; // Fila 0
         gbc.gridx = 0; // Columna 0
         gbc.gridwidth = 2; // Ocupa 2 columnas
         add(panelBotones, gbc);
        
         gbc.gridy = 6; // Fila 2
         gbc.gridx = 0; // Columna 0
         gbc.gridwidth = 2; // Ocupa 2 columnas
         gbc.ipady = 157; // Altura del área de tabla
         gbc.ipadx = 500; // Anchura del área de tabla
         tableModel = new CitaTableModel(citas);
         table = new JTable(tableModel);
         add(new JScrollPane(table), gbc);
        
         JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));            
         pnlBotones.add(btnNuevo);
         pnlBotones.add(btnGuardar);
         pnlBotones.add(btnCancelar);
         pnlBotones.add(btnEliminar);
        
         gbc.gridy = 7; // Fila 4
         gbc.gridx = 0; // Columna 0
         gbc.gridwidth = 2; // Ocupa 2 columnas
         gbc.weighty = 0.0;
         add(pnlBotones, gbc);
        
        
        
        // tableModel = new DefaultTableModel(new Object[]{"ID", "Médico", "Paciente", "FechaCita", "HoraCita"}, 0);
        // table = new JTable(tableModel);
        // JScrollPane scrollPane = new JScrollPane(table);
        
        
        
        // add(pnlFormulario, BorderLayout.NORTH);
        // add(panelBotones, BorderLayout.NORTH);
        // //add(scrollPane, BorderLayout.CENTER);
        // add(pnlBotones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
