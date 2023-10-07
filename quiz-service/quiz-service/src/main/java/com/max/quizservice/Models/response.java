package com.max.quizservice.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class response {
    private Integer id;
    private String response;
}
