//creates the Cube data structure as well as defines and implements turning of said cube

public class Cube extends Face{
	Face Up, Down, Left, Right, Back, Front;

	public Cube(){ //make Cube
		this.Up = new Face('W');
		this.Down = new Face('Y');
		this.Left = new Face('O');
		this.Right = new Face('R');
		this.Front = new Face('G');
		this.Back = new Face('B');
	}

	public void print(){

		//TOP
		for(int i=0; i<2; i++){
			System.out.println("   " + Up.face[i][0] + Up.face[i][1]);
		}
		System.out.println("");

		//LEFT FRONT RIGHT
		for(int i=0; i<2; i++){
			System.out.println("" + Left.face[i][0] + Left.face[i][1] + " " +
					Front.face[i][0] + Front.face[i][1] + " " +
					Right.face[i][0] + Right.face[i][1]);

		}
		System.out.println("");

		//DOWN
		for(int i=0; i<2; i++){
			System.out.println("   " + Down.face[i][0] + Down.face[i][1]);
		}
		System.out.println("");

		//BACK
		for(int i=0; i<2; i++){
			System.out.println("   " + Back.face[i][0] + Back.face[i][1]);
		}
	}

	//TURNING\\
	char[] tempArray = new char[2];
	char Temp;
	
//	private void TurnFaceCounterClockwise(Face f){ //turn face
//		Temp = f.face[0][0]; //store top left corner;
//		f.face[0][0] = f.face[0][1]; 
//		f.face[0][1] = f.face[1][1];
//		f.face[1][1] = f.face[1][0];
//		f.face[1][0] = Temp;
//	}
	private void TurnFaceClockwise(Face f){ //turn face
		Temp = f.face[0][1]; //store top left corner;
		f.face[0][1] = f.face[0][0]; 
		f.face[0][0] = f.face[1][0];
		f.face[1][0] = f.face[1][1];
		f.face[1][1] = Temp;
	}
	
	public void TurnLayerRightClockwise(){  // R
		
		TurnFaceClockwise(Right);
		tempArray[0] = Down.face[0][1]; //store right column
		tempArray[1] = Down.face[1][1];
		
		Down.face[0][1] = Back.face[0][1];
	    Down.face[1][1] = Back.face[1][1];
	    Back.face[0][1] = Up.face[0][1];
	    Back.face[1][1] = Up.face[1][1];
	    Up.face[0][1] = Front.face[0][1];
	    Up.face[1][1] = Front.face[1][1];
	    Front.face[0][1] = tempArray[0];
	    Front.face[1][1] = tempArray[1];
	}
	
	public void TurnLayerLeftClockwise(){ // L
		TurnFaceClockwise(Left);
		tempArray[0] = Down.face[0][0]; //store left column
		tempArray[1] = Down.face[1][0];
		
		Down.face[0][0] = Front.face[0][0];
		Down.face[1][0] = Front.face[1][0];
		Front.face[0][0] = Up.face[0][0];
		Front.face[1][0] = Up.face[1][0];
		Up.face[0][0] = Back.face[0][0];
		Up.face[1][0] = Back.face[1][0];
		Back.face[0][0] = tempArray[0];
		Back.face[1][0] = tempArray[1];
	}
	
	public void TurnLayerUpClockwise(){ // U
		TurnFaceClockwise(Up);
		tempArray[0] = Front.face[0][0]; //store Front Row
		tempArray[1] = Front.face[0][1];
		
		Front.face[0][0] = Right.face[0][0];
		Front.face[0][1] = Right.face[0][1];
		Right.face[0][0] = Back.face[1][1];
		Right.face[0][1] = Back.face[1][0];
		Back.face[1][1] = Left.face[0][0]; 
		Back.face[1][0] = Left.face[0][1];
		Left.face[0][0] = tempArray[0];
		Left.face[0][1] = tempArray[1];
		
	}
	
	public void TurnLayerDownClockwise(){ // D
		TurnFaceClockwise(Down);
		tempArray[0] = Front.face[1][0]; //store Front bottom Row
		tempArray[1] = Front.face[1][1];
	
		Front.face[1][0] = Left.face[1][0];
		Front.face[1][1] = Left.face[1][1];
		Left.face[1][0] = Back.face[0][1];
		Left.face[1][1] = Back.face[0][0];
		Back.face[0][1] = Right.face[1][0]; 
		Back.face[0][0] = Right.face[1][1]; 
		Right.face[1][0] = tempArray[0];
		Right.face[1][1] = tempArray[1];
	}
	
	public void TurnLayerFrontClockwise(){ // F
		TurnFaceClockwise(Front);
		tempArray[0] = Up.face[1][0]; //store Up bottom Row
		tempArray[1] = Up.face[1][1];
		
		Up.face[1][0] = Left.face[1][1];
		Up.face[1][1] = Left.face[0][1];
		Left.face[0][1] = Down.face[0][0];
		Left.face[1][1] = Down.face[0][1];
		Down.face[0][0] = Right.face[1][0]; 
		Down.face[0][1] = Right.face[0][0]; 
		Right.face[0][0] = tempArray[0];
		Right.face[1][0] = tempArray[1];
	}
	
	public void TurnLayerBackClockwise(){ // B
		TurnFaceClockwise(Back);
		tempArray[0] = Up.face[0][0]; //store Up Top Row
		tempArray[1] = Up.face[0][1];
		
		Up.face[0][0] = Right.face[0][1];
		Up.face[0][1] = Right.face[1][1];
		Right.face[0][1] = Down.face[1][1];
		Right.face[1][1] = Down.face[1][0];
		Down.face[1][1] = Left.face[1][0]; 
		Down.face[1][0] = Left.face[0][0]; 
		Left.face[0][0] = tempArray[1];
		Left.face[1][0] = tempArray[0];
	}
	
}
