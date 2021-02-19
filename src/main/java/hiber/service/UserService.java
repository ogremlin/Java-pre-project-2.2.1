package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    // получить User по его машине модели и серии
    User getUser(int series, String model);
    //Мой метод удаления Юзера для понимания удалится ли кар
    void drop(User user);
}
