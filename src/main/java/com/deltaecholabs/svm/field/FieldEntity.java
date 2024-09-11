package com.deltaecholabs.svm.field;

import com.deltaecholabs.svm.system.SystemEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity(name = "Field")
@Table(name = "field")
public class FieldEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    public Integer fieldId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_id", nullable = false)
    @NotNull(message = "{Field.system.required}")
    public SystemEntity system;

    @Column(name = "name")
    @NotEmpty(message = "{Field.name.required}")
    public String name;

    @Column(name = "description")
    public String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldEntity that = (FieldEntity) o;
        return Objects.equals(fieldId, that.fieldId) && Objects.equals(system, that.system) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldId, system, name, description);
    }

    @Override
    public String toString() {
        return "FieldEntity{" +
                "fieldId=" + fieldId +
                ", system='" + system.name + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
