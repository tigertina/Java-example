
public class B {
	//��̬����
	static int i = 1;
	//��̬����
	static{
		System.out.println("Class B1:static blocks" + i);
	}
	//�Ǿ�̬����
	int j = 1;
	//��̬����
	static{
		i++;
		System.out.println("Class B2:static blocks"+i);
	}
	//���캯��
	public B(){
		i++;
		j++;
		System.out.println("constructor B: "+"i="+i+",j="+j);
	}
	//�Ǿ�̬����
	{
	  i++;
	  j++;
	  System.out.println("Class B:common blocks"+"i="+i+",j="+j);
	}
	//�Ǿ�̬����
	public void bDisplay(){
		i++;
		System.out.println("Class B:static void bDisplay():	"+"i="+i+",j="+j);
		return ;
	}
	
	//��̬����
	public static void bTest(){
		i++;
		System.out.println("Class B:static void bTest():	"+"i="+i);
		return ;
	}

}
