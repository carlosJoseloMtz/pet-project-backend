package mx.nopaloverflow.petservices.api;

import mx.nopaloverflow.petservices.dtos.UserDto;
import mx.nopaloverflow.petservices.models.UserModel;
import mx.nopaloverflow.petservices.repositories.UserRepository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/users/**")
public class UsersController {

    @Resource
    private UserRepository userRepository;

    @PostMapping
    public String createUser(@RequestBody final UserDto user) {
        Assert.notNull(user, "User should not be null");

        final var nUser = new UserModel();
        nUser.setUsername(user.getUsername());
        nUser.setName(user.getName());
        nUser.setPassword("randome");
        userRepository.save(nUser);
        return nUser.getId();
    }

    @GetMapping
    public Collection<UserModel> getAllUsers() {
        return (Collection<UserModel>) userRepository.findAll();
    }
}
