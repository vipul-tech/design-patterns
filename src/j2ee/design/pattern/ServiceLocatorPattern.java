package j2ee.design.pattern;

import java.util.ArrayList;
import java.util.List;

interface Service
{
	public void execute();
	public String getName();
}

class EJBService1 implements Service
{

	@Override
	public void execute()
	{
		System.out.println("Executing EJBService");
	}

	@Override
	public String getName()
	{
		return "EJBService";
	}

}

class JMSService1 implements Service
{

	@Override
	public void execute()
	{
		System.out.println("Executing JMSService");

	}

	@Override
	public String getName()
	{
		return "JMSService";
	}

}

class ServiceLocator
{
	private static Cache cache;

	static
	{
		cache = new Cache();
	}

	public static Service getService( String jndiName )
	{
		// First check the service object available in cache
		Service service = cache.getService(jndiName);

		if( service != null )
		{
			return service;
		}

		/*
		 * If service object not available in cache do the lookup using
		 * JNDI initial context and get the service object and add it to
		 * the cache for future use
		 */
		InitialContext context = new InitialContext();
		Service service1 = (Service) context.lookup(jndiName);
		cache.addService(service1);
		return service1;
	}
}

class InitialContext
{
	public Object lookup( String jndiName )
	{
		if( jndiName.equalsIgnoreCase("EJBService") )
		{
			// JNDI lookup code will come in real time implementation
			System.out.println("Looking up and creating a new EJBService object");
			return new EJBService1();
		}
		else if( jndiName.equalsIgnoreCase("JMSService") )
		{
			// JNDI lookup code will come in real time implementation
			System.out.println("Looking up and creating a new JMSService object");
			return new JMSService1();
		}
		return null;
	}
}

class Cache
{
	private List<Service> services;

	public Cache()
	{
		services = new ArrayList<Service>();
	}

	public Service getService( String serviceName )
	{
		for( Service service : services )
		{
			if( service.getName().equalsIgnoreCase(serviceName) )
			{
				System.out.println("Return cached  " + serviceName + " object");
				return service;
			}
		}
		return null;
	}

	public void addService( Service newService )
	{
		boolean exists = false;
		for( Service service : services )
		{
			if( service.getName().equalsIgnoreCase(newService.getName()) )
			{
				exists = true;
			}
		}
		if( !exists )
		{
			services.add(newService);
		}
	}
}

public class ServiceLocatorPattern {

	public static void main(String[] args) {
		Service service = ServiceLocator.getService("EJBService");
		service.execute();
		System.out.println();
		service = ServiceLocator.getService("JMSService");
		service.execute();
		System.out.println();
		service = ServiceLocator.getService("EJBService");
		service.execute();
		System.out.println();
		service = ServiceLocator.getService("JMSService");
		service.execute();

	}

}
