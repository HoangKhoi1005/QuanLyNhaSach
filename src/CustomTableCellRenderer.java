import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private static final Color SELECTED_BACKGROUND = new Color(192, 192, 255); // Light purple
    private static final Color SELECTED_FOREGROUND = Color.WHITE;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            rendererComponent.setBackground(SELECTED_BACKGROUND);
            rendererComponent.setForeground(SELECTED_FOREGROUND);
        } else {
            boolean isChecked = (Boolean) table.getValueAt(row, 0);
            if (isChecked) {
                rendererComponent.setBackground(new Color(236, 234, 244)); // Light lavender
            } else {
                rendererComponent.setBackground(row % 2 == 0 ? new Color(224, 224, 224) : Color.WHITE);
            }
            rendererComponent.setForeground(Color.BLACK);
        }

        return rendererComponent;
    }
}
