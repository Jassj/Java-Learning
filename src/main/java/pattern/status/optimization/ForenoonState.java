package pattern.status.optimization;

public class ForenoonState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println(String.format("当前时间:{%s}, 上午工作, 来杯咖啡", work.getHour()));
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }

}
