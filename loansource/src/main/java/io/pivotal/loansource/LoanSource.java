package io.pivotal.loansource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

@Component
public class LoanSource {

    private static final Logger log = LoggerFactory.getLogger(LoanSourceApplication.class);
    private List<String> names = Arrays.asList("Bill Gates", "Steve Jobs", "Elon Musk", "Jeff Bezos", "Mark Zuckerberg",
            "Bernard Arnault", "Sergey Brin", "Larry Page");
    private List<Long> amounts = Arrays.asList(10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L,
            100000000L);

    @Bean
    public Supplier<Loan> supplyLoan() {

        Supplier<Loan> loanSupplier = () -> {
            Loan loan = new Loan(UUID.randomUUID().toString(),
                    names.get(new Random().nextInt(names.size())),
                    amounts.get(new Random().nextInt(amounts.size())));
            log.info("\n ----------- New Loan Source n^ {} ---------------- " +
                    "\n ------------------- {} => {} : ${} ------------------- \n\n", loan.getUuid(),
                    loan.getStatus(), loan.getName(), loan.getAmount());
            return loan;
        };

        return loanSupplier;
    }
}
