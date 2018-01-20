package dao;

import bean.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import util.HibernateUtil;

import java.util.List;

public class UserDao {
//    姓名，年龄，部门，入职时间，家庭住址，电话号码


public List<User> get(){
    List<User> users = HibernateUtil.handle(new HibernateUtil.ResultHandle<List<User>>() {
        @Override
        public List<User> resultHandle(Session session) {
            Query query = session.createQuery("from User ");
            List<User> list = query.list();
            return list;
        }
    });


    return users;
}

    public User get1(final int id){
      User user = HibernateUtil.handle(new HibernateUtil.ResultHandle<User>() {
            @Override
            public User resultHandle(Session session) {
                User user = session.get(User.class, id);

                return user;
            }
        });


        return user;
    }



    public void update(final User user){
      HibernateUtil.handle(new HibernateUtil.ResultHandle<User>() {
            @Override
            public User resultHandle(Session session) {
                int id = user.getId();
                User user1 = session.get(User.class, id);
                user1.setUname(user.getUname());
                user1.setAge(user.getAge());
                user1.setDepartment(user.getDepartment());
                user1.setTime(user.getTime());
                user1.setAddress(user.getAddress());
                user1.setPhone(user.getPhone());
                session.save(user1);
                return null;
            }
        });

    }


}
