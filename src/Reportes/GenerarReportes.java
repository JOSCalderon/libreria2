/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jose
 */
public class GenerarReportes {
    
    public static final String DRIVER="oracle.jdbc.OracleDriver";
    public static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER="ferreteria3";
    public static final String PAS="123";
    
    public static Connection CONEXION;
    
    public void reporteFactura(int codigofactura){
                    
            try {
                
           Class.forName(DRIVER);
           CONEXION=DriverManager.getConnection(URL,USER,PAS );
          // javax.swing.JOptionPane.showMessageDialog(null, "Conexion establecida");
                
            JasperReport reporte=(JasperReport) JRLoader.loadObject("Factura2.jasper");
            Map parametro = new HashMap();
            
            parametro.put("codigofactura", codigofactura);
           
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro,CONEXION);
            JasperViewer jv= new JasperViewer (j,false);
            
            jv.setTitle("Factura");
            jv.setVisible(true);
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al generar el reporte"+e);
            }
    
    
    }
    
    public void reporteVentas(int codigoemp){
    
    try {
                
           Class.forName(DRIVER);
           CONEXION=DriverManager.getConnection(URL,USER,PAS );
          //javax.swing.JOptionPane.showMessageDialog(null, "Conexion establecida");
                
            JasperReport rep=(JasperReport) JRLoader.loadObject("historialventas02.jasper");
            Map param = new HashMap();
            
            param.put("codigoemp", codigoemp);
           
            JasperPrint ja= JasperFillManager.fillReport(rep, param,CONEXION);
            JasperViewer jc= new JasperViewer (ja,false);
            
            jc.setTitle("HistorialVentas");
            jc.setVisible(true);
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al generar el reporte"+e);
            }
    
    
    
    }
    
     public void reporteClientes(){
    
    try {
                
           Class.forName(DRIVER);
           CONEXION=DriverManager.getConnection(URL,USER,PAS );
          javax.swing.JOptionPane.showMessageDialog(null, "Conexion establecida");
                
            JasperReport rep=(JasperReport) JRLoader.loadObject("reporteClientes.jasper");
            Map param = new HashMap();
            
           // param.put("idempleado", idempleado);
           
            JasperPrint ja= JasperFillManager.fillReport(rep, param,CONEXION);
            JasperViewer jc= new JasperViewer (ja,false);
            
            jc.setTitle("Clientes");
            jc.setVisible(true);
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al generar el reporte"+e);
            }
    
    
    
    }
}
