package pattern.status.optimization;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Work {

    /**
     * 时间状态: 1 - 24
     */
    private Integer hour;

    /**
     * 任务状态: 未完成, 完成
     */
    private boolean taskFinished;

    private State state;

    public void writeProgram() {
        state.writeProgram(this);
    }

    public static void main(String[] args) {
        Work work = new Work(9, false, new ForenoonState());
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(17);
//        work.setTaskFinished(true);
        work.writeProgram();
        work.setHour(21);
        work.writeProgram();
        work.setHour(23);
        work.writeProgram();
    }

}
