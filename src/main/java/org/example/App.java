/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 James Karlinski
 */

package org.example;

public class App
{
    public static void main(String[] args) {
        MultiStateTaxCalculator taxCalculator = new MultiStateTaxCalculator();
        double orderAmount = taxCalculator.getOrderAmountInput();
        String stateIdentifierInput = taxCalculator.getStateIdentifierInput();
        double totalTaxRate = taxCalculator.getTotalTaxRate(stateIdentifierInput);
        double totalTaxAmount = taxCalculator.calculateTotalTaxAmount(totalTaxRate, orderAmount);
        double totalAmount = taxCalculator.calculateTotal(totalTaxAmount, orderAmount);
        System.out.printf("The tax is $%.2f.\nThe total is $%.2f.", totalTaxAmount, totalAmount);
    }
}