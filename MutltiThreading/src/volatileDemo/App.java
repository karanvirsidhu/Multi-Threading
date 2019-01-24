package volatileDemo;

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running = true;

    @Override
    public void run() {
        while(running){


            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shutdown(){
        running=false;
    }
}

public class App {

    public static void main(String[] args){
        Processor p = new Processor();
        p.start();;
        System.out.println("Press return key to stop");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        p.shutdown();
    }
}
