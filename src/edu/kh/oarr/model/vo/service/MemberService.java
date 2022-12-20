package edu.kh.oarr.model.vo.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {

	private Scanner sc = new Scanner(System.in);
	//member 5킨짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];	
	
	// 현재 로그인한 회원들의 정보를 저장할 변수 선언
	private Member loginMember = null;
	
	public MemberService() { //기본생성자
		// memberArr 베열 0,1,2 인덱스 초기화
		memberArr[0] = new Member("user01","pass01","홍길동",30,"강원");
		memberArr[1] = new Member("user02","pass02","류정훈",23,"경기");
		memberArr[2] = new Member("user03","pass03","고길동",40,"서울");
		
	}
	// 메뉴 출력용 메서드
	public void displayMenu() {
		int menuNum = 0;
		do {System.out.println("******회원 정보 관리 프로그램 v2******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : System.out.println(signUp());break;
			case 2 : System.out.println(logIn());break;
			case 3 : System.out.println(selectMember());break;
			case 4 : 
				int result = updateMember();
				if(result == -1) {
					System.out.println("로그인 후 이용");
				}else if(result == 0) {
					System.out.println("회원정보 수정실패(비밀번호 불일치)");
				}else {
					System.out.println("회원정보 수정됨");
				}
				break;
			case 5 : searchRegion();break;
			case 0 : System.out.println("\n프로그램 종료");break;
			default : System.out.println("잘못 입력함");
			}
			
		}while(menuNum != 0);
	}
	//회원가입 메서드
	public String signUp() {
		System.out.println("******회원가입******");
		
		// 객체 배열 (memberArr)에 가입한 회원 정보를 저장할 예정
		// 새로운 회원 정보를 저장할 공간이 있는지 확인하고
		//	 빈 공간의 인덱스 번호를 얻어오기 >> 새로운 메서드 작성
		
		int index = emptyIndex(); // memberArr 배열에서 비어있는 인덱스를 반환 받음
		System.out.println("전체 회원 수 : " + index);
		
		if(index == -1) {//비어있는 인덱스가 없을경우
			return "회원가입 불가(인원수 초과)";
		}
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		System.out.print("비밀번호 확인 : ");
		String memberPw2 = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		System.out.print("지역 : ");
		String region = sc.next();
		
		//비밀번호, 비밀번호 확인 일치 시 회원가입
		if(memberPw.equals(memberPw2)) {
			//member객체를 생성해서 할당된 주소를 memberArr 비어있는 인덱스에 대입
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			return "회원가입 성공";
		}else {
			return "회원 가입 실패(비밀번호 불일치)";	
		}
		
	}
	//memberArr의 비어있는 인덱스 번호를 반환하는 메서드
	// 단 비어있는 인덱스가 없으면 -1 반환
	public int emptyIndex() { //요놈은 memberArr[5] 즉 5명 이상 회원가입불가하니깐 인원수 체크용
		//memberArr배열을 0번 인덱스부터 배열의 끝까지 접근해서
		// 참조하는값이 null인 경우의 인덱스를 반환
		
		for(int i = 0; i < memberArr.length; i++) {
			if(memberArr[i] == null) {
				return i;
			}
		}
		return -1;
		// for문을 수행했지만 return이 되지 않은 경우 해당 위치 코드가 수행
		//for문에서 return되지 않았다 == 배열에 빈칸이 없다
		// -1 반환
		
	}
	
	public String logIn() {
		
		System.out.println("\n******로그인******");
		
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
				
		for(int i = 0; i < memberArr.length; i++) {
			//회원정보가 있을경우
			if(memberArr[i]  != null);{
				//회원정보(memberArr[i])의 아이디 비밀번호와
				//입력받은 아이디, 비밀번호가 같은지 확인
				if(memberArr[i].getMemberId().equals(memberId) && 
				   memberArr[i].getMemberPw().equals(memberPw)) {
					//중첩if문사용 로그인 회원 정보 객체(member)을 참조하는 변수 loginMember에
					//현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사	
					
					loginMember = memberArr[i]; //0x1000
					
					break; // 더 이상 같은 아이디, 비밀번호 없음므로 for문 종료
				}
				
			}
			
		}//for문끝
		if(loginMember == null) { //로그인 실패
			return "아이디 또는 비밀번호가 미일치";
		}else { //로그인성공
			return loginMember.getMemberId() + "님 환영합니다";
		}
		
		
		// 4) 로그인 성공/실패 여부에 따라 결과값을 변환 회원정보 수정도 만들어보기
	}
	
	// 회원정보 조회 메서드
	public String selectMember() {
		System.out.println("\n******회원 정보 조회******");
		
		// 1) 로그인 여부 확인 -> 필드 loginMember가 참조하고 있는 객체가 있는지 확인
		if(loginMember == null) {
			return "로그인후 이용";
		}
		// 2) 로그인이 되어있는 경우
		String str = "이름: " + loginMember.getMemberName();
	    str += "\n아이디: " + loginMember.getMemberId();
	    str += "\n나이: " + loginMember.getMemberAge();
	    str += "\n지역: " + loginMember.getRegion();
	    
	    return str;
		// 회원정보를 출력할 문자열 만들어서 return
		// (단, pw제외)
		
		
		
		
		
		
	}
	// 회원정보 수정 메서드
	public int updateMember() {
		System.out.println("\n******회원 정보 수정******");
		
		// 1) 로그인 여부 판별
		// 로그인이 되어있지 않으면 -1반환
		if(loginMember == null) {
			return -1;
		}
		// 2) 수정할 회원 정보 입력 받기(이름, 나이, 지역)
		System.out.println("변경할 이름 : ");
		String inputName = sc.next();
		
		System.out.println("변경할 나이 : ");
		int inputAge = sc.nextInt();
		sc.nextLine(); // int형 다음 string이 오는 경우 nextline 써주기
		
		System.out.println("수정할 지역 : ");
		String inputRegion = sc.next();
		// 3) 비밀번호를 입력 받아서
		// 로그인한 회원의 비밀번호와 일치하는지 확인
		System.out.println("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			// 4) 비밀번호가 일치하는 경우
			// 로그인한 회원의 이름, 나이, 지역 정보를 입력받은 값으로 변경 후
			// 1 반환
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			loginMember.setRegion(inputRegion);
			
			return 1;
		}else {
			return 0;
		}
		
		// 5) 비밀번호가 다를경우엔 0반환
		
		
		
	}
	
	//회원검색 (지역)메서드
	public void searchRegion() {
		System.out.println("\n****** 회원 검색(지역)******");
		
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();
		
		boolean flag = false; //검색결과 신호용 변수
		
		// 1) memberArr 배열의 모든 요소
		 // 2) memberArr[i] 요소가 null 인경우 반복 종료
		for(int i = 0; i < memberArr.length; i++) {
			if(memberArr[i] == null) break;
			// 3) memberArr[i] 요소에 저장된 지역 (getRegion())
			// 입력받은 지역과 같을 경우, 회원 아이디, 이름출력
			if(memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s",
						memberArr[i].getMemberId(),
						memberArr[i].getMemberName());
				flag = true;
			}
				
			
		}
		
		if(!flag) {
			System.out.println("검색결과가 없음");
		}
			
	
		
		// 4) 검색 결과가 없을경우 "일치하는 검색 결과 없음" 출력
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
