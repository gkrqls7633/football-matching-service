package com.mateam.util;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@RequiredArgsConstructor(staticName = "of")
public class ResponseMessageDto<D> {

    private final String resultCode;
    private final String message;
    private final D data;


}
