package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import za.ac.nwu.ac.domain.persistence.Member;

@Entity
public class Transactions implements Serializable {

    private static final long serialVersionUID = 3793058415527415935L;

    @javax.persistence.Id
    private Long transactionId;
    private Member member;
    private Integer amount;
    private LocalDate transactionDate;

    public Transactions() {
    }

    public Transactions(Long transactionId, Member member, Integer amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.member = member;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember() {
        return member;
    }

    public void setMember(Member memberId) {
        this.member = memberId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", member=" + member +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(getTransactionId(), that.getTransactionId()) &&
                Objects.equals(getMember(), that.getMember()) &&
                Objects.equals(getAmount(), that.getAmount()) &&
                Objects.equals(getTransactionDate(), that.getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionId(), getMember(), getAmount(), getTransactionDate());
    }
}
