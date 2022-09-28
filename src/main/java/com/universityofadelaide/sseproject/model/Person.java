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
public class Person extends GenericModel<Person> {
    @Id
    @GeneratedValue
    private Long personid;
    @Column
    private String personname;
    @Column
    private String personlocation;
    @Column
    private String persongender;
    @Column
    private String persondateofbirth;

    @Override
    public Long getId() {
        return this.getPersonid();
    }

    @Override
    public Person updateParametersIfPresent(Person dataCell) {
        if(Objects.isNull(this.getPersonname())){
            this.setPersonname(dataCell.getPersonname());
        }
        if(Objects.isNull(this.getPersonlocation())){
            this.setPersonlocation(dataCell.getPersonlocation());
        }
        if(Objects.isNull(this.getPersongender())){
            this.setPersongender(dataCell.getPersongender());
        }
        if(Objects.isNull(this.getPersondateofbirth())){
            this.setPersondateofbirth(dataCell.getPersondateofbirth());
        }

        return this;
    }
}
