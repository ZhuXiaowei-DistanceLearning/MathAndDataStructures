# 数据结构和算法

## 1.算法时间复杂度(算法的时间量度)

1. 定义
   - T(n):语句总的执行次数->是关于问题规模n的函数
   - 分析T(n)随n的变化情况并确定T(n)的数量级
   - T(n) = O(f(n)):O表示在最糟糕情况下的运行时间
   - 随问题规模n的增大，算法执行时间的增长率和f(n)的增长率相同，称作算法的渐近时间复杂度，简称为时间复杂度。其中f(n)是问题规模n的某个函数。
   - 个人理解：总的执行次数最坏等于函数执行次数
2. 推导大O阶方法
   - 用常数1取代运行时间中的所有加法函数
   - 在修改后的运行次数函数中，只保留最高阶项
   - 如果最高阶项存在且不是1，则去除与这个项相乘的常数
   - 得到的最后结果就是大O阶
   - O(1),O(n),O(n^2)
3. 常用的时间复杂度所耗费的时间
   - O(1)<O(logn)<(n)<O(nlogn)<O(n^2)<O(n^3)<O(2^n)<O(n!)<O(n^n)

## 2.算法的空间复杂度

1. 定义
   - 算法的空间复杂度通过计算算法所需的存储空间实现
   - S(n) = O(f(n)),其中n为问题规模，f(n)为语句关于n所占存储空间的函数

## 3.线性表

### 3.1顺序存储结构

1. 优点
   - 无须为表中元素之间的逻辑关系而增加额外的存储空间
   - 可以快速地存取表中任意位置的元素
   - 插入和存储复杂度为O(1)
2. 缺点
   - 插入和删除操作需要移动大量元素
   - 当线性表长度变化较大时，难以确定存储空间的容量
   - 容易造成存储空间的碎片
   - 删除和更新复杂度为O(n)

### 3.2链式存储结构

## 4.队列

1. 定义
   - 先进先出

## 5.栈

1. 定义

   - ```java
     package com.zxw.aha;
     
     public class MyStack {
     
     	public static void main(String[] args) {
     		MyStack ms = new MyStack(4);
     		ms.push(2);
     		ms.push(4);
     		ms.push(1);
     		ms.push(3);
     		System.out.println(ms.isEmpty());
     		System.out.println(ms.isFull());
     		int[] arr2 = ms.getArr();
     		for (int i = 0; i < arr2.length; i++) {
     			System.out.println(arr2[i]);
     		}
     	}
     
     	int[] arr;
     	int top;
     
     	public MyStack() {
     		arr = new int[10];
     		top = -1;
     	}
     
     	public MyStack(int maxsize) {
     		arr = new int[maxsize];
     		top = -1;
     	}
     
     	/**
     	 * 入栈
     	 * 
     	 * @param value
     	 */
     	public void push(int value) {
     		arr[++top] = value;
     	}
     
     	/**
     	 * 出栈
     	 * 
     	 * @return
     	 */
     	public int pop() {
     		return arr[top--];
     	}
     
     	/**
     	 * 查找数据
     	 * 
     	 * @return
     	 */
     	public int peek() {
     		return arr[top];
     	}
     
     	/**
     	 * 判断是否为空
     	 */
     	public boolean isEmpty() {
     		return top == -1;
     	}
     
     	public boolean isFull() {
     		return top == arr.length - 1;
     	}
     }
     ```

     

## 6.递归和分治思想

1. 定义
   - 直接调用自己或通过一系列的调用语句间接地调用自己的函数。每个递归定义必须至少有一个条件，当满足条件时递归不再进行，即函数不再调用自身而是返回
2. 区别
   - 迭代使用的是循环结构
   - 递归使用的是选择结构

### 6.1斐波那契数列的递归实现

```java
public static void main(String[] args) {
    // 主体部分进行循环
		for (int i = 1; i < 41; i++) {
			System.out.print("当前数为:"+i+",递归数为:");
			System.out.print(feibo(i));
			System.out.println("");
		}
	}

	public static int feibo(int num) {
        // 对前两个数进行判断
		if (num == 1 || num == 0) {
			return 1;
		} else {
            // 前前个数加前一个数，等于当前数的值
			return feibo(num - 2) + feibo(num - 1);
		}

	}
```

### 6.2反向输出字符串

```java
public static void reverseString(String str) {
		if (str.length() == 1) {
			System.out.print(str);
		} else {
            // 截取字符串从开始到导数第二个，假设长度为5，则截取1-4的值(不包含最后一个),[0,x),后面不包含
			String str1 = str.substring(0, str.length() - 1);
			System.out.println(str1+"----");
            // 获取最后一个字符串
			String str2 = str.substring(str.length() - 1);
			System.out.println(str2+"!!");
            // 将截取后的字符串重新截取
			reverseString(str1);
		}
	}
```

### 6.3折半查找

1. 基本思想
   - 减小查找序列的长度，分而治之地进行关键字的查找
2. 过程
   - 先确定待查找记录的所在范围，然后逐渐缩小这个范围，直到找到该记录或查找失败为止。

### 6.4汉诺塔

```java
/**
	 * 要将最大的圆盘移动到柱子3上
	 * 柱子1只剩最大的圆盘
	 * 柱子3为空
	 * 
	 * @param n      圆盘个数
	 * @param start  柱子1
	 * @param temp   柱子2
	 * @param target 柱子3
	 */
	public static void move(int n, char start, char temp, char target) {
		if (n == 0) {
			return;
		}
		if (n == 1) {
			System.out.println(start + "------->" + target);
		} else {
			move(n - 1, start, target, temp);
			System.out.println(start + "------->" + target);
			move(n - 1, temp, start, target);
		}
	}
```

### 6.4皇后问题

回溯算法的典型例题

## 7.字符串

### 7.1 BF算法

1. 定义

   - 暴力匹配（BF）算法是普通的模式匹配算法，BF算法的思想就是将目标串S的第一个字符与模式串T的第一个字符进行匹配，若相等，则继续比较S的第二个字符和T的第二个字符；若不相等，则比较S的第二个字符和T的第一个字符，依次比较，直到得出最后的匹配结果。
   - 当第一个字符不相同时j也会继续向后比较，比如例子中的“abcdefg”和“def”，当“a”和“d”不相同时，则明显之后的两个字符及时相等也不是相同的子串。
   - 每次j下标都要回到0号下标，当主串和字串匹配失败时，主串进行回溯会影响效率，回溯之后，主串与字串有些部分比较是没有必要的 .
   - 这种简单的丢弃前面的匹配信息的算法，造成了极大的浪费和底下的匹配效率 
   - 最坏O(n*m)

2. ```java
   /**
   	 * 字符串匹配，寻找t是否在s中出现
   	 * 当有一个不匹配的时候，回溯到目标串的下个字符
   	 * @param S
   	 * @param T
   	 * @param pos
   	 * @return
   	 */
   	public static int BfFind(String S, String T, int pos) {
   		char[] arr1 = S.toCharArray();
   		char[] arr2 = T.toCharArray();
   		int i = pos;
   		int j = 0;
   		while (i < arr1.length && j < arr2.length) {
   			if (arr1[i] == arr2[j]) {
   				i++;
   				j++;
   			} else {
   				// 当匹配中断时,从中断的当前位置重新开始匹配
   				i = i - j + 1;
   				j = 0;
   			}
   		}
   		// 返回模式串在目标串中出现的位置,第一个字符的位置
   		return j == arr2.length ? i-j:-1;
   	}
   ```

### 7.2 KMP算法

1. 定义

   - 在KMP算法中，对于每一个模式串都会事先计算出模式串的内部匹配信息，在匹配失败时最大的移动模式串，以减少匹配次数，这样就很好的解决了BF算法的缺陷
   - 比如，当匹配失败后，最好是能够将模式字串尽量的右移和主串进行匹配，右移的距离在KMP算法中是这样计算的：在已经匹配的字串中，找到最长的相同的前缀和后缀，然后移动使他们重叠，这个位置就是j要回退的位置，这样j就不用每一次都回到0号位置了，每一次j回退的位置存储在一个数组里，称之为next数组 

2. 核心

   - 避免不必要的回溯

   - 由模式串决定，不是由目标串决定

   - next[j]代表了T的前j个字符组成的子串中，其前缀和后缀的最长公共串的长度。例如如果next [j] = k，代表j 之前的字符串中有最大长度为k 的相同前缀后缀。

   - ```
     next[0]=-1, next[1]=0。
     在求解next[j]时，令k=next[j-1]，
     比较T[j-1]与T[k]的值，
     	a.若T[j-1]等于T[k]，则next[j]=k+1。
     	b.若T[j-1]不等于T[k]，令k=next[k]，若k等于-1，则next[j]=0，否则跳至3。
     ```

   - ```
     下面以模式串T=“abaabcac”为例，给出求next数组的过程：
     1.next[0]=-1, next[1]=0。
     2.当j=2时，k=next[j-1]=next[1]=0，由于T[j-1]=T[1]=‘b’，T[k]=T[0]=‘a’，T[j-1]不等于T[k]，令k=next[k]=next[0]=-1，因此next[2]=0。
     3.当j=3时，k=next[j-1]=next[2]=0，由于T[j-1]=T[2]=‘a’，T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[3]=k+1=1。
     4.当j=4时，k=next[j-1]=next[3]=1，由于T[j-1]=T[3]=‘a’，T[k]=T[1]=‘b’，T[j-1]不等于T[k]，令k=next[k]=next[1]=0。此时T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[3]=k+1=1。
     5.当j=5时，k=next[j-1]=next[4]=1，由于T[j-1]=T[4]=‘b’，T[k]=T[1]=‘b’，T[j-1]等于T[k]，因此next[5]=k+1=2。
     6.当j=6时，k=next[j-1]=next[5]=2，由于T[j-1]=T[5]=‘c’，T[k]=T[2]=‘a’，T[j-1]不等于T[k]，令k=next[k]=next[2]=0。此时T[k]=T[0]=‘a’，T[j-1]不等于T[k]，再令k=next[k]=next[0]=-1，因此next[6]=0。
     7.当j=7时，k=next[j-1]=next[6]=0，由于T[j-1]=T[6]=‘a’，T[k]=T[0]=‘a’，T[j-1]等于T[k]，因此next[7]=k+1=1。
     ```

   - ```java
     package com.zxw.yuC;
     
     public class kmp {
     	public static void main(String[] args) {
     		System.out.println(kmpMatch("abcabaabaabcacb", "cb"));
     	}
     
     	// 求出next数组
     	/**
     	 * 求解next[j]是关键 令k=next[j-1]
     	 * 
     	 * @param t
     	 * @return
     	 * @next[j] : 当前字符之前的字符串中，有多大长度的相同前缀后缀。例如如果next [j] = k，代表j 之前的字符串中有最大长度为k 的相同前缀后缀。
     	 */
     	public static int[] getNextArray(char[] tmp) {
     		int[] next = new int[tmp.length];
     		next[0] = -1;
     		next[1] = 0;
     		int k;
     		// j:模板字符串的索引
     		// 否则跳至3。
     		for (int j = 2; j < tmp.length; j++) {
     			// k的值为前一个数的next值
     			k = next[j - 1];
     			while (k != -1) {
     				// 比较T[j-1]与T[K]的值
     				if (tmp[j - 1] == tmp[k]) {
     					// 若T[j-1]等于T[k]，则next[j]=k+1。
     					next[j] = k + 1;
     					break;
     				} else {
     					// 若T[j-1]不等于T[k]，令k=next[k]
     					k = next[k];
     				}
     				// 若k等于-1，则next[j]=0
     				next[j] = 0;
     			}
     		}
     		return next;
     	}
     
     	// KMP匹配过程
     	/**
     	 * 对主串s和模板串t进行KMP模式匹配
     	 * 
     	 * @param s
     	 * @param t
     	 * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     	 */
     	public static int kmpMatch(String s, String t) {
     		char[] s_arr = s.toCharArray();
     		char[] t_arr = t.toCharArray();
     		int i = 0, j = 0;
     		int[] next = getNextArray(t_arr);
     		while (i < s_arr.length && j < t_arr.length) {
     			// 当模式串T匹配至第j个字符时匹配失败，i指针不变，将j指针置为next[j]的值，若j的值为-1，则将i和j同时加1。随后继续进行逐个的比较。
     			// 如果j=-1，表示当前字符匹配成功
     			if (j == -1 || s_arr[i] == t_arr[j]) {
     				i++;
     				j++;
     			} else {
     				// 字符匹配失败，模式串T相对于文本串S向右移动了j-next[j]位
     				// 模式串向右移动的位数为：失配字符所在位置（j） - 失配字符对应的next值，即移动的实际位数为：j - next[j]（表示当前指针的位置向右移动的位数，例如当前指针在a[6]位置上，向右移动4位，则到达a[2]上），且此值大于等于1。
     				j = next[j];
     			}
     		}
     		if (j == t_arr.length) {
     			return i - j;
     		} else {
     			return -1;
     		}
     	}
     }
     ```

   - 步骤

     1. 寻找前缀后缀最长公共元素长度
     2. 求next数组
     3. 根据next数组进行匹配
     4. ![1564482722551](C:\Users\zxw\AppData\Roaming\Typora\typora-user-images\1564482722551.png)

   - 个人看法

     - k：相同前缀后缀的长度
     - next[]:考虑的是当前字符外的最长相同前缀后缀
     - 根据《最大长度表》，失配时，模式串向右移动的位数为：已匹配字符数 - 失配字符的上一位字符所对应的最大长度值
     - 而根据《next 数组》，失配时，模式串向右移动的位数 = 失配字符的位置 - 失配字符对应的next 值

## 8.二叉树

1. 定义
   - 非线性的数据结构
   - 由n(n>=0)个有限元素的集合,可以为空(空二叉树)
   - 一个元素称作一个结点
   - 二叉树是有序的，若左右数颠倒，则成为另一颗不同的二叉树
   - 一对多关系
2. 二叉树的五种形态
   1. 空二叉树
   2. 只有一个根结点的二叉树
   3. 有根结点和左子树的二叉树
   4. 有根结点和右子树的二叉树
   5. 有根结点的左、右二叉树
3. 概念
   - 结点的度：结点的子树的个数，例如：两个左右子树，度数为2
   - 叶结点(终端结点)：度为0的结点,即无子树
   - 分支结点(非终端结点)：度不为0的结点
   - 路径：结点ni是ni+1的父节点，n1,n2,***,nk称为一条n1~nk的路径。长度为k-1(包含了兄弟结点路径，所以长度-1)
   - 层数:根结点为1
   - 深度：最大层数称为树的深度
   - 树的度：各结点的最大值,最大为2(左右子树)
4. 性质
   - 非空二叉树的第i层上最多有2^i-1个结点
   - 深度为k的二叉树中，最多具有2^k-1个结点
   - 对于一颗非空的二叉树，如果叶子结点数为n0,度数为2的结点数为n2,则有n0=n2+1
   - 具有n个结点的完全二叉树的深度k为[1bn]+1
5. 二叉树遍历的方法及递归实现
   1. 先序遍历:DLR
   2. 中序遍历:LDR
   3. 后序遍历:LRD
   4. 层序遍历:从二叉树的第一层开始，从下至下逐层遍历，同一层中，从左到右的顺序对结点逐个访问

### 8.1 满二叉树

1. 定义
   - 所有分支结点都存在左子树和右子树，所有子结点都在同一层上(层数相同)

### 8.2 完全二叉树

1. 定义
   - 满二叉树一定是完全二叉树，完全二叉树不定义是满二叉树
   - 叶子结点(即度为0，没有子树)只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部

### 8.3二叉树的顺序存储

1. 对于完全二叉树和满二叉树比较适用，其他的构造成完全二叉树即可

### 8.4二叉树的链式存储

1. 二叉链式表存储：左结点 中间数据 右结点（同双向链表）
   - 无法由结点直接找打双亲
   - 比顺序存储更剩空间
2. 三叉链表存储：左结点 中间数据 右结点 指向双亲结点

### 8.5 哈弗曼树(最优二叉树)

1. 定义
   - 对于一组带有确定权值的叶结点、构造的具有最小带权路径长度的二叉树

## 9.图

1. 定义
   - 非线性数据结构
   - 多对多关系
   - 用于表达数据元素之间存在着的网状结构关系
   - 图是一系列顶点和描述顶点之间的关系边(弧)组成。图是数据元素的集合，这些数据元素相互连接形成网络。
   - G=(V,E),V={Vi|Vi属于某个元素集合},E={(Vi,Vj)|Vi,Vj属于V并上P(Vi,Vj)}
   - G表示图，V是顶点的集合，E是边或弧的集合。在集合E中,P(Vi,Vj)表示顶点Vi和顶点Vj之间有边或弧相连。(即某个顶点到某个顶点之间的连线)
2. 术语
   - 顶点集：具有相同特性的数据元素的集合称为顶点集
   - 边：边是一对顶点间的路径，通常带箭头的边称为弧
   - 弧头：每条箭头线的头顶点表示构成弧的有序对中的后一个顶点，称为弧头或终点
   - 弧尾：每条箭头线的尾顶点表示构成弧的有序对中的前一个顶点，称为弧尾或始点
   - 度：在无向图中的顶点的度是指连那个顶点的边的数量。在右向图中，每个顶点有两种类型的度：入度和出度
   - 出度：顶点的出度是由那个顶点触发的边的数量
   - 权：有些图的边附带有一些数据信息，这些数据信息称为边的权
3. 操作
   - 插入顶点
   - 查找顶点
   - 删除顶点
   - 插入边
   - 查找边
   - 删除边
   - 求图的边数
   - 求图的顶点数
   - 遍历图
   - 求最短路径
4. 图的抽象数据类型
   - ADT(图)
   - 数据元素:具有相同数据类型的数据元素的集合
   - 数据结构:数据元素之间通过边或弧相互连接形成网络
   - 数据操作:将对图的基本操作定义在接口IGraph中

### 9.1 有向完全图

1. 任意两个顶点之间都是弧相连
2. n(n-1)条弧

### 9.2 无向完全图(完全图)

1. 任意两个顶点之间都是无向弧相连
2. n(n-1)/2条弧

### 9.3 稠密图

1. n(n-1)/2条弧

### 9.4 稀疏图

1. 有很少条边或弧的

## 10. 排序算法

### 10.1 插入排序

1. 定义
   - 每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子列表中的适当位置，直到全部记录插入完成为止

#### 10.1.1 直接插入排序

1. 基本操作

   - 将当前无序区的第1个记录data[i]插入到有序区data[0...i-1]中适当的位置上，使data[0...i]变为新的有序区。每次使有序区增加1个记录，通常称为增量法。

2. 时间复杂度

   - 最好：O(n)
   - 最坏：O(n^2)
   - (n-1)(n+4)/2

3. 实现

   - ```java
     public static void crpx(int[] arr) {
     		for (int i = 1; i < arr.length; i++) {
     			// 判断无序区的第一个元素是否小于有序区的最后一个元素
     			if (arr[i] < arr[i - 1]) {
     				int temp = arr[i];
     				int j = 0;
     				for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
     					arr[j + 1] = arr[j];
     				}
     				// 当temp比当前数大的时候，将temp插入进当前位置的后一个位置中
     				arr[j + 1] = temp;
     			}
     		}
     	}
     
     ```

#### 10.1.2  希尔排序

1. 定义
   - 对待记录序列先作”宏观”调整，再作“微观”调整
   - 分成若干子序列
   - 对子序列进行插入排序
   - 不稳定排序

### 10.2 选择排序

#### 10.2.1 直接选择排序

1. 定义

   - 每一趟从待排序的记录中选出关键字最小或最大的记录，顺序放在已排序好的字列表的最后，直到全部记录排序完毕

   - n个记录的序列要做n-1次排序，因为最后一个数必定是最大或最小的那个

   - O(n^2)

   - ```java
     public static void crpx(int[] arr) {
         int k;
     		for (int i = 0; i < arr.length-1; i++) {
     			for (int j = i+1; j < arr.length; j++) {
     				if (arr[i] > arr[j]) {
     					int temp = arr[i];
     					arr[i] = arr[j];
     					arr[j] = temp;
     				}
     			}
                 // 第二种写法
                 for (int j = i+1; j < arr.length; j++) {
                     k=i;
     				if(data[j]<data[k])	k=j; // 通过索引的方式来确立当前位置
                     if(k!=i){ // 如果和初始值不同，则表示有比当前位置小的值，进行交换
                         temp = data[i];
                         data[i] = data[j];
                         data[j] = temp;
                     }
     			}
     		}
     	}
     
     ```

#### 10.2.2 堆排序

1. 在直接选择排序的基础上借助完全二叉树结构而形成的一种排序算法

2. 从数据结构看，堆排序是完全二叉树的顺序存储结构的应用

3. 堆排序产生的问题，在n-2次比较中，n-1次有许多已经做了，但是没有保存，堆排序是针对上述问题的一种改进方法

4. 定义

   1. 设有n个元素组成的序列data[0...n-1]，若满足下面的条件

   2. 这些元素是一颗完全二叉树的结点，且对于i=0,1,...,n-1,data[i]是该完全二叉树编号为i的结点

   3. ```mathematica
      a.不等式(最大堆)
      data[i]>=data[2i+1]
      data[i]>=data[2i+2]
      b.不等式(最小堆)
      data[i]<=data[2i+1]
      data[i]<=data[2i+2]
      
      ```

5. 性质

   1. 最大堆的根结点是堆中关键码最大的结点，最小堆的根结点是堆中关键码最小的结点，称堆的根结点记录为堆顶记录(树中的根结点)
   2. 对于最大堆，从根结点到每个叶子结点的路径上，结点组成的序列都是递减有序的
   3. 对于最小堆，从根结点到每个叶子结点的路径上，结点组成的序列都是递增有序的

6. 基本思想

   1. 将待排序的记录序列建成一个堆，并借助于堆的性质进行排序的方法叫做堆排序

### 10.3 交换排序

1. 定义
   - 两两比较待排序记录的关键字，发现两个记录的次序相反时即进行交换，直到没有反序的记录为止

#### 10.3.1 冒泡排序

1. O(n^2)

#### 10.3.2 快速排序

1. 定义

   1. 分治法策略:将原问题分解为若干个规模更小但结构与原问题相似的子问题。递归解决子问题，然后将这些子问题的解组合为原问题的解。
   2. 快速排序是目前已知的平均速度最快的一种排序

2. 基本思想

   1. pivot基准记录，一般选第一个。low记录第一个位置，high记录最后一个位置
   2. 子序列两端逐渐向中间扫描，i和j代表左右两端记录在序列中的位置号
   3. 序列左端扫描：从左端开始比较基准记录和当前索引的大小直到基准记录小于当前索引(pivot>=data[i])
   4. 序列右端扫描：从右端开始比较基准记录和当前索引的大小直到基准记录大于当前索引(pivot<=data[j])
   5. 从左端来看，基准记录比这个数小。从右端来看，基准记录比这个数大，所以左端大于右端，交换位置

3. ```java
   public int[] quickSort(int[] data) {
   		return quickSort(data, 0, data.length - 1);
   	}
   
   	public static int[] quickSort(int[] data, int low, int high) {
   		if (low > high) {
   			return null;
   		}
   		int pivot = data[low]; // 将第一个记录作为标准放到临时变量中,使第一个位置腾空
   		int i = low + 1; // 指示器low执向顺序表头
   		int j = high; // 指示器high执向顺序表的尾
   		int temp;
   		while (i < j) {
   			// 序列左端扫描
   			while ((i < j) && pivot >= data[i]) {
   				++i;
   			}
   			// 序列右端扫描
   			while ((j >= i) && pivot <= data[j]) {
   				--j;
   			}
   			if (i < j) {
   				temp = data[i];
   				data[i] = data[j];
   				data[j] = temp;
   			}
   		}
   		if (low < j) {
   			temp = data[low];
   			data[low] = data[j];
   			data[j] = temp;
   		}
   		quickSort(data, low, j - 1);
   		quickSort(data, j + 1, high);
   		return data;
   	}
   
   ```

### 10.4 归并排序

1. 定义
   - 将两个或两个以上的有序子序列“归并”为一个有序序列
   - 分治法
2. 基本思想
   1. 将两个或两个以上的有序子序列“归并”为一个有序序列。
   2. 在内部排序中，通常采用得到是二路归并排序。即将两个位置相邻的有序子序列“归并”为一个有序序列
   3. 将有n个记录的原始序列看作n个有序子序列，每个子序的长度为1，然后从第一个子序列开始，把相邻的子序列两两合并后排序，得到n/2个长度为2或1的有序子序列(当子序列的个数为奇数时，最后一组合并得到的序列长度为1)

### 10.5 基数排序(分配排序)

1. 定义
   - 无需比较关键字，通过“分配”和“收集”过程实现排序

# 啊哈算法

## 1.桶算法

1. 用容器表示数字出现的个数。

   ```java
   // 声明一个数组
   int a[11];
   // 输入5个数，假设1,2,3,4,5
   // 循环输入数，直接将输入的数作为参数传递，如下
   a[i]++
   // 循环输出该输出，排序完成
   
   ```

2. 优点

   - 算法的时间复杂度是O(m+n+m+n),即O(2*(m+n)),O(M+N)
   - 非常快

3. 缺点

   - 浪费空间
   - 只能是整数排序

## 2.冒泡排序

1. 基本思想(核心：每一趟找出最小的数放到最后)

   - 每次比较两个相邻的元素，如果它们的顺序错误就把他们交换过来
   - 大到小，小到大都行
   - 识别：如同气泡，一步一步往后翻滚
   - 时间复杂度O(n^2),最好O(n),最坏O(n^2),空间复杂度O(1)

2. 注意事项：

   - 判断根据内嵌循环的数进行判断，因为每次比较的是相邻的两个元素

   - 因为每一趟结局，则固定好一个位置，所以下次不再进行判断，长度减1

   - ```java
     int[] mp = new int[] { 3, 9, 8, 3, 1 };
     		for (int i = 0; i < mp.length -1; i++) {
                 // 每次从第一个开始
     			for (int j = 0; j < mp.length-i-1; j++) {
     				// 如果第一个数小于第二个数,则调换位置
     				if (mp[j] < mp[j+1]) {
     					int temp = mp[j];
     					// 将大的数换到前面
     					mp[j] = mp[j+1];
     					mp[j+1] = temp;
     				}
     			}
     		}
     
     ```

## 3.快速排序

1. 基本思想
   - 平均时间复杂度O(NlogN),最坏O(n^2)

## 4.队列排序

## 5.直接选择排序

1. 思想

   - 每一次循环固定一个最小/最大值

   - 核心是中间变量k=i

   - 顾名思义，每次选择一个元素到指定的位置

   - 通过前后元素的值对比，设立一个坐标等于当前外层循环的值，判断得出该值的坐标，然后直接交换

   - ```java
     /**
     	 * 从小到大排列
     	 * @param arr
     	 */
     	public static void sort(int[] arr) {
     		int k = 0;
     		int tmp = 0;
     		// 每一趟循环固定一个最小值在前面,此循环控制每个位置
     		for (int i = 0; i < arr.length - 1; i++) {
     			k = i;
     			// 此循环控制
     			for (int j = i; j < arr.length; j++) {
     				// 判断后一位是否比前一位数小，如果小，就将索引定位在此
     				if (arr[j] < arr[k]) {
     					k = j;
     				}
     			}
     			// 循环结束得到最小值的坐标，进行交换
     			tmp = arr[i];
     			arr[i] = arr[k];
     			arr[k] = tmp;
     		}
     	}
     
     ```

## 6.直接插入排序

1. 思想

   - ```java
     /**
     	 * 直接插入排序
     	 * 
     	 * @param arr
     	 */
     	public static void crpx(int[] arr) {
     		int i, j, k;
     
     		for (i = 1; i < arr.length; i++) {
     			// 为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
     			for (j = i - 1; j >= 0; j--)
     				// 当前数及之前的数是否小于这个数
     				// 判断当前索引上的数是否比之前的数小，如果小则往前移
     				if (arr[j] < arr[i])
     					break;
     			// 如果当前数的位置与当前索引不相等，则空出位置移动
     			if (j != i - 1) {
     				// 将比a[i]大的数据向后移
     				int temp = arr[i];
     				for (k = i - 1; k > j; k--)
     					// 将前面的值往后移
     					arr[k + 1] = arr[k];
     				// 将a[i]放到正确位置上
     				arr[k + 1] = temp;
     			}
     		}
     	}
     
     ```

## 7.链表

1. 定义

   - 是一种空间存储结构

   - ```java
     package com.zxw.aha;
     
     public class Node {
     	public int data;
     	public Node next;
     
     	public Node(int data) {
     		this.data = data;
     	}
     	
     	public void display() {
     		System.out.print(data+" ");
     	}
     }
     
     ```

### 7.1 单向链表

```java
package com.zxw.aha;

/**
 * 链表,是一种存储结构
 * 
 * @author zxw
 *
 */
public class LinkList {
	// 头结点
	private Node first;

	public LinkList() {
		first = null;
	}

	/**
	 * 插入节点，在头结点后插入
	 */
	public void insertFirst(int value) {
		Node node = new Node(value);
		// 将头结点赋值指向当前节点指针域
		// 第一次插入时，子节点为空，队尾
		node.next = first;
		// 将头指针移项到当前节点指针域
		// 保存当前节点信息，供下一个插入节点使用
		first = node;
	}

	/**
	 * 删除节点,在头结后进行删除
	 */
	public Node deleteFirst() {
		// 获取当前节点的子节点
		Node tmp = first.next;
		// 将当前节点的子节点赋值到该节点上
		first = tmp;
		return tmp;
	}

	/**
	 * 查找方法
	 */
	public Node find(int value) {
		Node current = first;
		while (current.data != value) {
			// 查找失败
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/**
	 * 删除
	 */
	public Node delete(int value) {
		Node current = first;
		Node previous = first;
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		// 如果删除的是第一个节点
		if (current == first) {
			// 将节点的下一个值赋值给该节点
			first = first.next;
		}else{
			// 如果不是第一个节点
			// 将当前节点的下一个值，赋值给上一个节点的下一个值
			previous.next = current.next;
		}
		return current;
	}

	/**
	 * 显示方法
	 */
	public void display() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}

```

### 7.2 双端链表

```java
package com.zxw.aha;

/**
 * 双端链表
 * 
 * @author zxw
 *
 */
public class DoubleLinkList {
	// 头结点
	private Node first;
	// 尾节点
	private Node last;

	public DoubleLinkList() {
		first = null;
		last = null;
	}

	/**
	 * 插入节点，在头结点后插入
	 */
	public void insertFirst(int value) {
		Node node = new Node(value);
		// 从头部进行插入
		// 头结点是否为空,如果为空则设置尾节点为新添加的节点
		// 第一个插入的元素既是头结点也是尾节点  
		if (isEmpty()) {
			last = node;
		}
		// 将头结点赋值指向当前节点指针域
		// 第一次插入时，子节点为空，队尾
		node.next = first;
		// 将头指针移项到当前节点指针域
		// 保存当前节点信息，供下一个插入节点使用
		first = node;
	}

	/**
	 * 从尾节点进行插入
	 * 
	 * @return
	 */
	public void insertLast(int value) {
		Node node = new Node(value);
		// 尾节点是否为空
		// 如果为空，则设置头节点为新添加的节点
		if (isEmpty()) {
			first = node;
		} else {
			// 将尾节点的指针指向新节点
			last.next = node;
		}
		// 将最后一个节点的指针移向新节点 
		last = node;
	}

	public boolean isEmpty() {
		return (first == null ? true : false);
	}

	/**
	 * 删除节点,在头结后进行删除
	 */
	public Node deleteFirst() {
		// 获取当前节点的子节点
		Node tmp = first;
		// 将当前节点的子节点赋值到该节点上
		if (first.next == null) {
			last = null;
		}
		first = tmp;
		return tmp;
	}

	/**
	 * 查找方法
	 */
	public Node find(int value) {
		Node current = first;
		while (current.data != value) {
			// 查找失败
			if (current.next == null) {
				return null;
			}
			current = current.next;
		}
		return current;
	}

	/**
	 * 删除
	 */
	public Node delete(int value) {
		Node current = first;
		Node previous = first;
		while (current.data != value) {
			if (current.next == null) {
				return null;
			}
			previous = current;
			current = current.next;
		}
		// 如果删除的是第一个节点
		if (current == first) {
			// 将节点的下一个值赋值给该节点
			first = first.next;
		} else {
			// 如果不是第一个节点
			// 将当前节点的下一个值，赋值给上一个节点的下一个值
			previous.next = current.next;
		}
		return current;
	}

	/**
	 * 显示方法
	 */
	public void display() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}

```

### 7.3 双向链表

1. 当前节点的前指针与前节点的后指针相互指向
2. 当前节点的后指针与后节点的前指针相互指向
3. 在node中新添属性pervious已记录前后节点