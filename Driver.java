//text Driver to build the cube and test turning
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cube c = new Cube();
		
		c.TurnLayerRightClockwise();
		c.TurnLayerUpClockwise();
		c.TurnLayerBackClockwise();
		c.TurnLayerDownClockwise();
		c.TurnLayerLeftClockwise();
		c.TurnLayerFrontClockwise();
		c.print();
	}

}
