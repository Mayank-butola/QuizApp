package com.max.quizservice.Models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ElementCollection
    private List<Integer> questionIds;
}
