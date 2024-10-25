package org.example;
/*
@author   $Krupcak_Anastasiia
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.30
*/
import java.util.List;

interface ICompanyService {
    /**
     * Get the top-level parent company of the given child.
     *
     * @param child Company for whom we are searching the top-level parent.
     * @return The top-level parent company.
     */
    Company getTopLevelParent(Company child);

    /**
     * Get the total employee count for a company and all its child companies.
     *
     * @param company   The company for which we are counting employees.
     * @param companies List of all available companies.
     * @return Total count of employees for the company and its children.
     */
    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}
