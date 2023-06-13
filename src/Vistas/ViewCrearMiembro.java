/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Data.MiembroData;
import Entidad.Miembro;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class ViewCrearMiembro extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewCrearMiembro
     */
    public ViewCrearMiembro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtDni = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Apellido:");

        jLabel4.setText("Dni:");

        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });

        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jLabel3.setText("CREAR NUEVO MIEMBRO");

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtxtDni)
                                        .addComponent(jtxtNombre))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 44, Short.MAX_VALUE)
                                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(37, 37, 37))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel3)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jButton1))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        if (jtxtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CAMPO Nombre -> VACIO!!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            jtxtNombre.requestFocus();
        } else if (!validarLetras(jtxtNombre.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Dato Nombre incorrecto >> Intente nuevamente...", "Error!", JOptionPane.ERROR_MESSAGE);
            jtxtNombre.requestFocus();
            jtxtNombre.setText("");
        } else if (jtxtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CAMPO Apellido -> VACIO!!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            jtxtApellido.requestFocus();
        } else if (!validarLetras(jtxtApellido.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Dato Apellido incorrecto >> Intente nuevamente...", "Error!", JOptionPane.ERROR_MESSAGE);
            jtxtApellido.requestFocus();
            jtxtApellido.setText("");
        } else if (jtxtDni.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CAMPO Dni -> VACIO!!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
            jtxtDni.requestFocus();
        } else if (!validarNumeros(jtxtDni.getText())) {
            JOptionPane.showMessageDialog(this, "Dato Dni incorrecto >> Intente nuevamente...", "Error!", JOptionPane.ERROR_MESSAGE);
            jtxtDni.requestFocus();
            jtxtDni.setText("");
        } else {
            try {
                Miembro miembro = new Miembro();
                MiembroData md = new MiembroData();
                miembro.setApellido(jtxtApellido.getText());
                miembro.setNombre(jtxtNombre.getText());
                miembro.setDni(Integer.parseInt(jtxtDni.getText()));
                miembro.setEstado(true);
                md.guardarMiembro(miembro);
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "El miembro no pudo ser agregado!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_jbGuardarActionPerformed
    public static boolean validarLetras(String letras) {
        return letras.matches("[a-z A-Z]*");
    }

    public static boolean validarNumeros(String numeros) {
        return numeros.matches("[0-9]*");
    }
    public void limpiar(){
        jtxtNombre.setText("");
        jtxtApellido.setText("");
        jtxtDni.setText("");
    }
    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtDni;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}
