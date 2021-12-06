package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users_car")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column
   private String firstName;

   @Column
   private String lastName;

   @Column
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn
   private Car car;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar(){
      return car;
   }

   public void setCar(){
      this.car = car;
   }

   @Override
   public String toString() {
      return "firstName: " + firstName + ", " +
              "lastName: " + lastName + ", " +
              "email: " + email + ", " +
              car.toString();
   }
}