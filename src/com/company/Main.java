package com.company;

import java.util.Random;
import java.util.Scanner;


/* ***************************************
  @author    Gopala Bhamidipati
  @date      08 October 2021
  @version   3
  Exercise - Chat Box
   ****************************************/
public class Main {

    public static void main(String[] args) {
        String name = chooseName();
        print("Sorry, I am back!");


        TriggerResponse[] trigRespDB = new TriggerResponse[]{};
        trigRespDB = initialiseArray(trigRespDB);
        //Using the initialiseArray() method the array of trigRespDB is initialised with the appropriate values

        String interests = computerInterests(name);

        print(checkTrigRespDB(trigRespDB, interests));
        //Uses the checkTrigRespDB() method to bring the response to the appropriate methods

        askQuestions();

    }

    
    public static TriggerResponse[] initialiseArray(TriggerResponse[] trigRespDB)
    {

        //Using the TriggerResponses methods to create new TriggerResponse objects

        TriggerResponse horrorFilms = horrorFilms();
        TriggerResponse actionFilms = actionFilms();
        TriggerResponse romComFilms = romComFilms();

        trigRespDB = new TriggerResponse[]{horrorFilms, actionFilms, romComFilms};
        //Creating a TriggerResponseDatabase record and initialising the field array

        sortArray(trigRespDB); //Sorts the array into ascending usefulness order

        return trigRespDB;
    }
    public static void askQuestions()
    {
        String choice = inputString("Can I ask you a question? (Y/N)");
        while (!choice.equals("N"))
        {
            if (choice.equals("Y"))
            {
                arrayOfChoices();
            }
            else
            {
                print("Choose something from the option");
            }

            choice = inputString("Would you like me to ask another question?");
        }
        repeatConversation();

    } //Repeatedly asks the user questions until they say N, moving onto the repeatConversations method
    public static String chooseName()
    {
        String name = inputString("Hi, what is your name?");

        inputString("Hi " + name + " how are you?");

        print("Sorry, I have to go");

        return name;


    } //Asks the user for their name,how they are and then tel

    public static String computerInterests(String name)
    {

        return inputString("My interests are film \nWhat is your favourite genre of movie " + name + " ?");
    } //Tells the user their interests before asking for the users interests, returning the users interests


    public static String checkTrigRespDB(TriggerResponse[] trigRespDB, String interests)
    {
        for (int i = 0; i < trigRespDB.length; i++) {
            if (interests.equals(getTrigger(trigRespDB[i])))
            {
                return getResponse(trigRespDB[i]);
        }
        }

    } //Checks if a string input is equal to a Trigger of the TriggerResponseDatabase array

    public static void arrayOfChoices() {
        String[] questions = new String[3];

        questions[0] = "What is your favourite movie";
        questions[1] = "What is your least favourite movie?";
        questions[2] = "Do you like action?";
        Random generator = new Random();
        int randomIndex = generator.nextInt((questions.length) - 1);

        String choice = inputString("Would you like a question asked?");
        while (!choice.equals("N"))
        {
            if (choice.equals("Y"))
            {
                for (int i = 0; i < questions.length; i++) {
                    inputString(questions[i]);
                    choice = inputString("Would you like a question asked?");
                }
            }
        }

     } //Prints a random element from an array of random questions


    public static void repeatConversation()
    {
        String response = inputString("What else do you want to talk about");
        while (!response.equals("Goodbye") && !response.equals("Got to go"))
        {
            print("I don't know about this");
            response = inputString("What else do you want to talk about");
        }

        print("Goodbye");
    } //Asks the user what they want to talk about, repeating until they want to leave


    public static void print(String message)
    {
        System.out.println(message);
    } //prints

    public static String inputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println(message);
        answer = scanner.nextLine();

        return answer;
    } //returns a string input


    public static void sortArray(TriggerResponse[] trigRespDB)
    {
        TriggerResponse temp;

        int n = trigRespDB.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (getUsefulness(trigRespDB[i]) > getUsefulness(trigRespDB[j]))
                {
                    temp = trigRespDB[i];
                    trigRespDB[i] = trigRespDB[j];
                    trigRespDB[j] = temp;
                }
            }
        }
    } //Sorts an array of a TriggerResponseDatabase using for loops

    public static TriggerResponse horrorFilms()
    {
        TriggerResponse horrorF = new TriggerResponse();
        horrorF.usefulness = 1;
        horrorF.trigger = "Horror";
        horrorF.response = "I never watch them as they terrify me";
        return horrorF;
    } //Creates a record horrorFilms of type TriggerResponse

    public static TriggerResponse actionFilms()
    {
        TriggerResponse actionF = new TriggerResponse();
        actionF.usefulness = 3;
        actionF.trigger = "Action";
        actionF.response = "Oh I really like action, high five!";
        return actionF;
    }//Creates a record actionFilms of type TriggerResponse

    public static TriggerResponse romComFilms()
    {
        TriggerResponse romComF = new TriggerResponse();
        romComF.usefulness = 5;
        romComF.trigger = "Rom Com";
        romComF.response = "Oh you are a romantic person eh?";
        return romComF;
    }//Creates a record romComFilms of type TriggerResponse



    public static String getTrigger(TriggerResponse tr)
    {
        return tr.trigger;
    } //Accessor method to get the trigger of a triggerResponse

    public static String getResponse(TriggerResponse tr)
    {
        return tr.response;
    }//Accessor method to get the response of a triggerResponse

    public static int getUsefulness(TriggerResponse tr)
    {
        return tr.usefulness;
    }//Accessor method to get the usefulness of a triggerResponse
}

class TriggerResponse {

    int usefulness;
    String trigger;
    String response;
} //Record TriggerResponse with field response


