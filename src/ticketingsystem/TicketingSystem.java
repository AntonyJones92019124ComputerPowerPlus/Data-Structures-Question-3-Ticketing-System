/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketingsystem;

import java.util.TimerTask;
import java.util.Queue;
import java.util.Timer;
import java.util.LinkedList;
/**
 *
 * @author tony
 */
public class TicketingSystem {
    
    public static Queue<String> ticketQueue = new LinkedList();//get LinkedList

    public static void main(String[] args) {
        addToTicketQueue();
        Timer timer = new Timer();
        timer.schedule(new SalesAssisstantTask(), 0, 5000);/*Timer set to 5 
        second intervals starts when first customer recieves a ticket number*/
    }
    public static void addToTicketQueue(){
        for (int i = 1; i <5; i ++){
            ticketQueue.add("Ticket Number: " + i);
        }
    }  
    
    public static class SalesAssisstantTask extends TimerTask{/*class for sales
        assisstant duties*/
        
        /**
         *
         */
        @Override
        public void run() {
              
            System.out.println("Sales Assistant is ready to serve the next "
                    + "customer."); 
            if (ticketQueue.isEmpty()){
                System.out.println("There are no customers to see.\n");
                System.exit(0);
            }//end of if statement
            else if (ticketQueue.size() == 1){
                System.out.println("The customer with ticket number " + 
                        ticketQueue.poll() + " will now be seen");
                System.out.println("There are no more customers to see.\n");
            }//end of else statement
            else{
                System.out.println("The customer with ticket number " + 
                        ticketQueue.poll() + " will now be seen");
                System.out.println("The customers with the following tickets "
                        + "are in the queue: " + 
                        ticketQueue.toString() + "\n");
            }//end of else statement    
            
        }//end of run
        
    }//end of Class SalesAssisstantTask
     
}//end of Class TicketingSystem
    
    
    
    
 
    
