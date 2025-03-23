package daljin.reminder.user;

import daljin.reminder.user.dto.GetByIdResponseDto;
import daljin.reminder.user.dto.GetResponseDto;
import daljin.reminder.user.dto.PostRequestDto;
import daljin.reminder.user.dto.PutRequestDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public GetResponseDto get(
            @RequestParam(defaultValue = "1" , required = false) int pageNo,
            @RequestParam(defaultValue = "25", required = false) int pageSize
    ) {
        return this.userService.page(pageNo , pageSize);
    }

    @GetMapping("/{id}")
    public GetByIdResponseDto getById(@PathVariable Long id) {
        return this.userService.getUser(id);
    }


    @PostMapping
    public void post(@RequestBody PostRequestDto body) {
        this.userService.create(body.getName(), body.getAge());
    }

    @PutMapping("/{id}")
    public void put(@PathVariable Long id, @RequestBody PutRequestDto body) {
        this.userService.update(id, body.getName(), body.getAge());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.userService.delete(id);
    }
}
