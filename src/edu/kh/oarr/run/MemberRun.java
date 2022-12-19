package edu.kh.oarr.run;

import edu.kh.oarr.model.vo.service.MemberService;

public class MemberRun {

	public static void main(String[] args) {

		MemberService ms = new MemberService();
		ms.displayMenu();
	}

}
