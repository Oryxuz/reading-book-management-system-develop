package com.app.rbms.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "Contain")
@Table
public class Contain implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_case_id", nullable = false, referencedColumnName = "book_case_id")
    private BookCase bookCase;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    public Contain() {
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Contain contain = (Contain) o;
        return Objects.equals(bookCase, contain.bookCase)
                && Objects.equals(book, contain.book)
                && Objects.equals(createDate, contain.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookCase, book, createDate);
    }
}
