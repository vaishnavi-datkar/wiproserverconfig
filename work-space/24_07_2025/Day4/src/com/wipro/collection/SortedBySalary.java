package com.wipro.collection;

import java.util.Comparator;

public class SortedBySalary implements Comparator<EmployeeInfo> {
    @Override
    public int compare(EmployeeInfo e1, EmployeeInfo e2) {
        return Double.compare(e2.getSalary(), e1.getSalary()); // descending
    }
}

