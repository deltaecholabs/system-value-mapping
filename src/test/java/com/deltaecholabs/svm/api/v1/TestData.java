package com.deltaecholabs.svm.api.v1;

public interface TestData {

    String USER_TEST = "user_test";
    SystemV1 SYSTEM_ONE = new SystemV1("system1", "System One");
    FieldV1 FIELD_ONE = new FieldV1(SYSTEM_ONE, "field1", "Field One");

}
