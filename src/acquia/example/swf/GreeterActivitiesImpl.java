package acquia.example.swf;

public class GreeterActivitiesImpl implements GreeterActivities {
	@Override
	public String getName() {
		return "World";
	}

	@Override
	public void say(String what) {
		System.out.println(what);
	}
}
