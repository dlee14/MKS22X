public class USACO {
  public int bronze(String filename) {
    int R, C, E, N;
    int[][] lake = new int[R][C];
    try{
      Scanner scanner = new Scanner(new File(filename));
      String line1= scanner.nextLine();
      R = parseInt(line1.substring(0,1));
    }
    catch(FileNotFoundException e){
      System.out.println("FILE NOT FOUND!!!");
    }
    //R C E N
    //R = row
    //C = column
    //E = elevation for the final water level
    //N = amount of stomp digging
    //R_s = row start for stomp digging
    //C_s = column start for stomp digging
    //D_s = push down D_s inches
    //N = amount of stomp digging

  }





  // public int silver(String filename) {
  //
  // }

}
