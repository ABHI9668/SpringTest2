import JavaMailSender.JavaMailSender;
import component.Component;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailWithObjects(String recipient, Object... objects) {
        try {
            MimeMessage message;
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            StringBuilder content = new StringBuilder();
            for (Object object : objects) {
                content.append(object.toString()).append("\n");
            }

            helper.setTo(recipient);
            helper.setSubject("Objects via Spring API");
            helper.setText(content.toString());

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MimeMessageHelper {
        public MimeMessageHelper(MimeMessage message, boolean b) {
        }

        public void setTo(String recipient) {
        }

        public void setSubject(String objectsViaSpringApi) {

        }

        public void setText(String string) {

        }
    }
}
