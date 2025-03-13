package kz.qbs.course.controller.rolebasedcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @PostMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from user");
    }
}
