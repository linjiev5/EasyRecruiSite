package jp.easyrecrui.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "easyRecruiApplyUser")
public class EasyRecruiApplyUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//	@Column(name = "userId")
	private String userId;
	//	@Column(name = "mail")
	private String mail;
	//	@Column(name = "password")
	private String password;
	//	@Column(name = "tel")
	private String tel;
	//	@Column(name = "name")
	private String name;
	//	@Column(name = "sex")
	private Integer sex;
	//	@Column(name = "adress")
	private String adress;
	//	@Column(name = "birthday")
	private Date birthday;
	//	@Column(name = "createTime")
	private Timestamp createTime;
	//	@Column(name = "updateTime")
	private Timestamp updateTime;


}
