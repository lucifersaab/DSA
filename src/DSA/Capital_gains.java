package DSA;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Capital_gains {
    static class Transaction{
        int count;
        int price;
        Date date;
        String formattedDate;
        Transaction(int count, int price, String date) throws ParseException {
          this.count=count;
          this.price=price;
          SimpleDateFormat db = new SimpleDateFormat("dd/MM/yy");
          this.date=db.parse(date);
          formattedDate = db.format(this.date);
        }
    }

    static Queue<Transaction> bought=new LinkedList<>();
    static Queue<Transaction> sold=new LinkedList<>();
    int calc() {


        int gains=0;

        while (!bought.isEmpty()&&!sold.isEmpty()){
            Transaction buy=bought.peek();
            System.out.println("BOUGHT:");
            System.out.println("Amount: "+buy.count+"\nPrice/stock: $"+buy.price +"\nDate purchased: "+ buy.formattedDate);
            System.out.println();
            Transaction sell=sold.peek();
            System.out.println("SOLD:");
            System.out.println("Amount: "+sell.count+"\nPrice/stock: $"+sell.price +"\nDate purchased: "+sell.formattedDate);
            System.out.println();
            if(buy.count< sell.count){
                gains= buy.count*(sell.price- buy.price)+gains;
                sell.count=sell.count-buy.count;
                bought.remove();
            }
            else {
                gains= sell.count*(sell.price- buy.price)+gains;
                sold.remove();
                if(buy.count==sell.count)
                    bought.remove();
                else buy.count=buy.count-sell.count;
            }
        }
        return gains;
    }


    public static void main(String[] args) throws ParseException {
        Capital_gains obj = new Capital_gains();
        Scanner sc;
        try {
            sc = new Scanner(new File("file.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (sc.hasNext()){
            String x=sc.next();
            int count= sc.nextInt();
            int price= sc.nextInt();
            String date=sc.next();
            if(x.equals("B")){
                bought.add(new Transaction(count,price,date));
            }else {
                sold.add(new Transaction(count,price,date));
            }

        }
        System.out.println("Net gain: $"+obj.calc());

    }
}
