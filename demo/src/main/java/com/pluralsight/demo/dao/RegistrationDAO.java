package com.pluralsight.demo.dao;


import com.pluralsight.demo.Model.Student;

public interface RegistrationDAO {
    public Long persistStudent(Student student);

    public Student findById(Long id);
}