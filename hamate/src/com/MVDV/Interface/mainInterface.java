/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MVDV.Interface;
import com.MVDV.PL2.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 */
public class mainInterface extends javax.swing.JFrame{

    private datosJugadorClasificacion clasificacion;
    private String cargarPartidaNif;
    /**
     * Creates new form mainInterface
     */
    public mainInterface() {
        clasificacion = new datosJugadorClasificacion();
        initComponents();
        this.setTitle("Hamate");
        this.jLabelNombre.setVisible(false);
        this.jTextField1.setVisible(false);
        this.jLabel3.setVisible(false);
        this.jTextFieldEdad.setVisible(false);
        this.jLabel5.setVisible(false);
        this.jButton4.setVisible(false);
        this.jButton5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nifTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(72, 72, 85));

        jPanel1.setBackground(new java.awt.Color(72, 72, 85));

        nifTextField.setBackground(new java.awt.Color(250, 250, 250));
        nifTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nifTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(250, 250, 250));
        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Introduce tu nif");

        jButton1.setBackground(new java.awt.Color(250, 250, 250));
        jButton1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton1.setText("Iniciar Partida");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(250, 250, 250));
        jComboBox1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Dificil" }));

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 250, 250));
        jLabel4.setText("Dificultad");

        jButton2.setBackground(new java.awt.Color(250, 250, 250));
        jButton2.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton2.setText("Registrar usuario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(250, 250, 250));
        jButton3.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton3.setText("Clasificacion");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        this.setVisible(false);
        jLabelNombre.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(250, 250, 250));
        jLabelNombre.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 250, 250));
        jLabel3.setText("Edad");

        jTextField1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jTextFieldEdad.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 250, 250));
        jLabel5.setText("Se ha encontrado una partida empezada, ¿Continuar?");

        jButton4.setText("Si");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("No");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(jButton2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabelNombre)
                                .addComponent(jLabel3))
                            .addGap(116, 116, 116)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldEdad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nifTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nif = "";
        nif = nifTextField.getText();
        //comprobar el dni
        comprobarDni(nif, false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nifTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nifTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nifTextFieldActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        //Launch mensaje clasificacion
       
    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * Boton que lanza un mensaje con la clasificacion
     * @param evt Evento de clickeo
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, this.clasificacion.dibujarClasificacionInterfaz(), "Clasificacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed
    /**
     * Cuando se pulsa el boton, se comprueba si el usuario esta o no registrado, si lo esta se comienza la partida normalmente.
     * Sino, se muestran campos necesarios que hay que rellenar para generar nu usuario nuevo y empezar a jugar.
     * Se contemplan diferentes excepciones si no se completan correctamente los datos
     * @param evt Evento de clickeo
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String nif;
        nif = nifTextField.getText();
        String comprobar = this.clasificacion.comprobarNIFInterfaz(nif);
        try{
            if (this.jLabelNombre.isVisible()){
                //registrar usuario
                if (this.jTextFieldEdad.getText().equals("") || Integer.valueOf(this.jTextFieldEdad.getText()) < 18 )
                    throw new com.MVDV.PL2.JugadorException(com.MVDV.PL2.JugadorException.EDAD_INCORRECTA);
                
                else if (nifTextField.getText().equals(""))
                        throw new com.MVDV.PL2.JugadorException(com.MVDV.PL2.JugadorException.NIF_INCORRECTO);
                else if (this.jTextField1.getText().equals(""))
                            throw new com.MVDV.PL2.JugadorException("No se ha introducido ningun nombre");         
                else{
                    this.clasificacion.registrarUsuarioInterface(nifTextField.getText(), this.jTextField1.getText(), this.jTextFieldEdad.getText());
                    this.comprobarDni(nifTextField.getText(), true);
                }
            }else{
                if (comprobar.equals("")){
                JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Por favor rellena los datos.\nSi has introducido mal el nif, compruebalo de nuevo", "Registrar nuevo usuario", JOptionPane.INFORMATION_MESSAGE);
                    this.jLabelNombre.setVisible(true);
                    this.jTextField1.setVisible(true);
                    this.jLabel3.setVisible(true);
                    this.jTextFieldEdad.setVisible(true);
                }else{
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "El usuario esta registrado, comenzando partida", "Datos de usuario encontrados", JOptionPane.INFORMATION_MESSAGE);
                    comenzarPartida(nif);
                }
            }
        }catch (com.MVDV.PL2.JugadorException msg){
            this.setVisible(true);
            JFrame frame = new JFrame("FrameDemo");
            JOptionPane.showMessageDialog(frame, msg);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
/**
 * WIP: Pulsando este boton cargamos la partida anterior 
 * @param evt Evento de clickeo
 */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.cargarDatos(this.cargarPartidaNif);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * WIP: Pulsando este boton se elimina el archivo de anterior partida y se comienza una nueva
     * @param evt Evento de clickeo
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            File file = new File(fileWithDirectoryAssurance("datosPartidas", this.cargarPartidaNif));
            file.delete();
        } catch (Exception e) {}
            String nif = this.cargarPartidaNif;
            Thread thread = new Thread() {
                public void run() {
                    datosJugadorClasificacion clasificacionThread = new datosJugadorClasificacion();
                    ArrayList <String> datos = clasificacionThread.getDatosRegistradoInterface(nif);
                    String dificultad = jComboBox1.getSelectedItem().toString();
                    boolean dificultadBool = true;
                    if (dificultad.equals("Facil"))
                        dificultadBool = false;
                    Partida partida = new Partida(datos.get(1), datos.get(0), Integer.valueOf(datos.get(2)), dificultadBool);
                }
            };
             thread.start();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new mainInterface().setVisible(true);               
            }
        });
    }
    
    /**
     * Funcion principal, comienza la partida con los datos del jugador
     * @param nif Identificacion del jugador para obtener los datos necesarios
     */
    
    public void comenzarPartida (String nif){
        
        if (!comprobarPartidaGuarda(nif)){
            this.setVisible(false);
            Thread thread = new Thread() {
                public void run() {
                    datosJugadorClasificacion clasificacionThread = new datosJugadorClasificacion();
                    ArrayList <String> datos = clasificacionThread.getDatosRegistradoInterface(nif);
                    String dificultad = jComboBox1.getSelectedItem().toString();
                    boolean dificultadBool = true;
                    if (dificultad.equals("Facil"))
                        dificultadBool = false;
                    Partida partida = new Partida(datos.get(1), datos.get(0), Integer.valueOf(datos.get(2)), dificultadBool);
                }
            };
             thread.start();
        }else{
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Datos encontrados", "Datos Encontrados", JOptionPane.INFORMATION_MESSAGE);
            this.cargarPartidaNif = nif;
            this.jButton1.setVisible(false);
            this.jButton2.setVisible(false);
            this.jLabel5.setVisible(true);
            this.jButton4.setVisible(true);
            this.jButton5.setVisible(true);
        }
    }
    
    /**
     * Metodo que comprueba si hay una partida anterior guardada
     * @param nif Identificacion del jugador, asi mismo la usamos como identificacion de la partida
     * @return Booleano de control si existe o no
     */
    
    private boolean comprobarPartidaGuarda(String nif){
        File f = new File("datosPartidas/"+nif+".ser");
        return f.exists();
    }
    
    /**
     * Metodo que realiza la carga de la partida anterior
     * @param nif Identificador para la partida y jugador
     */

    private void cargarDatos(String nif){
        try{
            FileInputStream fis = new FileInputStream("datosPartidas/"+nif+".ser");
            ObjectInputStream ois =  new ObjectInputStream(fis);
            Partida partida = (Partida) ois.readObject();//El método readObject() recupera el objeto
            ois.close(); fis.close();
            partida.continuarPartida();
          }catch(FileNotFoundException e){
            e.printStackTrace();
          }catch(IOException e){
            e.printStackTrace();
          }catch(ClassNotFoundException e){
            e.printStackTrace();
          }
    }
    /**
     * Metodo que dado un nif comprueba si esta o no registrado el usuario, ademas si el usuario no esta registrado habilita los campos necesarios para registrarlo
     * @param nif Identificacion de usuario
     * @param registrando Variable de control para comprobar el identificador en primera o segunda instancia
     */
    
    private void comprobarDni(String nif, boolean registrando){
        if (registrando){
            String comprobar = this.clasificacion.comprobarNIFInterfaz(nif);
            if (comprobar.equals("")){
                //registrar usuario
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Ha ocurrido un error al registrar, por favor vuelve a intentar", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                this.jLabelNombre.setVisible(true);
                this.jTextField1.setVisible(true);
                this.jLabel3.setVisible(true);
                this.jTextFieldEdad.setVisible(true);
            }
            else{
                //coger datos del usuario 
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Usuario registrado con exito", "Usuario registrado", JOptionPane.INFORMATION_MESSAGE);
                comenzarPartida(nif);
            }
            
        }else{
            String comprobar = this.clasificacion.comprobarNIFInterfaz(nif);
            if (comprobar.equals("")){
                //registrar usuario
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Por favor rellena los datos", "Usuario no registrado", JOptionPane.INFORMATION_MESSAGE);
                this.jLabelNombre.setVisible(true);
                this.jTextField1.setVisible(true);
                this.jLabel3.setVisible(true);
                this.jTextFieldEdad.setVisible(true);
            }
            else{
                //coger datos del usuario 
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Cargando datos y comenzando partida", "Usuario registrado", JOptionPane.INFORMATION_MESSAGE);
                comenzarPartida(nif);
            }
        }
    }
    
    /**
     * Metodo que dado un directorio, crea la carpeta del directorio si no existe y devuelve la ruta relativa al fichero
     * @param directory Directorio al fichero
     * @param filename Nombre del fichero
     * @return Ruta relativa al fichero
     */
 private static String fileWithDirectoryAssurance(String directory, String filename) {
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        return (directory + "/" + filename + ".ser");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField nifTextField;
    // End of variables declaration//GEN-END:variables
}
