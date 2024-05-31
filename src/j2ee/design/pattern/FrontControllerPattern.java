package j2ee.design.pattern;

class FrontController
{
		private Dispatcher dispatcher;

		public FrontController()
		{
				dispatcher = new Dispatcher();
		}

		private boolean isAuthenticUser()
		{
				//here you have to write Authentication logic
				System.out.println("User is authenticated successfully.");
				return true;
		}

		private void trackRequest( String request )
		{
				System.out.println("Page requested: " + request);
		}

		public void dispatchRequest( String request )
		{
				// log each request
				trackRequest(request);
				// authenticate the user
				if( isAuthenticUser() )
				{
						dispatcher.dispatch(request);
				}
		}
}

class Dispatcher
{
		private SalaryView  salaryView;
		private UserView    userView;
		private AccountView accountView;

		public Dispatcher()
		{
				salaryView = new SalaryView();
				userView = new UserView();
				accountView = new AccountView();
		}

		public void dispatch( String request )
		{
				if( request.equalsIgnoreCase("USER") )
				{
						userView.show();
				}
				else if( request.equalsIgnoreCase("ACCOUNT") )
				{
						accountView.show();
				}
				else
				{
						salaryView.show();
				}
		}
}

class AccountView
{
		public void show()
		{
				System.out.println("Displaying Account Page");
		}
}

class SalaryView
{
		public void show()
		{
				System.out.println("Displaying Salary Page");
		}
}

class UserView
{
		public void show()
		{
				System.out.println("Displaying User Page");
		}
}

public class FrontControllerPattern {

	public static void main(String[] args) {
		FrontController frontController = new FrontController();
		frontController.dispatchRequest("USER");
		System.out.println();
		frontController.dispatchRequest("ACCOUNT");
		System.out.println();
		frontController.dispatchRequest("SALARY");
	}

}
