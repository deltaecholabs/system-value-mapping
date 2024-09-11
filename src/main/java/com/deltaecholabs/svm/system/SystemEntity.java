package com.deltaecholabs.svm.system;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEntity that = (SystemEntity) o;
        return Objects.equals(systemId, that.systemId) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemId, name, description);
    }

    @Override
    public String toString() {
        return "SystemEntity{" +
                "systemId=" + systemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
