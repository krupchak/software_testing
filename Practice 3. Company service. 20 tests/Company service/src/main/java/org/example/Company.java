package org.example;
/*
@author   $Krupcak_Anastasiia
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.30
*/
import java.util.List;

class Company {
    private Company parent;      // Parent company, null if no parent
    private long employeeCount;  // Employee count

    // Constructors
    public Company(Company parent, long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    // Getters and setters
    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}

