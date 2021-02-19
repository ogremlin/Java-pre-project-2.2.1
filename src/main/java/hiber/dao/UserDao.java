package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   //Мой метод для получения User по модели и серии
   User getUser(int series, String model);
   //Мой метод удаления User для понимания удалится ли кар
   void drop(User user);
}
