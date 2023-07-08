package com.examly.springapp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

        @Id
        private long id;
        @Column(name = "id")
        

        @Column(name = "name")
        private String name;

        @Column(name = "email_id",unique = true)
        private String emailId;

        @Column(name = "phn_no")
        private String phn;
        @Column(name="active")
        private String act;
    }



