package daljin.reminder.user;

import daljin.reminder.user.domain.User;
import daljin.reminder.user.dto.GetByIdResponseDto;
import daljin.reminder.user.dto.GetResponseDto;
import daljin.reminder.user.dto.PostRequestDto;
import daljin.reminder.user.dto.PutRequestDto;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public GetResponseDto get(@RequestParam(required = false, defaultValue = "1") int pageNo, @RequestParam(required = false, defaultValue = "25") int pageSize) {

        Pair<Integer, List<User>> page = this.userService.page(pageNo, pageSize);

       return new GetResponseDto(page.getFirst(), page.getSecond().stream().map(u -> new GetResponseDto.User(u.getId(), u.getName(), u.getAge(), u.getCreatedAt().toString(), u.getUpdatedAt().toString())).toList());
    }

    @GetMapping("/{id}")
    public GetByIdResponseDto getById(@PathVariable int id) {
        User user = this.userService.getUser(id);
        return new GetByIdResponseDto(user.getId(), user.getName(), user.getAge(), user.getCreatedAt().toString(), user.getUpdatedAt().toString());
    }


    @PostMapping
    public void post(@RequestBody PostRequestDto body) {
        this.userService.create(body.name, body.age);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable int id, @RequestBody PutRequestDto body) {
        this.userService.update(id, body.name, body.age);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.userService.delete(id);
    }
}
