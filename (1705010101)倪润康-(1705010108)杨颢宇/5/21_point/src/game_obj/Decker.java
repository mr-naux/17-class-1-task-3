package game_obj;

public class Decker {
	public Poker[] pokers = new Poker[52];
	public String[] colors = {"meihua","fangkuai","hongtao","heitao"};
	public String[] paimians = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public void initDecker() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<13;j++) {
				pokers[i*13+j] = new Poker();
				pokers[i*13+j].getId(i*13+j);
				pokers[i*13+j].getColor(colors[i]);
				pokers[i*13+j].getPaimian(paimians[j]);
				pokers[i*13+j].getPoint(j);
			}
		}
	}
}
