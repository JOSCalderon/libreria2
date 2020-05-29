
package Formularios;

import Entidades.EntityMain;
import Entidades.Compras;
import Entidades.ComprasJpaController;
import Entidades.Proveedor;
import Entidades.ProveedorJpaController;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Compra1 extends javax.swing.JFrame {
    
    ComprasJpaController CCompra = new ComprasJpaController(EntityMain.getInstance());     
    
    ProveedorJpaController CProveedor = new ProveedorJpaController(EntityMain.getInstance());
    List<Proveedor> listProveedores= CProveedor.findProveedorEntities();
    
    boolean registroExiste = false;
    int contar = 0;
    DefaultTableModel modelo2;
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");

   
    public Compra1() {
        initComponents();
        ///fecha del sistema
       // Date sisFecha=new Date();
       // SimpleDateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
       // this.txtFecha.setText(formato.format(sisFecha));      
       
        CrearModelo();
        CargarCompras();
        DesactivarCajas();
        ContarCompras();        
        LlenarComboProveedor();
        btnEdit.setEnabled(true);
        
    }

     private void CrearModelo() {
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Id", "Proveedor",
                        "Fecha", "Precio de compra"}) {
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
     
     private void CargarCompras() {

        try {
            Object O[] = null;
            List<Compras> listcomp = CCompra.findComprasEntities();

            for (int i = 0; i < listcomp.size(); i++) {
                modelo2.addRow(O);
                modelo2.setValueAt(listcomp.get(i).getIdcompra(),i, 0);
                modelo2.setValueAt(listcomp.get(i).getIdproveedor(), i, 1);
                modelo2.setValueAt(listcomp.get(i).getPreciocompra(), i, 2);
                modelo2.setValueAt(listcomp.get(i).getFechacompra(), i, 3);
                
              
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());

        }
    }    
     
     private void Guardar() {

        Integer id = Integer.parseInt(this.txtId.getText());
        Integer proveedor = this.CBProveedorC.getSelectedIndex() + 1;
        Double total = Double.parseDouble(this.TXTTotal.getText());       
        String strFecha = this.txtFecha.getText();
        
            Date fecha = null;
            try {
                fecha = formatoDeFecha.parse(strFecha);
           } catch (ParseException ex) {
               ex.printStackTrace();
            }

        Compras comp = new Compras();

        comp.setIdcompra(BigDecimal.valueOf(id));
        comp.setIdproveedor(BigInteger.valueOf(proveedor));
        comp.setPreciocompra(BigDecimal.valueOf(total));
        comp.setFechacompra(fecha);

        try {
            CCompra.create(comp);
            JOptionPane.showMessageDialog(null, "Datos Registrados correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }
    }

    public void Actualizar() {
        try {
            Integer id = Integer.parseInt(this.txtId.getText());
            Integer proveedor = this.CBProveedorC.getSelectedIndex() + 1;    
            String strFecha = this.txtFecha.getText();
            Double total = Double.parseDouble(this.TXTTotal.getText());        
            
            
            Date fecha = null;
            try {
                fecha = formatoDeFecha.parse(strFecha);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        Compras comp = new Compras();

        comp.setIdcompra(BigDecimal.valueOf(id));
        comp.setIdproveedor(BigInteger.valueOf(proveedor));
        comp.setFechacompra(fecha);
        comp.setPreciocompra(BigDecimal.valueOf(total));

            CCompra.edit(comp);
            JOptionPane.showMessageDialog(null, "Datos Actualizados correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "error");
        }

    }
     
     
     public void ContarCompras() {
        contar = CCompra.getComprasCount();
         this.txtId.setText(String.valueOf(contar+1));
    }
     
     public void ActivarCajas(){
        //this.txtId.setEnabled(true);
        this.TXTTotal.setEnabled(true);
        this.txtFecha.setEnabled(true);
    }
     public void DesactivarCajas(){
         this.txtId.setEnabled(false);
         this.TXTTotal.setEnabled(false);
         this.txtFecha.setEnabled(false);
    }
     
public void Limpiar(){
      
   
    this.txtId.setText("");
    this.TXTTotal.setText(""); 
    this.txtFecha.setText("");
   
    
}

public void ValidarDecimales(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        

        if (c == KeyEvent.VK_BACK_SPACE){
        evt.consume();
        
        }else if ((c < '0' || c > '9')&&c!='.') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Debe Ingresar Solo numeros");
        }
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

 public void BuscarExistente() {

        Integer id = Integer.parseInt(this.txtId.getText());
        Compras registro = CCompra.findCompras(BigDecimal.valueOf(id));

        if (registro != null) {
            registroExiste = true;
        } else {
            registroExiste = false;
        }
    }
 DefaultComboBoxModel combo2  = new DefaultComboBoxModel();
      private void LlenarComboProveedor(){
          CBProveedorC.setModel(combo2);
         for (int i=0; i<listProveedores.size(); i++){
         combo2.addElement(listProveedores.get(i).getNombre());
         }
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CBProveedorC = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TXTTotal = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnProducto = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        btnCerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Registros de Compras");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("No. Compra");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Proveedor");

        CBProveedorC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CBProveedorC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Fecha:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDCompra", "Proveedor", "Fecha", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Total Compra");

        TXTTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnProducto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnProducto.setText("Agregar Producto Nuevo");
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCerrar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(CBProveedorC, 0, 112, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(TXTTotal)))
                    .addComponent(btnProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(369, 369, 369))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CBProveedorC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(TXTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Limpiar();
        ContarCompras();
        btnGuardar.setEnabled(true);
       
        ActivarCajas();   
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        BuscarExistente();
        if (registroExiste == true) {
            Actualizar();
            ContarCompras();

            Limpiar();
            CargarCompras();
        } else {
            Guardar();
            Limpiar();
            ContarCompras();
            CargarCompras();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        Productos_01 prod = new Productos_01();
        prod.setVisible(true);
      //this.setVisible(false);
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        ActivarCajas();
      
         btnGuardar.setEnabled(true);
        
        txtId.setText(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
        CBProveedorC.setSelectedItem(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        TXTTotal.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        txtFecha.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(Compra1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra1().setVisible(true);
           }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBProveedorC;
    private javax.swing.JTextField TXTTotal;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
