package pattern.status.optimization;

public class SleepingState implements State {

    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间:{%s}, 晚上不睡, 继续修仙", work.getHour()));
    }

}
