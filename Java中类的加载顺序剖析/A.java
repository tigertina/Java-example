public class A extends B {
	// ��̬����
	static int i = 1;
	// ��̬����
	static {
		System.out.println("Class A1:static blocks" + i);
	}
	// �Ǿ�̬����
	int j = 1;
	// ��̬����
	static {
		i++;
		System.out.println("Class A2:static blocks" + i);
	}

	// ���캯��
	public A() {
		super();
		i++;
		j++;
		System.out.println("constructor A: " + "i=" + i + ",j=" + j);
	}

	// �Ǿ�̬����
	{
		i++;
		j++;
		System.out.println("Class A:common blocks" + "i=" + i + ",j=" + j);
	}

	// �Ǿ�̬����
	public void aDisplay() {
		i++;
		System.out.println("Class A:static void aDisplay():	" + "i=" + i
				+ ",j=" + j);
		return;
	}

	// ��̬����
	public static void aTest() {
		i++;
		System.out.println("Class A:static void aTest():	" + "i=" + i);
		return;
	}

	/**
	 *  1.��Ҫ������A�����ȼ���ִ���丸��B(Object)�ľ�̬�����Լ���̬����(ִ���Ⱥ�˳�����е��Ⱥ�˳��)��
		2.Ȼ���ټ���ִ����A�ľ�̬�����Լ���̬���顣(����1��2����ֻ��ִ��1��)
		3.����ʵ������A�����ȵ����丸��B�Ĺ��캯��,�����ڵ����丸��B�Ĺ��캯��ǰ,�����ȵ��ø���B�еķǾ�̬�������Ǿ�̬����.����ٵ��ø���B�еĹ��캯����ʼ����
		4.Ȼ�������ε�����A�еķǾ�̬�������Ǿ�̬����.������A�еĹ��캯����ʼ����( ����3��4��������ظ�ִ��)
		5.�����ھ�̬�����ͷǾ�̬�������Ǳ�������,��ϵͳ�����Զ�����ִ��,�����û�û�е���ʱ����ִ��,��Ҫ�������ھ�̬��������ֱ��������ֱ�ӵ���(ʵ��������Ҳ����),���Ǿ�̬����ֻ����ʵ�����������ܵ��á�
	 * @param args
	 */
	public static void main(String[] args) {
		
		A a = new A();
		a.aDisplay();
	}

}
