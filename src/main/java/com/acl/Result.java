package com.acl;

import java.util.Objects;

public class Result {
    private String field;
    private String value1;
    private String value2;

    public Result(String field, String value1, String value2) {
        this.field = field;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Result{" +
                "field='" + field + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return Objects.equals(field, result.field) &&
                Objects.equals(value1, result.value1) &&
                Objects.equals(value2, result.value2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, value1, value2);
    }
}
