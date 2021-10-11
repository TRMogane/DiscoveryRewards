package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.persistence.Transactions;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TransactionDto {

    private Long transactionId;
    private Long memberId;
    private Integer amount;
    private LocalDate transactionDate;

    public TransactionDto(Transactions transactions){
        this.setAmount(transactions.getAmount());
        this.setTransactionDate(transactions.getTransactionDate());
        this.setMemberId(transactions.getMemberId());
    }

    public TransactionDto(Long memberId, Integer amount, LocalDate transactionDate) {
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
                "  transactionId=" + transactionId +
                ", member=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
