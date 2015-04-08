package applicationsOfQueues;

public class JStock {
LinkedQueue <Transaction> transactions;
private float totalValue;
public void buy (int num, float sharePrice)
{
transactions.enqueue(new Transaction (num, sharePrice));
}
public float sell (int num, float sharePrice){
	int sellingShares=0;
	float capitalGain=0;
	while (num>sellingShares)
	{
		
		if (num>sellingShares+transactions.peek().getShares())
		{
			Transaction t=transactions.dequeue();
			sellingShares=sellingShares+t.getShares();
			t.sell(t.getShares());
			capitalGain =capitalGain+t.getShares()*(sharePrice-t.getSharePrice());
		}
		else
		{
			Transaction t=transactions.peek();
			t.sell(num-sellingShares);
			capitalGain =capitalGain+(num-sellingShares)*(sharePrice-t.getSharePrice());
			sellingShares=num;
		}
	}
	return capitalGain;
}
}