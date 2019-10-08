package game_obj;



public class Hander {
	public Poker[] hander = new Poker[3];
	public int point;
	public int level;
	public void sort() {
		
		
		for(int i=0;i<2;i++) {
			int min = i;
			for(int j = i+1;j<3;j++) {
				
				if(hander[j].point<hander[min].point) {
					min = j;
				}
			}
			
			Poker temp;
			temp = hander[i];
			hander[i] = hander[min];
			hander[min] = temp;
		}
	}//手牌排序
	public boolean isPure() {
		if(hander[0].color.equals(hander[1].color)) {
			if(hander[1].color.equals(hander[2].color)) {
				return true;
			}
		}
		return false;
	}//判断是否是同色
	public boolean hasCouple() {
		if(hander[0].point==hander[1].point||hander[1].point==hander[2].point||hander[0].point==hander[2].point) {
			return true;
		}
		return false;
	}//是否有对子
	public boolean isE() {
		if(hander[0].point==hander[1].point&&hander[0].point==hander[2].point) {
			return true;
		}
		return false;
	}//是否是是同色
	public boolean isStraight() {
		if(hander[0].point+1==hander[1].point&&hander[0].point+2==hander[2].point) {
			return true;
		}
		return false;
	}//是否是顺子
	public int getPoint() {
		point = hander[0].point+hander[1].point+hander[2].point;
		return point;
	}//获得点数
	public int getLevel() {
		if(isPure()) {
			level=1;
		}else if(isStraight()) {
			level=2;
		}else if(isE()) {
			level=3;
		}else if(hasCouple()) {
			level=4;
		}else {
			level=5;
		}
		return level;
	}
	
}
