package com.raven.component;

import java.awt.Color;
import javax.swing.JTabbedPane;

/**
 *
 * @author RAVEN
 */
public class TabbedPaneCustom extends JTabbedPane {

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
        repaint();
    }

    public Color getUnselectedColor() {
        return unselectedColor;
    }

    public void setUnselectedColor(Color unselectedColor) {
        this.unselectedColor = unselectedColor;
        repaint();
    }

    private Color selectedColor = new Color(248, 91, 50);
    private Color unselectedColor = new Color(230, 230, 230);

    public TabbedPaneCustom() {
        setBackground(new Color(0, 0, 0, 0)); // Thiết lập màu nền trong suốt
        setOpaque(false); // Đặt thành phần trong suốt
        setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        setUI(new TabbedPaneCustomUI(this));
    }
}
