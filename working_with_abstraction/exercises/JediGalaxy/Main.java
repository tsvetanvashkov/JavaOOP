package working_with_abstraction.exercises.JediGalaxy;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        int[] dimestions = reader.readCoordinate(reader.readLine());
        int coordinateX = dimestions[0];
        int coordinateY = dimestions[1];
        Matrix galaxy = new Matrix(coordinateX, coordinateY);
        galaxy.getFilled(0);
        String command = reader.readLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you"))
        {
        	int[] ivoCoordinate = reader.readCoordinate(command);
        	int[] evilCoordinate = reader.readCoordinate(reader.readLine());
            int evalCoordinateX = evilCoordinate[0];
            int evalCoordinateY = evilCoordinate[1];
            galaxy.setEvilsPath(evalCoordinateX, evalCoordinateY);
            int ivoCoordinateX = ivoCoordinate[0];
            int ivoCoordinateY = ivoCoordinate[1];
            sum += galaxy.ivoStarsFromPath(ivoCoordinateX, ivoCoordinateY);
            command = reader.readLine();
        }
        System.out.println(sum);
        
    }
    
}
