package Service;

import com.example.demo.UserAuthRequest;
import com.example.demo.UserAuthResponse;

import dao.MemberDao;
import dto.Member;

public class UserAuthService {
	private MemberDao memberDao;
	
	public UserAuthService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public UserAuthResponse login(UserAuthRequest req) throws Exception{
		Member member = memberDao.selectByUserId(req.getUserId());
		if(member == null) {
			throw new Exception("Not Found User");
		}
		
		if(member.getPassword() != req.getPassword()) {
			throw new Exception("Different Password");
		}
		
		UserAuthResponse response = new UserAuthResponse(member.getUserId(), member.getUserName());       
		return response;
	}
	
	public void logout() {
		
	}
}
