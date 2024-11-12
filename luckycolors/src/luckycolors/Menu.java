package luckycolors;

public class Menu extends javax.swing.JFrame {
/*
 * Menu, cambia la dificultad del juego, aumentando la cantidad de variables
 */

    public Menu() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        easyBtn = new javax.swing.JButton();
        mediumBtn = new javax.swing.JButton();
        hardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(153, 153, 153));
        setFocusable(false);
        setResizable(false);
        setSize(new java.awt.Dimension(650, 530));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        easyBtn.setText("EASY");
        easyBtn.setFocusable(false);
        easyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyBtnActionPerformed(evt);
            }
        });

        mediumBtn.setText("MEDIUM");
        mediumBtn.setFocusable(false);
        mediumBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mediumBtnActionPerformed(evt);
            }
        });

        hardBtn.setText("HARD");
        hardBtn.setFocusable(false);
        hardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mediumBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(hardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(easyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(easyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mediumBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mediumBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mediumBtnActionPerformed
        String[] colors = {"red", "blue", "yellow"};
        Sort sorter = new Sort(4, colors);
        sorter.fillVials();

        GameWindow game = new GameWindow(sorter.retrieve(), 4);
        game.setVisible(true);
        dispose();
    }//GEN-LAST:event_mediumBtnActionPerformed

    private void easyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyBtnActionPerformed
        String[] colors = new String[]{"red", "orange"}; //2 + null
        Sort sorter = new Sort(3, colors);
        sorter.fillVials();

        GameWindow game = new GameWindow(sorter.retrieve(), 3);
        game.setVisible(true);
        dispose();
    }//GEN-LAST:event_easyBtnActionPerformed

    private void hardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardBtnActionPerformed
        String[] colors = new String[]{"red", "orange", "blue", "green"}; //4 + null
        Sort sorter = new Sort(5, colors);
        sorter.fillVials();
        
        GameWindow game = new GameWindow(sorter.retrieve(), 5);
        game.setVisible(true);
        dispose();
    }//GEN-LAST:event_hardBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton easyBtn;
    private javax.swing.JButton hardBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton mediumBtn;
    // End of variables declaration//GEN-END:variables
}
