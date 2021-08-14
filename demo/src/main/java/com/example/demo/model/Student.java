//package com.example.demo.model;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.GenericGenerator;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name = "Student")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Student {
//	
//	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid")
//	@Column(name = "id", unique = true)
//	private String id;
//	
//	@NotNull(message="不可為null")
//	private String name;
////	@Min(100)
////	@NotNull(message="不可為null")
////
////	@NotEmpty(message="不可為空")
////	private List<String> list;
//	
////	private List<Std> std;
//}
