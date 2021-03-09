package jp.easyrecrui.utils;

import jp.easyrecrui.entity.EasyRecruiApplyUser;
import jp.easyrecrui.object.ApplyUser;

public class ApplyUserAndEntity {
	/**
	 * EntityからObjectに変換
	 * @param easyRecruiApplyUser
	 * @return
	 */
	public static ApplyUser entityToObject(EasyRecruiApplyUser easyRecruiApplyUser) {
		ApplyUser applyUser = new ApplyUser();
		applyUser.setUserId(easyRecruiApplyUser.getUserId());
		applyUser.setAdress(easyRecruiApplyUser.getAdress());
		applyUser.setBirth(easyRecruiApplyUser.getBirthday());
		applyUser.setMail(easyRecruiApplyUser.getMail());
		applyUser.setName(easyRecruiApplyUser.getName());
		applyUser.setSex(easyRecruiApplyUser.getSex());
		applyUser.setPassword(easyRecruiApplyUser.getPassword());
		applyUser.setTel(easyRecruiApplyUser.getTel());
		return applyUser;
	}
	/**
	 * ObjectからEntityに変換
	 * @param applyUser
	 * @return
	 */
	public static EasyRecruiApplyUser objectToEntity(ApplyUser applyUser) {
		EasyRecruiApplyUser easyRecruiApplyUser = new EasyRecruiApplyUser();
		easyRecruiApplyUser.setAdress(applyUser.getAdress());
		easyRecruiApplyUser.setBirthday(applyUser.getBirth());
		easyRecruiApplyUser.setMail(applyUser.getMail());
		easyRecruiApplyUser.setName(applyUser.getName());
		easyRecruiApplyUser.setPassword(applyUser.getPassword());
		easyRecruiApplyUser.setSex(applyUser.getSex());
		easyRecruiApplyUser.setTel(applyUser.getTel());
		easyRecruiApplyUser.setUserId(applyUser.getUserId());
		return easyRecruiApplyUser;
	}
}
