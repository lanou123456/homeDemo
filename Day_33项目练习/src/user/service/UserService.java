package user.service;

import user.daomain.User;
import user.dao.UserDao;
import user.service.exception.loginException.*;
import user.service.exception.registerException.*;
import user.uti.Email;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.UUID;

public class UserService {
    private UserDao userDao = new UserDao();
    private Email email = new Email();
    public void register(User user) throws SQLException, RegisterException {
        if (user.getEmail()!=null|| user.getUsername()!=null||user.getPassword()!=null) {
            User byUsername = userDao.findByUsername(user.getUsername());
            User email = userDao.findEmail(user.getEmail());
            if (byUsername == null) {
                if (email == null) {
                    userDao.add(user);

                } else {
                    throw new EmailHasException();
                }
            } else {

                throw new UsernameHasException();

            }
        }else {
            throw  new NullException();
        }
    }


    public  void  sendEmail(String sEmail,String uuid ) throws GeneralSecurityException, MessagingException {

        email.t1(sEmail,uuid);


    }




    public User active(String uuid) throws SQLException, RegisterException {
        User user = userDao.FindByCode(uuid);

        if (user!=null){
                     return  user;
        }else {


            throw  new CodeIsNullException();
        }


    }



    public String findUid(User form) throws SQLException {
        String uidByName = userDao.findUidByName(form);
        return uidByName;


    }





    public  String  Ud(){


        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;

    }



    public  void  state(String code) throws SQLException {
     userDao.updateState(code);

    }



    public User login(User user) throws SQLException, LoginException {
        User fname = userDao.findByUsername(user.getUsername());
        if (user.getPassword()!=null && user.getUsername()!=null) {
            if (fname != null) {
                if (user.getUsername().equals(fname.getUsername())) {
                    if (user.getPassword().equals(fname.getPassword())) {
                        if (fname.getState() == 1) {
                            return user;

                        } else {
                            throw new StateException();
                        }

                    } else {
                        throw new PasswordWrongException();
                    }
                } else {

                    throw new UsernaemNotException();
                }
             }else {
                throw new UserNotHasExection();
            }

        } else {
                throw new NullLoginException();
        }

    }


    
}
