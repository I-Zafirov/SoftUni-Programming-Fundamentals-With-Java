package T19MidExamPreparation;

import java.util.Scanner;

public class kalendar {
    static boolean isLeapYear(int year) {



        if(year%100==0 && year%400==0){
            return true;
        }
        if(year%4==0 && year%100==0 && year%400!=0){
            return false;
        }
        if(year%4==0 && year%100!=0){
            return true;
        }
        if(year%4!=0){
            return false;
        }
        return false;

    }


    static int countDaysInMonth(int month, int year) {
        // ...
        int c=0;
        if(isLeapYear(year)){
            c=1;
        }
        if(month==1){
            return 0;
        }
        if(month==2 ){
            return 31;
        }

        if(month==3 ){
            return 29+31+c;
        }



        if(month==4){
            return 29+31+c+31;
        }
        if(month==5){
            return 29+31+c+31+30;
        }
        if(month==6){
            return 29+31+c+31+30+31;
        }
        if(month==7){
            return 29+31+c+31+30+31+30;
        }
        if(month==8){
            return 29+31+c+31+30+31+30+31;
        }
        if(month==9){
            return 29+31+c+31+30+31+30+31+31;
        }
        if(month==10){
            return 29+31+c+31+30+31+30+31+31+30;
        }
        if(month==11){
            return 29+31+c+31+30+31+30+31+31+30+31;
        }
        if(month==12){
            return 29+31+c+31+30+31+30+31+31+30+31+30;
        }
        return 0;

    }


    static boolean isValidDate(int day, int month, int year) {
        // ...

        if(month==1 && day>31){

            return false;
        }
        if(month==2 && day>29 && isLeapYear(year) ){

            return false;
        }
        if(month == 2 && day>28 && !isLeapYear(year)){

            return false;
        }
        if(month==3 && day>31){

            return false;
        }
        if(month==4 && day>30){

            return false;
        }
        if(month==5 && day>31){

            return false;
        }
        if(month==6 && day>30){

            return false;
        }
        if(month==7 && day>31){

            return false;
        }
        if(month==8 && day>31){

            return false;
        }
        if(month==9 && day>30){

            return false;
        }
        if(month==10 && day>31){

            return false;
        }
        if(month==11 && day>30){

            return false;
        }
        if(month==12 && day>31){

            return false;
        }
        if(month>12){
            return false;
        }
        if(year<1900){
            return false;
        }
        return true;

    }


    static int countDays(int day, int month, int year) {
        // ...

        int daysinlastyear= countDaysInMonth(month,year)+day;
        int otherdays=0;
        for(int i=1900;i<year;i++){
            if(isLeapYear(year)){
                otherdays+=366;
            }
            else{
                otherdays+=365;
            }
        }
        return otherdays+daysinlastyear-1;



    }

    public static void main(String[] args) {
        // ...
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] arrinstring = s.split(" ");
        int[] arr=new int[3];
        for(int i=0;i<arrinstring.length;i++) {
            arr[i]=Integer.parseInt(arrinstring[i]);
        }
        int day=arr[0];
        int month=arr[1];
        int year=arr[2];
        if(!isValidDate(day,month,year)){
            System.out.println("invalid");

        }
        else{
            if(countDays(day,month,year)%7==1){
                System.out.println("monday");
            }
            if(countDays(day,month,year)%7==2){
                System.out.println("tuesday");
            }
            if(countDays(day,month,year)%7==3){
                System.out.println("wednesday");
            }
            if(countDays(day,month,year)%7==4){
                System.out.println("thursday");
            }
            if(countDays(day,month,year)%7==5){
                System.out.println("friday");
            }
            if(countDays(day,month,year)%7==6){
                System.out.println("saturday");
            }
            if(countDays(day,month,year)%7==0){
                System.out.println("sunday");
            }
        }

    }
}
