package com.group.budgeteer.repositories;

import com.group.budgeteer.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * The Expense Repository interface is responsible for defining database operations
 * for the Expense Entity, such as CRUD operations.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}