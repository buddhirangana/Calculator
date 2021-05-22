/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhi Rangana
 */
public final class CalcJFrame extends javax.swing.JFrame {

    float num1 = 0, num2 = 0, oprClickCount = 0;
    String opr;
    boolean isOprClick = false, isEqualClick = false;

    public CalcJFrame() {
        initComponents();
        addAction();
        setTitle("Calculator");
        setIconImage(new ImageIcon(getClass().getResource("Apps-Calc-icon.png")).getImage());
    }

    public ActionListener createAction(JButton button) {

        ActionListener acLis = (ActionEvent e) -> {
            // if the button is not an operation (is number include '.')
            if (!isOperator(button)) {
                if (isOprClick)// if an opration is clicked
                {
                    num1 = Float.valueOf(input_txt.getText());
                    input_txt.setText("");
                }

                if (!input_txt.getText().contains(".")) { //if the text dont contain '.'

                    if (input_txt.getText().equals("0") && !button.getText().equals(".")) {
                        // if jtext contain only 0 clear text
                        // and the button pressed is not '.'
                        input_txt.setText(button.getText());
                        isOprClick = false;
                    } else {
                        input_txt.setText(input_txt.getText() + button.getText());
                        isOprClick = false;
                    }
                } else if (!button.getText().equals(".")) {
                    input_txt.setText(input_txt.getText() + button.getText());
                    isOprClick = false;
                }
            } else {// if the button is an operation [+ - * / =]

                if (oprClickCount == 0)// if an operation is clicked for the first time
                {
                    oprClickCount++;
                    // convert the textField to float and set it into num1
                    num1 = Float.valueOf(input_txt.getText());
                    opr = button.getText();
                    isOprClick = true;
                } else {

                    if (!button.getText().equals("="))// if the operation is not '='
                    {
                        if (!isEqualClick) {
                            num2 = Float.valueOf(input_txt.getText());
                            input_txt.setText(Float.toString(calc(opr, num1, num2)));
                            opr = button.getText();
                            num2 = Float.valueOf(input_txt.getText());
                            isOprClick = true;
                            isEqualClick = false;
                        } else {
                            isEqualClick = false;
                            opr = button.getText();
                        }
                    } else {
                        num2 = Float.valueOf(input_txt.getText());
                        input_txt.setText(Float.toString(calc(opr, num1, num2)));
                        num1 = Float.valueOf(input_txt.getText());
                        isOprClick = true;
                        isEqualClick = true;
                    }

                }

            }
        };
        return acLis;
    }

    // calc two numbers and return the result
    public float calc(String op, float n1, float n2) {
        float result = 0;

        switch (op) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
                }
                break;
            default:
                break;
        }

        return result;
    }

    // check if the button is an operator
    public boolean isOperator(JButton button) {
        String buttonText = button.getText();

        return buttonText.equals("+") || buttonText.equals("-")
                || buttonText.equals("*") || buttonText.equals("/")
                || buttonText.equals("=");

    }

    // add action to all buttons
    public void addAction() {

        Component[] components = cal_panel.getComponents();

        for (Component component : components) {

            if (component instanceof JButton) {

                JButton button = (JButton) component;
                button.addActionListener(createAction(button));

            }

        }

    }

    public void resetButton() {
		getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Are you Sure", "Reset", JOptionPane.QUESTION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        txt_date = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        cal_panel = new javax.swing.JPanel();
        input_txt = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        sub_btn = new javax.swing.JButton();
        mul_btn = new javax.swing.JButton();
        div_btn = new javax.swing.JButton();
        zero_btn = new javax.swing.JButton();
        first_btn = new javax.swing.JButton();
        two_btn = new javax.swing.JButton();
        three_btn = new javax.swing.JButton();
        four_btn = new javax.swing.JButton();
        five_btn = new javax.swing.JButton();
        six_btn = new javax.swing.JButton();
        seven_btn = new javax.swing.JButton();
        eight_btn = new javax.swing.JButton();
        nine_btn = new javax.swing.JButton();
        equals_btn = new javax.swing.JButton();
        point_btn = new javax.swing.JButton();
        header_pane = new javax.swing.JDesktopPane();
        reset_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        footer_pane = new javax.swing.JDesktopPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        txt_date.setText("Date");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 150, 150, 150));
        setResizable(false);

        cal_panel.setBackground(new java.awt.Color(0, 0, 0));

        input_txt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        input_txt.setText("0");
        input_txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        add_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add_btn.setText("+");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        sub_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sub_btn.setText("-");
        sub_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sub_btnActionPerformed(evt);
            }
        });

        mul_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mul_btn.setText("*");

        div_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        div_btn.setText("/");

        zero_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        zero_btn.setText("0");

        first_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        first_btn.setText("1");

        two_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        two_btn.setText("2");

        three_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        three_btn.setText("3");

        four_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        four_btn.setText("4");

        five_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        five_btn.setText("5");

        six_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        six_btn.setText("6");

        seven_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        seven_btn.setText("7");

        eight_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        eight_btn.setText("8");

        nine_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nine_btn.setText("9");

        equals_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        equals_btn.setText("=");

        point_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        point_btn.setText(".");

        javax.swing.GroupLayout header_paneLayout = new javax.swing.GroupLayout(header_pane);
        header_pane.setLayout(header_paneLayout);
        header_paneLayout.setHorizontalGroup(
            header_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        header_paneLayout.setVerticalGroup(
            header_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout cal_panelLayout = new javax.swing.GroupLayout(cal_panel);
        cal_panel.setLayout(cal_panelLayout);
        cal_panelLayout.setHorizontalGroup(
            cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cal_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cal_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(input_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cal_panelLayout.createSequentialGroup()
                        .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sub_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(zero_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(first_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(four_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(five_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(eight_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nine_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(point_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(equals_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(six_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seven_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(mul_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(div_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cal_panelLayout.createSequentialGroup()
                                .addComponent(two_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(three_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(header_pane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        cal_panelLayout.setVerticalGroup(
            cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cal_panelLayout.createSequentialGroup()
                .addComponent(header_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mul_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(div_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(three_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(two_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zero_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(first_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(four_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(five_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(six_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seven_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cal_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eight_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nine_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(point_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equals_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        reset_btn.setBackground(new java.awt.Color(102, 102, 255));
        reset_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        reset_btn.setText("Reset");
        reset_btn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/Button-Block-icon.png"))); // NOI18N
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });
        reset_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reset_btnKeyPressed(evt);
            }
        });

        clear_btn.setBackground(new java.awt.Color(255, 102, 102));
        clear_btn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        clear_btn.setText("Clear");
        clear_btn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/Button-Delete-icon (1).png"))); // NOI18N
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout footer_paneLayout = new javax.swing.GroupLayout(footer_pane);
        footer_pane.setLayout(footer_paneLayout);
        footer_paneLayout.setHorizontalGroup(
            footer_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        footer_paneLayout.setVerticalGroup(
            footer_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(footer_pane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cal_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cal_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset_btn)
                    .addComponent(clear_btn))
                .addGap(18, 18, 18)
                .addComponent(footer_pane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        resetButton();

        num1 = 0;
        num2 = 0;
        oprClickCount = 0;
        opr = "";
        isOprClick = false;
        isEqualClick = false;

        input_txt.setText("0");
    }//GEN-LAST:event_reset_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        if (input_txt.getText().length() > 0) {
            String txt = input_txt.getText();
            String txtMinus = txt.substring(0, txt.length() - 1);
            input_txt.setText(txtMinus);
        }
    }//GEN-LAST:event_clear_btnActionPerformed

    private void sub_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sub_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sub_btnActionPerformed

    private void reset_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reset_btnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_btnKeyPressed

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
            java.util.logging.Logger.getLogger(CalcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalcJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CalcJFrame().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JPanel cal_panel;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton div_btn;
    private javax.swing.JButton eight_btn;
    private javax.swing.JButton equals_btn;
    private javax.swing.JButton first_btn;
    private javax.swing.JButton five_btn;
    private javax.swing.JDesktopPane footer_pane;
    private javax.swing.JButton four_btn;
    private javax.swing.JDesktopPane header_pane;
    private javax.swing.JTextField input_txt;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mul_btn;
    private javax.swing.JButton nine_btn;
    private javax.swing.JButton point_btn;
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton seven_btn;
    private javax.swing.JButton six_btn;
    private javax.swing.JButton sub_btn;
    private javax.swing.JButton three_btn;
    private javax.swing.JButton two_btn;
    private javax.swing.JMenu txt_date;
    private javax.swing.JButton zero_btn;
    // End of variables declaration//GEN-END:variables
}
