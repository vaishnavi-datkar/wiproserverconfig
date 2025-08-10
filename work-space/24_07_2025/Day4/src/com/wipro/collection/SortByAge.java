package com.wipro.collection;

import java.util.Comparator;

public class SortByAge implements Comparator<EmployeeInfo> {
    @Override
    public int compare(EmployeeInfo e1, EmployeeInfo e2) {
        return Integer.compare(e1.getAge(), e2.getAge());
    }
}
