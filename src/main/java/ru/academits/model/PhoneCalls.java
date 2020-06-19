package ru.academits.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "phone_calls")
public class PhoneCalls {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_id") //Аннотацией @JoinColumn определяется поле связи в таблице БД
    private Contact contact;

    @Column
    private Date date;

    @Column
    private Long duration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
