import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sort {

	/**
	 * ͨ��������Ԫ�صıȽϺͽ�������С������������ǰ�档�������������ˮ��������һ��
	 * 
	 * @param nums
	 */
	public void bubbleSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] < nums[j - 1]) {
					swap(nums, j, j - 1);
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * ѡ��������ͨ���������ѡ��,��һ����������С��Ԫ�طŵ���ǰ��
	 * 
	 * @param nums
	 */
	public void selectSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[minIndex])
					minIndex = j;
			}
			if (minIndex != i)
				swap(nums, i, minIndex);
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * ͨ���Ƚ��ҵ����ʵ�λ�ò���Ԫ�����ﵽ�����Ŀ�ĵ�,ÿ�ζ��Ƕ��Ѿ��ź���Ķν��е���
	 * 
	 * @param nums
	 */
	public void insertSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j > 0 && (nums[j] < nums[j - 1]); j--) {
				swap(nums, j, j - 1);
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * ��������
	 * 
	 * @param nums
	 */
	public void quickSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		quickSortSub(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public void quickSortSub(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int pivotPos = partition(nums, left, right);
		quickSortSub(nums, left, pivotPos - 1);
		quickSortSub(nums, pivotPos + 1, right);
	}

	public int partition(int[] nums, int left, int right) {
		int pivotKey = nums[left];
		int pivotIndex = left;
		while (left < right) {
			while (left < right && nums[right] >= pivotKey)
				right--;
			while (left < right && nums[left] <= pivotKey)
				left++;
			swap(nums, left, right);
		}
		swap(nums, pivotIndex, right);
		return right;
	}

	/**
	 * �sС�������򷨣��ڲ����ڵļ�¼֮����бȽϺͽ��������ò�����������ʱ��������ԡ�
	 * �����зֳ������У�Ȼ��ֱ�������н���������������һ��Ϊ(2^k,2^k-1,...2,1)
	 * 
	 * @param nums
	 */
	public void shellSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		int d = nums.length / 2;
		while (d >= 1) {
			shellInsert(nums, d);
			d = d / 2;
		}
		System.out.println(Arrays.toString(nums));
	}

	public void shellInsert(int[] nums, int d) {
		for (int i = d; i < nums.length; i++) {
			for (int j = i; j > 0 && nums[j] < nums[j - d]; j -= d) {
				swap(nums, j, j - d);
			}
		}
	}

	/**
	 * �ȵݹ黮�������⣬Ȼ��ϲ������
	 * �Ѵ������п�������������������У�Ȼ��ϲ����������У�Ȼ��������п����������������С���������������������ʵ�����������ϲ�
	 * ��Ȼ�����ĺϲ������������γ��������С��ռ临�Ӷ�ΪO(n)��ʱ�临�Ӷ�ΪO(nlogn)��
	 * 
	 * @param nums
	 */
	public void mergeSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		mSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	public void mSort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int mid = left + (right - left) / 2;
		mSort(nums, left, mid);// �ݹ��������
		mSort(nums, mid + 1, right);// �ݹ������ұ�
		merge(nums, left, mid, right);// �ϲ�
	}

	public void merge(int[] nums, int left, int mid, int right) {
		// [left, mid] [mid+1, right]
		int[] tmp = new int[right - left + 1];
		int l = left;
		int r = mid + 1;
		int k = 0;
		while (l <= mid && r <= right) {
			if (nums[l] <= nums[r])
				tmp[k++] = nums[l++];
			else
				tmp[k++] = nums[r++];
		}
		while (l <= mid) {
			tmp[k++] = nums[l++];
		}
		while (r <= right) {
			tmp[k++] = nums[r++];
		}
		for (int i = 0; i < tmp.length; i++)
			nums[left + i] = tmp[i];
	}

	/**
	 * ������
	 * 
	 * @param nums
	 */
	public void heapSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		// ��������
		for (int i = nums.length / 2; i >= 0; i--) {
			heapAdjust(nums, i, nums.length - 1);
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			swap(nums, 0, i);
			heapAdjust(nums, 0, i - 1);
		}
		System.out.println(Arrays.toString(nums));
	}

	public void heapAdjust(int[] nums, int l, int r) {
		int tmp = nums[l];
		for (int i = 2 * l + 1; i <= r; i *= 2) {
			// ���Һ��ӵĽڵ�ֱ�Ϊ2*i+1,2*i+2

			// //ѡ������Һ��ӽ�С���±�
			if (i < r && nums[i] < nums[i + 1])
				i++;

			if (tmp >= nums[i]) {
				break; // �Ѿ�Ϊ�󶥶ѣ�=�����ȶ��ԡ�
			}

			nums[l] = nums[i]; // ���ӽڵ�����
			l = i; // ��һ��ɸѡ
		}
		nums[l] = tmp;// ������ȷ��λ��
	}

	/**
	 * (1) ӳ�亯��f(k)�ܹ���N������ƽ���ķ��䵽M��Ͱ�У�����ÿ��Ͱ����[N/M]����������
	 * 
	 * ����(2)
	 * ����������Ͱ�����������������ÿ��Ͱֻ�ܵõ�һ�����ݣ���������ȫ�ܿ���Ͱ�����ݵġ��Ƚϡ������������Ȼ��������һ��ܲ����ף��������޴�������
	 * ��f(k)������ʹ��Ͱ���ϵ������޴󣬿ռ��˷����ء������һ��ʱ����ۺͿռ���۵�Ȩ�������ˡ�
	 * 
	 * ����N���������ݣ�M��Ͱ��ƽ��ÿ��Ͱ[N/M]�����ݵ�Ͱ����ƽ��ʱ�临�Ӷ�Ϊ��
	 * 
	 * O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM) Ͱ����
	 * 
	 * @param nums
	 */
	public void bucketSort(int[] nums) {
		if (null == nums)
			return;
		System.out.println(Arrays.toString(nums));
		
		List<List<Integer>> buckets = new ArrayList<List<Integer>>(); // Ͱ������
		for (int i = 0; i < 10; i++) {
			buckets.add(new LinkedList<Integer>());// ������ȽϺ���
		}
		for (int i = 0; i < nums.length; i++)
			buckets.get(f(nums[i])).add(nums[i]);
		// ��ÿ��Ͱ��������
		for (int i = 0; i < buckets.size(); i++) {
			if (!buckets.get(i).isEmpty()) {
				Collections.sort(buckets.get(i)); // ��ÿ��Ͱ���п���
			}
		}
		// ��ԭ�ź��������
		int k = 0;
		for (List<Integer> bucket : buckets) {
			for (int ele : bucket)
				nums[k++] = ele;
		}
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * ӳ�亯��
	 * 
	 * @param x
	 * @return
	 */
	public static int f(int x) {
		return x / 10;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] num = { 5, 3, 8, 4, 6, 9 };
		sort.bucketSort(num);

	}

}
