import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Auto DI
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        return ResponseEntity
                .ok("200 OK");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@PathVariable Long id){
        return ResponseEntity
                .ok(new User());// user Instance
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(
            @PathVariable long id,
            @RequestBody User user
    ){
        return ResponseEntity
                .ok("200 OK");
    }
}