package composite;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class banat extends Shape{
	private List<Shape> sremBanatBacka= new ArrayList<>();
	
	public void add(Shape s )
	{
		sremBanatBacka.add(s);
	}
}
