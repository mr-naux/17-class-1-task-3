
package ctrl;

import java.util.Random;

import game_obj.Decker;
import game_obj.Hander;
import game_obj.Poker;
import game_obj.Record;
public class Controler implements Game_controler {

	
	public Hander h1 = new Hander();
	public Hander h2 = new Hander();
	public Poker[] pokers = new Poker[6];
	public Decker decker = new Decker();
	public Record[] records = new Record[10000];
	public int length=0;
	@Override
	public void shuffling() {
		// TODO Auto-generated method stub
		decker.initDecker();
		boolean[] bool = new boolean[52];
		int id = 0;
		for(int i = 0;i<6;i++) {
			Random ra = new Random();
			do {
				id = ra.nextInt(52);
			}while(bool[id]);
			bool[id] = true;
			
			pokers[i] = decker.pokers[id];
		}
		for(int i=0;i<3;i++) {
			h1.hander[i] = pokers[i];
		}
		for(int i=3;i<6;i++) {
			h2.hander[i-3] = pokers[i];
		}
		h1.sort();
		System.out.println("");
		h2.sort();
	}

	
	@Override
	public int judgement() {
		// TODO Auto-generated method stub
		h1.getLevel();
		h1.getPoint();
		h2.getLevel();
		h2.getPoint();
		if(h1.level<h2.level) {
			return 1;
		}else if (h1.level>h2.level){
			return 2;
		}else {
			if(h1.point>h2.point) {
				return 1;
			}else if(h1.point<h2.point) {
				return 2;
			}else 
				return 0;
		}
	}
	@Override
	public void recording() {
		// TODO Auto-generated method stub
		h1.getLevel();
		h1.getPoint();
		h2.getLevel();
		h2.getPoint();
		records[length] = new Record();
		records[length].level=h1.level;
		records[length].paixing=h1.hander[0].paimian+" "+h1.hander[1].paimian+" "+h1.hander[2].paimian;
		records[length].point=h1.point;
		records[length++].getWin(judgement());
		
		records[length] = new Record();
		records[length].level=h2.level;
		records[length].paixing=h2.hander[0].paimian+" "+h2.hander[1].paimian+" "+h2.hander[2].paimian;
		records[length].point=h2.point;
		if(this.judgement()==1)
			records[length++].getWin(2);
		else if(this.judgement()==2)
			records[length++].getWin(1);
		else
			records[length++].getWin(0);
	}
	public int appearTimes(int i) {
		int time=0;
		for(int j=0;j<this.length;j++) {
			if(this.records[j].level==i) {
				time++;
			}
		}
		return time;
	}
	public int winTimes(int i) {
		int time=0;
		for(int j=0;j<this.length;j++) {
			if(this.records[j].level==i&&this.records[j].win==1) {
				time++;
			}
		}
		return time;
	}
	

}
