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
public class Personcredential extends GenericModel<Personcredential> {
    @Id
    @GeneratedValue
    private Long personcredentialid;
    @Column
    private Long personid;
    @Column
    private String personcredentialemail;
    @Column
    private String personcredentialpassword;

    @Override
    public Long getId() {
        return this.getPersoncredentialid();
    }

    @Override
    public Personcredential updateParametersIfPresent(Personcredential dataCell) {
        if(Objects.isNull(this.getPersonid())){
            this.setPersonid(dataCell.getPersonid());
        }
        if(Objects.isNull(this.getPersoncredentialemail())){
            this.setPersoncredentialemail(dataCell.getPersoncredentialemail());
        }
        if(Objects.isNull(this.getPersoncredentialpassword())){
            this.setPersoncredentialpassword(dataCell.getPersoncredentialpassword());
        }

        return this;
    }
}
