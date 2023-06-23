/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gueel
 */
public class Reserva {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
      private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Reserva(){}

    public Reserva(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }
  
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public String updateDates(Date checkIn,Date checkOut){
        Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
               return "ERRO: AS DATAS DE RESERVAS TEM QUE SER POSTERIORES A ATUAL! ";
            } if (!checkOut.after(checkIn)) {
               return "A data de check-in não pode ser posterio a de check-out ";
            }
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Quarto: "
                +roomNumber
                +", Entrada: "
                +sdf.format(checkIn)
                + ", Saida: "
                +sdf.format(checkOut)
                + ", "
                + duration()
                +" Noite";
        
    }
    
    
    
    
}
