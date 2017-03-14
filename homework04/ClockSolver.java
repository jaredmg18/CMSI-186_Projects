/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Jared Gencarella
 *  Date written  :  2017-03-11
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
  *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   double angleInput = 1800.00;
   double slice = 60.0;
   double window = 0;
   //final double EPSILON_VALUE = 0.1;      // small value for double-precision comparisons


  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */

   /**
    *  Method to handle all the input arguments from the command line
    *   this sets up the variables for the simulation
    */
    public void handleInitialArguments( String args[] ) {
      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit(-1);
      }
      try {
        slice = Double.parseDouble(args[0]);
        angleInput = Double.parseDouble(args[1]);
      } catch (Exception e) {
        System.err.println("Invalid Input: Input must be a real number.");
        System.exit(-1);
      } if
        (slice >= 1800.00 || slice <= 0) {
        System.out.println("Invalid Input: Time Slice must be a positive real number less than 1800.00");
        System.exit(-1);
      } if
        (angleInput >= 360 || angleInput <= 0) {
        System.out.println("Invalid Input: The anlge must be a positive real number less than 360");
        System.exit(-1);
       }
      Clock clock = new Clock(angleInput, slice, window);
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      //ClockSolver cse = new ClockSolver();
      Clock clock = new Clock(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
      //double[] timeValues = new double[3];
      //cse.handleInitialArguments( args );
      while( clock.isStillRunning() ) {
        clock.increasingAngle();
         clock.tick();
         if (clock.formsAngleInput()) {
           System.out.println("Angle is: " + clock.toString());
         }
      }
      System.exit(-1);
   }
}
