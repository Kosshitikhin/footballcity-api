package com.kosshitikhin.footballcity.common.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.*;

@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    protected Long id;

    public IdEntity(Long id) {
        this.id = id;
    }

    public IdEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdEntity{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() && getClass() != HibernateProxyHelper.getClassWithoutInitializingProxy(o))
            return false;
        IdEntity idEntity = (IdEntity) o;
        return getId() != null ? getId().equals(idEntity.getId()) : idEntity.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
