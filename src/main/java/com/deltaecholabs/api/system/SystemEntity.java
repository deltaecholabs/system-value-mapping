package com.deltaecholabs.api.system;

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
    @NotEmpty
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemEntity that = (SystemEntity) o;
        if (!Objects.equals(systemId, that.systemId)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = systemId != null ? systemId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SystemEntity{" +
                "systemId=" + systemId +
                ", name='" + name + '\'' +
                '}';
    }

}