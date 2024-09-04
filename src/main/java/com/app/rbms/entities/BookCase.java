package com.app.rbms.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "BookCase")
@Table
public class BookCase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_case_id")
    private long id;

    @Column(name = "book_case_name", nullable = false, length = 50)
    private String name;

    public BookCase() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
