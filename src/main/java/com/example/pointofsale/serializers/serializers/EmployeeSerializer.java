package com.example.pointofsale.serializers.serializers;

import com.example.pointofsale.entities.Employee;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class EmployeeSerializer extends BaseSerializer<Employee> {
    public EmployeeSerializer(Class<Employee> employeeClass) {
        super(employeeClass);
    }

    @Override
    protected void serializeHelper(Employee value, JsonGenerator jgen) throws IOException {
        jgen.writeObjectField("user", value.getUser());
    }
}