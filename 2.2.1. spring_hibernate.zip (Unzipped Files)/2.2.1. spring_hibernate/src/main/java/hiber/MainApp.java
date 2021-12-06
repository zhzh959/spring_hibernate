package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new Car("BMW", 320));
      userService.add(new Car("LADA", 2121));
      userService.add(new Car("LEXUS", 570));
      userService.add(new Car("GAZ", 3110));

      List<Car> cars = userService.listCars();

      userService.add(new User("Igor", "Popov", "user1@mail.ru", cars.get(0)));
      userService.add(new User("Ivan", "Ivanov", "user2@mail.ru", cars.get(1)));
      userService.add(new User("Petr", "Sidorov", "user3@mail.ru", cars.get(2)));
      userService.add(new User("Fedor", "Sinicin", "user4@mail.ru", cars.get(3)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println("Кто владеет \"LEXUS 570\"?");
      System.out.println(userService.findOwner("LEXUS", 570));
      System.out.println();
      System.out.println();
      userService.deleteAllUsers();
      context.close();
   }
}

