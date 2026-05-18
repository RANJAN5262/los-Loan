package com.loan.service;

import com.loan.entity.LoanApplication;
import com.loan.enums.LoanStatus;
import com.loan.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanApplication applyLoan(LoanApplication loan) {

        double monthlyRate = loan.getInterestRate() / (12 * 100);

        double emi =
                (loan.getAmount() * monthlyRate *
                        Math.pow(1 + monthlyRate, loan.getTenureMonths()))
                        /
                        (Math.pow(1 + monthlyRate,
                                loan.getTenureMonths()) - 1);

        loan.setEmi(emi);

        loan.setStatus(LoanStatus.PENDING);

        return loanRepository.save(loan);
    }

    public List<LoanApplication> getAllLoans() {
        return loanRepository.findAll();
    }

    public LoanApplication approveLoan(Long id) {

        LoanApplication loan =
                loanRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Loan Not Found"));

        loan.setStatus(LoanStatus.APPROVED);

        return loanRepository.save(loan);
    }
}
