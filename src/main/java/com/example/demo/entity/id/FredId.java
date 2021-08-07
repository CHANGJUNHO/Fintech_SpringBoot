package com.example.demo.entity.id;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

@Data
public class FredId implements Serializable {

     // @Transient 직렬화에 포함시키지 않을 데이터 명시
    String seriesId;
    String observationDate;
}
