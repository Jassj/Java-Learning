package pattern.status.optimization;

public class RestState implements State {

    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间:{%s}, 一到下班, 健步如飞", work.getHour()));
    }

}
