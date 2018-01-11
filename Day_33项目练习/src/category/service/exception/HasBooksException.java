package category.service.exception;

public class HasBooksException extends Exception {
    @Override
    public String getMessage() {
        return "该分类中有书！无法删除";
    }
}
