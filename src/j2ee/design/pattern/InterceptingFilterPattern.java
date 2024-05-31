package j2ee.design.pattern;

import java.util.ArrayList;
import java.util.List;

interface Filter
{
	public void processRequest(String request);
}

class LoggingFilter implements Filter
{
	@Override
	public void processRequest( String request )
	{
		System.out.println("Request Tracking is done by LoggingFilter : " + request);		        
	}
}

class AuthenticationFilter implements Filter
{

	@Override
	public void processRequest( String request )
	{
		System.out.println("Authenticating the request by AuthenticationFilter : " + request);

	}

}

class FilterChain
{
	private List<Filter> filters = new ArrayList<Filter>();
	private Target       target;

	public void addFilter( Filter filter )
	{
		filters.add(filter);
	}

	public void execute( String request )
	{
		for( Filter filter : filters )
		{
			filter.processRequest(request);
		}
		target.processRequest(request);
	}

	public void setTarget( Target target )
	{
		this.target = target;
	}
}

class FilterManager
{
	FilterChain filterChain;

	public FilterManager( Target target )
	{
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter( Filter filter )
	{
		filterChain.addFilter(filter);
	}

	public void filterRequest( String request )
	{
		filterChain.execute(request);
	}
}

class Target
{
	public void processRequest( String request )
	{
		System.out.println("Process the Request by Target Class: " + request);
	}
}

// This class will act as client
public class InterceptingFilterPattern {

	FilterManager filterManager;

	public void setFilterManager( FilterManager filterManager )
	{
		this.filterManager = filterManager;
	}

	public void sendRequest( String request )
	{
		filterManager.filterRequest(request);
	}

	public static void main(String[] args) {
		FilterManager filterManager = new FilterManager(new Target());
		filterManager.setFilter(new AuthenticationFilter());
		filterManager.setFilter(new LoggingFilter());
		InterceptingFilterPattern client = new InterceptingFilterPattern();
		client.setFilterManager(filterManager);
		client.sendRequest("HOME");
	}

}
