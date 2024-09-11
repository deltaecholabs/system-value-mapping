package com.deltaecholabs.svm.field;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FieldRepository implements PanacheRepositoryBase<FieldEntity, Integer> {
}
