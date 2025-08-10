package com.wipro.collection;

import java.util.Comparator;

public class SortedByName implements Comparator<EmployeeInfo> {
    @Override
    public int compare(EmployeeInfo e1, EmployeeInfo e2) {
        return e1.getEmpName().compareTo(e2.getEmpName());
    }
}
