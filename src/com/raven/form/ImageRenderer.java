package com.raven.form;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer extends DefaultTableCellRenderer {
    private Color backgroundColor = new Color(236, 234, 234);
 // Màu nền cho cột ảnh
    
    // Hàm khởi tạo có tham số cho màu nền


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Kiểm tra nếu giá trị của ô là một ImageIcon
        if (value instanceof ImageIcon) {
            JLabel label = new JLabel((ImageIcon) value);
            label.setOpaque(true);
            label.setBackground(backgroundColor); // Đặt màu nền cho ảnh
            label.setForeground(table.getSelectionForeground());
            return label;
        } else {
            // Nếu không phải là ImageIcon, sử dụng bộ điều khiển mặc định
            return renderer;
        }
    }
}
