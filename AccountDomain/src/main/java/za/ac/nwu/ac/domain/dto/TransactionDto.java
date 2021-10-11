package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.persistence.Transactions;

import java.time.LocalDate;

public class TransactionDto {

    private Long transactionId;
    private Member member;
    private Integer amount;
    private LocalDate transactionDate;

    public TransactionDto(Transactions transactions){
        this.setAmount(transactions.getAmount());
        this.setTransactionDate(transactions.getTransactionDate());
        this.setMember(transactions.getMember());
    }

    public TransactionDto(Member member, Integer amount, LocalDate transactionDate) {
        this.member = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionId=" + transactionId +
                ", member=" + member +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
