package org.example;

import java.text.MessageFormat;
import java.util.Scanner;

public class MultiStateTaxCalculator
{
    Scanner scanner = new Scanner(System.in);
    final double WISCONSIN_TAX_RATE = 0.05;
    final double ILLINOIS_TAX_RATE = 0.05;
    final double EAU_CLAIRE_COUNTY_TAX = 0.005;
    final double DUNN_CLAIRE_COUNTY_TAX = 0.004;

    public double getOrderAmountInput() {
        System.out.print("What is the order amount? ");
        return scanner.nextDouble();
    }

    public String getStateIdentifierInput() {
        scanner.nextLine();
        System.out.print("What state do you live in? ");
        return scanner.nextLine();
    }

    public double getTotalTaxRate(String stateIdentifierInput)
    {
        double totalTax = 0;
        if (IsWisconsin(stateIdentifierInput))
        {
            totalTax = getCountyTaxRate() + WISCONSIN_TAX_RATE;
        }
        else if (IsIllinois(stateIdentifierInput))
        {
            totalTax = ILLINOIS_TAX_RATE;
        }
        else
        {
            System.out.println(MessageFormat.format("Invalid input. {0}", stateIdentifierInput));
            System.exit(0);
        }
        return totalTax;
    }

    public double calculateTotalTaxAmount(double totalTaxRate, double orderAmount)
    {
        return totalTaxRate * orderAmount;
    }

    public double calculateTotal(double totalTaxAmount, double orderAmount)
    {
        return totalTaxAmount + orderAmount;
    }

    private String getCountyIdentifierInput() {
        System.out.print("What county do you live in? ");
        return scanner.nextLine();
    }

    private boolean IsWisconsin(String state)
    {
        return state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("WI");
    }

    private boolean IsIllinois(String state)
    {
        return state.equalsIgnoreCase("Illinois") || state.equalsIgnoreCase("IL");
    }

    private double getCountyTaxRate()
    {
        String countyIdentifierInput = getCountyIdentifierInput();
        if (countyIdentifierInput.equalsIgnoreCase("eau claire"))
        {
            return EAU_CLAIRE_COUNTY_TAX;
        }
        else if (countyIdentifierInput.equalsIgnoreCase("dunn"))
        {
            return DUNN_CLAIRE_COUNTY_TAX;
        }
        else return 0;
    }
}
