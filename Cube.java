import java.util.Random;

public class Cube extends Face{
	Face Up, Down, Left, Right, Back, Front;
	int numberOfTurns = 0;

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
		System.out.println("--------");		
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

	//takes in a scramble and performs said scramble
	public void scramble(String strIn){ //ex   R U R' U'
		//		System.out.println(strIn);
		//Rafi WUZ HERE
		int i = 0;
		while(i < strIn.length()){
			char char1 = strIn.charAt(i);
			if(i+1 < strIn.length()){
				char char2 = strIn.charAt(i+1);
				if(char2 == '\''){
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise(); 
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}	
					i+=2;
				}else if(char2 == '2'){
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					this.TurnLayerUpClockwise();  
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}
					i+=2;
				}else{
					switch(char1){
					case 'R': this.TurnLayerRightClockwise(); 
					break;
					case 'U': this.TurnLayerUpClockwise(); 
					break;
					case 'D': this.TurnLayerDownClockwise(); 
					break;
					case 'L': this.TurnLayerLeftClockwise(); 
					break;
					case 'B': this.TurnLayerBackClockwise(); 
					break;
					case 'F': this.TurnLayerFrontClockwise(); 
					break;
					default: break;
					}
					i+=1;
				}
			}else{
				switch(char1){
				case 'R': this.TurnLayerRightClockwise(); 
				break;
				case 'U': this.TurnLayerUpClockwise(); 
				break;
				case 'D': this.TurnLayerDownClockwise(); 
				break;
				case 'L': this.TurnLayerLeftClockwise(); 
				break;
				case 'B': this.TurnLayerBackClockwise(); 
				break;
				case 'F': this.TurnLayerFrontClockwise(); 
				break;
				default: break;
				}
				i+=1;
			}
		}
		//RAFI LEFT HERE

	}

	//SOLVE\\
	public int Solve(){
		
		numberOfTurns = 0 ; //reset number of turns

		this.print(); //print turn
		int bottomPiecesSolved = 0;
		while (bottomPiecesSolved != 4){ //while all 4 pieces haven't been solved
			if(isDownTargetSolved()){ //if there is a solved piece in the target insertion area
				System.out.println(numberOfTurns + ": Each Piece");
				this.TurnLayerDownClockwise();this.TurnLayerDownClockwise();this.TurnLayerDownClockwise(); //do a D'
				numberOfTurns++;
				//	this.print(); //print turn
				bottomPiecesSolved++; //increase number of solved pieces by 1
			} else { 
				//there is an unsolved piece somewhere

				//System.out.println(targetStrickerFacingUp()); //NULL
				if(targetStickerFacingUp() != null){ //[1] could be facing sticker side up on Top Layer
					while(Up.face[1][1] != 'W'){
						this.TurnLayerUpClockwise();
						numberOfTurns++;
						//	this.print(); //print turn

					}
					//piece is up and in target position
					//ALGORITHM {R U2 R' U' R U R'}
					this.scramble("RU2R'U'RUR'");
					numberOfTurns+=7;
					//					this.print(); 
				} else if (targetStickerFacingSideExists()){ //[2] could be facing sticker side out on Top Layer
					while(Front.getColor(0, 0) != 'W' && Front.getColor(0,1) != 'W'){ //while white is in neither target
						this.TurnLayerUpClockwise();
						numberOfTurns++;
						//						this.print(); //print turn
					}
					if(Front.face[0][1] == 'W'){ //piece is in front right
						//ALGORITHM {U R U' R'}
						this.scramble("URU'R'");
						numberOfTurns+=4;
						//this.print(); 
					} else { //otherwise the found piece is on left
						//ALGRITHM {U' R U R'}
						this.scramble("U'RUR'");
						numberOfTurns+=4;
						//this.print(); 
					}

				} else { //[3] could be inserted but oriented wrong
					//check orientation
					if(Front.face[1	][1] == 'W'){
						//ALGORITHM R U' R' U R U' R' 
						this.scramble("RU'R'URU'R'");
						numberOfTurns+=7;
					} else { //twisted away from you
						//ALGORITHM R U R' U' R U R'
						this.scramble("RUR'U'RUR'");
						numberOfTurns+=7;
					}
				}
			}
		}

		System.out.println(numberOfTurns + " :SIDE");

		//OLL\\

		/* Cases:
		 * 1} 0 stickers face up
		 * 2} 1 sticker face up
		 * 3} 2 stickers face up
		 * (4 stickers face up means it has been solved)
		 *  */

		if(this.numberOfStickersFacingUp('Y') != 4){
			//SUNE or ANTISUNE
			if(this.numberOfStickersFacingUp('Y') == 1){
				if(Front.face[0][1] == 'Y'){
					//SUNE
					//keep turning top face till correct orientation
					while(Up.face[1][0] != 'Y'){
						numberOfTurns++;
						this.TurnLayerUpClockwise();
					}
					//SUNE is set up, execute
					//ALGORITHM R U R' U R U2 R' (SUNE)
					//System.out.println("DONE");
					numberOfTurns+=7;
					this.scramble("RUR'URU2R'");
				} else {
					//its possible that it is SUNE but there isn't a block in the target spot. Doing a U fixes this
					numberOfTurns++;
					this.TurnLayerUpClockwise();
					//check again for SUNE
					if(Front.face[0][1] == 'Y'){
						//is this runs SUNE is also in the correct orientation to be executed
						//ALGORITHM R U R' U R U2 R' (SUNE
						numberOfTurns+=7;
						this.scramble("RUR'URU2R'");
					} else {
						//ANTISUNE
						while(Up.face[0][1] != 'Y'){
							numberOfTurns++;
							this.TurnLayerUpClockwise();
						}
						//ALGORITHM R U2 R' U' R U' R'
						numberOfTurns+=7;
						this.scramble("RU2R'U'RU'R'");
					} 
				}
			} else if(this.numberOfStickersFacingUp('Y') == 2){
				//BOWTIE, HAMMERHEAD, HEADLIGHTS

				while(Up.face[1][1] != 'Y'){
					numberOfTurns++;
					this.TurnLayerUpClockwise();
				}
				if(Up.face[0][0] == 'Y'){
					//BOWTIE
					//Check Orientation
					if(Front.face[0][0] == 'Y'){
						//do alg from front
						//ALGORITHM F R' F' R U R U' R' 
						numberOfTurns+=8;
						this.scramble("FR'F'RURU'R'");	
					} else {
						numberOfTurns+=9;
						this.scramble("U'F'RUR'U'R'FR");
					}
				} else if(Left.face[0][1] == 'Y'){ // head lights
					numberOfTurns+=6;
					this.scramble("FRUR'U'F'");	
				} else if (Front.face[0][0] == 'Y'){ //hammer head
					numberOfTurns+=8;
					this.scramble("RUR'U'R'FRF'");
				} else if (Right.face[0][1] == 'Y'){ //hammer head
					numberOfTurns+=9;
					this.scramble("U'RUR'U'R'FRF'");
				} else { //head lights
					numberOfTurns+=7;
					this.scramble("U'FRUR'U'F'");	
				}

			} else{
				while((Front.face[0][0] != 'Y' || Front.face[0][1] != 'Y')){ //while both spots aren't Yellow
					numberOfTurns++;
					this.TurnLayerUpClockwise();
				}
				if(Right.face[0][1] == 'Y'){
					numberOfTurns+=8;
					this.scramble("R'FR2U'R2FR");	
				} else {
					numberOfTurns+=5;
					this.scramble("R2U2RU2R2");
				}
			}
		}

		//this.print();
		System.out.println(numberOfTurns + ": OLL");

		//DETECT PBL AND SOLVE=\\
		/*Cases:
		 * 1. diag | diag
		 * 2. diag | bar
		 * 3. bar | doag
		 * 4. bar | bar
		 * 5. solved | bar // parity
		 * 6. sovled | diag //parity
		 * 7. diag | solved //parity
		 * 8. bar | solved //parity
		 * 9. solved | solved
		 */

		if(areOpposites(Front.face[0][0], Front.face[0][1]) && (areOpposites(Right.face[0][0], Right.face[0][1])) 
				&& (areOpposites(Front.face[1][0], Front.face[1][1])) && (areOpposites(Right.face[1][0], Right.face[1][1]))){
			//DIAGONAL | DIAGONAL
			numberOfTurns+=3;
			this.scramble("R2 B2 R2");
			System.out.println("DIAG DIAG");
		} else if(this.isBarOnTop() && ((areOpposites(Front.face[1][0], Front.face[1][1])) && (areOpposites(Right.face[1][0], Right.face[1][1])))){
			System.out.println("OPP DIAG");
			//BAR | DIAGONAL
			//place bar in front
			while(Front.face[0][0] != Front.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			numberOfTurns+=7;
			this.scramble("R U' R F2 R' U R'");
		} else if((areOpposites(Front.face[0][0], Front.face[0][1]) && (areOpposites(Right.face[0][0], Right.face[0][1])))
				&& (this.isBarOnBottom())){
			System.out.println("DIAG OPP");
			//DIAGONAL | BAR
			//place bar on side
			while(Left.face[1][0] != Left.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}
			numberOfTurns+=9;
			this.scramble("R2 U R2 U' R2 U R2 U' R2");
		} else if(this.isBarOnTop()
				&& this.isBarOnBottom()){
			System.out.println("OPP OPP");
			//BAR | BAR
			while(Front.face[0][0] != Front.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			while(Front.face[1][0] != Front.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}
			numberOfTurns+=7;
			this.scramble("R2 U' B2 U2 R2 U' R2");
		} else if((areOpposites(Front.face[0][0], Front.face[0][1]) && areOpposites(Right.face[0][0], Right.face[0][1]))
				&& (Front.face[1][0] == Front.face[1][1] && Right.face[1][0] == Right.face[1][1])){
			System.out.println("DIAG SOLVE");
			//DIAGONAL | SOLVED
			numberOfTurns+=11;
			this.scramble("R U' R' U' F2 U' R U R' U F2");
		} else if ((Front.face[0][0] == Front.face[0][1] && Right.face[0][0] == Right.face[0][1]) && 
				(areOpposites(Front.face[1][0], Front.face[1][1]) && areOpposites(Right.face[1][0], Right.face[1][1]))){
			System.out.println("SOLVE DIAG");
			//SOLVED | DIAGONAL
			numberOfTurns+=12;
			this.scramble("R U' R' U' F2 U' R U R' D F2 R2");
		} else if (this.isBarOnTop()
				&& (Front.face[1][0] == Front.face[1][1] && Right.face[1][0] == Right.face[1][1])){
			System.out.println("OPP SOLVE");
			//BAR | SOLVED
			while(Left.face[0][0] != Left.face[0][1]){
				numberOfTurns++;
				this.TurnLayerUpClockwise();
			}
			numberOfTurns+=11;
			this.scramble("R U2 R' U' R U2 R' F R' F' R");
		} else if ((Front.face[0][0] == Front.face[0][1] && Right.face[0][0] == Right.face[0][1])  
				&& (this.isBarOnBottom())){
			System.out.println("SOLVE OPP");
			//SOLVED | BAR
			while(Left.face[1][0] != Left.face[1][1]){
				numberOfTurns++;
				this.TurnLayerDownClockwise();
			}		
			numberOfTurns+=11;
			this.scramble("R' U2 R' U' R U2 R' F R' F' R'");
		} else {
			System.out.println("PBL SKIP");
		} 
		//System.out.println("DONE");


		System.out.println(numberOfTurns + ": PBL");

		//AUF
		while(Front.face[0][0] != Front.face[1][0]){
			numberOfTurns++;
			this.TurnLayerUpClockwise();
		}
		System.out.println(numberOfTurns + ": AUF");
		System.out.println(numberOfTurns);
		this.print();
		
		return numberOfTurns;
	}


	public boolean isDownTargetSolved(){  //checks insertion spot to see if a piece has been solved yet
		if(Down.getColor(0, 1) == 'W'){
			return true;
		}
		return false;
	}

	//only used for null check, int[] return value never used
	public int[] targetStickerFacingUp(){ //check Up face to see if there is a target sticker facing up
		int[] point = new int[2];
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				//System.out.println(Up.getColor(i, j) + " " + i + " : " + j);
				if(Up.getColor(i, j) == 'W'){ //there is a white sticker facing up
					//System.out.println("found");
					point[0] = i;
					point[1] = j;
					return point;
				}
			}
		}
		return null;
	}

	public boolean targetStickerFacingSideExists(){ //check is target sticker in on the sides of the top layer
		for(int j=0; j<2; j++){ //check left front right
			if(Left.getColor(0, j) == 'W'){
				return true;
			} else if(Front.getColor(0, j) == 'W'){
				return true;
			} else if(Right.getColor(0,j) == 'W'){
				return true;
			} else if(Back.getColor(1, j) == 'W'){
				return true;
			}
		}
		return false;
	}

	public int numberOfStickersFacingUp(char color){
		int sum = 0;
		for(int i=0; i < 2; i++){
			for(int j =0; j< 2; j++){
				if(Up.getColor(i, j) == color){
					sum++;
				}
			}
		}

		return sum;
	}

	public static boolean areOpposites(char a, char b){
		if((a == 'W' && b == 'Y') || (a == 'Y' && b =='W') || ( a == 'B' && b == 'G') || (a == 'G' && b == 'B') || (a == 'R' && b == 'O') || (a == 'O' && b == 'R')){
			return true;
		}
		return false;
	}

	public boolean isBarOnTop(){

		if(Front.face[0][0] == Front.face[0][1] && Right.face[0][0] != Right.face[0][1]){
			return true;
		} else if (Right.face[0][0] == Right.face[0][1] && Front.face[0][0] != Front.face[0][1]){
			return true;
		} else if (areOpposites(Front.face[0][0], Front.face[0][1]) && !areOpposites(Right.face[0][0], Right.face[0][1])){
			return true;
		} else if (areOpposites(Right.face[0][0], Right.face[0][1]) && !areOpposites(Front.face[0][0], Front.face[0][1])){
			return true;
		}
		return false;
	}

	public boolean isBarOnBottom(){
		if(Front.face[1][0] == Front.face[1][1] && Right.face[1][0] != Right.face[1][1]){
			return true;
		} else if (Right.face[1][0] == Right.face[1][1] && Front.face[1][0] != Front.face[1][1]){
			return true;
		} else if (areOpposites(Front.face[1][0], Front.face[1][1]) && !areOpposites(Right.face[1][0], Right.face[1][1])){
			return true;
		} else if (areOpposites(Right.face[1][0], Right.face[1][1]) && !areOpposites(Front.face[1][0], Front.face[1][1])){
			return true;
		}
		return false;
	}

	public static String generateScramble(){
		String scramble = "";
		String[] moves = {"R", "U", "F", "R'", "U'", "F'", "R2", "U2", "F2"};
		for(int i=0; i < 9; i++){
			Random notActuallyARandomNumber =  new Random();
			int index = notActuallyARandomNumber.nextInt(9); //random number from {0,8}
			scramble += moves[index];
			scramble += " ";
		}
		return scramble;
		 
	}

}
