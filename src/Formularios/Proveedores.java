/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Entidades.Cliente;
import Entidades.ClienteJpaController;
import Entidades.EntityMain;
import Entidades.Proveedor;
import Entidades.ProveedorJpaController;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Proveedores extends javax.swing.JFrame {
    ProveedorJpaController CProveedor = new ProveedorJpaController(EntityMain.getInstance());

    Proveedor eProv;
    boolean registroExiste = false;
    int contar = 0;
    DefaultTableModel modelo2;
    
    /**
     * Creates new form Clientes
     */
    public Proveedores() {
        initComponents();
        CrearModelo();
        CargarProveedores();
        DesactivarCajas();
        ContarProveedores();
         btnGuardar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnNuevo2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JFormattedTextField();
        btnCerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tabla.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo2.setText("Nuevo");
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Proveedores");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setEnabled(false);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("Id");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnCerrar1.setText("Salir");
        btnCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(427, 427, 427))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId)
                        .addGap(106, 106, 106)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(53, 53, 53)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btnNuevo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTelefono)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        BuscarExistente();
        if (registroExiste == true) {
            Actualizar();
            ContarProveedores();

            Limpiar();
            CargarProveedores();
        } else {
            Guardar();
            Limpiar();
            ContarProveedores();
            CargarProveedores();
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ActivarCajas();
      
         btnGuardar.setEnabled(true);
        
        txtId.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        txtTelefono.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        txtDireccion.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());

      
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        Limpiar();
          ContarProveedores();
        btnGuardar.setEnabled(true);
       
        ActivarCajas();      
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    private void CrearModelo() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Id", "Nombre",
                        "Telefono", "Direccion"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }
 
    private void CargarProveedores() {

        try {
            Object O[] = null;
            List<Proveedor> listProveedores = CProveedor.findProveedorEntities();

            for (int i = 0; i < listProveedores.size(); i++) {
                modelo2.addRow(O);
                modelo2.setValueAt(listProveedores.get(i).getIdproveedor(), i, 0);
                modelo2.setValueAt(listProveedores.get(i).getNombre(), i, 1);
                modelo2.setValueAt(listProveedores.get(i).getTelefono(), i, 2);
                modelo2.setValueAt(listProveedores.get(i).getDireccion(), i, 3);
              
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }
    }

    private void Guardar() {

        Integer id = Integer.parseInt(this.txtId.getText());
        String nombre = this.txtNombre.getText();
        String direccion = this.txtDireccion.getText();
        String telefono = this.txtTelefono.getText();

        Proveedor prov = new Proveedor();

        prov.setIdproveedor(BigDecimal.valueOf(id));
        prov.setNombre(nombre);
        prov.setDireccion(direccion);
        prov.setTelefono(telefono);

        try {
            CProveedor.create(prov);
            JOptionPane.showMessageDialog(null, "Datos Registrados correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void Actualizar() {
        try {
            Integer id = Integer.parseInt(this.txtId.getText());
        String nombre = this.txtNombre.getText();
        String direccion = this.txtDireccion.getText();
        String telefono = this.txtTelefono.getText();

        Proveedor prov = new Proveedor();

        prov.setIdproveedor(BigDecimal.valueOf(id));
        prov.setNombre(nombre);
        prov.setDireccion(direccion);
        prov.setTelefono(telefono);

            CProveedor.edit(prov);
            JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "error");
        }

    }
      
    public void BuscarExistente() {

        Integer id = Integer.parseInt(this.txtId.getText());
        Proveedor registro = CProveedor.findProveedor(BigDecimal.valueOf(id));

        if (registro != null) {
            registroExiste = true;
        } else {
            registroExiste = false;
        }
    }
    
    public void ContarProveedores() {
        contar = CProveedor.getProveedorCount();
         this.txtId.setText(String.valueOf(contar+1));
    }
    
    public void ActivarCajas(){
        this.txtNombre.setEnabled(true);
        this.txtDireccion.setEnabled(true);
        this.txtTelefono.setEnabled(true);
    }
     public void DesactivarCajas(){
         this.txtNombre.setEnabled(false);
         this.txtDireccion.setEnabled(false);
         this.txtTelefono.setEnabled(false);
    }
    public void Limpiar(){
        this.txtId.setText("");
        this.txtNombre.setText("");
        this.txtDireccion.setText("");
        this.txtTelefono.setText("");
    }
   
    public void ValidarNumeros(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (c == KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        } else if (c < '0' || c > '9') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Debe Ingresar Solo numeros");
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
