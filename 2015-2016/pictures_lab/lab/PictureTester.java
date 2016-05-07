package lab;

import java.awt.Color;

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
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.Negate();
    beach.explore();
  }  
  
  public static void testGrayscale()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }
  public static void testFixUnderwater()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.fixUnderwater();
    beach.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }
  
  public static void testMirrorHorizontal()
  {
    Picture beach = new Picture("water.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }
  
  public static void testMirrorBotToTop()
  {
	    Picture beach = new Picture("blueMotorcycle.jpg");
	    beach.explore();
	    beach.mirrorBotToTop();
	    beach.explore();
	  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testStegnography()
  {
	  Picture whiteFlower = new Picture("whiteFlower.jpg");
	  whiteFlower.explore();
	  
	  new Picture("clock.jpg").explore();

	  Picture encodedpic = whiteFlower.encode(new Picture("clock.jpg"));
	  encodedpic.explore();
//	  
	  Picture newFlower = encodedpic.decode();
	  newFlower.explore();
  }
  
  public static void testChromakey()
  {
	  Picture smile = new Picture("mrhorn.jpg");
	  smile.explore();
	  
	  Picture newsmile = smile.chromakey(new Picture("moon landing.jpg"), new Color(0, 0, 0));
	  newsmile.explore();
  }
  
  public static void testPixelate()
  {
	  Picture mrhorn = new Picture("mrhorn.jpg");
	  mrhorn.explore();
	  
	  Picture blurryhorn = mrhorn.pixelate(15);
	  blurryhorn.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
//    testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVerticalRightToLeft();
//	  testMirrorHorizontal();
//	  testMirrorBotToTop();
//	  testStegnography();
	  
	  testChromakey();
//	  testPixelate();

	  //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
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