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
import jp.easyrecrui.utils.ApplyUserAndEntity;
import jp.easyrecrui.utils.CodeType;

@Service
public class ApplyUserService {
	@Autowired
	ApplyUserRepository applyUserRepository;

	/**
	 * ユーザ存在するかどうかを確認
	 * @param userId
	 * @return
	 */
	@Transactional
	public int fineUserByUserId(String userId) {
		List<EasyRecruiApplyUser> newUser = applyUserRepository.findByUserId(userId);
		if (newUser.isEmpty()) {
			return CodeType.USERNAME_NOT_EXIST.getCode();
		} else {
			return CodeType.USER_EXIST.getCode();
		}
	}

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
			//			eay.setUserId(applyUser.getUserId());
			//			eay.setMail(applyUser.getMail());
			//			eay.setPassword(applyUser.getPassword());
			//			eay.setTel(applyUser.getTel());
			//			eay.setName(applyUser.getName());
			//			eay.setSex(applyUser.getSex());
			//			eay.setAdress(applyUser.getAdress());
			//			eay.setBirthday(applyUser.getBirth());
			eay = ApplyUserAndEntity.objectToEntity(applyUser);
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
			//			setData.setAdress(era.getAdress());
			//			setData.setBirth(era.getBirthday());
			//			setData.setMail(era.getMail());
			//			setData.setName(era.getName());
			//			setData.setPassword(era.getPassword());
			//			setData.setSex(era.getSex());
			//			setData.setTel(era.getTel());
			//			setData.setUserId(era.getUserId());
			//			System.out.println(setData);
			setData = ApplyUserAndEntity.entityToObject(era);
		} else {

		}

		return setData;
	}

	@Transactional
	public int saveAppluUser(ApplyUser applyUser) {
		if (!applyUser.equals(null)) {
			EasyRecruiApplyUser easyRecruiApplyUser = new EasyRecruiApplyUser();
			easyRecruiApplyUser = ApplyUserAndEntity.objectToEntity(applyUser);
			List<EasyRecruiApplyUser> list = applyUserRepository.findByUserId(applyUser.getUserId());
			easyRecruiApplyUser.setId(list.get(0).getId());
			easyRecruiApplyUser.setPassword(list.get(0).getPassword());
			easyRecruiApplyUser.setCreateTime(list.get(0).getCreateTime());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			easyRecruiApplyUser.setUpdateTime(timestamp);
			applyUserRepository.saveAndFlush(easyRecruiApplyUser);
			return 11;
		} else {
			return 12;
		}
	}
	@Transactional
	public void withdrawal(String userId) {
		List<EasyRecruiApplyUser> list = applyUserRepository.findByUserId(userId);
		applyUserRepository.deleteById(list.get(0).getId());
	}
}