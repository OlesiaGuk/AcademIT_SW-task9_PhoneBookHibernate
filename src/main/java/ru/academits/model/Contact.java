package ru.academits.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private Boolean isDeleted;

    @OneToMany(mappedBy = "contact")//Параметр mappedBy указывает на поле в классе владельца (PhoneCalls.contact)
    private Set<PhoneCalls> phoneCalls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsDeleted() {//наименование для единообразия с ContactDto
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<PhoneCalls> getPhoneCalls() {
        return phoneCalls;
    }

    public void setPhoneCalls(Set<PhoneCalls> phoneCalls) {
        this.phoneCalls = phoneCalls;
    }
}
