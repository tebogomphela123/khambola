package tebogo.khula.khambola.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Account {
    @Id
    @GeneratedValue
    private int userId;
    private String firstName;
    private String lastName;
    private int age;
}
