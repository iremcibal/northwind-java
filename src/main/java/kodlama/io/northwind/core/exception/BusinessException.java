package kodlama.io.northwind.core.exception;

public class BusinessException extends RuntimeException{
    public BusinessException(String message)
    {
        super(message);
    }
}
