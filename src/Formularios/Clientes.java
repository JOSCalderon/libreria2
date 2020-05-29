/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Entidades.Cliente;
import Entidades.ClienteJpaController;
import Entidades.EntityMain;
import Reportes.GenerarReportes;
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
public class Clientes extends javax.swing.JFrame {
    ClienteJpaController CCliente = new ClienteJpaController(EntityMain.getInstance());

    Cliente eCli;
    boolean registroExiste = false;
    int contar = 0;
    DefaultTableModel modelo2;
    boolean hayvacio=false;
    
    /**
     * Creates new form Clientes
     */
    public Clientes() {
        initComponents();
        CrearModelo();
        CargarClientes();
        DesactivarCajas();
        ContarClientes();
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
        txtNombres = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        lblDui = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        txtNrc = new javax.swing.JTextField();
        lblNrc = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtDui = new javax.swing.JFormattedTextField();
        txtNit = new javax.swing.JFormattedTextField();
        btnCerrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        jLabel1.setText("Clientes");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setEnabled(false);

        txtNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("Id");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setText("Nombres");

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblApellidos.setText("Apellidos");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDireccion.setText("Dirección");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelefono.setText("Telefono");

        lblDui.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDui.setText("DUI");

        lblNit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNit.setText("NIT");

        txtNrc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNrc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNrcKeyTyped(evt);
            }
        });

        lblNrc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNrc.setText("NRC");

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

        try {
            txtDui.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDui.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        try {
            txtNit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNit.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btnCerrar.setText("Salir");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(lblNombre))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNrc)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtNrc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDireccion)
                                .addGap(53, 53, 53)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellidos)
                                .addGap(54, 54, 54)
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefono)
                            .addComponent(lblDui)
                            .addComponent(lblNit))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblId)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNrc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(txtId)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNrc)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addGap(31, 31, 31)
                                .addComponent(lblDui))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDui, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNit)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        BuscarExistente();
        ValidarVacio();
        
        if (registroExiste == true) {
            Actualizar();
            Limpiar();
            CargarClientes();
            ContarClientes();

        } else {
            if (hayvacio==false){
             Guardar();
            }else{
             JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            }
           Limpiar();
            CargarClientes();
            ContarClientes();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ActivarCajas();
         btnGuardar.setEnabled(true);
        
        txtId.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        txtNombres.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        txtApellidos.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        txtDireccion.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
        txtTelefono.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
        txtDui.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
        txtNit.setText(tabla.getValueAt(tabla.getSelectedRow(), 6).toString());
        txtNrc.setText(tabla.getValueAt(tabla.getSelectedRow(), 7).toString());


    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
        Limpiar();
        btnGuardar.setEnabled(true);
        this.txtId.setText(String.valueOf(contar+1));
        ActivarCajas();      
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void txtNrcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNrcKeyTyped
        ValidarNumeros(evt);
    }//GEN-LAST:event_txtNrcKeyTyped

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       generarReporteClientes();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    private void CrearModelo() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Id", "Nombres",
                        "Apellidos", "Direccion", "Telefono", "DUI", "NIT", "NRC"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
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
 
    private void CargarClientes() {

        try {
            Object O[] = null;
            List<Cliente> listClientes = CCliente.findClienteEntities();

            for (int i = 0; i < listClientes.size(); i++) {
                modelo2.addRow(O);
                modelo2.setValueAt(listClientes.get(i).getIdcliente(), i, 0);
                modelo2.setValueAt(listClientes.get(i).getNombres(), i, 1);
                modelo2.setValueAt(listClientes.get(i).getApellidos(), i, 2);
                modelo2.setValueAt(listClientes.get(i).getDireccion(), i, 3);
                modelo2.setValueAt(listClientes.get(i).getTelefono(), i, 4);
                modelo2.setValueAt(listClientes.get(i).getDui(), i, 5);
                modelo2.setValueAt(listClientes.get(i).getNit(), i, 6);
                modelo2.setValueAt(listClientes.get(i).getNrc(), i, 7);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }

    }

    private void Guardar() {

        Integer id = Integer.parseInt(this.txtId.getText());
        String nombres = this.txtNombres.getText();
        String apellidos = this.txtApellidos.getText();
        String direccion = this.txtDireccion.getText();
        String telefono = this.txtTelefono.getText();
        String dui = this.txtDui.getText();
        String nit = this.txtNit.getText();
        String nrc = this.txtNrc.getText();

        Cliente cli = new Cliente();

        cli.setIdcliente(BigDecimal.valueOf(id));
        cli.setNombres(nombres);
        cli.setApellidos(apellidos);
        cli.setDireccion(direccion);
        cli.setTelefono(telefono);
        cli.setDui(dui);
        cli.setNit(nit);
        cli.setNrc(nrc);

        try {
            CCliente.create(cli);
            JOptionPane.showMessageDialog(null, "Datos Registrados correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void Actualizar() {
        try {
            Integer id = Integer.parseInt(this.txtId.getText());
            String nombres = this.txtNombres.getText();
            String apellidos = this.txtApellidos.getText();
            String direccion = this.txtDireccion.getText();
            String telefono = this.txtTelefono.getText();
            String dui = this.txtDui.getText();
            String nit = this.txtNit.getText();
            String nrc = this.txtNrc.getText();

            Cliente eCli = new Cliente();
            
           

            eCli.setIdcliente(BigDecimal.valueOf(id));
            eCli.setNombres(nombres);
            eCli.setApellidos(apellidos);
            eCli.setDireccion(direccion);
            eCli.setTelefono(telefono);
            eCli.setDui(dui);
            eCli.setNit(nit);
            eCli.setNrc(nrc);

            CCliente.edit(eCli);
            JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "error");
        }

    }
      
    public void BuscarExistente() {

        Integer id = Integer.parseInt(this.txtId.getText());
        Cliente registro = CCliente.findCliente(BigDecimal.valueOf(id));

        if (registro != null) {
            registroExiste = true;
        } else {
            registroExiste = false;
        }
    }
    
    public void ContarClientes() {
        contar = CCliente.getClienteCount();
         this.txtId.setText(String.valueOf(contar+1));
    }
    
    public void ActivarCajas(){
        this.txtApellidos.setEnabled(true);
        this.txtNombres.setEnabled(true);
        this.txtDireccion.setEnabled(true);
        this.txtDui.setEnabled(true);
        this.txtNit.setEnabled(true);
        this.txtNrc.setEnabled(true);
        this.txtTelefono.setEnabled(true);
    }
     public void DesactivarCajas(){
        this.txtApellidos.setEnabled(false);
        this.txtNombres.setEnabled(false);
        this.txtDireccion.setEnabled(false);
        this.txtDui.setEnabled(false);
        this.txtNit.setEnabled(false);
        this.txtNrc.setEnabled(false);
        this.txtTelefono.setEnabled(false);
    }
    public void Limpiar(){
        this.txtId.setText("");
        this.txtApellidos.setText("");
        this.txtNombres.setText("");
        this.txtDireccion.setText("");
        this.txtDui.setText("");
        this.txtNit.setText("");
        this.txtNrc.setText("");
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
    
    public void ValidarVacio(){
        
        
        if (txtNombres.getText().length()==0){
            hayvacio=true;
        
        }else if (txtApellidos.getText().length()==0){
            hayvacio=true;
       }else if (txtNrc.getText().length()==0){
            hayvacio=true;
       }else if (txtDireccion.getText().length()==0){
            hayvacio=true;
       }else if (txtTelefono.getText().length()==0){
            hayvacio=true;
       }else if (txtDui.getText().length()==0){
            hayvacio=true;
       }else if (txtNit.getText().length()==0){
            hayvacio=true;
       }
     
    }
    
     private void generarReporteClientes(){
    
    GenerarReportes g =new GenerarReportes(); 
    g.reporteClientes();
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDui;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNit;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNrc;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JFormattedTextField txtDui;
    private javax.swing.JTextField txtId;
    private javax.swing.JFormattedTextField txtNit;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNrc;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
