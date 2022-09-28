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
public class Personmatch extends GenericModel<Personmatch> {
    @Id
    @GeneratedValue
    private Long matchid;
    @Column
    private Long personid1;
    @Column
    private Long personid2;
    @Column
    private Boolean personid1like;
    @Column
    private Boolean personid2like;
    @Column
    private String chaturl;

    @Override
    public Long getId() {
        return this.getMatchid();
    }

    @Override
    public Personmatch updateParametersIfPresent(Personmatch dataCell) {
        if(Objects.isNull(this.getPersonid1())){
            this.setPersonid1(dataCell.getPersonid1());
        }
        if(Objects.isNull(this.getPersonid2())){
            this.setPersonid2(dataCell.getPersonid2());
        }
        if(Objects.isNull(this.getPersonid1like())){
            this.setPersonid1like(dataCell.getPersonid1like());
        }
        if(Objects.isNull(this.getPersonid2like())){
            this.setPersonid2like(dataCell.getPersonid2like());
        }
        if(Objects.isNull(this.getChaturl())){
            this.setChaturl(dataCell.getChaturl());
        }

        return this;
    }
}
