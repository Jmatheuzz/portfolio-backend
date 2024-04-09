package com.jmatheus.portfolio.portfolio.responses;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseNoBody extends Response{

    public ResponseNoBody(String message) {
        super(message);
    }
}
