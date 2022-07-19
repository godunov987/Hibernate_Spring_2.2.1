package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import javax.persistence.Query;
import java.util.List;

public interface UserDao {
   void add(User user);

   void add(Car car);

   List<User> listUsers();
   public User getUserByCar(Car car);

}
