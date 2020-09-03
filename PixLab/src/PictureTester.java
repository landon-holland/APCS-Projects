/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testKeepOnlyBlue() {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }

  public static void testNegate() {
    Picture p = new Picture("images/lemonke.png");
    p.explore();
    p.negate();
    p.explore();
  }

  public static void testGrayscale() {
    Picture p = new Picture("images/kitten2.jpg");
    p.explore();
    p.grayscale();
    p.explore();
  }

  public static void testFixUnderwater() {
    Picture p = new Picture("images/water.jpg");
    p.explore();
    p.fixUnderwater();
    p.explore();
  }

  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("images/caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalRightToLeft() {
    Picture p = new Picture("images/caterpillar.jpg");
    p.explore();
    p.mirrorVerticalRightToLeft();
    p.explore();
  }

  public static void testMirrorHorizontal() {
    Picture p = new Picture("images/caterpillar.jpg");
    p.explore();
    p.mirrorHorizontal();
    p.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture p = new Picture("images/caterpillar.jpg");
    p.explore();
    p.mirrorHorizontalBotToTop();
    p.explore();
  }

  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms() {
    Picture snowman = new Picture("images/snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }

  public static void testMirrorGull() {
    Picture gull = new Picture("images/seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }

  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("images/640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  public static void testCopy() {
    Picture p = new Picture("images/swan.jpg");
    p.explore();
    Picture p1 = new Picture("images/lemonke.png");
    p1.explore();
    p1.copy(p, 50, 100, 100, 150, 100, 100);
    p1.explore();
  }

  public static void testMyCollage() {
    Picture canvas = new Picture("images/640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }

  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("images/swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testMyCollage();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}