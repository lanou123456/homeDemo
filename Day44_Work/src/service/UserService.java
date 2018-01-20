package service;

import bean.User;
import dao.UserDao;

import java.util.List;

public class UserService {
    private  UserDao userDao = new UserDao();
    public List<User> get(){

        List<User> users = userDao.get();
        return users;

    }


    public User get1(int id){

        User user = userDao.get1(id);
        return user;

    }

    public void update(User user){
userDao.update(user);

    }

}
