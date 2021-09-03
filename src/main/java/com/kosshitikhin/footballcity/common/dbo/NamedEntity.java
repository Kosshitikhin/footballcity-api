package com.kosshitikhin.footballcity.common.dbo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
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
    protected int age;

    public NamedEntity() {

    }

    public NamedEntity(Long id, String firstName, String surname, String patronymic, int age) {
        super(id);
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        NamedEntity that = (NamedEntity) o;
        return age == that.getAge() &&
                Objects.equals(firstName, that.getFirstName()) &&
                Objects.equals(surname, that.getFirstName()) &&
                Objects.equals(patronymic, that.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, patronymic, age);
    }
}
