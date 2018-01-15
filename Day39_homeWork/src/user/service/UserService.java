package user.service;

import user.dao.UserDao;
import user.domain.User;
import user.service.loginException.LoginException;
import user.service.loginException.PasswordWrongException;
import user.service.loginException.UserNoHasException;
import user.service.registerException.UserHasException;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao  = new UserDao();
    public void register(User user) throws SQLException, UserHasException {
        User byUname = userDao.findByUname(user.getUsername());
        if (byUname == null){
                    userDao.add(user);
        }else {
            throw  new UserHasException();
        }

    }

    public  void  login(User user) throws SQLException, LoginException {

        User byUname = userDao.findByUname(user.getUsername());
        if (byUname!=null){
            if (user.getPassword().equals(byUname.getPassword())){

            }else {
                throw  new PasswordWrongException();
            }

        }else {
            throw  new UserNoHasException();
        }


    }



}
