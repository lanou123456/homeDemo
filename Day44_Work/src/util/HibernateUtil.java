package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
   private static SessionFactory sessionFactory;
    static {

         sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static <T> T handle(ResultHandle<T> rh){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

       T stu = rh.resultHandle(session);

        session.getTransaction().commit();
        session.close();
        return stu;
    }

  public   interface ResultHandle<T> {
    T resultHandle(Session session);
}

}
