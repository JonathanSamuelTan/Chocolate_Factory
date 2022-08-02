import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class App {
    public static void main(String[] args) throws Exception {
        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);
        int choose;
        ArrayList<Chocolate> chocolateList = new ArrayList<Chocolate>();

        while(continueLoop){
            System.out.println("====== welcome to the chocolate factory ======");
            System.out.println("1. Create Chocolate");
            System.out.println("2. Edit Chocolate");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            choose = input.nextInt();
            switch(choose){
                case 1:
                    String name = "none";
                    String type = "none";
                    int price = 0;
                    boolean checker1 = true;
                    boolean checker2 = true;
                    boolean checker3 = true;
                    while(checker1){
                        System.out.println("Input name [Must be more than 1 word] : ");
                        name = input.nextLine();
                        checker1 = nameValidation(name);
                    }
                    while(checker2){
                        System.out.print("Input Type [Original],[Vanilla],[Strawberry],[Coffee],[!Case Sensitive!] : ");
                        type = input.nextLine();
                        checker2 = typeValidation(type);
                    }
                    while(checker3){
                        System.out.print("Input Price [5.000 - 50.000 (inclusive)] : ");
                        price = input.nextInt();
                        checker3 = priceValidation(price);
                    }
                    String letter1 = String.valueOf(randomChar());
                    String letter2 = String.valueOf(randomChar());
                    String num1 = String.valueOf((int)Math.floor(Math.random()*10));
                    String num2 = String.valueOf((int)Math.floor(Math.random()*10));
                    String id = letter1 + letter2 + num1 + num2;
                    Chocolate chocolate = new Chocolate(name, type, price,id);
                    chocolateList.add(chocolate);
                    System.out.println("Chocolate created successfully");
                    break;

                case 2:
                    boolean continueLoop2 = true;
                    while(continueLoop2){
                        System.out.println("1. Update Chocolate");
                        System.out.println("2. Delete Chocolate");
                        System.out.println("3. Back to main menu");
                        System.out.print("Choose: ");
                        choose = input.nextInt();
                        switch(choose){
                            case 1 :
                                //display all chocolate
                                displayList(chocolateList);
            
                                //update choco
                                System.out.print("Choose chocolate number to update: ");
                                int chooseChoco = input.nextInt();
                                if (chooseChoco > chocolateList.size()){
                                    System.out.println("Chocolate number is not exist");
                                }else{
                                    boolean checker4 = true;
                                    boolean checker5 = true;
                                    boolean checker6 = true;
                                    while(checker4){
                                        System.out.print("Input name [Must be more than 1 word] : ");
                                        chocolateList.get(chooseChoco-1).setName(input.nextLine());
                                        checker4 = nameValidation(chocolateList.get(chooseChoco-1).getName());
                                    }
                                
                                    while(checker5){
                                        System.out.print("Input Type [Original],[Vanilla],[Strawberry],[Coffee],[!Case Sensitive!] : ");
                                        chocolateList.get(chooseChoco-1).setType(input.nextLine());
                                        checker5 = typeValidation(chocolateList.get(chooseChoco-1).getType());
                                    }
                                    while(checker6){
                                        System.out.print("Input Price [5.000 - 50.000 (inclusive)] : ");
                                        chocolateList.get(chooseChoco-1).setPrice(input.nextInt());
                                        checker6 = priceValidation(chocolateList.get(chooseChoco-1).getPrice());
                                    }
                                    System.out.println("Chocolate updated successfully");
                                }
                                break;
                                
                            case 2:
                                //display all chocolate
                                displayList(chocolateList);
                                System.out.println("Choose chocolate number to delete: ");
                                int chooseChoco2 = input.nextInt();
                                if (chooseChoco2 > chocolateList.size()){
                                    System.out.println("Chocolate number is not exist");
                                }else{
                                    chocolateList.remove(chooseChoco2-1);
                                    System.out.println("Chocolate deleted successfully");

                                }
                                break;
                            case 3:
                                continueLoop2 = false;
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
                    break;
                case 3:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid choose");
                    break;
            }

       }
       input.close();
    }
    private static char randomChar() {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'A');
    }

    private static void displayList(ArrayList<Chocolate> chocolateList){
        if(chocolateList.isEmpty()){
            System.out.println("Chocolate is empty");
        }else{
            System.out.printf("|no | %20s | %20s | %20s | %20s  |\n", "Name", "Type", "Price", "ID");
            for(int i = 0; i < chocolateList.size(); i++){
                String Name = String.format("%20s", chocolateList.get(i).getName());
                String Type = String.format("%20s", chocolateList.get(i).getType());
                String Price = String.format("%20d", chocolateList.get(i).getPrice());
                String Id = String.format(" %20s", chocolateList.get(i).getId());
                System.out.println("|" + (i+1) + "  | " + Name + " | " + Type + " | " + Price + " | " + Id + " |");
            }
        }
    }

    private static boolean nameValidation(String name){
        if(name.contains(" ")){
            return false;
        }
        else{
            return true;
        }
    }

    private static boolean typeValidation(String type){
        if(type.equals("Original") || type.equals("Vanilla") || type.equals("Strawberry") || type.equals("Coffee")){
            return false;
        }
        else{
            return true;
        }
    }

    private static boolean priceValidation(int price){
        if(price >= 5000 && price <= 50000){
            return false;
        }
        else{
            return true;
        }
    }
}
