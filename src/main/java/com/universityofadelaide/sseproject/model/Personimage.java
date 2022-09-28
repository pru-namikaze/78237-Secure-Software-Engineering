package com.universityofadelaide.sseproject.model;

import com.universityofadelaide.sseproject.model.generic.GenericModel;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Personimage extends GenericModel<Personimage> {
    @Id
    @GeneratedValue
    private Long personimageid;
    @Column
    private Long personid;
    @Column
    private String imageurl;

    @Override
    public Long getId() {
        return this.getPersonimageid();
    }

    @Override
    public Personimage updateParametersIfPresent(Personimage dataCell) {
        if(Objects.isNull(this.getPersonid())){
            this.setPersonid(dataCell.getPersonid());
        }
        if(Objects.isNull(dataCell.getImageurl())){
            this.setImageurl(dataCell.getImageurl());
        }

        return this;
    }
}
