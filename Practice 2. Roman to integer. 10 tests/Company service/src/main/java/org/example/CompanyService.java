package org.example;
/*
@author   $Krupcak_Anastasiia
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.30
*/
import java.util.List;

public class CompanyService implements ICompanyService {

    @Override
    public Company getTopLevelParent(Company child) {
        if (child == null) return null;
        while (child.getParent() != null) {
            child = child.getParent();
        }
        return child;
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null) return 0;  // Якщо компанія null, повертаємо 0

        long totalEmployeeCount = company.getEmployeeCount();  // Отримуємо кількість співробітників для даної компанії

        // Якщо companies не null, обробляємо
        if (companies != null) {
            for (Company c : companies) {
                if (isChildOf(company, c)) {  // Перевіряємо, чи є компанія дочірньою
                    totalEmployeeCount += c.getEmployeeCount();
                }
            }
        }

        return totalEmployeeCount;  // Повертаємо загальну кількість співробітників
    }


    // Helper method to check if a company is a child of another company
    private boolean isChildOf(Company parent, Company child) {
        while (child.getParent() != null) {
            if (child.getParent().equals(parent)) {
                return true;
            }
            child = child.getParent();
        }
        return false;
    }
}
