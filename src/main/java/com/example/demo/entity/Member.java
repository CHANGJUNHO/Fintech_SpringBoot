package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
//@Builder
@NoArgsConstructor // 기본생성자를 생성해줘야 serialization 정상적으로 동작한다.
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue
    Long seq;
    String id;
    String name;
    String org;
    Boolean active;
}
