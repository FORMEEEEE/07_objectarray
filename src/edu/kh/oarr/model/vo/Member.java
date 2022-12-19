package edu.kh.oarr.model.vo;

public class Member {
	//필드(멤버 변수)
	// 클래스변수 인스턴스 변수 정의 특징 외우셈
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;
	
	//생성자
	// 생성자 규칙
	// 1. 생성자 이름은 클래스명과 같아야한다
	// 2. 반환형이 없다
	public Member() {} //기본생성자 밑에껀 매개변수 생성자
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
	}
	
	
	//메소드
	//getter setter
	
	/*다 접근 가능하도록 public
	 * String 자료형을 돌려보내겠다
	 * 매개변수가 없어서 중복된 이름의 memberId가 없기때문에 memberId만 써도됨
	 */

	public String getMemberId() {
		return memberId;
	}
	/*setter는 말그대로 셋팅하는애
	 * 무엇을 셋팅할지 전달받아올 아이가 필요함 >> 매개변수
	 * setter는 보통 반환 값은 없음
	 * */
	public void setMemberId(String memberId) {
		// 모든 메서드는 종료 시 호출한 곳으로 돌아가는
		// return 구문이 작성되어야하지만 단,void일 경우 생략 가능하다
		// 생략시 컴파일러가 자동 추가
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	
	
}
