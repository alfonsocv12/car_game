package car_game;

public class CCounter {
	private int CCounter;
	private int Money;
	private int EngineCost;
	private int EngineType;
	
	public void setCounter( int counter) {
		this.CCounter = counter;
	}
	public int getCounter( ) {
		return this.CCounter;
	}
	public void setMoney(int pesos) {
		this.Money= pesos;
	}
	public int getMoney( ) {
		return this.Money;
	}
	public void setEngineCost(int cost) {
		this.EngineCost= cost;
	}
	public int getEngineCost() {
		return this.EngineCost;
	}
	public void setEngineType(int number) {
		this.EngineType=number;
	}
	public int getEngineType() {
		return this.EngineType;
	}
}
