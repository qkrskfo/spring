import com.itwill.guest.controller.GuestListController;

public class Reflection1Main {

	public static void main(String[] args) throws Exception {
		/*
		 * 생성자 직접 호출없이(GuestListController 클래스타입을 지칭하지않고) GuestListController객체 생성
		 */
		
		/*
		 * 1. com.itwill.guest.controller.GuestListController.class 클래스를 메모리위로 로딩
		 */
		String className1 = "com.itwill.guest.controller.GuestListController";
		String className2 = "com.itwill.guest.controller.GuestMainController";
		String className3 = "com.itwill.guest.controller.GuestViewController";
		Class anyClass1 = Class.forName(className1);
		Class anyClass2 = Class.forName(className2);
		Class anyClass3 = Class.forName(className3);
		
		/*
		 * 2. 로딩된 클래스의 기본생성자 호출
		 */
		Object object1 = anyClass1.newInstance();
		Object object2 = anyClass2.newInstance();
		Object object3 = anyClass3.newInstance();
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
		
		
	}

}
