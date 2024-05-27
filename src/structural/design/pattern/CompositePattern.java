package structural.design.pattern;

import java.util.ArrayList;
import java.util.List;

interface Service {
	public abstract void service(String serviceType);
}

class AdminService implements Service {

	@Override
	public void service(String serviceType) {
		System.out.println(serviceType + " for Admin");
	}
	
}

class EmployeeService implements Service {

	@Override
	public void service(String serviceType) {
		System.out.println(serviceType + " for Employee");
	}
	
}

class ServiceProvider implements Service {
	
	private List<Service> serviceList = new ArrayList<>();

	@Override
	public void service(String serviceType) {
		for(Service service : serviceList)
			service.service(serviceType);
	}
	
	public void addService(Service service) {
		serviceList.add(service);
	}
	
	public void deleteService(Service service) {
		serviceList.remove(service);
	}
	
	public void clearService() {
		serviceList.clear();
	}
}

public class CompositePattern {

	public static void main(String[] args) {
		Service employeeService1 = new EmployeeService();
		Service employeeService2 = new EmployeeService();
		Service adminService = new AdminService();
		
		ServiceProvider serviceProvider = new ServiceProvider();
		
		serviceProvider.addService(employeeService1);
		serviceProvider.addService(employeeService2);
		serviceProvider.addService(adminService);
		
		serviceProvider.service("Registration Service");
		
		serviceProvider.deleteService(employeeService2);
		
		serviceProvider.addService(new AdminService());
		System.out.println("------------------------");
		serviceProvider.service("Logout Service");
		
		serviceProvider.clearService();
		
		serviceProvider.addService(new EmployeeService());
		System.out.println("-------------------------");
		serviceProvider.service("Update Service");
	}

}
