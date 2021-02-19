package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   //Мой метод для получения User по модели и серии
   @Override
   public User getUser(int series, String model) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("select u from User u where u.car.model = :model and u.car.series = :series")
              .setParameter("model", model)
              .setParameter("series", series);
      return query.getSingleResult();
   }

   //Мой метод удаления Юзера для понимания удалится ли кар
   @Override
   public void drop(User user) {
      sessionFactory.getCurrentSession().delete(user);
   }
}
