package examples.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class UserFilter {

    public static void main(String[] args) {

        List<User> users = asList(
                new User("Hemanth", 30),
                new User("Priyansh", 28),
                new User("Sudhir", 35)
        );

        List<String> names = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
