package shoppingmall.exception;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 22/10/2020
 * Time : 7:35 AM
 */

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(String s) {
        super(s);
    }
}
