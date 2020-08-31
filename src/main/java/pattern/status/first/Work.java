package pattern.status.first;

import lombok.Data;

@Data
public class Work {

	/**
	 * 时间状态: 1 - 24
	 */
	private Integer hour;

	/**
	 * 任务状态: 未完成, 完成
	 */
	private boolean taskFinished;

	public void writeProgram(Integer hour) {
		// 方法冗长, 不利于扩展; 可变性和可移植性不高; 按状态抽象类
		if (hour < 12) {
			System.out.println(String.format("当前时间:{%s}, 上午工作, 来杯咖啡", hour));
		} else if (hour < 13) {
			System.out.println(String.format("当前时间:{%s}, 午休时间, 请勿打扰", hour));
		} else if (hour < 17) {
			System.out.println(String.format("当前时间:{%s}, 状态不错, 继续写BUG", hour));
		} else {
			if (taskFinished) {
				System.out.println(String.format("当前时间:{%s}, 一到下班, 健步如飞", hour));
			} else {
				if (hour < 21) {
					System.out.println(String.format("当前时间:{%s}, 晚上加班, 赛过神仙", hour));
				} else {
					System.out.println(String.format("当前时间:{%s}, 晚上不睡, 继续修仙", hour));
				}
			}
		}
	}

	public static void main(String[] args) {
		Work work = new Work();
		work.writeProgram(9);
		work.writeProgram(10);
		work.writeProgram(12);
		work.writeProgram(13);
		work.writeProgram(14);
		work.writeProgram(17);
		work.setTaskFinished(true);
		work.setTaskFinished(false);
		work.writeProgram(19);
		work.writeProgram(22);
	}

}
