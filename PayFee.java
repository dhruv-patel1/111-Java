
public class PayFee {
	public static void main(String[]args){
		double payment = IO.readDouble();
		double fee = 0;
		
		if (payment >= 10000)
		{
			fee += 200;
			payment -= 10000;
			
			if (payment >= 5000)
			{
				fee += 150;
			}
			else 
			{
				fee += payment * 0.03;
			}
			payment -= 5000;
			
			if (payment >=0)
			{
				fee += payment * 0.04;
			}
		}
		else if ((payment >= 5000)&&(payment < 10000))
		{
			fee += ((payment * 0.02) > 120) ? (payment * 0.02):120;
	
		}
		else if ((payment > 500) && (payment < 5000))
		{
			fee += ((payment * 0.01) > 20 ? (payment * 0.01): 20);
		}
		else 
		{
			fee += 10;
		}
		IO.outputDoubleAnswer(fee);
	}
}
