package jp.easyrecrui.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.easyrecrui.entity.EasyRecruiApplyUser;
import jp.easyrecrui.object.ApplyUser;
import jp.easyrecrui.object.User;
import jp.easyrecrui.repository.ApplyUserRepository;
import jp.easyrecrui.utils.CodeType;

@Service
public class ApplyUserService {
	@Autowired
	ApplyUserRepository applyUserRepository;

	/**
	 * ログイン状態を判断する
	 * @param user
	 * @return
	 */
	@Transactional
	public int findUser(User user) {
		List<EasyRecruiApplyUser> newUser = applyUserRepository.findByUserId(user.getUserId().toString());
		if (newUser.isEmpty()) {
			return CodeType.USERNAME_NOT_EXIST.getCode();
		} else {
			String pswd = newUser.get(0).getPassword().toString();
			if (!pswd.equals(user.getPassword())) {
				return CodeType.PASSWORD_ERROR.getCode();
			} else {
				return CodeType.LOGIN_SUCESS.getCode();
			}
		}

	}

	/**
	 *
	 */
	@Transactional
	public int addUser(ApplyUser applyUser) {
		List<EasyRecruiApplyUser> newUser = applyUserRepository.findByUserId(applyUser.getUserId().toString());
		if (newUser.isEmpty()) {
			EasyRecruiApplyUser eay = new EasyRecruiApplyUser();
			eay.setUserId(applyUser.getUserId());
			eay.setMail(applyUser.getMail());
			eay.setPassword(applyUser.getPassword());
			eay.setTel(applyUser.getTel());
			eay.setName(applyUser.getName());
			eay.setSex(applyUser.getSex());
			eay.setAdress(applyUser.getAdress());
			eay.setBirthday(applyUser.getBirth());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			eay.setCreateTime(timestamp);
			applyUserRepository.saveAndFlush(eay);
			return CodeType.REGIST_SUCESS.getCode();
		} else {
			return CodeType.USER_EXIST.getCode();
		}

	}

	/**
	 * ユーザのデータを取得する
	 */
	@Transactional
	public ApplyUser getUserData(String userId) {
		List<EasyRecruiApplyUser> newUser = applyUserRepository.findByUserId(userId);
		ApplyUser setData = new ApplyUser();
		if (!newUser.isEmpty()) {
			EasyRecruiApplyUser era = newUser.get(0);
			setData.setAdress(era.getAdress());
			setData.setBirth(era.getBirthday());
			setData.setMail(era.getMail());
			setData.setName(era.getName());
			setData.setPassword(era.getPassword());
			setData.setSex(era.getSex());
			setData.setTel(era.getTel());
			setData.setUserId(era.getUserId());
//			System.out.println(setData);
		}else {

		}

		return setData;
	}
}