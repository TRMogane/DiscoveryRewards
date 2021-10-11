package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;

public class MemberDto implements Serializable {
    private static final long serialVersionUID = -3675411777951570019L;

    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private Integer balance;

    public MemberDto(String firstName, String lastName, String email, String status, Integer balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.balance = balance;
    }

    public MemberDto(Member member) {
        this.setBalance(member.getBalance());
        this.setStatus(member.getStatus());
        this.setEmail(member.getEmail());
        this.setFirstName(member.getFirstName());
        this.setLastName(member.getLastName());
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

    public Member getMember(){
        return new Member(
                getFirstName(),
                getLastName(),
                getEmail(),
                getStatus(),
                getBalance());
    }
}
