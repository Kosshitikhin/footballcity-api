package com.kosshitikhin.footballcity.common.dbo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public class StatisticsEntity extends IdEntity {

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String surname;

    @Column(nullable = false)
    protected int minute;

    public StatisticsEntity() {
    }

    public StatisticsEntity(Long id, String firstName, String surname, int minute) {
        super(id);
        this.firstName = firstName;
        this.surname = surname;
        this.minute = minute;
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

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }



    @Override
    public String toString() {
        return "StatisticsEntity{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", minute=" + minute +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        StatisticsEntity that = (StatisticsEntity) o;
        return minute == that.getMinute() &&
                Objects.equals(firstName, that.getFirstName()) &&
                Objects.equals(surname, that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, surname, minute);
    }
}
