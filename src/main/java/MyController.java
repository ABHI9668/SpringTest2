import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    private Person person;
    private EmailSender emailSender;

    @Autowired
    public MyController(Person person) {
        this.person = person;
    }

    @GetMapping("/getMappings")
    public ResponseEntity<Map<String, Object>> getMappings() {
        Map<String, Object> mappings = new HashMap<>();
        mappings.put("person", person);
        mappings.put("address", person.getAddress());
        
        emailSender.sendEmailWithObjects("spring.mail.username", person, person.getAddress());

        return ResponseEntity.ok(mappings);
    }
}
