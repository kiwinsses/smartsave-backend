package com.example.smartsave.controller;

import com.example.smartsave.model.Transaction;
import com.example.smartsave.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/get-all")
    public List<Transaction> getAll() {
        return repo.findAll();
    }

    @PostMapping("/add-transaction")
    public Transaction create(@RequestBody Transaction transaction) {
        transaction.setDate(new Date()); // sets current timestamp
        return repo.save(transaction);
    }
}
