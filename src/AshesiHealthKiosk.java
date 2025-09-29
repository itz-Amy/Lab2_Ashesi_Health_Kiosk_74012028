import java.util.Scanner;


public class AshesiHealthKiosk {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float triageValue = 0;
        double newBMI = 0;
        String service ;
        System.out.print("Enter your service code: ");
        String serviceCode = scan.nextLine().toUpperCase().trim();

// TASK 1
        switch (serviceCode.charAt(0)) {
            case 'P' -> {
                System.out.println("Go to: Pharmacy Desk");
                service = "PHARMACY";
            }

            case 'L' -> {
                System.out.println("Go to: Lab Desk");
                service = "LABORATORY";
            }

            case 'C' -> {
                System.out.println("Go to: Counseling Desk");
                service = "COUNSELLING";
            }
            case 'T' -> {
                System.out.println("Go to: Triage Desk");
                service = "TRIAGE";
            }

            default -> {
                System.out.println("Invalid service code");
                service = "INVALID";
            }
        }


  // TASK 2
        if (serviceCode.charAt(0) == 'T') {
            System.out.print("""
                    Enter health metric
                    1. For BMI press 1
                    2. For Dosage round-up press 2
                    3. For Simple Trig Helper press 3
                    """);
            int quickMetric = scan.nextInt();
            if (quickMetric == 1) {
                System.out.println("Enter weight in kg: ");
                float weight = scan.nextFloat();
                System.out.println("Enter height in meters: ");
                float height = scan.nextFloat();
                triageValue = weight / (height * height);
                newBMI = Math.round(triageValue * 10) / 10.0;
                System.out.println("New BMI is " + newBMI);


                if (newBMI < 18.5)
                    System.out.println("Underweight");
                else if (newBMI < 25)
                    System.out.println("Normal");
                else if (newBMI < 30)
                    System.out.println("Overweight");
                else if (newBMI >= 30)
                    System.out.println("Obese");

            }
            else if (quickMetric == 2) {
                System.out.println("Enter The required dosage mg: ");
                float dosage = scan.nextFloat();
                if (dosage > 250)
                    System.out.println("Cannot dispense dosage");

                double finalDose = Math.ceil(dosage / 250);
                triageValue = (float) finalDose;
                int tablets = (int) finalDose;
                System.out.println("The number of tablets is: " + tablets);

            }

            else if (quickMetric == 3) {
                System.out.println("Enter an angle in degrees");
                double angle = scan.nextDouble();
                double sinAngle = (Math.round(Math.sin(angle)*1000)/1000.0);
                double cosAngle = (Math.round(Math.cos(angle)*1000)/1000.0);
                System.out.println("Sin of angle in radians is "+sinAngle);
                System.out.println("Cos of angle in radians is "+cosAngle);
                triageValue = (float) sinAngle;
            }

        }
// TASK 3
        char ch = (char) (65 + (int) (Math.random() * 25));

        int num1 = 3 + (int) (Math.random() * 7);
        int num2 = 3 + (int) (Math.random() * 7);
        int num3 = 3 + (int) (Math.random() * 7);
        int num4 = 3 + (int) (Math.random() * 7);
        String letter = Character.toString(ch);
        String shortCode = letter + num1 + num2 + num3 + num4;

        if (shortCode.length() <= 5) {
            char firstLetter = shortCode.charAt(0);
            if (Character.isLetter(firstLetter)) {
                if ((Character.isDigit(shortCode.charAt(1))) && (Character.isDigit(shortCode.charAt(2))) &&
                        (Character.isDigit(shortCode.charAt(3))) && (Character.isDigit(shortCode.charAt(shortCode.length() - 1))))
                    System.out.println("Your ID code is valid " + shortCode);
                else
                    System.out.println("The last 4 numbers must be digits");

            } else {
                System.out.println("Invalid: first char must be a letter");
            }
        } else
            System.out.println("Invalid Length");

// TASK 4
        System.out.print("Enter your firstname: ");
        String name = scan.next();
        char base = name.toUpperCase().charAt(0);
        char shiftedLetter = (char) ('A' + (base - 'A' + 2) % 26);
        String finalCode = Character.toString(shiftedLetter) + shortCode.substring(shortCode.length() - 2)
        + "-" + Math.round(triageValue);

        System.out.println(finalCode);

// TASK 5
        System.out.print("SUMMARY: " + service + " | ID = " + shortCode + " | Code = "+ finalCode);

    }
}
