package io.pivotal.loansource;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertNotNull;

public class LoansourceApplicationTest {

  @Test
  public void supplyLoan() {
    LoanSource app = new LoanSource();
    Supplier<Loan> loan = app.supplyLoan();
    assertNotNull(loan);
    assertNotNull(loan.get());
    assertNotNull(loan.get().getAmount());
    assertNotNull(loan.get().getName());
  }
}