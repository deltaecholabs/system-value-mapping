package com.deltaecholabs.svm.system;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity(name = "System")
@Table(name = "system")
public class SystemEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_id")
    public Integer systemId;

    @Column(name = "name")
    @NotEmpty(message = "{System.name.required}")
    public String name;

    @Column(name = "description")
    @NotEmpty(message = "{System.description.required}")
    public String description;

}
