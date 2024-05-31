package j2ee.design.pattern;

interface BusinessService
{
	public void doProcessing();
}

class EJBService implements BusinessService
{

	@Override
	public void doProcessing()
	{
		System.out.println("Processing task by invoking EJB Service");

	}

}

class JMSService implements BusinessService
{

	@Override
	public void doProcessing()
	{
		System.out.println("Processing task by invoking JMS Service");

	}

}

class BusinessDelegate
{
	private BusinessLookUp  lookupService = new BusinessLookUp();
	private BusinessService businessService;

	public void doTask( String serviceType )
	{
		businessService = lookupService.getBusinessService(serviceType);

		System.out.println(businessService.toString() + " : Got business serve object after do the look up");

		businessService.doProcessing();
	}
}

class BusinessLookUp
{
	public BusinessService getBusinessService( String serviceType )
	{
		if( serviceType.equalsIgnoreCase("EJB") )
		{
			return new EJBService();
		}
		else if( serviceType.equalsIgnoreCase("JMS") )
		{
			return new JMSService();
		}
		return null;
	}
}



public class BusinessDelegatePattern {

	public static void main(String[] args) {
		BusinessDelegate businessDelegate = new BusinessDelegate();

		System.out.println("Invoke the business delegate by passing service type as EJB");

		businessDelegate.doTask("EJB");

		System.out.println("");

		System.out.println("Invoke the business delegate by passing service type as JMS");

		businessDelegate.doTask("JMS");

	}

}
