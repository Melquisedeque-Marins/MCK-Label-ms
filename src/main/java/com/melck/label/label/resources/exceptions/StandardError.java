package com.melck.label.label.resources.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError {
    private Instant timeStamp;
    private Integer status;
    private String error;
    private String path;
}
