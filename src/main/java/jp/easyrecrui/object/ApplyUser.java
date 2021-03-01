package jp.easyrecrui.object;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApplyUser extends User{


	private String mail;
	private String tel;
	private String name;
	private int sex;
	private String adress;
	private Date birth;

}