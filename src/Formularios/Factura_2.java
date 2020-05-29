/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Entidades.Cliente;
import Entidades.ClienteJpaController;
import Entidades.Detalleventa;
import Entidades.DetalleventaJpaController;
import Entidades.Empleado;
import Entidades.EmpleadoJpaController;
import Entidades.EntityMain;
import Entidades.Factura;
import Entidades.FacturaJpaController;
import Entidades.Producto;
import Entidades.ProductoJpaController;
import Entidades.Tipoprecio;
import Entidades.TipoprecioJpaController;
import Entidades.Tipoventa;
import Entidades.TipoventaJpaController;
import Reportes.GenerarReportes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class Factura_2 extends javax.swing.JFrame {
    
    
    
    TipoventaJpaController CTipoventa = new TipoventaJpaController(EntityMain.getInstance());
    List<Tipoventa> listTipoventa = CTipoventa.findTipoventaEntities();
    
    
   ProductoJpaController CProducto = new ProductoJpaController(EntityMain.getInstance());
    List<Producto> listProducto = CProducto.findProductoEntities();
    
    TipoprecioJpaController CTipoPrecio = new TipoprecioJpaController(EntityMain.getInstance());
    List<Tipoprecio> listTipoPrecio = CTipoPrecio.findTipoprecioEntities();
    
     FacturaJpaController CFactura = new FacturaJpaController(EntityMain.getInstance());
    List<Factura> listFactura = CFactura.findFacturaEntities();
   
     ClienteJpaController CCliente = new ClienteJpaController(EntityMain.getInstance());
    List<Cliente> listCliente = CCliente.findClienteEntities();
    
     EmpleadoJpaController CEmpleado = new EmpleadoJpaController(EntityMain.getInstance());
    List<Empleado> listEmpleado= CEmpleado.findEmpleadoEntities();
    
    DetalleventaJpaController CDetalleVenta = new DetalleventaJpaController(EntityMain.getInstance());
    List<Detalleventa> listDetalleVenta = CDetalleVenta .findDetalleventaEntities();
    
    DecimalFormat df=new DecimalFormat("#.00");
    
    
    Double SubTotalFactura, iva,totaldetalle, TotalFactura;
    
    String dato1,dato2,dato3,dato4,dato5;
    
    int contar = 0;
    boolean registroExiste = false;
    boolean hayvacio=false;
    

    /**
     * Creates new form Factura_2
     */
    public Factura_2() {
        initComponents();
        
        LlenarComboTipoVenta();
        LlenarComboProducto();
        LlenarComboTipoPrecio();
        ContarFactura();
        LlenarComboCliente();
        LlenarComboEmpleado();
        
    }
    
    
     private void GenerarFactura(){
    
    GenerarReportes g =new GenerarReportes(); 
    g.reporteFactura(Integer.parseInt(txtNFactura.getText()));
    
    }
    
     
    DefaultComboBoxModel combo1  = new DefaultComboBoxModel();
    DefaultComboBoxModel combo2  = new DefaultComboBoxModel();
    DefaultComboBoxModel combo3  = new DefaultComboBoxModel();
    DefaultComboBoxModel combo4  = new DefaultComboBoxModel();
    DefaultComboBoxModel combo5  = new DefaultComboBoxModel();
    
    private void LlenarComboTipoVenta(){
          cmbTipoVenta.setModel(combo1);
         for (int i=0; i<listTipoventa.size(); i++){
         combo1.addElement(listTipoventa.get(i).getTipoventa());
         }
    
    }
    
    private void LlenarComboProducto(){
          cmbProducto.setModel(combo2);
         for (int i=0; i<listProducto.size(); i++){
         combo2.addElement(listProducto.get(i).getNombre());
         
         }
         
    
    }
    
     private void LlenarComboTipoPrecio(){
          cmbTipoPrecio.setModel(combo3);
         for (int i=0; i<listTipoPrecio.size(); i++){
         combo3.addElement(listTipoPrecio.get(i).getTipoprecio());
         }
    
    }
     
      private void LlenarComboCliente(){
          cmbCliente.setModel(combo4);
         for (int i=0; i<listCliente.size(); i++){
         combo4.addElement(listCliente.get(i).getNombres()+' '+listCliente.get(i).getApellidos());
         }
    
    }
     
      
       private void LlenarComboEmpleado(){
          cmbEmpleado.setModel(combo5);
         for (int i=0; i<listEmpleado.size(); i++){
         combo5.addElement(listEmpleado.get(i).getNombres()+' '+listEmpleado.get(i).getApellidos());
         }
    
    }
     
   
     DefaultTableModel modelo = new DefaultTableModel();
     private void LlenarTablaFactura(){
         

         this.tabla.setModel(modelo);

         String titulo[] = {"Producto", "Precio Unitario", "Cantidad", "SubTotal", "Descuento", "Total"};

         modelo.setColumnIdentifiers(titulo);

         String registros[] = new String[6];

         double precio, descuento, subtotal, total = 0;

        precio = Double.parseDouble(txtPrecio.getText());
        int cant = Integer.parseInt(spinCantidad.getValue().toString());

        if (cmbTipoPrecio.getSelectedIndex() == 0) {
            descuento = (0.05);
        } else {
            descuento = (0.20);
        }

        subtotal = (precio * cant);
        totaldetalle = (subtotal - (subtotal * descuento));

        registros[0] = cmbProducto.getSelectedItem().toString();
        registros[1] = String.valueOf(precio);
        registros[2] = String.valueOf(cant);
        registros[3] = String.valueOf(subtotal);
        registros[4] = String.valueOf(descuento);
        registros[5] = String.valueOf(totaldetalle);

        SubTotalFactura = totaldetalle;

        HacerCalculos();
        MostrarCalculos();

        dato1 = registros[1];
        dato2 = registros[2];
        dato3 = registros[3];
        dato4 = registros[4];
        dato5 = registros[5];

        modelo.addRow(registros);

    }

    public void HacerCalculos() {

        // SubTotalFactura = totaldetalle;
        iva = (Totalizar() * 0.13);
        TotalFactura = (Totalizar() + iva);

    }

    public void MostrarCalculos() {

        lblSubTotal.setText(String.valueOf(df.format(Totalizar())));
        lblIva.setText(String.valueOf(df.format(iva)));
        lblTotalFactura.setText(String.valueOf(df.format(TotalFactura)));

    }

    public double Totalizar() {
        int contar = tabla.getRowCount();
        double Totalizar = 0;

        for (int i = 0; i < contar; i++) {
            Totalizar = Totalizar + Double.parseDouble(tabla.getValueAt(i, 5).toString());
        }

        return Totalizar;
    }

    public void ContarFactura() {
            contar = CFactura.getFacturaCount();
        this.txtNFactura.setText(String.valueOf(contar + 1));
        

    }

    public void GuardarDetalle() {

        Integer id = Integer.parseInt(txtNFactura.getText());
        Integer producto = cmbProducto.getSelectedIndex() + 1;
        Integer tipoprecio = cmbTipoPrecio.getSelectedIndex() + 1;

        modelo = (DefaultTableModel) tabla.getModel();

        lblResultado.setText(dato1);

        Double preciounitario = Double.parseDouble(dato1);
        Integer cantidad = Integer.parseInt(dato2);
        Double subto = Double.parseDouble(dato3);
        Double desc = Double.parseDouble(dato4);
        Double totl = Double.parseDouble(dato5);

        Detalleventa de = new Detalleventa();

        de.setIdfactura(BigInteger.valueOf(id));
        de.setIdproducto(BigInteger.valueOf(producto));
        de.setIdtipoprecio(BigInteger.valueOf(tipoprecio));
        de.setCantidad(BigInteger.valueOf(cantidad));
        de.setPrecionominal(BigDecimal.valueOf(preciounitario));
        de.setSubtotal(BigDecimal.valueOf(subto));
        de.setDescuento(BigDecimal.valueOf(desc));
        de.setTotal(BigDecimal.valueOf(totl));

        try {
            CDetalleVenta.create(de);
           // JOptionPane.showMessageDialog(null, "Factura registrada Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }

    }
    
    
    
    
    
    
    private void GuardarFactura(){
        
        Integer id = Integer.parseInt(txtNFactura.getText());
       Integer tipoventa = cmbTipoVenta.getSelectedIndex() + 1;
       Integer empleado = cmbEmpleado.getSelectedIndex() + 1;
       Integer cliente = cmbCliente.getSelectedIndex() + 1;
       SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
       
         
         String strFecha = this.txtFecha.getText();
        Date fecha = null;
        try {
            fecha = formatoFecha.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        Double subtotalfac = Double.parseDouble(lblSubTotal.getText());
        Double ivafac = Double.parseDouble(lblIva.getText());
        Double totalfactura = Double.parseDouble(lblTotalFactura.getText());
        Factura fac = new Factura();

        fac.setIdfactura(BigDecimal.valueOf(id));
        fac.setIdtipoventa(BigInteger.valueOf(tipoventa));
        fac.setIdempleado(BigInteger.valueOf(empleado));
        fac.setIdcliente(BigInteger.valueOf(cliente));
        fac.setFechahora(fecha);
         fac.setSubtotal(BigDecimal.valueOf(subtotalfac));
        fac.setIva(BigDecimal.valueOf(ivafac));
       
        fac.setTotalfactura(BigDecimal.valueOf(totalfactura));

        try {
            CFactura.create(fac);
            JOptionPane.showMessageDialog(null, "Factura Registrada Correctamente correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.toString());
        }

    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtBuscarCliente = new javax.swing.JTextField();
        cmbTipoVenta1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JButton();
        cmbProducto = new javax.swing.JComboBox<>();
        lblResultado = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        spinCantidad = new javax.swing.JSpinner();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        lblIva = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtNFactura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblTotalFactura = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoVenta = new javax.swing.JComboBox<>();
        cmbTipoPrecio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnCerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Buscar Cliente");

        tabla.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        txtBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClienteActionPerformed(evt);
            }
        });

        cmbTipoVenta1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoVenta1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nrc", "Dui", "Apellidos", "Nombres" }));
        cmbTipoVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVenta1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cliente:");

        txtFecha.setEditable(false);
        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.setText("14-11-2019");
        txtFecha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Producto:");

        btnHistorial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHistorial.setText("Ver Historial Ventas");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        cmbProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });
        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        lblResultado.setText("jLabel13");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        spinCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spinCantidad.setValue(0);

        cmbCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Total  $ ");

        cmbEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Cantidad:");

        btnFacturar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnFacturar.setText("FACTURAR");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Subtotal:  $");

        lblSubTotal.setEditable(false);
        lblSubTotal.setBackground(new java.awt.Color(230, 230, 230));
        lblSubTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblSubTotal.setFocusable(false);
        lblSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSubTotalActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("IVA:  $");

        lblIva.setEditable(false);
        lblIva.setBackground(new java.awt.Color(230, 230, 230));
        lblIva.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblIva.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Venta");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Precio  $");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nº Factura:");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNFactura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNFactura.setEnabled(false);
        txtNFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNFacturaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de Venta:");

        lblTotalFactura.setEditable(false);
        lblTotalFactura.setBackground(new java.awt.Color(230, 230, 230));
        lblTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotalFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblTotalFactura.setFocusable(false);
        lblTotalFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblTotalFacturaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Tipo Precio");

        cmbTipoVenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVentaActionPerformed(evt);
            }
        });

        cmbTipoPrecio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipoPrecio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbTipoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPrecioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Empleado:");

        btnGuardar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar1.setText("Nuevo");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

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
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(325, 325, 325)
                                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(299, 299, 299))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTipoVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addGap(10, 10, 10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel32))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblTotalFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(lblIva)
                                    .addComponent(lblSubTotal))))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(632, 632, 632))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtNFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoVenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                                    .addComponent(btnCerrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFacturar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 414, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClienteActionPerformed

    private void cmbTipoVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoVenta1ActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        ListadoVentas lis = new ListadoVentas();
        lis.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged
        int seleccionado= cmbProducto.getSelectedIndex();
        txtPrecio.setText(listProducto.get(seleccionado).getPrecioventa().toString());

    }//GEN-LAST:event_cmbProductoItemStateChanged

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        LlenarTablaFactura();
        HacerCalculos();
        MostrarCalculos();
        GuardarDetalle();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        modelo = (DefaultTableModel) tabla.getModel();

        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            int []filasselec  = tabla.getSelectedRows();
            for (int i=0; i<filasselec.length;i++)
            {
                modelo.removeRow(filasselec[i]);
                HacerCalculos();
                MostrarCalculos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        GuardarFactura();
        GenerarFactura();
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void lblSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblSubTotalActionPerformed

    private void txtNFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNFacturaActionPerformed

    private void lblTotalFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTotalFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTotalFacturaActionPerformed

    private void cmbTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoVentaActionPerformed

    private void cmbTipoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoPrecioActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        Clientes cli = new Clientes();
        cli.setVisible(true);
    }//GEN-LAST:event_btnGuardar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Factura_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar1;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbTipoPrecio;
    private javax.swing.JComboBox<String> cmbTipoVenta;
    private javax.swing.JComboBox<String> cmbTipoVenta1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblIva;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField lblSubTotal;
    private javax.swing.JTextField lblTotalFactura;
    private javax.swing.JSpinner spinCantidad;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNFactura;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
