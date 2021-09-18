package com.kosshitikhin.footballcity.common.dbo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class NamedEntity extends IdEntity{

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String surname;

    @Column(nullable = false)
    protected String patronymic;

    @Column(nullable = false)
    protected LocalDate birthday;

    public NamedEntity() {

    }

    public NamedEntity(Long id, String firstName, String surname, String patronymic, LocalDate birthday) {
        super(id);
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        NamedEntity that = (NamedEntity) o;
        return birthday == that.getBirthday() &&
                Objects.equals(firstName, that.getFirstName()) &&
                Objects.equals(surname, that.getFirstName()) &&
                Objects.equals(patronymic, that.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, patronymic, birthday);
    }
}
