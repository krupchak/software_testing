package org.example;
/*
@author   $Krupcak_Anastasiia
@project   $Roman_To_Integer
@class  $444A
@version  1.0.0
@since 19.10.2024 - 19.30
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class CompanyServiceTest {

    private ICompanyService companyService;
    private Company parentCompany;
    private Company childCompany1;
    private Company childCompany2;
    private Company grandChildCompany;

    @BeforeEach
    void setUp() {
        companyService = new CompanyService();

        parentCompany = new Company(null, 100);  // Parent company with 100 employees
        childCompany1 = new Company(parentCompany, 50);  // Child 1 with 50 employees
        childCompany2 = new Company(parentCompany, 75);  // Child 2 with 75 employees
        grandChildCompany = new Company(childCompany1, 25);  // Grandchild with 25 employees
    }

    @Test
    void testGetTopLevelParentWithGrandchild() {
        Company result = companyService.getTopLevelParent(grandChildCompany);
        assertEquals(parentCompany, result);
    }

    @Test
    void testGetTopLevelParentWithChild() {
        Company result = companyService.getTopLevelParent(childCompany1);
        assertEquals(parentCompany, result);
    }

    @Test
    void testGetTopLevelParentWithParent() {
        Company result = companyService.getTopLevelParent(parentCompany);
        assertEquals(parentCompany, result);
    }

    @Test
    void testGetTopLevelParentWithNull() {
        Company result = companyService.getTopLevelParent(null);
        assertNull(result);
    }

    @Test
    void testEmployeeCountForParentCompany() {
        List<Company> companies = Arrays.asList(childCompany1, childCompany2, grandChildCompany);
        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, companies);
        assertEquals(250, result);  // 100 (parent) + 50 (child 1) + 25 (grandchild) + 75 (child 2)
    }

    @Test
    void testEmployeeCountForChildCompany() {
        List<Company> companies = Arrays.asList(childCompany1, childCompany2, grandChildCompany);
        long result = companyService.getEmployeeCountForCompanyAndChildren(childCompany1, companies);
        assertEquals(75, result);  // 50 (child 1) + 25 (grandchild)
    }

    @Test
    void testEmployeeCountForGrandchildCompany() {
        List<Company> companies = Arrays.asList(childCompany1, childCompany2, grandChildCompany);
        long result = companyService.getEmployeeCountForCompanyAndChildren(grandChildCompany, companies);
        assertEquals(25, result);  // 25 (grandchild)
    }

    @Test
    void testEmployeeCountWithEmptyCompanyList() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, Arrays.asList());
        assertEquals(100, result);  // Only parent company employee count
    }

    @Test
    void testEmployeeCountWithNullCompanyList() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, null);
        assertEquals(100, result);  // Only parent company employee count
    }

    @Test
    void testEmployeeCountForNullCompany() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(null, Arrays.asList(childCompany1, childCompany2));
        assertEquals(0, result);  // Null company
    }

    @Test
    void testGetTopLevelParentWithMultipleChildren() {
        Company result1 = companyService.getTopLevelParent(childCompany1);
        Company result2 = companyService.getTopLevelParent(childCompany2);

        assertEquals(parentCompany, result1);
        assertEquals(parentCompany, result2);
    }

    @Test
    void testGrandChildHasCorrectTopLevelParent() {
        Company result = companyService.getTopLevelParent(grandChildCompany);
        assertEquals(parentCompany, result);
    }

    @Test
    void testOrphanCompany() {
        Company orphanCompany = new Company(null, 10);
        assertEquals(orphanCompany, companyService.getTopLevelParent(orphanCompany));
    }

    @Test
    void testParentIsItsOwnTopLevel() {
        assertEquals(parentCompany, companyService.getTopLevelParent(parentCompany));
    }

    @Test
    void testInvalidChildCompanyHasNoTopLevelParent() {
        Company invalidCompany = new Company(null, 0);
        assertEquals(invalidCompany, companyService.getTopLevelParent(invalidCompany));
    }

    @Test
    void testGetEmployeeCountForUnrelatedCompanies() {
        Company unrelatedCompany = new Company(null, 200);
        List<Company> unrelatedCompanies = Arrays.asList(unrelatedCompany);
        long result = companyService.getEmployeeCountForCompanyAndChildren(unrelatedCompany, unrelatedCompanies);
        assertEquals(200, result);
    }

    @Test
    void testEmptyListReturnsParentEmployeeCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, Arrays.asList());
        assertEquals(100, result);  // Only parent company employees
    }

    @Test
    void testChildCompanyHasZeroEmployees() {
        Company emptyCompany = new Company(parentCompany, 0);
        List<Company> companies = Arrays.asList(emptyCompany, grandChildCompany);
        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, companies);
        assertEquals(125, result);  // 100 (parent) + 25 (grandchild)
    }

    @Test
    void testEmployeeCountForChildCompanyWithGrandchild() {
        // Створення дочірньої компанії з 2 співробітниками
        Company childCompanyWithGrandchild = new Company(parentCompany, 50);
        Company grandChildCompany1 = new Company(childCompanyWithGrandchild, 30);
        Company grandChildCompany2 = new Company(childCompanyWithGrandchild, 20);

        List<Company> companies = Arrays.asList(childCompanyWithGrandchild, grandChildCompany1, grandChildCompany2);

        long result = companyService.getEmployeeCountForCompanyAndChildren(childCompanyWithGrandchild, companies);

        // Очікується: 50 (дочірня компанія) + 30 (перша дочірня компанія) + 20 (друга дочірня компанія) = 100
        assertEquals(100, result);
    }


    @Test
    void testEmployeeCountForUnrelatedCompanies() {
        Company unrelatedCompany = new Company(null, 150);
        Company anotherUnrelatedCompany = new Company(null, 80);

        List<Company> unrelatedCompanies = Arrays.asList(unrelatedCompany, anotherUnrelatedCompany);

        long result = companyService.getEmployeeCountForCompanyAndChildren(parentCompany, unrelatedCompanies);

        // Очікується: тільки 100 (parentCompany), оскільки інші компанії не є дочірніми
        assertEquals(100, result);
    }
}
