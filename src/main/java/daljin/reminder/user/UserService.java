package daljin.reminder.user;

import daljin.reminder.user.domain.User;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service()
public class UserService {

    private final List<User> users = new ArrayList<>(List.of(
            User.builder()
                    .id(1)
                    .name("user_name_1")
                    .age(2)
                    .createdAt(new Date())
                    .updatedAt(new Date())
                    .build()
    ));

    public Pair<Integer, List<User>> page(int pageNo, int pageSize) {
        List<User> pageUsers;
        int startIndex = ((pageNo - 1) * pageSize);
        if(startIndex > this.users.size() -1) {
            pageUsers = new ArrayList<>();
        } else {
            int lastIndex = Math.min(startIndex + pageSize - 1 , this.users.size());
            pageUsers = this.users.subList(startIndex, lastIndex);
        }


        return Pair.of(this.users.size(), pageUsers);
    }

    public User getUser(int id) {
        return this.users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow();
    }

    public void create(String name, int age) {
        int nextId = this.users.size() + 1;
        this.users.add(User.builder()
                .id(nextId)
                .name("user_name_" + nextId)
                .age(nextId + 1)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build());
    }


    public void update(int id, String name, int age) {
        User user = this.users.stream().filter(u -> u.getId() == id).findFirst().orElseThrow();

        user.setName(name);
        user.setAge(age);
    }

    public void delete(int id) {
        this.users.removeIf(user -> user.getId() == id);
    }

}
