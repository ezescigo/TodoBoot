package TodoList.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    private String message;

    public ItemNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public ItemNotFoundException() {
    }
}