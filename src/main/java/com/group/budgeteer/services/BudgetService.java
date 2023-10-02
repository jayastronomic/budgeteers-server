package com.group.budgeteer.services;

import com.group.budgeteer.models.Budget;
import com.group.budgeteer.repositories.BudgetRepository;
import com.group.budgeteer.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Service class for managing budget CRUD operations.
 */
@Service
public class BudgetService extends ApplicationService {

    private final BudgetRepository budgetRepository;

    private final ExpenseRepository expenseRepository;

    Logger logger = Logger.getLogger(BudgetService.class.getName()); //log messages related to the class

    /**
     * Constructor for BudgetService, adds instances of budget and expense repository to access & manipulate respective data.
     *
     * @param budgetRepository  The repository for managing budget data.
     * @param expenseRepository The repository for managing expense data.
     */
    @Autowired
    public BudgetService(BudgetRepository budgetRepository, ExpenseRepository expenseRepository) {
        this.budgetRepository = budgetRepository;
        this.expenseRepository = expenseRepository;
    }

    /**
     * Retrieves a list of budgets associated with the current user.
     *
     * @return A list of budgets belonging to the current user.
     */
    public List<Budget> getBudgets() { return currentUser().getBudgets(); }


    public Budget getBudget(UUID budgetId) { return budgetRepository.findById(budgetId).orElseThrow(); }

    public Budget createBudget(Budget budgetObject) {
        logger.info("Creating Budget");
        budgetObject.setUser(currentUser());
        logger.info("Setting User");
        logger.info(budgetObject.toString());
        return budgetRepository.save(budgetObject);

    }

    public Budget updateBudget(Budget budgetObject) {
        Budget budget = budgetRepository.findById(budgetObject.getId()).orElseThrow();
        return budgetRepository.save(budget.update(budgetObject));
    }

    public void deleteBudget(UUID budgetId) { budgetRepository.deleteById(budgetId); }
}
