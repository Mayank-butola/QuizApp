package com.project.quizapp.Models;
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
    @ManyToMany
    private List<question> questions;
}
