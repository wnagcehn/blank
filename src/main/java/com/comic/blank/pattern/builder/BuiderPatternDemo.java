package com.comic.blank.pattern.builder;

/**
 * created by ..w-chen..
 */
public class BuiderPatternDemo {

    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("Non-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());

        Meal vegMeal = builder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());
    }

}
