package com.raven.form;

import com.raven.main.*;
import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.Form1;
import com.raven.form.Form_Home;
import com.raven.form.Form_QuanLySach;
import com.raven.form.MainForm;
import com.raven.main.Form_Login;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswingdev.message.MessageDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {
    
    private String profile;
    private String user;
    private String phanQuyen;
    private String tenNV;
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    public Main(String profile, String user,String phanQuyen, String tenNV) {
        this.profile = profile;
        this.user = user;
        this.phanQuyen = phanQuyen;
        this.tenNV = tenNV;
        initComponents();
        init();
    }

    public Main() {
        initComponents();
        init();
    }
    
    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu(phanQuyen);
        header = new Header(profile,user,phanQuyen);
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new Form_Home(tenNV));
                    System.err.println(tenNV);
                } else if (menuIndex == 1) 
                {
                    if (subMenuIndex == 0) {
                        main.showForm(new Form_QuanLySach(Main.this));
                    }
                    else if(subMenuIndex == 1)
                    {
                        main.showForm(new Form_NhaCungCap(Main.this));
                    }
                }
                else if (menuIndex == 2) 
                {
                    if (subMenuIndex == 0) {
                        main.showForm(new Form_PhieuNhap(Main.this));
                    }
                }
                else if (menuIndex == 3) 
                {
                    if (subMenuIndex == 0) {
                        
                        main.showForm(new Form_XuLyHoaDon1(Main.this));
                    }
                    else if(subMenuIndex == 1)
                    {
                        main.showForm(new Form_HoaDon(Main.this));
                    }
                    else if(subMenuIndex == 2)
                    {
                        main.showForm(new Form_QuanLyHoaDon());
                    }
                }
                else if(menuIndex == 4)
                {
                    main.showForm(new Form_KhachHang(Main.this));
                }
                else if (menuIndex == 5) 
                {
                    if ("Admin".equals(phanQuyen)) {
                        if (subMenuIndex == 0) {
                            main.showForm(new Form_QuanLyNhanVien(Main.this));
                        } else if (subMenuIndex == 1) {
                            main.showForm(new Form_QuanLyTaiKhoan(Main.this));
                        } else if (subMenuIndex == 2) {
                            main.showForm(new Form_TaoKhuyenMai(Main.this));
                        } else if (subMenuIndex == 3) {
                            main.showForm(new Form_ThemSachKhuyenMai(Main.this));
                        }
                    } else {
                        // Hiển thị thông báo nếu người dùng không có quyền truy cập
                        MessageDialog obj = new MessageDialog(Main.this);
                        obj.showMessage("Bạn không có quyền truy cập vào mục này.", "");
                    }
                }
                else if (menuIndex == 6) 
                {
                    MessageDialog obj = new MessageDialog(Main.this);

                    obj.showMessage("Bạn chắc chắn muốn đăng xuất ?", "");
                    if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                        Form_Login login = new Form_Login();
                        login.setVisible(true);
                        login.setLocationRelativeTo(null);
                        //  Close login form
                        SwingUtilities.getWindowAncestor(bg).dispose();
                    } else {
                        System.out.println("User clicked Cancel");
                    }
                    
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                if ("Admin".equals(phanQuyen)) {
                    MenuItem item = (MenuItem) com;
                    PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                    int x = Main.this.getX() + 52;
                    int y = Main.this.getY() + com.getY() + 86;
                    popup.setLocation(x, y);
                    popup.setVisible(true);
                } else {

                }
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Form_Home(tenNV));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        bg.setText("jLabel1");
        bg.setMaximumSize(new java.awt.Dimension(1366, 783));
        bg.setMinimumSize(new java.awt.Dimension(1366, 783));
        bg.setPreferredSize(new java.awt.Dimension(1366, 783));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    // End of variables declaration//GEN-END:variables
}
