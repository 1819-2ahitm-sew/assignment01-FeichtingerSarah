import java.util.ArrayList;
import java.util.Scanner;

public class Taschenrechner
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        boolean nulldivPruef;
        int zaehler = 0;
        int hilfszaehl = 0;     //hilfszähler
        double zahl1, zahl2;
        double ergebnis = 0;
        char operator;
        char[] arrayOperator;
        String rechnung;
        String[] arrayRechnung;
        ArrayList alleRechnungen = new ArrayList();
        
       


        System.out.print("Eingabe: ");
        rechnung = sc.nextLine();


        while (!rechnung.equalsIgnoreCase("quite"))
        {
            if (rechnung.equals("p") || rechnung.equals("n"))
            {
                if (rechnung.equals("p"))
                {
                    hilfszaehl--;
                    if(hilfszaehl > 0)
                    {
                        System.out.printf("%d. Rechnug: %s \n", hilfszaehl, alleRechnungen.get(hilfszaehl - 1));
                    }else
                    {
                        System.out.println("Sie haben keine weiteren Rechnungen eingegeben");
                    }
                }else if(rechnung.equals("n"))
                {
                    hilfszaehl++;
                    if(hilfszaehl < zaehler)
                    {
                        System.out.printf("%d. Rechnug: %s \n", hilfszaehl, alleRechnungen.get(hilfszaehl - 1));
                    }else
                    {
                        System.out.println("Sie haben noch keine weiteren Rechnungen eingegeben");
                    }
                }
            }else
            {
                zaehler++;
                hilfszaehl = zaehler;
                nulldivPruef = false;       //Nulldivision Prüfer

                arrayRechnung = rechnung.split(" ");
                zahl1 = Double.parseDouble(arrayRechnung[0]);
                arrayOperator = arrayRechnung[1].toCharArray();
                operator = arrayOperator[0];
                zahl2 = Double.parseDouble(arrayRechnung[2]);

                if (operator == '+' || operator == '-' || operator == '*' || operator == '/')
                {
                    if (operator == '+')
                    {
                        ergebnis = zahl1 + zahl2;
                    } else if (operator == '-')
                    {
                        ergebnis = zahl1 - zahl2;
                    } else if (operator == '*')
                    {
                        ergebnis = zahl1 * zahl2;
                    } else if (operator == '/')
                    {
                        if (zahl2 != 0)
                        {
                            ergebnis = zahl1 / zahl2;
                        }else
                        {
                            nulldivPruef = true;
                        }
                    }


                    if (!nulldivPruef)
                    {
                        System.out.printf("Ausgabe: %.2f %c %.2f = %.2f \n", zahl1, operator, zahl2, ergebnis);
                        alleRechnungen.add(zaehler - 1, rechnung + " = " + Double.toString(ergebnis));
                    }else
                    {
                        System.out.println("Keine Division durch 0 möglich!");
                        zaehler--;
                    }


                }else
                {
                    System.out.println("Falsche Eingabe");
                    zaehler--;
                }


            }

            System.out.print("Eingabe: ");
            rechnung = sc.nextLine();

        }
        System.out.printf("Es gab %d Berechnungen \n", zaehler);

        for (int j = 0; j < zaehler; j++)
        {
            System.out.printf("%d. Rechnug: %s \n", j + 1, alleRechnungen.get(j));
        }
    }
}
