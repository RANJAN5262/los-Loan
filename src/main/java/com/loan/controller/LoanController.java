package com.loan.controller;

import com.loan.entity.LoanApplication;
import com.loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanApplication> applyLoan(
            @RequestBody LoanApplication loan) {

        return ResponseEntity.ok(
                loanService.applyLoan(loan));
    }

    @GetMapping
    public ResponseEntity<List<LoanApplication>> getAllLoans() {
        return ResponseEntity.ok(
                loanService.getAllLoans());
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<LoanApplication> approveLoan(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                loanService.approveLoan(id));
    }
}
