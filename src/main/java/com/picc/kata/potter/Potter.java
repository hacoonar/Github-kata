package com.picc.kata.potter;

import java.util.Arrays;

public class Potter {

	/**
	 * calPrice 计算书费
	 * @param int[] bookCart 所购本数清单
	 * 如{1,0,5,3,0}代表第一册买1本，第三册买5本，第四册买3本
	 * @return int 书费
	 */
	public static double calPrice(int[] bookCart) {
		double price = 0;
		
		//删除本数为0的项
		bookCart = removeZeroBook(bookCart);
		
		while(bookCart.length>0){
			//1.从小到大排序
			Arrays.sort(bookCart);
			
			//2.计算套装价格 size * 最小数 * 折扣 * 100
			int suitSize = bookCart.length;
			int minCount = bookCart[0];
			if(suitSize>0){
				double discount = calDiscount(suitSize);
				price += suitSize * minCount * discount * 100;
			}
			
			//3.每个值减去最小数
			for(int i=0;i<suitSize;i++){
				bookCart[i] = bookCart[i] - minCount;
				if(bookCart[i]<0){
					bookCart[i] = 0;
				}
			}
			
			//4.删除本数为0的项
			bookCart = removeZeroBook(bookCart);
		}
		
		return price;
	}

	private static int[] removeZeroBook(int[] bookCart) {
		//统计0的个数
        int count = 0;  //定义一个变量记录0的个数
        int cartCount = bookCart.length;
		for(int i = 0 ; i<cartCount; i++){
            if(bookCart[i]==0){
                count++;
            }
        }
        //创建一个新的数组
        int[] newArr = new int[cartCount-count];
        int index = 0; //新数组使用的索引值
        //把非的数据存储到新数组中。
        for(int i = 0; i<cartCount; i++){
            if(bookCart[i]!=0){
                newArr[index] = bookCart[i];
                index++;
            }
        }
        return newArr;
	}

	//计算折扣
	private static double calDiscount(int suitSize) {
		double discount = 1;
		if(suitSize==2){
			discount = 0.95;
		}else if(suitSize==3){
			discount = 0.9;
		}else if(suitSize==4){
			discount = 0.8;
		}else if(suitSize==5){
			discount = 0.75;
		}
		return discount;
	}

}