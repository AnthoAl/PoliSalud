package UserInterface.CustomerControl;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import DataAccess.DTO.CitaDTO;

public class CitaTableModel extends AbstractTableModel {
    private final List<CitaDTO> citas;
    private int startIndex;
    private final int pageSize = 10;
    private final String[] columnNames = {"ID", "Médico", "Paciente", "FechaCita", "HoraCita"};

    public CitaTableModel(List<CitaDTO> citas) {
        this.citas = citas;
        this.startIndex = 0;
    }

    @Override
    public int getRowCount() {
        return Math.min(pageSize, citas.size() - startIndex);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (startIndex + rowIndex >= citas.size()) return null;
        CitaDTO cita = citas.get(startIndex + rowIndex);
        return switch (columnIndex) {
            case 0 -> cita.getIdCita   ();
            case 1 -> cita.getMedico   ();
            case 2 -> cita.getPaciente ();
            case 3 -> cita.getFechaCita();
            case 4 -> cita.getHoraCita ();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void nextPage() {
        if (startIndex + pageSize < citas.size()) {
            startIndex += pageSize;
            fireTableDataChanged();
        }
    }

    public void previousPage() {
        if (startIndex - pageSize >= 0) {
            startIndex -= pageSize;
            fireTableDataChanged();
        }
    }

    public void setCitas(List<CitaDTO> nuevasCitas) {
        this.citas.clear();
        this.citas.addAll(nuevasCitas);
        fireTableDataChanged(); // Notifica a la tabla que los datos han cambiado
    }
}
