package edu.sjsu.cmpe275.cartpool.cartpool.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBody {
    private String timestamp;
    private Integer status;
    private String title;
    private String message;

    public ResponseBody() {

    }
}
