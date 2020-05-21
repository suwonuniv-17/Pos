import javax.swing.JFrame;

public class MainProcess {
	FrameLogin f_login;
	FrameMain f_main ;
	FramePay f_pay;
	
	static MainProcess main;
	public static void main(String[] args) {
		//메인프로세스 실행
		main = new MainProcess();
		
		main.f_login = new FrameLogin();
		main.f_login.setMain(main);
		
	}
	
	public void showFrameMain() {
		f_login.dispose();
		this.f_main = new FrameMain();
		main.f_main.setMain(main);
	}
	
	public void showFramePayment() {
		f_main.dispose();
		this.f_pay = new FramePay();
	}
}
