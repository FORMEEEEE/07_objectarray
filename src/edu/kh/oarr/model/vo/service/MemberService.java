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
		do {System.err.println("******회원 정보 관리 프로그램 v2******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 검색(지역)");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("메뉴 입력 >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			case 1 : break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 0 : break;
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
	public int emptyIndex() {
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
		
		// 1) memberArr 배열 내 요소를 순서대로 접근 null이 아닌지 확인
					//회원정보가 있을경우
		           // 1번안에 들어감 :2) 회원정보(memberArr[i])의 아이디 비밀번호
					//입력받은 아이디, 비밀번호가 같은지 확인
						//이거도 안에들어감	3) 중첩if문사용 로그인 회원 정보 객체(member)을 참조하는 변수 loginMember에
		//					현재 접근중인 memberArr[i] 요소에 저장된 주소를 얕은 복사 (대입하면됨 그게 얕은복사)
		
		// 4) 로그인 성공/실패 여부에 따라 결과값을 변환 회원정보 수정도 만들어보기
		return "";
	}
	
}
