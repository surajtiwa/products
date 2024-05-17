package com.scaler.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotFoundException extends Exception {

    public NotFoundException(Long id) {
        super("The product Id was not found."+id);
    }
}
