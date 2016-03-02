import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * һ����Ҫ��������������������̳߳ش�С��
	�����CPU�ܼ������񣬾���Ҫ����ѹեCPU���ο�ֵ������Ϊ NCPU+1
	�����IO�ܼ������񣬲ο�ֵ��������Ϊ2*NCPU
 * @author smile_tina
 *
 */
public class ThreadPoolTest {

	/**
	 * ��ִ�н�����Կ��������̳߳����̵߳���Ŀ����5ʱ���㽫����������񻺴�������棬�����񻺴��������֮�󣬱㴴���µ��̡߳������������У���forѭ���иĳ�ִ��20�����񣬾ͻ��׳�����ܾ��쳣�ˡ�
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		for(int i = 0; i < 16; i++){
			MyTask task = new MyTask(i);
			executor.execute(task);
			System.out.println("�̳߳����߳���Ŀ��"+executor.getPoolSize()+",�����еȴ�ִ�е�������Ŀ��"+executor.getQueue().size()+",��ִ�����������Ŀ"+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

}
class MyTask implements Runnable{
	private int taskNum;
	public MyTask(int num){
		this.taskNum = num;
	}
	@Override
	public void run() {
		System.out.println("����ִ��task "+taskNum);
		try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"ִ�����");
	}
}
