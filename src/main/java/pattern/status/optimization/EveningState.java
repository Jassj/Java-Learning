package pattern.status.optimization;

public class EveningState implements State {

    @Override
    public void writeProgram(Work work) {
        if (work.isTaskFinished()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println(String.format("当前时间:{%s}, 晚上加班, 赛过神仙", work.getHour()));
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }


}
