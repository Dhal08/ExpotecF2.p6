package Clases;

import java.util.Properties;
import java.util.Random;
import javax.mail.*; 
import javax.mail.internet.*;

public class ServicioCorreo {
    
    private final String correoRemitente = "danielpirirperez0511@gmail.com"; 
    private final String contraseniaApp = "hpcxehvlxtziztjw"; 

    public String generarCodigo() {
        Random rand = new Random();
        int numero = 100000 + rand.nextInt(900000);
        return String.valueOf(numero);
    }

    public boolean enviarCodigoVerificacion(String correoDestino, String codigo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correoRemitente, contraseniaApp);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
            
            message.setSubject("Código de Verificación - Expotec");
            
            String cuerpo = "<h2>¡Hola!</h2>"
                    + "<p>Gracias por Usar Qode!. Para validar tu correo electrónico, ingresa el siguiente código en la aplicación:</p>"
                    + "<h1 style='color: #FF6B1A;'>" + codigo + "</h1>"
                    + "<p>Si no solicitaste este código, puedes ignorar este mensaje.</p>";
            
            message.setContent(cuerpo, "text/html; charset=utf-8");

            Transport.send(message);
            return true; 
            
        } catch (MessagingException e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
            return false; 
        }
    }
}