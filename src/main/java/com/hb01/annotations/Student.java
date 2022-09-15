package com.hb01.annotations;

import javax.persistence.*;

@Entity // When we use this annotation, it means our class synchronize with table in Database
@Table(name = "tbl01_student") // If we want to set our table name specially, we need to use @Table annotation, otherwise it names our table with lowercased class name.
public class Student {

    @Id // This annotation set Primary Key for our table
    @Column(name = "std_id") // @Column annotation works same like @Table. If we want to set our column name specially, we are using it.
    private int id;

    // length = 255(default)
    // nullable = true(default)
    // unique = false(default)
    // Column annotations isn't a must. Just needed for customize our column.
    @Column(name = "std_name",length = 100,nullable = false,unique = false)
    private String name;

    // Transient annotation is usable for if I want to do some process but dont want to set it as column in my table.
    @Transient
    private int grade;

    @Column(name = "std_house")
    private String house;

    // with large object we can keep big datas
    // @Lob
    // private byte[] image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", house='" + house + '\'' +
                '}';
    }
}
