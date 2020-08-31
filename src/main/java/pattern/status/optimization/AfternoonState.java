package pattern.status.optimization;

public class AfternoonState implements State{

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17) {
            System.out.println(String.format("当前时间:{%s}, 状态不错, 继续写BUG", work.getHour()));
        } else {
            work.setState(new EveningState());
            work.writeProgram();
        }
    }

}
