package com.raven.component;

import com.raven.swing.scrollbar.ScrollBarCustom;
import com.raven.swing.table.Action;
import com.raven.swing.table.ModelAction;
import com.raven.swing.table.ModelProfile;
import com.raven.swing.table.Profile;
import com.raven.swing.table.TableCellAction;
import com.raven.swing.table.TableHeader;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(60);
        getTableHeader().setReorderingAllowed(false);
        if (getColumnCount() > 0) {
            getColumnModel().getColumn(0).setCellRenderer(new CustomTableCellRenderer());
        }
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
                    if (selected) {
                        cell.setBackground(new Color(192, 192, 255)); // Màu nền dòng được chọn
                        cell.setForeground(Color.WHITE); // Màu chữ khi dòng được chọn
                    } else {
                        cell.setBackground(i % 2 == 0 ? new Color(224, 224, 224) : Color.WHITE);
                        cell.setForeground(Color.BLACK); // Màu chữ mặc định
                    }
                    return cell;

                } else if (o instanceof ModelAction) {
                    ModelAction data = (ModelAction) o;
                    Action cell = new Action(data);
                    if (selected) {
                        cell.setBackground(new Color(192, 192, 255)); // Màu nền dòng được chọn
                        cell.setForeground(Color.WHITE); // Màu chữ khi dòng được chọn
                    } else {
                        cell.setBackground(i % 2 == 0 ? new Color(224, 224, 224) : Color.WHITE);
                        cell.setForeground(Color.BLACK); // Màu chữ mặc định
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(192, 192, 255)); // Màu nền dòng được chọn
                        com.setForeground(Color.WHITE); // Màu chữ khi dòng được chọn
                    } else {
                        com.setBackground(i % 2 == 0 ? new Color(224, 224, 224) : Color.WHITE);
                    }
                    return com;
                }
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 4) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
