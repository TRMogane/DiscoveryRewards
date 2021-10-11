package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = 5604864958111056329L;

    @Id
    @SequenceGenerator(
            name = "MEMBER_SEQUENCE",
            sequenceName = "MEMBER_SEQUENCE",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQUENCE"
    )
    private Long memberId;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private Integer balance;

    public Member(){

    }

    public Member(Long memberId, String firstName, String lastName, String email, String status, Integer balance) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.balance = balance;
    }

    public Member(String firstName, String lastName, String email, String status, Integer balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.balance = balance;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(getMemberId(), member.getMemberId()) &&
                Objects.equals(getFirstName(), member.getFirstName()) &&
                Objects.equals(getLastName(), member.getLastName()) &&
                Objects.equals(getEmail(), member.getEmail()) &&
                Objects.equals(getStatus(), member.getStatus()) &&
                Objects.equals(getBalance(), member.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMemberId(), getFirstName(), getLastName(), getEmail(), getStatus(), getBalance());
    }
}
