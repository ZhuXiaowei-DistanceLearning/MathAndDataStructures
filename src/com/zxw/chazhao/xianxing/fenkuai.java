package com.zxw.chazhao.xianxing;

public class fenkuai {
	// 块查找
	public int blockSearch() {
		return 0;
	}

	// 表示索引表结点类型
	static class BlockInfo {
		int blockBeginIndex; // 块的起始下标
		int blockEndIndex; // 块的结束下标
		int blockMaxValue; // 块中最大关键字

		// 创建分块查找的索引表
		public BlockInfo[] getBlockArray(int[] data) {
			int length = data.length;
			int n = (int) Math.sqrt(length);
			int m = (int) length / n;
			BlockInfo[] blocks = new BlockInfo[m];
			for (int i = 0; i < m; i++) {
				BlockInfo block = new BlockInfo();
				block.blockBeginIndex = i * n;
				if (i * n + n - 1 < length - 1) {
					block.blockEndIndex = i * n + n - 1;
				} else {
					block.blockEndIndex = length - 1;
				}
				int maxValue = data[block.blockBeginIndex];
				for (int j = block.blockBeginIndex; j < block.blockEndIndex; j++) {
					if (maxValue < data[j]) {
						maxValue = data[j];
					}
				}
				block.blockMaxValue = maxValue;
				blocks[i] = block;
			}
			return blocks;
		}
	}
}
