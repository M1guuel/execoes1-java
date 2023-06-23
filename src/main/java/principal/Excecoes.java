/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package principal;

import entities.Reserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gueel
 */
public class Excecoes {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int number = sc.nextInt();
        System.out.print("Data de Check-in (dd/MM/yyyy) : ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de Check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());
        if (!checkOut.after(checkIn)) {
            System.out.println("A data de check-in não pode ser posterio a de check-out ");
        } else {
            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("RESERVA: " + reserva.toString());

            System.out.println("");
            System.out.println("ENTRE COM OS DADOS PARA ATUALIZAÇÃO DA RESERVA");
            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            sdf.parse(sc.next());
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("ERRO: AS DATAS DE RESERVAS TEM QUE SER POSTERIORES A ATUAL! ");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("A data de check-in não pode ser posterio a de check-out ");
            } else {
                reserva.updateDates(checkIn, checkOut);
                System.out.println("Resevar:" + reserva.toString());
            }
        }
        sc.close();
    }
}
