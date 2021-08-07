package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTo Service <-> Controller <-> DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Observation {
    String date;
    Double value;
}
