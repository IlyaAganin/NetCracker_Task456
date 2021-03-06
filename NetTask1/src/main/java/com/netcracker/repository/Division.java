package com.netcracker.repository;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import ru.vsu.lab.entities.IDivision;

/**
 * Class for object division
 */
@XmlRootElement
public class Division implements IDivision {

    private Integer id;
    private String name;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return Objects.equals(id, division.id) &&
                Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

	@Override
	public String toString() {
		return "Division [id=" + id + ", name=" + name + "]";
	}
    
}
