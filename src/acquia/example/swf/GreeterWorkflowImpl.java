package acquia.example.swf;

import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;

public class GreeterWorkflowImpl implements GreeterWorkflow {
	private GreeterActivitiesClient operations = new GreeterActivitiesClientImpl();

	public void greet() {
		// If you pass a returned Promise to an activity client method or an
		// asynchronous workflow method,
		// it defers execution until object is ready.
		Promise<String> name = operations.getName();
		System.out.println("Got name");
		Promise<String> greeting = getGreeting(name);
		operations.say(greeting);
	}

	@Asynchronous
	private Promise<String> getGreeting(Promise<String> name) {
		String returnString = "Hello " + name.get() + "!";
		return Promise.asPromise(returnString);
	}
}
