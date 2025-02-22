package imaks.hillelboot.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
}
