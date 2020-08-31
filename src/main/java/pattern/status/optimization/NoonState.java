package pattern.status.optimization;

public class NoonState implements State {

	@Override
	public void writeProgram(Work work) {
		if (work.getHour() < 13) {
			System.out.println(String.format("当前时间:{%s}, 午休时间, 请勿打扰", work.getHour()));
		} else {
			work.setState(new AfternoonState());
			work.writeProgram();
		}
	}

}
