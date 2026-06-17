/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz_expotec;

import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author Computacion
 */
public class PruebaModulos extends javax.swing.JFrame {

    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;

    private int preguntaActual = 1;
    private int totalPreguntas = 5;

    private JProgressBar barraProgreso;
    private javax.swing.JLabel lblPregunta;

    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JRadioButton rbtn4;

    private javax.swing.ButtonGroup grupoRespuestas;

    /**
     * Creates new form PruebaModulos
     */
    public PruebaModulos() {

        initComponents();

        crearComponentes();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        addComponentListener(
                new java.awt.event.ComponentAdapter() {

            @Override
            public void componentResized(
                    java.awt.event.ComponentEvent evt
            ) {
                redimensionar();
            }

        }
        );

        redimensionar();

    }

    private void crearComponentes() {

        jPanel8.setLayout(null);

        // Barra progreso
        barraProgreso = new JProgressBar();

        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);

        // ejemplo: pregunta 1 de 5
        barraProgreso.setValue(20);

        barraProgreso.setStringPainted(true);

        // Label pregunta
        lblPregunta = new javax.swing.JLabel("Pregunta 1");

        lblPregunta.setFont(
                new Font("Arial",
                        Font.BOLD,
                        22
                )
        );

        lblPregunta.setForeground(
                new java.awt.Color(45, 37, 80)
        );

        // CheckBox
        grupoRespuestas = new javax.swing.ButtonGroup();

        rbtn1 = new javax.swing.JRadioButton("Respuesta A");
        rbtn2 = new javax.swing.JRadioButton("Respuesta B");
        rbtn3 = new javax.swing.JRadioButton("Respuesta C");
        rbtn4 = new javax.swing.JRadioButton("Respuesta D");

        javax.swing.JRadioButton[] radios = {
            rbtn1,
            rbtn2,
            rbtn3,
            rbtn4
        };

        for (javax.swing.JRadioButton r : radios) {

            r.setBackground(
                    new java.awt.Color(
                            244,
                            239,
                            245
                    )
            );

            r.setFont(
                    new java.awt.Font(
                            "Arial",
                            java.awt.Font.PLAIN,
                            18
                    )
            );

            btnAnterior = new javax.swing.JButton("← Anterior");
            btnSiguiente = new javax.swing.JButton("Siguiente →");

            btnAnterior.setFont(
                    new java.awt.Font(
                            "Arial",
                            java.awt.Font.BOLD,
                            14
                    )
            );

            btnSiguiente.setFont(
                    new java.awt.Font(
                            "Arial",
                            java.awt.Font.BOLD,
                            14
                    )
            );

// BOTON ANTERIOR
            btnAnterior.addActionListener(e -> {

                if (preguntaActual > 1) {

                    preguntaActual--;

                    grupoRespuestas.clearSelection();

                    actualizarPregunta();

                }

            });

// BOTON SIGUIENTE
            btnSiguiente.addActionListener(e -> {

                // validar respuesta
                if (!hayRespuestaSeleccionada()) {

                    javax.swing.JOptionPane.showMessageDialog(
                            this,
                            "Seleccione una respuesta antes de continuar"
                    );

                    return;

                }

                // avanzar
                if (preguntaActual < totalPreguntas) {

                    preguntaActual++;

                    grupoRespuestas.clearSelection();

                    actualizarPregunta();

                } else {

                    javax.swing.JOptionPane.showMessageDialog(
                            this,
                            "Ha terminado la prueba"
                    );

                }

            });

            jPanel8.add(btnAnterior);

            jPanel8.add(btnSiguiente);

            grupoRespuestas.add(r);

            jPanel8.add(r);

        }

        jPanel8.add(barraProgreso);

        jPanel8.add(lblPregunta);

    }

    private void actualizarPregunta() {

        // Titulo
        lblPregunta.setText(
                "Pregunta " + preguntaActual
        );

        // progreso
        int porcentaje
                = (preguntaActual * 100)
                / totalPreguntas;

        barraProgreso.setValue(
                porcentaje
        );

        barraProgreso.setString(
                preguntaActual
                + " de "
                + totalPreguntas
        );

        // respuestas prototipo
        rbtn1.setText(
                "Respuesta A - Pregunta " + preguntaActual);

        rbtn2.setText(
                "Respuesta B - Pregunta " + preguntaActual);

        rbtn3.setText(
                "Respuesta C - Pregunta " + preguntaActual);

        rbtn4.setText(
                "Respuesta D - Pregunta " + preguntaActual);

        // activar/desactivar botones
        btnAnterior.setEnabled(
                preguntaActual > 1
        );

        btnSiguiente.setEnabled(
                preguntaActual < totalPreguntas
        );

    }

    private boolean hayRespuestaSeleccionada() {

    return grupoRespuestas.getSelection() != null;

}
    
    private void redimensionar() {

        int ancho = getContentPane().getWidth();
        int alto = getContentPane().getHeight();
        jPanel5.setLayout(null);
        jPanel5.setBounds(0, 0, ancho, alto);
        jPanel5.setBounds(0, 0, ancho, 70);
        jPanel8.setBounds(120, 120, ancho - 200, 80);
        jPanel8.setLayout(null);

        getContentPane().setLayout(null);

        // PANEL PRINCIPAL
        jPanel5.setBounds(
                0,
                0,
                ancho,
                alto
        );

        jPanel5.setLayout(null);

        // BARRA SUPERIOR
        jPanel6.setBounds(
                0,
                0,
                ancho,
                70
        );

        // BARRA INFERIOR
        jPanel7.setBounds(
                0,
                alto - 70,
                ancho,
                70
        );

        // PANEL CENTRAL
        int anchoPanel = (int) (ancho * 0.60);
        int altoPanel = (int) (alto * 0.65);
        int xPanel = (ancho - anchoPanel) / 2;
        int yPanel = (alto - altoPanel) / 2;
        jPanel8.setBounds(xPanel, yPanel, anchoPanel, altoPanel);
        jPanel8.setLayout(null);

        // TITULOS
        jLabel1.setBounds(
                40,
                20,
                180,
                50
        );

        jLabel3.setBounds(
                175,
                20,
                400,
                50
        );

        jLabel4.setBounds(
                30,
                90,
                jPanel8.getWidth() - 60,
                30
        );

        jLabel6.setBounds(
                30,
                150,
                150,
                30
        );

        // BARRA PROGRESO
        barraProgreso.setBounds(
                30,
                190,
                jPanel8.getWidth() - 60,
                25
        );

        // PREGUNTA
        lblPregunta.setBounds(
                30,
                270,
                300,
                40
        );

        if (btnAnterior != null) {

            btnAnterior.setBounds(
                    120,
                    altoPanel - 75,
                    150,
                    45
            );

        }

        if (btnSiguiente != null) {

            btnSiguiente.setBounds(
                    anchoPanel - 270,
                    altoPanel - 75,
                    170,
                    45
            );

        }

        int anchoRespuesta = jPanel8.getWidth() - 100;

        rbtn1.setBounds(50, 350, anchoRespuesta, 35);
        rbtn2.setBounds(50, 410, anchoRespuesta, 35);
        rbtn3.setBounds(50, 470, anchoRespuesta, 35);
        rbtn4.setBounds(50, 530, anchoRespuesta, 35);

        repaint();
        revalidate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(238, 234, 248));
        jPanel5.setPreferredSize(new java.awt.Dimension(970, 560));

        jPanel6.setBackground(new java.awt.Color(30, 27, 46));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Prueba");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(1115, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(30, 27, 46));
        jPanel7.setPreferredSize(new java.awt.Dimension(67, 48));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz_expotec/Recursos/imagen_66x47.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(562, 562, 562)
                    .addComponent(jLabel10)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel10)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel8.setBackground(new java.awt.Color(244, 239, 245));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel8.setPreferredSize(new java.awt.Dimension(765, 370));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(45, 37, 80));
        jLabel1.setText("Prueba: ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(45, 37, 80));
        jLabel3.setText("Modulo");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(45, 37, 80));
        jLabel4.setText("Evaluacion de conceptos clave en ingeniería en Sistemas.");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 37, 80));
        jLabel6.setText("Progreso");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(599, 599, 599)
                        .addComponent(jLabel9))
                    .addComponent(jLabel4)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1190, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PruebaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaModulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaModulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
