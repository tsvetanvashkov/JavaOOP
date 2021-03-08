package working_with_abstraction.exercises.JediGalaxy;

public class Matrix {

	private int coordinateX;
	private int coordinateY;
	private int[][] matrix;
	
	public Matrix(int coordinateX, int coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.matrix = new int[coordinateX][coordinateY];
	}
	
	public void getFilled(int startValue) {
		for (int i = 0; i < this.coordinateX; i++) {
			for (int j = 0; j < this.coordinateY; j++) {
				this.matrix[i][j] = startValue++;
			}
		}
	}
	
	public void setEvilsPath(int evalCoordinateX, int evalCoordinateY) {
		 while (evalCoordinateX >= 0 && evalCoordinateY >= 0)
         {
             if (evalCoordinateX >= 0 && evalCoordinateX < this.matrix.length 
            		 && evalCoordinateY >= 0 && evalCoordinateY < this.matrix[0].length)
             {
                 this.matrix[evalCoordinateX] [evalCoordinateY] = 0;
             }
             evalCoordinateX--;
             evalCoordinateY--;
         }
	}
	
	public int ivoStarsFromPath(int ivoCoordinateX, int ivoCoordinateY) {
		int sum = 0;
		while (ivoCoordinateX >= 0 && ivoCoordinateY < this.matrix[1].length)
        {
            if (ivoCoordinateX >= 0 && ivoCoordinateX < this.matrix.length && ivoCoordinateY >= 0 && ivoCoordinateY < this.matrix[0].length)
            {
                sum += this.matrix[ivoCoordinateX][ivoCoordinateY];
            }
            ivoCoordinateY++;
            ivoCoordinateX--;
        }
		return sum;
	}

}
