import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kalkulator {

    public int add(int x, int y){
        int or = x ^ y;
        int and = x & y;
        int or_prev;
        while(and != 0){
            and = and << 1;
            or_prev = or;
            or = or ^ and;
            and = or_prev & and;
        }
        return or;
    }

    public int substract(int x, int y){
        return this.add(x, this.add(~y,1));
    }

    public int multiply(int x, int y){
        if(x<0 && y<0){
            x = this.substract(0, x);
            y = this.substract(0, y);
        }
        if(y<0){
            int p = x;
            x=y;
            y=p;
        }
        int s=0;
        for(int i=0; i<y; i=this.add(i,1)){
            s = this.add(s, x);
        }
        return s;
    }

    public int power(int x, int y) throws Exception {
        if(y<0){
            throw new Exception("Ujemny wykładnik potęgi.");
        }
        int s=1;
        for(int i=0; i<y; i=this.add(i,1)){
            s = this.multiply(s, x);
        }
        return s;
    }

    public double divide(double x, double y) throws Exception {
        if(x>2000)  throw new Exception("Za duża pierwsza liczba.");
        if(x<0 || y<0)  throw new Exception("Ujemne liczby na wejściu.");
        x *= 1000;
        y *= 1000;
        int xi = (int)x;
        int yi = (int)y;
        xi = this.multiply(xi, 1000);
        int i=1, s=xi;
        while(s>y){
            i = this.add(i, 1);
            s = this.substract(s, yi);
        }
        return (double)i/1000;
    }

    public int factorial(int x) throws Exception {
        if(x<0){
            throw new Exception("Ujemna liczba na wejściu.");
        }
        int s=1;
        for(int i=2; i<=x; i=this.add(i,1)){
            s = this.multiply(s, i);
        }
        return s;
    }

    private boolean if_end() throws IOException {
        System.out.println("Wpisz 1 jeśli chcesz zakończyć działanie programu.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int w = 0;
        try {
            w = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return false;
        }
        if (w!=1)   return false;
        return true;
    }

    private int ask_input(boolean positive) throws Exception {
        System.out.print("Podaj liczbę całkowitą");
        if(positive)    System.out.println(" dodatnią: ");
        else System.out.println(": ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int w = 0;
        try {
            w = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("To nie jest liczba całkowita.");
            throw new Exception("Nie podano liczby.");
        }
        if(positive && w<0){
            System.out.println("Ujemna liczba.");
            throw new Exception("Ujemna liczba.");
        }
        return w;
    }

    private double ask_input_double(int threshold) throws Exception {
        System.out.println("Podaj dodatnią liczbę:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        double w = 0;
        try {
            w = Double.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.println("To nie jest liczba.");
            throw new Exception("Nie podano liczby.");
        }
        if(threshold!=0 && w > threshold){
            System.out.println("Za duża liczba. Dopuszczalna max: " + threshold);
            throw new Exception("Nie podano liczby.");
        }
        if(w < 0){
            System.out.println("Ujemna liczba.");
            throw new Exception("Ujemna liczba.");
        }
        return w;
    }

    public void run() throws IOException {
        boolean if_run = true;
        while(if_run){
            System.out.println("Wybierz operację do obliczenia:");
            System.out.println("1 - dodawanie");
            System.out.println("2 - odejmowanie");
            System.out.println("3 - mnożenie");
            System.out.println("4 - dzielenie");
            System.out.println("5 - potegowanie");
            System.out.println("6 - silnia");
            System.out.println("Inna - zakończ program.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            int w = 0;
            try {
                w = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Niewłaściwa odpowiedź.");
                if_run = !this.if_end();
                if(!if_run)  break;
            }
            switch (w){
                case 1:{
                    System.out.println("Wybrano dodawanie.");
                    try {
                        System.out.println("Wynik: " + this.add(this.ask_input(false), this.ask_input(false)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                case 2:{
                    System.out.println("Wybrano odejmowanie.");
                    try {
                        System.out.println("Wynik: " + this.substract(this.ask_input(false), this.ask_input(false)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                case 3:{
                    System.out.println("Wybrano mnożenie.");
                    try {
                        System.out.println("Wynik: " + this.multiply(this.ask_input(false), this.ask_input(false)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                case 4:{
                    System.out.println("Wybrano dzielenie.");
                    try {
                        System.out.println("Wynik: " + this.divide(this.ask_input_double(2000), this.ask_input_double(0)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                case 5:{
                    System.out.println("Wybrano potęgowanie.");
                    try {
                        System.out.println("Wynik: " + this.power(this.ask_input(false), this.ask_input(true)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                case 6:{
                    System.out.println("Wybrano silnię.");
                    try {
                        System.out.println("Wynik: " + this.factorial(this.ask_input(true)) + "\n");
                    } catch (Exception e) {
                        if_run = !this.if_end();
                    }
                    break;
                }
                default:{
                    System.out.println("Niewłaściwa odpowiedź.");
                    if_run = !this.if_end();
                }
            }
        }
    }

    public static void main(String[] args) {
        Kalkulator kalk = new Kalkulator();
        try {
            kalk.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}