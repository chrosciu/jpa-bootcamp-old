package com.smalaca.jpa.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Buyer {
    @Id
    @GeneratedValue
    private UUID id;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "login", column = @Column(name = "buy_login")),
            @AttributeOverride(name = "phone", column = @Column(name = "phone_number")),
            @AttributeOverride(name = "mail", column = @Column(name = "mail_address")),
    })
    private ContactDetails contactDetails;

    public Buyer(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    UUID getId() {
        return id;
    }
}
