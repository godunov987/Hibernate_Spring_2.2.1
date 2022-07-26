package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car[] = {
              new Car("bmw", 3),
              new Car("mers", 200),
              new Car("jiguli", 7),
              new Car("paravozik_tomas", 1)};

      User userArr[] = {
              new User("User1", "Lastname1", "user1@mail.ru"),
              new User("User2", "Lastname2", "user2@mail.ru"),
              new User("User3", "Lastname3", "user3@mail.ru"),
              new User("User4", "Lastname4", "user4@mail.ru")
      };
      for (int i = 0; i < userArr.length; i++) {
         userArr[i].setCar(car[i]);
         userService.add(userArr[i]);
      }

      System.out.println(userService.getUserByCar(car [1]).toString());



//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}
