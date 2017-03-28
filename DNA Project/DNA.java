/**
 * Lukas Strobel
 * Mr. Bergquist period 4
 * 2/2/17
 * AP CS
 * DNA Project
 * Checks the validity of possible protein DNA combos, as well as prints out information about
 * those DNA
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class DNA {

   // class constants
   public static final int MIN_CODONS = 4; // min codons for a valid protein
   public static final int CG_MASS_PERCENT = 30; // percent mass of C and G for valid proteins
   public static final int UNIQUE_NUC_COUNT = 4; // num of unique nucleotides
   public static final int NUC_PER_COD = 3; // nucleotides per codon

   public static void main(String[] args)
           throws FileNotFoundException {

      // grab file locations before bulk of initializations
      Scanner console = new Scanner(System.in);
      System.out.print("Input file name? ");
      String inputName = console.nextLine();
      System.out.print("Output file name? ");
      String outputName = console.nextLine();

      // initialization
      Scanner input = new Scanner(new File(inputName));
      PrintStream out = new PrintStream(new File(outputName));

      // loop through each DNA strand
      while (input.hasNextLine()) {
         String[] inputArray = grabInput(input);
         String[] codonArray = splitIntoCodons(inputArray[1]);
         int[] nucleotideCounts = countNucleotides(inputArray[1]);
         double[] massPercentages = findMassPercent(nucleotideCounts);
         boolean isValid = checkValidity(massPercentages, codonArray);
         writeOutput(out, inputArray, nucleotideCounts, massPercentages, codonArray, isValid);
      }
   }

   // grab everything in one import method and return a String array
   // inputArray[0] is the name, and inputArray[1] is the DNA
   public static String[] grabInput(Scanner input) {
      String[] inputArray = new String[2];
      inputArray[0] = input.nextLine();
      inputArray[1] = input.nextLine().toUpperCase();
      return inputArray;
   }

   // take the dna and return a String array with each index being an individual codon
   public static String[] splitIntoCodons(String DNA) {
      String[] codonArray = new String[DNA.length() / NUC_PER_COD];
      for (int i = 0; i < DNA.length(); i += NUC_PER_COD) {
         codonArray[i / NUC_PER_COD] = DNA.substring(i, i + NUC_PER_COD);
      }
      return codonArray;
   }

   // count the nucleotides
   public static int[] countNucleotides(String DNA) {
      int[] nucleotideCounts = new int[UNIQUE_NUC_COUNT];
      for (int i = 0; i < DNA.length(); i++) {
         if (DNA.charAt(i) == 'A') {
            nucleotideCounts[0]++;
         } else if (DNA.charAt(i) == 'C') {
            nucleotideCounts[1]++;
         } else if (DNA.charAt(i) == 'G') {
            nucleotideCounts[2]++;
         } else if (DNA.charAt(i) == 'T') {
            nucleotideCounts[3]++;
         }
      }
      return nucleotideCounts;
   }

   // find the mass percentages and round appropriately
   public static double[] findMassPercent(int[] nucleotideCounts) {
      double[] massPercentages = new double[UNIQUE_NUC_COUNT];

      double aMass = nucleotideCounts[0] * 135.128;
      double cMass = nucleotideCounts[1] * 111.103;
      double gMass = nucleotideCounts[2] * 151.128;
      double tMass = nucleotideCounts[3] * 125.107;
      double totalMass = aMass + cMass + gMass + tMass;

      // converts decimal percentage into whole percent rounded to 10th place
      massPercentages[0] = Math.round(aMass / totalMass * 1000) * 100.0 / 1000.0;
      massPercentages[1] = Math.round(cMass / totalMass * 1000) * 100.0 / 1000.0;
      massPercentages[2] = Math.round(gMass / totalMass * 1000) * 100.0 / 1000.0;
      massPercentages[3] = Math.round(tMass / totalMass * 1000) * 100.0 / 1000.0;

      return massPercentages;
   }

   // check the validity of a protein based on simple heuristics
   public static boolean checkValidity(double[] massPercentages, String[] codonArray) {
      int score = 0;
      if (codonArray[0].equals("ATG")) score++;
      if (codonArray[codonArray.length - 1].equals("TAA") || codonArray[codonArray.length - 1].equals
              ("TAG") || codonArray[codonArray.length - 1].equals("TGA")) score++;
      if (codonArray.length >= MIN_CODONS) score++;
      if (massPercentages[1] + massPercentages[2] > CG_MASS_PERCENT) score++;
      return score == 4;
   }

   // write information passed into defined output file
   public static void writeOutput(PrintStream printer, String[] inputArray, int[]
           nucleotideCounts, double[] massPercentages, String[] codons, boolean isValid) {
      printer.println("Name: " + inputArray[0]);
      printer.println("Nucleotides: " + inputArray[1]);
      printer.println("Nucleotide counts: " + Arrays.toString(nucleotideCounts));
      printer.println("Mass percentages: " + Arrays.toString(massPercentages));
      printer.println("Codons: " + Arrays.toString(codons));
      printer.print("Encodes a protein: ");
      if (isValid) {
         printer.println("yes");
      } else {
         printer.println("no");
      }
      printer.println();
   }
}
