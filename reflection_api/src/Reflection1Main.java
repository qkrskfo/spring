import com.itwill.guest.controller.GuestListController;

public class Reflection1Main {

	public static void main(String[] args) throws Exception {
		/*
		 * 생성자 직접 호출없이(GuestListController 클래스타입을 지칭하지않고) GuestListController객체 생성
		 */
		
		
		/*
		 * 1. com.itwill.guest.controller.GuestListController.class 클래스를 메모리위로 로딩
		 */
		String className = "com.itwill.guest.controller.GuestListController";
		Class anyClass = Class.forName(className);
		
		/*
		 * 2. 로딩된 클래스의 기본생성자 호출
		 */
		Object object = anyClass.newInstance();
		
		System.out.println(object);
		
		
	}

}
