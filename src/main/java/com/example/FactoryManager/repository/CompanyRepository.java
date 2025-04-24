package com.example.FactoryManager.repository;

import com.example.FactoryManager.dto.request.CompanySearchRequest;
import com.example.FactoryManager.dto.request.UserSearchRequest;
import com.example.FactoryManager.entity.Company;
import com.example.FactoryManager.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    boolean existsByCode(String code);

    @Query("SELECT u FROM Company u WHERE " +
            "(:#{#company.keyword} IS NULL OR " +
            " u.code LIKE %:#{#company.keyword}% OR " +
            " u.companyName LIKE %:#{#company.keyword}%) AND " +
            "(:#{#company.state} IS NULL OR u.state LIKE %:#{#company.state}%) AND " +
            "(:#{#company.status} IS NULL OR u.status = :#{#company.status})")
    Page<Company> searchCompanies(@Param("company") CompanySearchRequest company, Pageable pageable);

}
