package jarfile;
import sample.calc.Calculator;
import sample.echo.Echo;
public class Jarfile {
	public static void main(String[] args)
	{
		int sum = 0;
		Calculator c = new Calculator();
		for(String s : args)
		{
			sum = c.add(sum, Integer.parseInt(s));
		}
		System.out.println("" + sum);
	}
}
