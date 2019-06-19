/////////////////////////////////////////////
// Class: Spectrometer Tester
// Date: 7/1/17
// Description: Program to Identify Raman Spectra using OmniDriver and GUI Classes to display the output
///////////////////////////////////////////////




import java.io.*;
import com.oceanoptics.omnidriver.api.wrapper.Wrapper;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import java.text.DateFormat;
import java.time.LocalDateTime;

public class Main {
	
	//Global Variable Declartions
    static double[] waves, spectrum;          // arrays of doubles to hold the spectral data and wavelengths
    static double[] waves2, spectrum2;  
    
     public static void main(String[] args) throws IOException {
    	 //Variable Declarations
       Wrapper wrapper = new Wrapper();             // Create a wrapper object
       int numberOfSpectrometers, numberOfPixels=0;   // variables for the program
       int integrationTime = 10000;                  // set the integration time
       String serialNumber;                         // variable to get the serial number
       double[] wavelengths, spectralData;          // arrays of doubles to hold the spectral data
       double[] wavelengths2, spectralData2;  
       List<Double[]> data= new ArrayList<Double[]>();
       List<Double[]> row = new ArrayList<Double[]>();
       
       // open the spectrometers - if not, do not continue
       numberOfSpectrometers = wrapper.openAllSpectrometers(); // opens all of the spectrometers and returns the number of spectrometers found
       if (numberOfSpectrometers < 1){              // Check for any spectrometers
           System.out.println("There are no spectrometers attached to the computer");
           return;
       }       
       System.out.println("Number of Spectrometers found: " + numberOfSpectrometers);   // prints the number of spectrometers found to the screen
        wavelengths = wrapper.getWavelengths(0);                // gets the wavelengths of the first spectrometer and save them in a double array
       spectralData = wrapper.getSpectrum(0); 
       wavelengths2 = wrapper.getWavelengths(0);                // gets the wavelengths of the first spectrometer and save them in a double array
       spectralData2 = wrapper.getSpectrum(0);  
       
  /////GUI Begins
       boolean testing = true;
       Intro intr=new Intro();
       intr.setVisible(true);
       int exit=0;
       Targeting2 targ2=new Targeting2();
       Instructions inst=new Instructions();
       boolean removeinfinite=true;
       while(exit==0)
       {
    	   
    	  if(intr.getCurrScreen()==1 && removeinfinite)
    	  {
    		  System.out.println("Instructions");
    		  inst.setVisible(true);
    		  removeinfinite=false;
    	  }
    	  if(intr.getCurrScreen()==2)
    	  {
    		  
    		  targ2.setVisible(true);
    		  exit=1;
    	  }
       }
       
       //Set Integration Time
       wrapper.setIntegrationTime(0, integrationTime);         // sets the integration time of the spectrometer
      //Set number of scans to average 
       wrapper.setScansToAverage(0, 100);
       wrapper.setCorrectForElectricalDark(0, 1);
       wrapper.setBoxcarWidth(0, 5);
       wrapper.setCorrectForDetectorNonlinearity(0, 1);
       
       
       //Run Dark Test
       // Allowed to make 5 passes at getting a valid spectrum
       boolean temp = getSpectrum(wrapper,0);
       wavelengths=waves;
       spectralData=spectrum;
       if(temp)
       {
    	   System.out.println("Spectrum is valid, continuing with light spectrum");
       }
       else
       {
    	   System.out.println("Spectrum is invalid, re-performing testing procedure");
    	   int count=1;
    	  while(temp==false && count<5);
    	   {
    	       temp = getSpectrum(wrapper,0);
    	       wavelengths=waves;
    	       spectralData=spectrum;
    	       if(temp)
    	       {
    	    	   System.out.println("Spectrum is valid, continuing with light spectrum");
    	       }
    	       else
    	       {
    	    	   count++;
    	       }
    	   }
    	   if (count>5)
    	   {
    		   System.out.println("Spectrometer test is having repeated issues. Abort testing procedure");
    		   System.exit(1);
    	   }
    	   
       }
       //------------------End of Dark Specrum Testing---------------------------------
       // Light Spectrum (with Laser)
       boolean test=false;
       while(test==false)
       {
    	   test= targ2.testing();
    	   try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	   
       }
       Targeting target= new Targeting();
		target.setVisible(true);   
       temp = getSpectrum(wrapper,1);
       wavelengths=waves2;
       spectralData=spectrum2;
       if(temp)
       {
    	   System.out.println("Spectrum is valid, processing results");
       }
       else
       {
    	   System.out.println("Spectrum is invalid, re-performing testing procedure");
    	   int count=1;
    	  while(temp==false && count<5);
    	   {
    	       temp = getSpectrum(wrapper,1);
    	       wavelengths=waves2;
    	       spectralData=spectrum2;
    	       if(temp)
    	       {
    	    	   System.out.println("Spectrum is valid, continuing with light spectrum");
    	       }
    	       else
    	       {
    	    	   count++;
    	       }
    	   }
    	   if (count>5)
    	   {
    		   System.out.println("Spectrometer test is having repeated issues. Abort testing procedure");
    	   }
    	   
       }
       
       

       numberOfPixels = wrapper.getNumberOfPixels(0);          // gets the number of pixels in the first spectrometer.
       
       // loop for printing the spectral data to the screen:
      
        
       int size=wavelengths.length;
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddyyyy HHmmss");
       LocalDateTime localDate = LocalDateTime.now();
       PrintStream fout = new PrintStream(new FileOutputStream(dtf.format(localDate)+ ".txt"));
       System.setOut(fout);
       fout.printf("Begin testing procedure %n");
       
               
       
        for (int i = 0; i < numberOfPixels; i++){       
           
           Double[] trans = new Double[size];
           trans[0]=waveLentoNum(waves[i]);
           trans[1]=spectrum[i];
           trans[2]=spectrum2[i];
           if(trans[0]>200 && trans[2]<10000)
           {
           fout.printf("Wavelength: %5.3f,  Intensity: %5.3f, Laser Intensity: %5.3f  %n", trans[0], trans[1], trans[2]);
           data.add(trans);
           }
         
           //row.add(wavelengths[i]);
           //row.add(spectralData[i]);
           //values.add(row);
       }
        boolean detailed=false;
        int isDia= getGemstone(data);
        
        if (isDia==1)
        {
        	System.out.println("The sample seems to contain diamond.");
        	Diamond dia=new Diamond();
        	dia.setVisible(true);	
        	while(dia.getDetailed()==false)
        	{
        		
        	}
       	  DrawGraph draw = new DrawGraph(data);
          //double x=draw.getMaxScore();
          //System.out.printf("Max Score %5.3f", x);
          draw.createAndShowGui(data);
    	
        }
        else if (isDia==2)
        {
        	System.out.println("The sample seems to contain Asha.");
        	Asha ash=new Asha();
        	ash.setVisible(true);	
        	while(ash.getDetailed()==false)
        	{
        		
        	}
       	  DrawGraph draw = new DrawGraph(data);
          //double x=draw.getMaxScore();
          //System.out.printf("Max Score %5.3f", x);
          draw.createAndShowGui(data);
    	
        }
        else if (isDia==3)
        {
        	System.out.println("The sample seems to contain the purple gem.");
        	PurpleGem purple=new PurpleGem();
        	purple.setVisible(true);	
        	while(purple.getDetailed()==false)
        	{
        		
        	}
       	  DrawGraph draw = new DrawGraph(data);
          //double x=draw.getMaxScore();
          //System.out.printf("Max Score %5.3f", x);
          draw.createAndShowGui(data);
    	
        }
        else
        {
        	System.out.println("The sample does not seem to contain a testable element.");
        	Negative neg=new Negative();
        	neg.setVisible(true);
        	while(neg.getDetailed()==false)
        	{
        		
        	}
        	  DrawGraph draw = new DrawGraph(data);
              //double x=draw.getMaxScore();
              //System.out.printf("Max Score %5.3f", x);
              draw.createAndShowGui(data);
        	
        }
        
      
        fout.close();
        
        
        
    }
     public static boolean getSpectrum(Wrapper wrapper, int type)
     {
    	 if(type==0) {
    	 waves=wrapper.getWavelengths(0);
    	 spectrum=wrapper.getSpectrum(0);
    	 }
    	 if(type==1) {
    		 waves2=wrapper.getWavelengths(0);
        	 spectrum2=wrapper.getSpectrum(0);	 
    	 }
    	 
    	  boolean spectrumIsValid = wrapper.isSpectrumValid(0);
          return spectrumIsValid;
     }
     public static int getGemstone(List<Double[]> data)
     {
    	 ArrayList<Double[]> maxes = new ArrayList<Double[]>();
    	 int gemstone=0; //0 = non-identifiable 1= diamond 2= asha 3= purple gemstone
    	 for(int i=0;i<data.size()-5;i++)
    	 {
    		 if(i<5)
    		 {
    			 boolean isMax=true;
    			 for (int x=0;x<5;x++)
    			 {
					if(data.get(i+x)[2]>data.get(i)[2])
						isMax=false;
				}
    			 if(isMax)
    			 {
    				 maxes.add(data.get(i));
    			 }
    		 }
    		 else
    		 {
    			 boolean isMax=true;
    			 for (int x=-5;x<5;x++)
    			 {
					if(data.get(i+x)[2]>data.get(i)[2])
						isMax=false;
				}
    			 if(isMax)
    			 {
    				 maxes.add(data.get(i));
    			 }
    		 }
    	 }
    	 boolean diamond1=false;
		 boolean asha1=false;
		 boolean asha2=false;
		 boolean asha3=false;
		 boolean purple1=false;
		 System.out.printf("Number of Maxes %d %n", maxes.size());
    	 for(int i=0;i<maxes.size();i++)
    	 {
    		 System.out.printf("Max %d: %5.3f %n", i, maxes.get(i)[0]);
    		if(maxes.get(i)[0]<1350 && maxes.get(i)[0]>1320)
    		{
    			diamond1=true;
    			asha1=true;
    		}
    		if(maxes.get(i)[0]<1450 && maxes.get(i)[0]>1430)
    		{
    			asha2=true;
    		}
    		if(maxes.get(i)[0]<1540 && maxes.get(i)[0]>1525)
    		{
    			asha3=true;
    		}
    		if(maxes.get(i)[0]>1370 && maxes.get(i)[0]<1390)
    		{
    			purple1=true;
    		}
    		 
    	 }
    	 if(asha1==true && asha2==true && asha3==true)
    	 {
    		 gemstone=2;
    		 System.out.println("Asha");
    	 }
    	 else if(purple1==true)
    	 {
    		 gemstone=3; 
    		 System.out.println("Purple");
    	 }
    	 else if(diamond1==true && asha2==false || asha3==false)
    	 {
    		 gemstone=1;
    		 System.out.println("Diamond");
    	 }
    	 return gemstone;
    	 
     }
     public static double waveLentoNum(double WaveLength)
     {
    	 double wave=785.00;
    	 double wavenumber = ((1/wave)-(1/WaveLength))*Math.pow(10, 7);
    	 return wavenumber;
     }

}