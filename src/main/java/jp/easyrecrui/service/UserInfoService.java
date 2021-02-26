package jp.easyrecrui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.easyrecrui.entity.EasyRecruiUserInfo;
import jp.easyrecrui.object.User;
import jp.easyrecrui.repository.UserInfoRepository;

@Service
@Transactional
public class UserInfoService {
	@Autowired
	UserInfoRepository userInfoRepository;

	/**
	 *
	 */
	public int findUser(User user) {
		List<EasyRecruiUserInfo> newUser = userInfoRepository.findByUserid(user.getUserid().toString());
		String pswd = newUser.get(0).getPassword().toString();
		if (newUser.isEmpty()) {
			return 1;
		} else if (!pswd.equals(user.getPassword())) {
			return 2;
		} else {
			return 0;
		}

	}
}
