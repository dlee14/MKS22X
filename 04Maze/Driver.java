public class Driver{
    public static void main(String[]args){
        Maze f = new Maze("data3.txt");//true animates the maze.

        //f.setAnimate(true);
        f.solve();

        System.out.println(f);
    }
}
