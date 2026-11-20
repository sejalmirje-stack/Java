import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        // Optional inputs from form, or fallback to default
        String from = request.getParameter("from");
        if (from == null || from.trim().isEmpty()) {
            from = "ssmm88560@gmail.com";
        }

        String appPassword = request.getParameter("appPassword");
        if (appPassword == null || appPassword.trim().isEmpty()) {
            appPassword = "iwuwvwrqqvkwagul";
        }

        final String username = from;
        final String password = appPassword;

        Properties props = new Properties();
       

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");

        props.put("mail.smtp.ssl.enable", "false");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        props.put("mail.smtp.connectiontimeout", "20000");
        props.put("mail.smtp.timeout", "20000");
        props.put("mail.smtp.writetimeout", "20000");

        props.put("mail.debug", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            out.println("<!DOCTYPE html><html><head><title>Email Sent</title>");
            out.println("<style>body{font-family:sans-serif;padding:40px;background:#f4f6f9;} .card{background:#fff;padding:24px;border-radius:8px;max-width:550px;box-shadow:0 2px 10px rgba(0,0,0,0.1);}</style></head><body>");
            out.println("<div class='card'>");
            out.println("<h2 style='color:#27ae60;'>&#10004; Email Sent Successfully!</h2>");
            out.println("<p><strong>To:</strong> " + to + "</p>");
            out.println("<p><strong>Subject:</strong> " + subject + "</p>");
            out.println("<p><a href='index.html'>&larr; Send Another Email</a></p>");
            out.println("</div></body></html>");
        } catch (MessagingException e) {
            e.printStackTrace();
            out.println("<!DOCTYPE html><html><head><title>Email Status</title>");
            out.println("<style>body{font-family:sans-serif;padding:40px;background:#f4f6f9;} .card{background:#fff;padding:24px;border-radius:8px;max-width:550px;box-shadow:0 2px 10px rgba(0,0,0,0.1);}</style></head><body>");
            out.println("<div class='card'>");
            out.println("<h2 style='color:#e74c3c;'>&#10008; Email Dispatch Failed</h2>");
            out.println("<p style='color:#c0392b;'><strong>Error:</strong> " + e.getMessage() + "</p>");
            out.println("<p><small>Tip: If using Gmail SMTP, generate a 16-character <b>Google App Password</b> under Google Account Security &rarr; 2-Step Verification &rarr; App passwords.</small></p>");
            out.println("<p><a href='index.html'>&larr; Back to Form</a></p>");
            out.println("</div></body></html>");
        }
    }
}
