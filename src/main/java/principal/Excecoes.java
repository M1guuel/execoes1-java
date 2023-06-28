/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package principal;

import entities.Reserva;
import exeception.DomainExeception;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gueel
 */
public class Excecoes {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Numero do quarto: ");
            int number = sc.nextInt();
            System.out.print("Data de Check-in (dd/MM/yyyy) : ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());
            Reserva reserva = new Reserva(number, checkIn, checkOut);
            System.out.println("RESERVA: " + reserva.toString());

            System.out.println("");
            System.out.println("ENTRE COM OS DADOS PARA ATUALIZAÇÃO DA RESERVA");
            System.out.print("Data de Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reserva.updateDates(checkIn, checkOut);
            System.out.println("Resevar:" + reserva.toString());
            
        } catch (ParseException e) {
              System.out.println("Erro Data Invalida: "+e.getMessage());
        }catch(DomainExeception e){
            System.out.println("ERRO NA RESERVA: "+ e.getMessage());
        }catch(RuntimeException e){
            System.out.println("ERRO INESPERADO: ");
        }

        sc.close();
    }
}
