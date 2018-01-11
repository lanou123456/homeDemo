package category.service;

import category.dao.CategoryDao;
import category.domain.Category;
import category.service.exception.HasBooksException;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CategoryService {

    public  String UUid(){
        UUID id= UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0];
    }

    private CategoryDao categoryDao = new CategoryDao();
    public List<Category> catSer() throws SQLException {
        List<Category> cate = categoryDao.cate();
return cate;

    }


    public void add( String cname) throws SQLException {
        String cid = UUid();
        categoryDao.add(cname,cid);
    }

public  void  delete(String cid) throws SQLException, HasBooksException {
    int count = categoryDao.count(cid);
    if (count==0){

        categoryDao.delete(cid);
    }else {

        throw  new HasBooksException();

    }

}



}
