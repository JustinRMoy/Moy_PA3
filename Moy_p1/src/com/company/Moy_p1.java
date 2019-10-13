package com.company;

import java.security.SecureRandom;
import java.util.Scanner;

public class Moy_p1 {

    public static float arithmetic(int type, int num1, int num2, SecureRandom random){
        int randNum = random.nextInt(4)+1;

        if(type == 1){
            System.out.println("How much is " + num1 + " plus " + num2 + "?");
            return (float)num1 + num2;
        }else if(type == 2){
            System.out.println("How much is " + num1 + " minus " + num2 + "?");
            return (float)num1 - num2;
        }else if(type == 3){
            System.out.println("How much is " + num1 + " times " + num2 + "?");
            return (float)num1 * num2;
        }else{
            System.out.println("How much is " + num1 + " divided by " + num2 + "?");
            return Math.round( ((float)num1 / num2) * (float)100) / (float)100;
        }
    }

    public static float generateQuestion(int type, int difficulty, SecureRandom random){
        int num1;
        int num2;
        if(type == 5) {
            type = random.nextInt(4)+1;
        }
        if(difficulty == 1) {
            num1 = random.nextInt(10);
            num2 = random.nextInt(10);

            if((num2 - 0.00) < 0.0001 && type == 4)
                num2 = random.nextInt(9)+1;
        }else if(difficulty == 2) {
            num1 = random.nextInt(100);
            num2 = random.nextInt(100);
            if((num2 - 0.00) < 0.0001 && type == 4)
                num2 = random.nextInt(99)+1;
        }else if(difficulty == 3) {
            num1 = random.nextInt(1000);
            num2 = random.nextInt(1000);
            if((num2 - 0.00) < 0.0001 && type == 4)
                num2 = random.nextInt(999)+1;
        }else{
            num1 = random.nextInt(10000);
            num2 = random.nextInt(10000);
            if((num2 - 0.00) < 0.0001 && type == 4)
                num2 = random.nextInt(9999)+1;
        }

        return arithmetic(type, num1, num2, random);

    }

    public static void wrongResponse(int randResp){
        switch (randResp) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void correctResponse(int randResp){
        switch (randResp) {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice Work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("Choose Difficulty: 1,2,3,4");
        int difficulty = in.nextInt();

        System.out.println("Choose math type:\n1 Addition\n2 Subtraction\n3 Multiplication\n4 Division\n5 Random");
        int type = in.nextInt();

        float answer = generateQuestion(type, difficulty, random);

        int randResp = random.nextInt(4) + 1;

        int correct = 0;
        int wrong = 0;
        int numberOfResponses = 0;
        char continueLoop = 'y';
        float userAnswer;

        while (true) {

            while (numberOfResponses != 10) {
                userAnswer = in.nextFloat();
                numberOfResponses++;

                if (!(Math.abs(userAnswer - answer) < 0.001)) {
                    wrongResponse(randResp);
                    if(numberOfResponses != 10)
                        answer = generateQuestion(type, difficulty, random);
                    wrong++;
                } else {
                    correctResponse(randResp);
                    if(numberOfResponses != 10)
                        answer = generateQuestion(type, difficulty, random);

                    correct++;
                }
                randResp = random.nextInt(4) + 1;
            }

            if (((correct / 10.00) * 100) < 75) {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }

            System.out.println("Number correct: " + correct + "\nNumber incorrect: " + wrong);
            System.out.println("Next person, do you wish to continue (y/n)");
            continueLoop = in.next().charAt(0);
            if(continueLoop == 'n')
                break;

            correct = 0;
            wrong = 0;
            numberOfResponses = 0;

            System.out.println("Choose Difficulty: 1,2,3,4");
            difficulty = in.nextInt();

            System.out.println("Choose math type:\n1 Addition\n2 Subtraction\n3 Multiplication\n4 Division\n5 Random");
            type = in.nextInt();

            answer = generateQuestion(type, difficulty, random);
        }
    }
}

