/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz_expotec;

import javax.swing.JOptionPane;

/**
 *
 * @author anerm
 */
public class Prueba extends javax.swing.JFrame {

    private int preguntaActual = 1;
    private final int Total_Preguntas = 10;
    
    // 1. BANCO DE PREGUNTAS
    private String[] preguntas = {
        
        "¿Cómo reaccionas cuando obtienes una calificación baja en un examen para el cual estudiaste mucho?",
        "Cuando debes preparar un examen basado en capítulos completos de libros extensos y densos, ¿cómo procedes?",
        "¿Con qué frecuencia te interesa armar, desarmar o programar objetos tecnológicos, o software?",
        "Frente al estudio de la anatomía humana, patologías complejas y una enorme cantidad de terminología técnica médica, tú te sientes:",
        "Ante la necesidad de analizar extensos textos legales, códigos oficiales, jurisprudencia y redactar argumentos lógicos, tu postura es:",
        "¿Qué tipo de evaluaciones consideras que miden mejor tu verdadero nivel de preparación y conocimiento?",
        "Cuando te encuentras con un texto académico saturado de vocabulario técnico, formal y estructuras complejas, ¿cuál es tu actitud?",
        "¿Quién consideras que es el principal responsable de que comprendas y domines los contenidos evaluados en una carrera exigente?",
        "Al estudiar o simular un examen en una plataforma digital con una interfaz directa, sobria y formal, tú:",
        "Al simular exámenes de admisión o pruebas parciales exigentes antes de ingresar a la universidad, ¿qué es lo que más valoras obtener?"
    };
    
    // 2. BANCO DE OPCIONES
    private String[][] opciones = {
        
        {"A) Analizo detalladamente mi examen, busco el material oficial and modifico mi método.", "B) Me frustro un poco, pero pido consejo a compañeros o profesores para repasar.", "C) Me desmotivo y cuestiono si realmente soy apto para esta materia o carrera.", "D) Me enfado con el sistema, considerando que la prueba fue injusta o rebuscada."},
        {"A) Asumo la responsabilidad, planifico con tiempo y desgloso los capítulos solo.", "B) Busco resúmenes hechos por otros estudiantes o guías cortas en internet.", "C) Dependo de que un tutor, profesor o aplicación me explique los conceptos clave.", "D) Me cuesta organizarme solo y suelo dejar la lectura para los últimos días."},
        {"A) Siempre, me apasiona entender cómo funcionan las cosas a nivel de software.", "B) A veces, si el objeto o programa llama mucho mi atención.", "C) Rara vez, prefiero usar la tecnología en lugar de crearla o programarla.", "D) Nunca, me interesa más las áreas humanísticas o creativas."},
        {"A) Fascinado; me apasiona comprender mecanismos biológicos a nivel profundo.", "B) Interesado, siempre que sea práctico y no requiera tanta lectura teórica.", "C) Intimidado por la cantidad de memoria y precisión que se exige en el área.", "D) Indiferente; prefiero áreas relacionadas con las humanidades o artes digitales."},
        {"A) Me entusiasma el desafío intelectual de interpretar textos complejos y debatir.", "B) Me interesa el impacto social, pero me resulta pesado leer documentos largos.", "C) Prefiero la resolución de problemas mediante fórmulas o creatividad aplicada.", "D) No no me atrae en absoluto la lectura analítica ni el entorno legal."},
        {"A) Exámenes formales y estrictos basados exclusivamente en la bibliografía oficial.", "B) Evaluaciones prácticas, proyectos dinámicos o trabajos colaborativos en grupo.", "C) Cuestionarios cortos con retroalimentación inmediata y un enfoque interactivo.", "D) Pruebas sencillas que solo midan la comprensión general o rapidez lectora."},
        {"A) Lo tomo como un reto necesario; investigo los términos hasta dominar el lenguaje.", "B) Intento comprender el contexto general saltándome las palabras complejas.", "C) Me confundo rápidamente y pierdo el interés si el material no es cotidiano.", "D) Evito ese tipo de lecturas; prefiero contenidos audiovisuales o esquemas simples."},
        {"A) Yo mismo; el éxito depende de mi disciplina para estudiar el material oficial.", "B) Compartida; requiero que la institución me brinde herramientas interactivas.", "C) El docente o la plataforma de estudio; su rol debe ser guiarme paso a paso.", "D) El sistema de estudio general; si las preguntas son confusas el diseño falló."},
        {"A) Mantengo el foco al 100%, prefiero un entorno profesional serio y real.", "B) Me adapto bien, aunque preferiría algún tipo de recordatorio visual de progreso.", "C) Me distraigo con facilidad; necesito colores atractivos y mecánicas dinámicas.", "D) Me resulta abrumador y me genera ansiedad enfrentarme a una pantalla rígida."},
        {"A) Claridad absoluta sobre el nivel real de dificultad y la profundidad conceptual.", "B) Un diagnóstico rápido que me diga si aprobaría o no de manera general.", "C) Una experiencia guiada y cómoda que aumente mi confianza evitando frustrarme.", "D) Ejercicios rápidos para practicar a última hora antes del examen oficial."}
    };
            
    public Prueba() {   
        this.setUndecorated(true);
        initComponents();
        
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        jProgressBar1.setMinimum(0);
        jProgressBar1.setMaximum(Total_Preguntas);
        jProgressBar1.setValue(preguntaActual);
        jProgressBar1.setStringPainted(true);
        
        actualizarPregunta();
    }

    // 3. ACTUALIZACIÓN ADAPTATIVA DE TEXTOS
    private void actualizarPregunta() {
        int index = preguntaActual - 1; 
        
        jLabel7.setText("<html><body style='width: 800px; text-align: center; font-family: SansSerif; font-weight: bold; color: #2D2550;'>" 
                + preguntas[index] + "</body></html>");
        
        jLabel8.setText("");
        
        jRadioButton1.setText(opciones[index][0]);
        jRadioButton2.setText(opciones[index][1]);
        jRadioButton3.setText(opciones[index][2]);
        jRadioButton4.setText(opciones[index][3]);
        
        jLabel2.setText("Pregunta " + preguntaActual + " de " + Total_Preguntas + " (" + (preguntaActual * 10) + "%)");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(238, 234, 248));
        jPanel1.setPreferredSize(new java.awt.Dimension(1190, 710));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(30, 27, 46));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prueba Vocacional");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, -1));

        jPanel6.setBackground(new java.awt.Color(30, 27, 46));
        jPanel6.setPreferredSize(new java.awt.Dimension(67, 48));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz_expotec/Recursos/imagen_66x47.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(562, 562, 562)
                    .addComponent(jLabel10)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel10)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1190, 70));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Anterior");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 160, 50));

        jButton1.setBackground(new java.awt.Color(255, 107, 26));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz_expotec/Recursos/flecha-correcta.png"))); // NOI18N
        jButton1.setText("Siguiente");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 160, 50));

        jPanel7.setBackground(new java.awt.Color(244, 239, 245));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jPanel7.setPreferredSize(new java.awt.Dimension(940, 410));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(45, 37, 80));
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 107, -1, -1));

        // CONFIGURACIÓN DE TU ETIQUETA PRINCIPAL DE PREGUNTA CON ALINEACIÓN TOP Y CENTRO
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 37, 80));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 840, 90));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel7.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 840, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel7.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 840, 31));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel7.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 840, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPanel7.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 840, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 139, 940, 410));

        jProgressBar1.setForeground(new java.awt.Color(107, 107, 138));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 930, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabel2.setText("Pregunta 1 de 10 ( %)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (preguntaActual > 1) {
            preguntaActual--;
            jProgressBar1.setValue(preguntaActual);
            actualizarPregunta();
        }
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if (!jRadioButton1.isSelected() && !jRadioButton2.isSelected() &&
                !jRadioButton3.isSelected() && !jRadioButton4.isSelected()){
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, Selecciona una respuesta.");
            return;
        }
        
       if (preguntaActual < Total_Preguntas){
           preguntaActual++;
           jProgressBar1.setValue(preguntaActual);
           
           actualizarPregunta();
           
           buttonGroup1.clearSelection();
       } else {
           Selección_Carrera Seleccion = new Selección_Carrera();
           Seleccion.setVisible(true);
           this.dispose();
       }
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Mantiene la escala del AbsoluteLayout adaptada a monitores grandes
        System.setProperty("sun.java2d.uiScale", "1.0");

        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration                   
}