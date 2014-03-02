// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2538.AerialAssist2014.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.networktables2.util.List;
import java.util.Vector;
/**
 *
 */
public class Camera extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private AxisCamera camera;
    private boolean rightSide;
    private double RIGHT_SIDE_OFFSET;
    private double LEFT_SIDE_OFFSET;
    private final double RECTANGLE_PROPORTION = .2;
    private double MIN_DISTANCE;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Camera(){
        super();
        camera = AxisCamera.getInstance();
        
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean toShoot(){
        return true; 
    } 
    
     private Vector getImages() throws NIVisionException, AxisCameraException {
        ColorImage image = null;
        BinaryImage binaryImage = null;
        BinaryImage binaryNoSmallObj = null;
        //ParticleAnalysisReport particle = null;
        //BinaryImage binaryConvexHullResults = null;
        Vector images = null;

        if (camera.freshImage()) {
            image = camera.getImage();
            images = new Vector();
            images.addElement(image);
            // HSV values should be in the range 0-255 since a byte describes each of H, S, V
            // these constants should be moved elsewhere eventually
            int maxHue = 255;
            int maxSat = 255;
            int maxLum = 255;
            int halfLum = (int) (maxLum / 2.0);
            // H = 100 -200
            // S = 192 - max
            // L = half - max

            //binaryImage = image.thresholdHSL(53, 92, 185, 255, halfLum, maxLum);
            //binaryImage = image.thresholdHSL(50, 110, 50, 200, halfLum, maxLum);
            //binaryImage = image.thresholdHSL(50, 110, 50, 230, halfLum, 240);
            binaryImage = image.thresholdHSL(100, 200, 192, maxHue, halfLum, 255);
            images.addElement(binaryImage);
            binaryNoSmallObj = binaryImage.removeSmallObjects(true, 1);
            images.addElement(binaryNoSmallObj);
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {
                //ex.printStackTrace();
            }
            //binaryConvexHullResults = binaryNoSmallObj.convexHull(true);
            //images.addElement(binaryConvexHullResults);
        }
                
                // Test print:
                // printParticleReports(binaryConvexHullResults, "convex hull objects", '+', true);
                
        return images;
    }
     private void free(Vector enslavedImages) {
        for (int i = 0; i < enslavedImages.size(); i++) {
            if (enslavedImages.elementAt(i) != null) {
                try {
                    ((Image) enslavedImages.elementAt(i)).free();
                } catch (NIVisionException ex) {
                    ex.printStackTrace();
                }
            }
        } 
    }
     private void printParticleReports(BinaryImage binaryImage, String reportObjects, char marker, boolean printAll) {
        try {
            ParticleAnalysisReport[] allReports = binaryImage.getOrderedParticleAnalysisReports();
            printParticleReportChar(allReports, reportObjects, marker);
            if (printAll) {
                for (int i = 0; i < allReports.length; i++) {
                    printParticleReportChar(allReports, reportObjects, marker);
                    System.out.println(allReports[i]);
                }
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }
     private void printParticleReportChar(ParticleAnalysisReport[] allReports, String reportObjects, char marker) {
        System.out.print("We have " + allReports.length + " " + reportObjects);
        for (int i = 0; i < 20; i++) {
            System.out.print(marker);
        }
        System.out.println();
    }
    private ParticleAnalysisReport SortSides(BinaryImage binaryImage){
        try{
            ParticleAnalysisReport[] allReports = binaryImage.getOrderedParticleAnalysisReports();
            int objectCenterX;
            int element = 0;
            objectCenterX = allReports[element].center_mass_x;
            
            for(int i = 0; i < RIGHT_SIDE_OFFSET; i++){
                
            }
            if(objectCenterX < RIGHT_SIDE_OFFSET){
                objectCenterX = allReports[element++].center_mass_x;
            }
            else{
                return allReports[element];
            }
        }
        catch(NIVisionException ex){
            
        }
        
        return null;
    }
    
    private Vector checkOffset(ParticleAnalysisReport[] reports){
        int objectCenterX;
        Vector reportsPostOffset = null;
        
        if(rightSide){
            for(int i=0; i < reports.length; i++){
                objectCenterX = reports[i].center_mass_x;
                
                if(objectCenterX > RIGHT_SIDE_OFFSET){
                    reportsPostOffset.addElement(reports[i]);
                }
                else{
                    continue;
                }
            }
        }
        else{
            for(int i = 0; i < reports.length; i++){
                objectCenterX = reports[i].center_mass_x;
                
                if(objectCenterX < LEFT_SIDE_OFFSET ){
                    reportsPostOffset.addElement(reports[i]);
                }
                else{
                    continue;
                }
            }
            
        }
        return null;
    }
    private List checkProportion(ParticleAnalysisReport[] reports){
        int objectHeight;
        int objectWidth;
        int boxProportion;
        List postProportion = null;
        
        for(int i = 0; i < reports.length; i++){
            objectHeight = reports[i].boundingRectHeight;
            objectWidth = reports[i].boundingRectWidth;
            
            if(objectHeight > objectWidth){
                boxProportion =  objectWidth/objectHeight;
            }
            else if(objectHeight < objectWidth){
                boxProportion = objectHeight/objectWidth;
            }
            else{
                return null;
            }
            
            if(boxProportion < RECTANGLE_PROPORTION){
                postProportion.add(reports[i]);
            }
            else{
                postProportion.add(reports[i]);
            }
        }
        return postProportion;
    }
    private boolean boxDistance(ParticleAnalysisReport[] reports){
        for(int i = 1; i < reports.length; i++){
            double objOneX = reports[i-1].center_mass_x - (reports[i-1].imageWidth/2);
            double objOneY = reports[i-1].center_mass_y - (reports[i-1].imageHeight/2);
            double objTwoX = reports[i].center_mass_x - (reports[i].imageWidth/2);
            double objTwoY = reports[i].center_mass_y - (reports[i].imageHeight/2);
            double distance = Math.sqrt(((objOneX - objTwoY)*(objOneX - objOneY)) + ((objOneY - objTwoY)*(objOneY - objTwoY)));
           
            if(distance > MIN_DISTANCE){
                return toShoot();
            }
            else{
                return !toShoot();
            }
       }
       return false;
    }
}
